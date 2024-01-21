package com.study.toyproject.tming.repository;

import com.study.toyproject.tming.entity.Portfolio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PortfolioRepository extends JpaRepository<Portfolio, Integer> {
}
