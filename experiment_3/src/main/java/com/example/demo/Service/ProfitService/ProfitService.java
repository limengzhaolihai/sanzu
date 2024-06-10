package com.example.demo.Service.ProfitService;

import com.example.demo.Pojo.Po.LotteryOne;
import com.example.demo.Pojo.Po.Profit;

/**
 * 类的模板注释
 *
 * @author bosonghua
 * @date 2022/11/1 - 9:01
 */
public interface ProfitService {
    Profit calProfit(String testee_id);

    Profit calLotteryRevenue(String testee_id);

    Profit stageProfit(String testee_id);

    Profit finalProfit(String testee_id);

    Profit viewRoundProfit(String testee_id);

    Profit presetScale(String testee_id);

}
