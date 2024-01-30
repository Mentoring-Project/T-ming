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
@Table(name = "tb_study")
@DynamicInsert
public class Study {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="study_seq")
    private Integer studySeq;

    @Column(name="user_seq")
    private Integer userSeq;

    @Column(name="category_seq")
    private Integer categorySeq;

    @Column
    private String title;

    @Column(name="sub_title")
    private String subitle;

    @Column
    private String contents;

    @Column(name="recruit_int")
    private Integer recruitInt;

    @Column
    private String type;

    @Column(name="hope_area")
    private String hopeArea;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(nullable = true, name="start_date")
    private LocalDateTime startDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(nullable = true, name="end_date")
    private LocalDateTime endDate;

    @Column
    private String status;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Column(nullable = false, name="create_date")
    @CreationTimestamp
    private LocalDateTime createDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Column(insertable = false, name="update_date")
    @UpdateTimestamp
    private LocalDateTime updateDate;

    @Column(name="portfolio_yn")
    private String portfolioYn;

}
