package com.jan.enterprise.pos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.jan.enterprise.pos.model.MemberDetail;

@Controller
public class ShopController {
	@GetMapping("/shop")
	public String plainPage(Model model ) {
		MemberDetail memberDetail = new MemberDetail();
        model.addAttribute(memberDetail);
        return "shop/shop";
    }
}
