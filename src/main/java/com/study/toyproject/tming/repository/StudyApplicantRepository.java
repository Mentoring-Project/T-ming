package com.study.toyproject.tming.repository;

import com.study.toyproject.tming.entity.Applicant;
import com.study.toyproject.tming.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudyApplicantRepository extends JpaRepository<Applicant,Integer> {
}
