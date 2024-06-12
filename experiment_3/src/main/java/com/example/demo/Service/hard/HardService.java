package com.example.demo.Service.hard;

import com.example.demo.Pojo.entity.HardEntity;

import java.util.List;

/**
 * @author MZ_Li
 * @date 2024/6/12 11:03
 */
public interface HardService {
    List<HardEntity> list();

    void remove(Long id);
}
