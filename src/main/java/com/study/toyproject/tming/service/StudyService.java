package com.study.toyproject.tming.service;

import com.study.toyproject.tming.entity.Applicant;
import com.study.toyproject.tming.entity.Category;
import com.study.toyproject.tming.entity.Study;
import com.study.toyproject.tming.entity.StudyMember;
import com.study.toyproject.tming.enums.ApplicationStatusType;
import com.study.toyproject.tming.repository.CategoryRepository;
import com.study.toyproject.tming.repository.StudyApplicantRepository;
import com.study.toyproject.tming.repository.StudyMemberRepository;
import com.study.toyproject.tming.repository.StudyRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudyService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final StudyRepository studyJpaRepository;
    private final CategoryRepository categoryRepository;
    private final StudyMemberRepository studyMemberRepository;

    public List<Study> getStudyList() {
        List<Study> studyList = studyJpaRepository.findAll();

        if (!ObjectUtils.isEmpty(studyList)) {
            List<StudyMember> studyMemberList = studyMemberRepository.findAll();

            if (!ObjectUtils.isEmpty(studyMemberList)) {
                for(int i=0 ; i<studyList.size() ; i++) {
                    int num = 0;
                    for (int j=0 ; j<studyMemberList.size() ; j++) {
                        if (studyList.get(i).getStudySeq() == studyMemberList.get(j).getStudySeq()) {
                            num++;
                        }
                        studyList.get(i).setMemberNum(num);
                    }
                }
            }
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
