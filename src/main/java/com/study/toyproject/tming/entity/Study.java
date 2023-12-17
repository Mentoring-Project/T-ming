package com.study.toyproject.tming.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Study {

    @Id @GeneratedValue
    private Integer seq;
}
