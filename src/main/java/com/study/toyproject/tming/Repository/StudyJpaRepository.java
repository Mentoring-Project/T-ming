package com.study.toyproject.tming.Repository;

import com.study.toyproject.tming.Entity.Study;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class StudyJpaRepository {

    @PersistenceContext
    private EntityManager em;

    public Study save(Study study) {
        em.persist(study);
        return study;
    }

    public Study find(Study study) {
        return em.find(Study.class, study);
    }
}
