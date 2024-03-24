package com.study.toyproject.tming.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;

@Entity
@Data
@Table(name = "tb_study_category")
@DynamicInsert
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="category_seq")
    private Integer categorySeq;

    @Column(name="category_type")
    private Integer categoryType;

    @Column(name="category_add")
    private Integer categoryAdd;

}
