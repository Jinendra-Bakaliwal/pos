package com.jan.enterprise.pos.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.jan.enterprise.pos.form.LoginForm;
import com.jan.enterprise.pos.form.SignUpForm;
import com.jan.enterprise.pos.service.SignupService;

/**
 * @author bakli
 *
 */
@Controller
public class SignUpController implements WebMvcConfigurer {

	@Autowired
	private SignupService signupService;
	
	@GetMapping("/signup")
	public String getMemberSignUpForm(Model model) {
		SignUpForm signUpModel = new SignUpForm();
        model.addAttribute(signUpModel);
        return "signup/signup";
    }
	
	@PostMapping("/signup")
	public String signup(@Valid SignUpForm signUpModel, Model model, BindingResult result, SessionStatus status) {
//		model.addAttribute("member", member);
		if (result.hasErrors()) {
            return "signup/signup";
        }
		signupService.signup(signUpModel);
		model.addAttribute(new LoginForm());
        return "login/login";
    }
}
