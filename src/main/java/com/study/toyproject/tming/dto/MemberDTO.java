package com.study.toyproject.tming.dto;

import com.study.toyproject.tming.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberDTO {

	private String name;
	private String id;
	private String password;
	private String email;
	private String gender;
	private Integer age;
	private String phone;
	private LocalDateTime createDate;
	private LocalDateTime updateDate;

	public static MemberDTO toMemberDTO(Member Member) {
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId(Member.getId());
		memberDTO.setEmail(Member.getEmail());
		memberDTO.setPassword(Member.getPassword());
		memberDTO.setName(Member.getName());
		return memberDTO;
	}
	
}
