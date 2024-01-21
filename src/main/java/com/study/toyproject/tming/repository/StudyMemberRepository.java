package com.study.toyproject.tming.repository;

import com.study.toyproject.tming.entity.StudyMember;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudyMemberRepository extends JpaRepository<StudyMember, Integer> {
}
