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
@Table(name = "tb_portfolio")
@DynamicInsert
public class Portfolio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="port_seq")
    private Integer portSeq;

    @Column(name="study_seq")
    private Integer studySeq;

    @Column(name="file_seq")
    private Integer fileSeq;

    @Column(name="category_seq")
    private Integer categorySeq;

    @Column(name="title")
    private String title;

    @Column(name="sub_title")
    private String subTitle;

    @Column(name="status")
    private String status;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Column(nullable = false, name="create_date")
    @CreationTimestamp
    private LocalDateTime createDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Column(insertable = false, name="update_date")
    @UpdateTimestamp
    private LocalDateTime updateDate;

    @Column(name="creator")
    private String creator;

    @Column(name="updator")
    private String updator;
}
