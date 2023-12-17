package com.study.toyproject.tming.Repository;

import com.study.toyproject.tming.Entity.Study;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class StudyJpaRepositoryTest {

    @Autowired
    StudyJpaRepository studyJpaRepository;

    @Test
    public void testStudy() {
        Study study = new Study();
        study.setSeq(1);
        Study studySeq = studyJpaRepository.save(study);
        studyJpaRepository.find(studySeq);
    }

}