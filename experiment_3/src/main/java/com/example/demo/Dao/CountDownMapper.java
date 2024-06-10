package com.example.demo.Dao;

import com.example.demo.Pojo.Po.CountDown;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface CountDownMapper {
    String allDown();
    String firstDown();
    CountDown startDown();
    CountDown finishDown();
    CountDown halfDown();
}
