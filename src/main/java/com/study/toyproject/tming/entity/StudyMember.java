package com.study.toyproject.tming.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;

@Entity
@Data
@Table(name = "tb_study_member")
@DynamicInsert
public class StudyMember {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="member_seq")
    private Integer memberSeq;

    @Column(name="study_seq")
    private Integer studySeq;

    @Column(name="user_seq")
    private String userSeq;

    @Column(name="category_seq")
    private Integer categorySeq;
}
