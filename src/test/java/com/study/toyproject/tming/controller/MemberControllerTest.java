package com.study.toyproject.tming.controller;

import com.study.toyproject.tming.dto.MemberDTO;
import com.study.toyproject.tming.entity.Member;
import com.study.toyproject.tming.repository.MemberJpaRepository;
import com.study.toyproject.tming.service.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.mock;

@SpringBootTest
class MemberControllerTest {

	@DisplayName("회원 가입")
	@Test
	void joinMemberTest() throws Exception {

		MemberJpaRepository memberJpaRepository = mock(MemberJpaRepository.class);

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

		MemberService memberService = mock(MemberService.class);

		MemberDTO memberDTO = MemberDTO.builder()
			.id("test")
			.password("test")
			.build();

		memberService.login(memberDTO);

	}

}