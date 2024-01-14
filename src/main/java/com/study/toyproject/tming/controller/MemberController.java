package com.study.toyproject.tming.controller;

import com.study.toyproject.tming.dto.MemberDTO;
import com.study.toyproject.tming.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequestMapping(value = "/member")
@RequiredArgsConstructor
public class MemberController {

	private final MemberService memberService;

	@GetMapping("/login")
	public String login() {
		return "member/login";
	}

	/**
	 * 로그인
	 * */
	@PostMapping("/login")
	public String loginMember(@ModelAttribute MemberDTO memberDTO, HttpSession session) throws Exception {
		MemberDTO loginResult = memberService.login(memberDTO);
		if (loginResult != null) {
			session.setAttribute("loginId", loginResult.getId());
			return "redirect:/main";
		}

		return "member/login";
	}

	/**
	 * 로그아웃
	 * */
	@PostMapping("/logout")
	public String logout(HttpSession session) {
		if (session != null) {
			session.invalidate();
		}
		return "redirect:/member/login";
	}

	@GetMapping("/joinMember")
	public String join() {
		return "member/join";
	}

	/**
	 * 회원가입
	 * */
	@PostMapping("/joinMember")
	public String joinMember(@ModelAttribute MemberDTO memberDTO) throws Exception {

		memberService.save(memberDTO);

		return "member/login";
	}

	/**
	 * 아이디 중복 확인
	 * */
	@PostMapping("/checkId")
	public @ResponseBody String checkMemberId(@RequestParam("id") String id) {
		String checkResult = "";
		if(id != "") {
			checkResult = memberService.checkId(id);
		}
		return checkResult;
	}

//	/**
//	 * 회원 정보 수정 페이지
//	 * */
//	@GetMapping("/modifyMember")
//	public String modifyMember(HttpSession session, Model model) throws Exception {
//
//		String myId = (String) session.getAttribute("loginId");
//		MemberDTO memberDTO = memberService.updateForm(myId);
//		model.addAttribute("modifyMember", memberDTO);
//
//		return "member/join";
//	}
//
//	/**
//	 * 회원 정보 수정
//	 * */
//	@PostMapping("/modifyMember{id}")
//	public String modifyMember(@PathVariable String id, Model model) {
//
//		MemberDTO memberDTO = memberService.updateForm(id);
//		model.addAttribute("modifyMember", memberDTO);
//
//		return "member/join";
//	}
//
//	/**
//	 * 회원 탈퇴
//	 * */
//	@PostMapping("/deleteMember{id}")
//	public String deleteMember(@PathVariable String id) {
//
//		memberService.deleteById(id);
//
//		return "redirect:/main";
//	}

}
