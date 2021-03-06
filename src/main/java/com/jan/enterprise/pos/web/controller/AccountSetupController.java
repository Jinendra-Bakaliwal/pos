package com.jan.enterprise.pos.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.MessageSource;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.jan.enterprise.pos.model.MemberModel;
import com.jan.enterprise.pos.response.GenericResponse;
import com.jan.enterprise.pos.service.MemberService;
import com.jan.enterprise.pos.web.form.AccountSetupForm;
import com.jan.enterprise.pos.web.form.SignUpForm;
import com.jan.enterprise.pos.web.util.IAuthenticationFacade;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Jinendra Bakliwal
 *
 */
@Controller
@Slf4j
public class AccountSetupController implements WebMvcConfigurer {

	@Autowired
	private MemberService memberService;
	
    @Autowired
    private ApplicationEventPublisher eventPublisher;
	
    @Autowired
    private MessageSource messages;

    @Autowired
    private IAuthenticationFacade authenticationFacade;
	    
    @GetMapping("/signupdetails")
	public String showAdditionalSignupDetails(Model model) {
    	AccountSetupForm accountSetupForm = new AccountSetupForm();
    	Authentication authentication = authenticationFacade.getAuthentication();
    	log.debug("authorities are {}",authentication.getAuthorities().toString());
//    	log.debug("Credntials are {}", authentication.getCredentials().toString());
    	log.debug("details are {}",authentication.getDetails().toString()); 
    	log.debug("name is {}", authentication.getName());
    	model.addAttribute(accountSetupForm);
        return "accountsetup/setup";
    }
    
    @PostMapping("/signupdetails")
	@ResponseBody
	public GenericResponse additionalSignupDetails(@Valid SignUpForm signUpForm, Model model, BindingResult result, final HttpServletRequest request) {
//		model.addAttribute("member", member);
		/*if (result.hasErrors()) {
            return "signup/signup";
        }*/
//        LOGGER.debug("Registering user account with information: {}", singUpForm);

        final MemberModel registered = memberService.registerNewUserAccount(signUpForm);
//        eventPublisher.publishEvent(new OnRegistrationCompleteEvent(registered, request.getLocale(), getAppUrl(request)));

//		signupService.signup(signUpForm);
		
//		model.addAttribute(new LoginForm());
//        return "login/login";
        return new GenericResponse("success");
    }
}

