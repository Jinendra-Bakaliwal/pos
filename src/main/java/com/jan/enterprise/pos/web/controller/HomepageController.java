/**
 * 
 */
package com.jan.enterprise.pos.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Jinendra Bakliwal
 *
 */
@Controller
public class HomepageController {
	@GetMapping("/homepage")
	public String showHomePage(Model model ) {
        return "home/homepage";
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
