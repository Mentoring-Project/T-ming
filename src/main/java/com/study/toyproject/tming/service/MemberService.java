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
				return dto;
			} else {
				return null;
			}
		} else {
			return null;
		}
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

	public List<MemberDTO> findAll() {
		List<Member> MemberList = memberJpaRepository.findAll();
		List<MemberDTO> memberDTOList = new ArrayList<>();
		for (Member member: MemberList) {
			memberDTOList.add(MemberDTO.builder()
				.name(member.getName())
				.id(member.getId())
				.password(member.getPassword())
				.email(member.getEmail())
				.gender(member.getGender())
				.age(member.getAge())
				.phone(member.getPhone())
				.build());
		}
		return memberDTOList;
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

	public MemberDTO updateForm(String id) {
		Member member = memberJpaRepository.findById(id);
		if (member != null) {
			return MemberDTO.builder()
				.name(member.getName())
				.id(member.getId())
				.password(member.getPassword())
				.email(member.getEmail())
				.gender(member.getGender())
				.age(member.getAge())
				.phone(member.getPhone())
				.build();
		} else {
			return null;
		}
	}

	public void update(MemberDTO memberDTO) {
		memberJpaRepository.save(Member.builder()
			.name(memberDTO.getName())
			.id(memberDTO.getId())
			.password(memberDTO.getPassword())
			.email(memberDTO.getEmail())
			.gender(memberDTO.getGender())
			.age(memberDTO.getAge())
			.phone(memberDTO.getPhone())
			.build());
	}

	public void deleteById(String id) {
		memberJpaRepository.deleteById(Long.valueOf(id));
	}

}
