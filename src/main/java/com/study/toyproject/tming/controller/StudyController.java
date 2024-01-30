package com.study.toyproject.tming.controller;

import com.study.toyproject.tming.entity.Category;
import com.study.toyproject.tming.entity.Study;
import com.study.toyproject.tming.repository.StudyRepository;
import com.study.toyproject.tming.service.StudyService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@Controller
@RequestMapping("/study")
@RequiredArgsConstructor
public class StudyController {

    private final StudyService studyService;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/list")
    public String StudyList (Model model, HttpServletRequest request) {

        //TODO 로그인 타입
        //logger.info("loginId = {}", request.getSession());

        List<Study> studyList = studyService.getStudyList();
        model.addAttribute("studyList", studyList);
        //신청 인원
        model.addAttribute("applicantNo", 0);

        logger.info("studyList = {}", studyList);

        return "study/studyList";
    }

    @GetMapping("/studyDetail")
    public String studyDetail (Model model, HttpServletRequest request, @RequestParam Integer studySeq) {

        //TODO 로그인 타입
        //logger.info("loginId = {}", request.getSession());

        if (studySeq != null) {
            Optional<Study> study = studyService.getStudyDetail(studySeq);
            Optional<Category> category = studyService.getCategoryType(study.get().getCategorySeq());

            model.addAttribute("study", study);
            model.addAttribute("category", category);
        } else {

        }

        logger.info("studyList = {}");

        return "study/studyDetail";
    }


    @PostMapping("/studyDetail")
    public String studyDetail (Model model, HttpServletRequest request, @RequestBody Study study) {


        logger.info("studyList = {}");

        return "redirect:/study/studyDetail";
    }


}
