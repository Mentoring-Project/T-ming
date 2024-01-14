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
		memberDTO.setName(Member.getName());
		memberDTO.setId(Member.getId());
		memberDTO.setPassword(Member.getPassword());
		memberDTO.setEmail(Member.getEmail());
		memberDTO.setGender(Member.getGender());
		memberDTO.setAge(Member.getAge());
		memberDTO.setPhone(Member.getPhone());
		memberDTO.setCreateDate(Member.getCreateDate());
		return memberDTO;
	}
	
}
