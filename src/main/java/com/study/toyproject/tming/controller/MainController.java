package com.study.toyproject.tming.controller;

import com.study.toyproject.tming.entity.Study;
import com.study.toyproject.tming.service.StudyService;
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
@RequestMapping("/main")
@RequiredArgsConstructor
public class MainController {

    private final StudyService studyService;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/list")
    public String getMainList(Model model, HttpServletRequest request) {

        List<Study> studyList = studyService.getStudyList();

        model.addAttribute("studyList", studyList);
        logger.info("studyList = {}", studyList);

        return "/main/main";
    }
}
