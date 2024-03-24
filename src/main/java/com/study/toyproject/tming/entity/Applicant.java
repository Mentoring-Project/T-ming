package com.study.toyproject.tming.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "tb_study_applicant")
@DynamicInsert
public class Applicant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="apply_seq")
    private Integer applySeq;

    @Column(name="study_seq")
    private Integer studySeq;

    @Column(name="user_seq")
    private String userSeq;

    @Column(name="status")
    private String status;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(nullable = false, name="req_date")
    @CreationTimestamp
    private LocalDateTime reqDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(insertable = false, name="res_date")
    @UpdateTimestamp
    private LocalDateTime resDate;

}
