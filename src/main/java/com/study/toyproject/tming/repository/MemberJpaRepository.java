package com.study.toyproject.tming.repository;

import com.study.toyproject.tming.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberJpaRepository extends JpaRepository<Member,Long> {
	Member findById(String id);
}
