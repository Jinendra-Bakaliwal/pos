/**
 * 
 */
package com.jan.enterprise.pos.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.support.SessionStatus;

import com.jan.enterprise.pos.model.MemberDetail;

/**
 * @author Jinendra Bakliwal
 *
 */
@Controller
public class MemberController {

	@GetMapping("/member")
	public String plainPage(Model model ) {
		MemberDetail memberDetail = new MemberDetail();
        model.addAttribute(memberDetail);
        return "member/member_info";
    }
	
	@PostMapping("/member")
	public String plainPage(@Valid MemberDetail memberDetail, BindingResult result, SessionStatus status) {
//		model.addAttribute("member", member);
        return "member/member_info";
    }
	
	@GetMapping("/members")
	public String getMembers(Model model ) {
		List<MemberDetail> memberList = new ArrayList<>();
		if (memberList.size() > 1) {
            // multiple members found
            model.addAttribute("selections", memberList);
            return "owners/ownersList";
        } else {
            // 1 member found
            MemberDetail memberDetail = memberList.iterator().next();
            return "redirect:/owners/" + memberDetail.getMemberId();
        }
    }

}
