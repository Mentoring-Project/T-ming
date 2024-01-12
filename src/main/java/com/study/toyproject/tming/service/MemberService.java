package com.study.toyproject.tming.service;

import com.study.toyproject.tming.dto.MemberDTO;
import com.study.toyproject.tming.entity.Member;
import com.study.toyproject.tming.repository.MemberJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MemberService {

	private final MemberJpaRepository memberJpaRepository;

	public void save(MemberDTO memberDTO) {
		Member member = new Member();
		member.toMember(memberDTO);
		memberJpaRepository.save(member);
	}

	public MemberDTO login(MemberDTO memberDTO) {

		Optional<Member> byId = memberJpaRepository.findById(memberDTO.getId());
		if (byId.isPresent()) {
			Member Member = byId.get();
			if (Member.getPassword().equals(memberDTO.getPassword())) {
				MemberDTO dto = MemberDTO.toMemberDTO(Member);
				return dto;
			} else {
				return null;
			}
		} else {
			return null;
		}
	}

	public List<MemberDTO> findAll() {
		List<Member> MemberList = memberJpaRepository.findAll();
		List<MemberDTO> memberDTOList = new ArrayList<>();
		for (Member Member: MemberList) {
			memberDTOList.add(MemberDTO.toMemberDTO(Member));
//            MemberDTO memberDTO = MemberDTO.toMemberDTO(Member);
//            memberDTOList.add(memberDTO);
		}
		return memberDTOList;
	}

	public MemberDTO findById(String id) {
		Optional<Member> optionalMember = memberJpaRepository.findById(id);
		if (optionalMember.isPresent()) {
//            Member Member = optionalMember.get();
//            MemberDTO memberDTO = MemberDTO.toMemberDTO(Member);
//            return memberDTO;
			return MemberDTO.toMemberDTO(optionalMember.get());
		} else {
			return null;
		}

	}

	public MemberDTO updateForm(String id) {
		Optional<Member> optionalMember = memberJpaRepository.findById(id);
		if (optionalMember.isPresent()) {
			return MemberDTO.toMemberDTO(optionalMember.get());
		} else {
			return null;
		}
	}

	public void update(MemberDTO memberDTO) {
		memberJpaRepository.save(Member.toModifyMember(memberDTO));
	}

	public void deleteById(String id) {
		memberJpaRepository.deleteById(Long.valueOf(id));
	}

	public String checkId(String id) {
		Optional<Member> byId = memberJpaRepository.findById(id);
		if (byId.isPresent()) {
			// 조회결과가 있다 -> 사용할 수 없다.
			return "null";
		} else {
			// 조회결과가 없다 -> 사용할 수 있다.
			return "ok";
		}
	}

}
