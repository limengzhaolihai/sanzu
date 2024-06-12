package com.example.demo.Pojo.entity;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author MZ_Li
 * @date 2024/6/12 11:21
 */
@Data
public class HardEntity {
    private Long id;
    private BigDecimal numF;
    private BigDecimal numS;
    private BigDecimal result;
}
