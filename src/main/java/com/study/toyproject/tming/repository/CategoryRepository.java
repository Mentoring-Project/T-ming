package com.study.toyproject.tming.repository;

import com.study.toyproject.tming.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
}
