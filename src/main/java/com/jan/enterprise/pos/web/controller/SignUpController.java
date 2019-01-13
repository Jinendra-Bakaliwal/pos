package com.jan.enterprise.pos.web.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.MessageSource;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.jan.enterprise.pos.event.OnRegistrationCompleteEvent;
import com.jan.enterprise.pos.model.MemberModel;
import com.jan.enterprise.pos.model.Privilege;
import com.jan.enterprise.pos.response.GenericResponse;
import com.jan.enterprise.pos.service.MemberService;
import com.jan.enterprise.pos.web.form.SignUpForm;

/**
 * @author Jinendra Bakliwal
 *
 */
@Controller
public class SignUpController implements WebMvcConfigurer {

	@Autowired
	private MemberService memberService;
	
    @Autowired
    private ApplicationEventPublisher eventPublisher;
	
    @Autowired
    private MessageSource messages;

	@GetMapping("/signup")
	public String getMemberSignUpForm(Model model) {
		SignUpForm signUpModel = new SignUpForm();
        model.addAttribute(signUpModel);
        return "signup/signup";
    }
	
	@PostMapping("/signup")
	@ResponseBody
	public GenericResponse signup(@Valid SignUpForm signUpForm, Model model, BindingResult result, final HttpServletRequest request) {
//		model.addAttribute("member", member);
		/*if (result.hasErrors()) {
            return "signup/signup";
        }*/
//        LOGGER.debug("Registering user account with information: {}", singUpForm);

        final MemberModel registered = memberService.registerNewUserAccount(signUpForm);
        eventPublisher.publishEvent(new OnRegistrationCompleteEvent(registered, request.getLocale(), getAppUrl(request)));

//		signupService.signup(signUpForm);
		
//		model.addAttribute(new LoginForm());
//        return "login/login";
        return new GenericResponse("success");
    }
	
	private String getAppUrl(HttpServletRequest request) {
        return "http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
    }
	
	@RequestMapping(value = "/registrationConfirm", method = RequestMethod.GET)
    public String confirmRegistration(final HttpServletRequest request, final Model model, @RequestParam("token") final String token) throws UnsupportedEncodingException {
        Locale locale = request.getLocale();
        final String result = memberService.validateVerificationToken(token);
        if (result.equals("valid")) {
            final MemberModel user = memberService.getUser(token);
            // if (user.isUsing2FA()) {
            // model.addAttribute("qr", userService.generateQRUrl(user));
            // return "redirect:/qrcode.html?lang=" + locale.getLanguage();
            // }
            authWithoutPassword(user);
            model.addAttribute("message", messages.getMessage("message.accountVerified", null, locale));
            return "redirect:/console.html?lang=" + locale.getLanguage();
        }

        model.addAttribute("message", messages.getMessage("auth.message." + result, null, locale));
        model.addAttribute("expired", "expired".equals(result));
        model.addAttribute("token", token);
        return "redirect:/badUser.html?lang=" + locale.getLanguage();
	}
	
    public void authWithoutPassword(MemberModel user) {
        List<Privilege> privileges = user.getRoles().stream().map(role -> role.getPrivileges()).flatMap(list -> list.stream()).distinct().collect(Collectors.toList());
        List<GrantedAuthority> authorities = privileges.stream().map(p -> new SimpleGrantedAuthority(p.getName())).collect(Collectors.toList());

        Authentication authentication = new UsernamePasswordAuthenticationToken(user, null, authorities);

        SecurityContextHolder.getContext().setAuthentication(authentication);
    }
}

