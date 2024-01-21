package com.study.toyproject.tming.repository;

import com.study.toyproject.tming.entity.Study;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudyRepository extends JpaRepository<Study,Integer> {
}
