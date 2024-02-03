package com.study.toyproject.tming.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
public class MemberDTO {

	private Integer userSeq;
	private String name;
	private String id;
	private String password;
	private String email;
	private String gender;
	private Integer age;
	private String phone;
	private LocalDateTime createDate;
	private LocalDateTime updateDate;
	
}
