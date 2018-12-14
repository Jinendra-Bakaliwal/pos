package com.jan.enterprise.pos.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.support.SessionStatus;

import com.jan.enterprise.pos.model.MemberDetail;
import com.jan.enterprise.pos.model.SignUpModel;

/**
 * @author bakli
 *
 */
@Controller
public class SignUpController {
	
	@GetMapping("/signup")
	public String plainPage(Model model ) {
		SignUpModel signUpModel = new SignUpModel();
        model.addAttribute(signUpModel);
        return "signup/signup";
    }
	
	@PostMapping("/signup")
	public String plainPage(@Valid MemberDetail memberDetail, BindingResult result, SessionStatus status) {
//		model.addAttribute("member", member);
        return "login/login";
    }
}
