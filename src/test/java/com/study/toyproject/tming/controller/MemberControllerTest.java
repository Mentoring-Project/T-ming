package com.study.toyproject.tming.controller;

import com.study.toyproject.tming.dto.MemberDTO;
import com.study.toyproject.tming.entity.Member;
import com.study.toyproject.tming.repository.MemberJpaRepository;
import com.study.toyproject.tming.service.MemberService;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Transactional
class MemberControllerTest {

	@Autowired
	MemberService memberService;

	@Autowired
	MemberJpaRepository memberJpaRepository;

	@DisplayName("회원 가입")
	@Test
	void joinMemberTest() throws Exception {

		Member member = memberJpaRepository.save(Member.builder()
			.userSeq(1)
			.name("이름")
			.id("test")
			.password("test")
			.email("test@test")
			.gender("W")
			.age(27)
			.phone("01012345678")
			.build());

	}

	@DisplayName("로그인")
	@Test
	void loginTest() throws Exception {

		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setUserSeq(1);
		memberDTO.setId("test");
		memberDTO.setPassword("test");

		memberService.login(memberDTO);

	}

}