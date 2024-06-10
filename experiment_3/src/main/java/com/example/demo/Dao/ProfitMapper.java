package com.example.demo.Dao;

import com.example.demo.Pojo.Po.LotteryOne;
import com.example.demo.Pojo.Po.Profit;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 类的模板注释
 *
 * @author bosonghua
 * @date 2022/11/1 - 9:14
 */
@Mapper
@Repository
public interface ProfitMapper {

    // 获取场次、阶段、轮次
    Profit findRound(String TESTEE_ID);

    //获取登录人、场次、阶段、轮次对应的基金编号、投资比例
    List<Profit> findRatio(Profit profit);

    List<Profit> findFundGroup(Profit profit);

    // 获取基金详情表价值
    List<Profit> findFund(Profit profit);

    // 保存本轮次收入
    void insertIncome(Profit profit);

    List<String> isExistIncome(Profit profit);

    //获取上一轮总市值
    Profit findLastIncome(Profit profit);

    // 查询符合条件的彩票
    List<LotteryOne> findLottery(Profit profit);

    // 阶段收益保存
    void saveStageIncome(Profit profit);

    List<Profit> findStageIncome(Profit profit);

    List<Profit> findGlobal();

    // 查看轮次的收益
    Profit viewRoundProfit(Profit profit);

    Profit presetScale(Profit profit);

}
