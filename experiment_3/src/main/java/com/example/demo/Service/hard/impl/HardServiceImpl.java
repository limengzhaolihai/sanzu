package com.example.demo.Service.hard.impl;

import com.example.demo.Dao.hard.HardMapper;
import com.example.demo.Pojo.entity.HardEntity;
import com.example.demo.Service.hard.HardService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author MZ_Li
 * @date 2024/6/12 11:03
 */
@Service
public class HardServiceImpl implements HardService {
    @Resource
    private HardMapper hardMapper;

    @Override
    public List<HardEntity> list() {
        return hardMapper.list().stream().peek(e -> {
            BigDecimal add = e.getNumF().add(e.getNumS());
            e.setResult(add);
        }).collect(Collectors.toList());
    }

    @Override
    public void remove(Long id) {
        hardMapper.remove(id);
    }
}
