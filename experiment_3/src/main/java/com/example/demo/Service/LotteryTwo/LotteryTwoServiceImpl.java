package com.example.demo.Service.LotteryTwo;

import com.example.demo.Dao.LotteryTwoMepper;
import com.example.demo.Pojo.Po.LotteryTwo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LotteryTwoServiceImpl implements LotteryTwoService {
    @Autowired
    LotteryTwoMepper lotteryTwoMepper;

    @Override
    public void inertLotteryTwo(LotteryTwo lotteryTwo) {
        lotteryTwoMepper.insertLotteryTwo(lotteryTwo);
    }
}



