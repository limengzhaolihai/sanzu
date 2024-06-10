package com.example.demo.Dao;

import com.example.demo.Pojo.Po.LotteryOne;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface LotteryOneMepper {

    //	彩票表中插入一条数据-------彩票选择1
    void  inertLotteryOne(LotteryOne lotteryOne);
    //更新进度表 为第四阶段第一轮
    void  updateTestee(LotteryOne  lotteryOne);


}
