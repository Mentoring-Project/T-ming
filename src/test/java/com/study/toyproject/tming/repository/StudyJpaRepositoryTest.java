package com.study.toyproject.tming.repository;

import com.study.toyproject.tming.entity.Study;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;


@SpringBootTest
@Transactional
class StudyJpaRepositoryTest {

    @Autowired
    StudyRepository studyJpaRepository;

    @Test
    public void testStudyList() {
        Study study = new Study();
        study.setCategorySeq(1);
        study.setUserSeq(1);
        study.setTitle("test");

        Study saveStudy = studyJpaRepository.save(study);
        Optional<Study> findStudy = studyJpaRepository.findById(saveStudy.getStudySeq());

        assertThat(findStudy.get().getTitle().equals(study.getTitle()));
    }

}