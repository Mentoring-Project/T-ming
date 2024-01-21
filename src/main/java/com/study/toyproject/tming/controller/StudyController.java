package com.study.toyproject.tming.controller;

import com.study.toyproject.tming.entity.Study;
import com.study.toyproject.tming.repository.StudyRepository;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/study")
@RequiredArgsConstructor
public class StudyController {

    @Autowired
    StudyRepository studyJpaRepository;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/list")
    public String StudyList (Model model, HttpServletRequest request) {

        //TODO 로그인 타입
        //logger.info("loginId = {}", request.getSession());

        List<Study> studyList = studyJpaRepository.findAll();
        model.addAttribute("studyList", studyList);


        logger.info("studyList = {}", studyList);

        return "study/studyList";
    }

}
