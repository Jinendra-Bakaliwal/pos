/**
 * 
 */
package com.jan.enterprise.pos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Jinendra Bakliwal
 *
 */
@Controller
public class MemberController {

	@GetMapping("/member")
	public String plainPage() {
        return "member_info";
    }
}
