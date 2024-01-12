package com.study.toyproject.tming.entity;

import com.study.toyproject.tming.dto.MemberDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_user")
public class Member {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_seq")
	private Integer userSeq;

	@Column(name = "name")
	private String name;

	@Column(name = "id")
	private String id;

	@Column(name = "password")
	private String password;

	@Column(name = "email")
	private String email;

	@Column(name = "gender")
	private String gender;

	@Column(name = "age")
	private Integer age;

	@Column(name = "phone")
	private String phone;

	@Column(name = "create_date")
	private LocalDateTime createDate;

	@Column(name = "update_date")
	private LocalDateTime updateDate;

	public static Member toMember(MemberDTO memberDTO) {
		Member Member = new Member();
		Member.setName(memberDTO.getName());
		Member.setId(memberDTO.getId());
		Member.setPassword(memberDTO.getPassword());
		Member.setEmail(memberDTO.getEmail());
		Member.setGender(memberDTO.getGender());
		Member.setAge(memberDTO.getAge());
		Member.setPhone(memberDTO.getPhone());
		Member.setCreateDate(memberDTO.getCreateDate());
		return Member;
	}

	public static Member toModifyMember(MemberDTO memberDTO) {
		Member Member = new Member();
		Member.setName(memberDTO.getName());
		Member.setId(memberDTO.getId());
		Member.setPassword(memberDTO.getPassword());
		Member.setEmail(memberDTO.getEmail());
		Member.setGender(memberDTO.getGender());
		Member.setAge(memberDTO.getAge());
		Member.setPhone(memberDTO.getPhone());
		Member.setUpdateDate(memberDTO.getUpdateDate());
		return Member;
	}

}
