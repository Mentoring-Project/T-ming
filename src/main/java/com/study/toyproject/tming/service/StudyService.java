package com.study.toyproject.tming.service;

import com.study.toyproject.tming.entity.Category;
import com.study.toyproject.tming.entity.Study;
import com.study.toyproject.tming.repository.CategoryRepository;
import com.study.toyproject.tming.repository.StudyRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudyService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final StudyRepository studyJpaRepository;
    private final CategoryRepository categoryRepository;


    public List<Study> getStudyList() {
        List<Study> studyList = studyJpaRepository.findAll();
        if (!studyList.isEmpty()) {
            //신청 인원도 구하기
        }

        return studyList;
    }

    public Optional<Study> getStudyDetail(Integer studySeq) {
        return studyJpaRepository.findById(studySeq);
    }

    public Optional<Category> getCategoryType(Integer categorySeq) {
        return categoryRepository.findById(categorySeq);
    }

}
