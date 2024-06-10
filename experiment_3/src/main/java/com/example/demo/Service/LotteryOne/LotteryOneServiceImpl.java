package com.example.demo.Service.LotteryOne;

import com.example.demo.Dao.LotteryOneMepper;
import com.example.demo.Pojo.Po.LotteryOne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class LotteryOneServiceImpl implements LotteryOneService {
    @Autowired
    LotteryOneMepper lotteryOneMepper;
    @Override
    public void inertLotteryOne(LotteryOne lotteryOne) {
        lotteryOneMepper.inertLotteryOne(lotteryOne);
    }

    @Override
    public void updateOne(LotteryOne lotteryOne) {
        lotteryOneMepper.updateTestee(lotteryOne);
    }
}
