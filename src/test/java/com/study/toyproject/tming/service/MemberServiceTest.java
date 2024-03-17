package com.study.toyproject.tming.service;

import com.study.toyproject.tming.dto.MemberDTO;
import com.study.toyproject.tming.entity.Member;
import com.study.toyproject.tming.repository.MemberJpaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.mockito.Mockito.mock;

@SpringBootTest
public class MemberServiceTest {
	MemberDTO memberDTO = new MemberDTO(1, "test", "test", "test", "test@test", "M", 20, "01012345678", LocalDateTime.now(), null);
	MemberJpaRepository memberJpaRepository = mock(MemberJpaRepository.class);

	@Test
	public void saveTest() {
		Member member = Member.builder()
			.name(memberDTO.getName())
			.id(memberDTO.getId())
			.password(memberDTO.getPassword())
			.email(memberDTO.getEmail())
			.gender(memberDTO.getGender())
			.age(memberDTO.getAge())
			.phone(memberDTO.getPhone())
			.build();
		memberJpaRepository.save(member);
	}

	@Test
	public void loginTest() {
		Member byId = memberJpaRepository.findById(memberDTO.getId());
		if (byId != null) {
			Member member = Member.builder()
				.id(memberDTO.getId())
				.password(memberDTO.getPassword())
				.build();
			if (member.getPassword().equals(memberDTO.getPassword())) {
				MemberDTO dto = MemberDTO.builder()
					.id(member.getId())
					.password(member.getPassword())
					.build();
			}
		}
	}

	@Test
	public void checkIdTest() {
		Member byId = memberJpaRepository.findById(memberDTO.getId());
		if (byId != null) {

		}
	}

}
