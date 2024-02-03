package com.study.toyproject.tming.service;

import com.study.toyproject.tming.dto.MemberDTO;
import com.study.toyproject.tming.entity.Member;
import com.study.toyproject.tming.repository.MemberJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class MemberService {

	private final MemberJpaRepository memberJpaRepository;

	public void save(MemberDTO memberDTO) {
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

	public MemberDTO login(MemberDTO memberDTO) {

		Member user = memberJpaRepository.findById(memberDTO.getId());

		if(user == null) {
			return null;
		}

		if(!user.getPassword().equals(memberDTO.getPassword())) {
			return null;
		}

		MemberDTO dto = MemberDTO.builder()
			.id(user.getId())
			.password(user.getPassword())
			.build();

		return dto;
	}

	public boolean checkId(String id) {
		Member byId = memberJpaRepository.findById(id);
		if (byId != null) {
			// 조회결과가 있다 -> 사용할 수 없다.
			return false;
		} else {
			// 조회결과가 없다 -> 사용할 수 있다.
			return true;
		}
	}

	public MemberDTO findById(String id) {
		Member member = memberJpaRepository.findById(id);
		if (member != null) {
			return MemberDTO.builder()
				.id(member.getId())
				.build();
		} else {
			return null;
		}

	}

}
