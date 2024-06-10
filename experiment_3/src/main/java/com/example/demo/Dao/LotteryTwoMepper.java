package com.example.demo.Dao;

import com.example.demo.Pojo.Po.LotteryTwo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface LotteryTwoMepper {
    //彩票选择二 新增一条彩票表数据
    void insertLotteryTwo(LotteryTwo lotteryTwo);
}
