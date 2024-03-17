package com.study.toyproject.tming.controller;

import com.study.toyproject.tming.dto.MemberDTO;
import com.study.toyproject.tming.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
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
	public String loginMember(@ModelAttribute MemberDTO memberDTO, Model model, HttpSession session) throws Exception {
		MemberDTO loginResult = memberService.login(memberDTO);

		if (loginResult == null) {
			model.addAttribute("loginFail", "로그인 아이디 또는 비밀번호를 확인해주세요.");
			return null;
		}

		session.setAttribute("loginId", loginResult.getId());
		return "main";
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
	@GetMapping("/{id}")
	public @ResponseBody boolean checkMemberId(@PathVariable("id") String id) {
		boolean checkResult = false;
		if(!id.isEmpty()) {
			checkResult = memberService.checkId(id);
		}
		return checkResult;
	}

}
