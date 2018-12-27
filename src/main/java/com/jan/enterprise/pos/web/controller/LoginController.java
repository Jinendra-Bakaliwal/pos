/**
 * 
 */
package com.jan.enterprise.pos.web.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.support.SessionStatus;

import com.jan.enterprise.pos.web.form.LoginForm;

/**
 * @author Jinendra Bakliwal
 *
 */
@Controller
public class LoginController {
	@GetMapping("/login")
	public String showLoginPage(Model model ) {
		LoginForm loginModel = new LoginForm();
        model.addAttribute(loginModel);
        return "login/login";
    }
	
//	@PostMapping("/login")
//	public String login(@Valid LoginForm loginModel, BindingResult result, SessionStatus status) {
////        model.addAttribute(loginModel);
//		if (result.hasErrors()) {
//			
//            return "login/login";
//        }
//		
//        return "login/login";
//    }
}
