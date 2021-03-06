package com.jan.enterprise.pos.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.jan.enterprise.pos.web.form.MemberForm;

@Controller
public class ShopController {
	@GetMapping("/shop")
	public String plainPage(Model model ) {
		MemberForm memberDetail = new MemberForm();
        model.addAttribute(memberDetail);
        return "shop/shop";
    }
}
