package com.example.demo.Service.ProfitService;

import com.example.demo.Dao.ProfitMapper;
import com.example.demo.Pojo.Po.LotteryOne;
import com.example.demo.Pojo.Po.Profit;
import com.example.demo.Service.CalculationService.CalculationService;
import org.apache.commons.lang.math.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 类的模板注释
 *
 * @author bosonghua
 * @date 2022/11/1 - 9:01
 */
@Serv
public class ProfitServiceImpl implements ProfitService {

    @Autowired
    private ProfitMapper profitMapper;

    @Autowired
    private CalculationService calculationService;

    public Profit calProfit(String testee_id) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:ss:mm");

        // 轮次信息
        Profit profitInfo = profitMapper.findRound(testee_id);
        if ("13".equals(profitInfo.getTEST_ROUND_ID())) {
            profitInfo.setTEST_ROUND_ID("12");
        }
        // 投资比例
        profitInfo.setTESTEE_ID(testee_id);
        List<Profit> ratio = profitMapper.findRatio(profitInfo);

        // Fund1/2/3 本轮资产 获取数据类型A/B
        String fund_group = profitMapper.findFundGroup(profitInfo).get(0).getFUND_GROUP();
        profitInfo.setFUND_GROUP(fund_group);
        List<Profit> fundList = profitMapper.findFund(profitInfo);


        // Fund1/2/3 上一轮资产
        Profit lastProfit = new Profit();
        lastProfit.setTEST_STAGE_ID(profitInfo.getTEST_STAGE_ID());
        lastProfit.setTEST_ROUND_ID(String.valueOf(Integer.valueOf(profitInfo.getTEST_ROUND_ID()) - 1));
        lastProfit.setFUND_GROUP(fund_group);
        List<Profit> fundLastList = profitMapper.findFund(lastProfit);

        // 上一次资产
        Profit LastIncome = profitMapper.findLastIncome(profitInfo);

        Double sumIncome = 0.0;
        Double fund = 0.0;
        // Fund1/2/3/末置 -- 本轮资产
        for (int i = 0; i < ratio.size(); i++) {
            // 需要判断第几轮
            if ("1".equals(profitInfo.getTEST_ROUND_ID())) {
                // 未配置资金
                if ("4".equals(ratio.get(i).getFUND_ID())) {
                    fund = 1000 * Double.parseDouble(ratio.get(i).getFUND_RATIO()) / 100;
                    profitInfo.setUNALLOCAT_INCOME(String.valueOf(fund));
                } else {
                    for (int k = 0; k < fundList.size(); k++) {
                        if (fundList.get(k).getFUND_ID().equals(ratio.get(i).getFUND_ID())) {
                            ratio.get(i).setFUND_RATIO(null == ratio.get(i).getFUND_RATIO() || "".equals(ratio.get(i).getFUND_RATIO()) ? "0" : ratio.get(i).getFUND_RATIO());
                            // B 有可能是变量
                            fund = 1000 * Double.parseDouble(ratio.get(i).getFUND_RATIO()) * Double.parseDouble(fundList.get(k).getPRICE()) / 100 / 100;
                            if ("1".equals(ratio.get(i).getFUND_ID())){
                                profitInfo.setFUND_ONE_INCOME(String.valueOf(fund));
                            }
                            if ("2".equals(ratio.get(i).getFUND_ID())){
                                profitInfo.setFUND_TWO_INCOME(String.valueOf(fund));
                            }
                            if ("3".equals(ratio.get(i).getFUND_ID())){
                                profitInfo.setFUND_THR_INCOME(String.valueOf(fund));
                            }
                        }
                    }
                }
                sumIncome += fund;
                // 第一轮之外
            } else {
                if ("4".equals(ratio.get(i).getFUND_ID())) {
                    fund = Double.parseDouble(LastIncome.getLastIncome()) * Double.parseDouble(ratio.get(i).getFUND_RATIO()) / 100;
                    profitInfo.setUNALLOCAT_INCOME(String.valueOf(fund));
                } else {
                    for (int k = 0; k < fundList.size(); k++) {
                        for (int j = 0; j < fundLastList.size(); j++) {
                            if (fundList.get(k).getFUND_ID().equals(ratio.get(i).getFUND_ID()) && fundLastList.get(j).getFUND_ID().equals(ratio.get(i).getFUND_ID())) {
                                ratio.get(i).setFUND_RATIO(null == ratio.get(i).getFUND_RATIO() || "".equals(ratio.get(i).getFUND_RATIO()) ? "0" : ratio.get(i).getFUND_RATIO());
                                System.out.println("上一轮资产:"+LastIncome.getLastIncome());
                                System.out.println("本轮比例:"+ratio.get(i).getFUND_RATIO());
                                System.out.println("本轮基金:"+fundList.get(k).getPRICE());
                                System.out.println("上一轮基金:"+fundLastList.get(j).getPRICE());
                                // 上一轮资产 * 本轮比例（eg: 1、2、3） * 本轮基金（eg: 1、2、3）的值 / 上一轮基金（eg: 1、2、3）的值
                                fund = Double.parseDouble(LastIncome.getLastIncome()) * Double.parseDouble(ratio.get(i).getFUND_RATIO()) * Double.parseDouble(fundList.get(k).getPRICE()) / Double.parseDouble(fundLastList.get(j).getPRICE()) / 100;
                                if ("1".equals(ratio.get(i).getFUND_ID())){
                                    profitInfo.setFUND_ONE_INCOME(String.valueOf(fund));
                                }
                                if ("2".equals(ratio.get(i).getFUND_ID())){
                                    profitInfo.setFUND_TWO_INCOME(String.valueOf(fund));
                                }
                                if ("3".equals(ratio.get(i).getFUND_ID())){
                                    profitInfo.setFUND_THR_INCOME(String.valueOf(fund));
                                }
                            }
                        }
                    }
                }
                sumIncome += fund;
            }
        }
        Double thisIncom = "1".equals(profitInfo.getTEST_ROUND_ID()) ? sumIncome - 1000 : sumIncome - Double.parseDouble(LastIncome.getLastIncome());
        Double cumINcom = sumIncome - 1000;

        profitInfo.setSUM_INCOME(String.valueOf(sumIncome));
        profitInfo.setSESSION_INCOME(String.valueOf(thisIncom));
        profitInfo.setACC_INCOME(String.valueOf(cumINcom));
        profitInfo.setCREATED_TIME(simpleDateFormat.format(new Date()));

        List<String> incomeList = profitMapper.isExistIncome(profitInfo);
        final int[] status = {1};
        incomeList.forEach(item -> {
            if (profitInfo.getTEST_ROUND_ID().equals(item)) {
                status[0] = 0;
            }
        });
        if (status[0] == 1) {
            // 保存进收益表
            profitMapper.insertIncome(profitInfo);
        }
        return profitInfo;
    }

    public Profit calLotteryRevenue(String testee_id) {

        Profit round = profitMapper.findRound(testee_id);
        round.setTEST_ROUND_ID("1");
        List<LotteryOne> lotteryList = profitMapper.findLottery(round);
        LotteryOne lotteryA = lotteryList.get(RandomUtils.nextInt(lotteryList.size()));
        List<String> listA = new ArrayList<>();
        listA.add(lotteryA.getCOUNT_1());
        listA.add(lotteryA.getCOUNY_2());
        String lotteryProfitA = listA.get(RandomUtils.nextInt(listA.size()));

        round.setTEST_ROUND_ID("2");
        List<LotteryOne> lotteryListB = profitMapper.findLottery(round);
        LotteryOne lotteryB = lotteryListB.get(RandomUtils.nextInt(lotteryListB.size()));
        List<String> listB = new ArrayList<>();
        listB.add(lotteryB.getCOUNT_1());
        listB.add(lotteryB.getCOUNY_2());
        String lotteryProfitB = listB.get(RandomUtils.nextInt(listB.size()));

        List<String> list = new ArrayList<>();
        list.add(lotteryProfitA);
        list.add(lotteryProfitB);
        String stageIncome = list.get(RandomUtils.nextInt(list.size()));

        stageIncome = 0 == stageIncome.length() || " ".equals(stageIncome) || "".equals(stageIncome) || null == stageIncome ? "0" : stageIncome;
        round.setSTAGE_INCOME(stageIncome);

        return round;
    }

    public Profit stageProfit(String testee_id) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:ss:mm");

        // 轮次信息
        Profit round = profitMapper.findRound(testee_id);

        Profit profit = this.calProfit(testee_id);
        String sum_income = profit.getSUM_INCOME();
        profit.setInvestmentIncome(sum_income);

        Profit effortProfit = calculationService.effortIncome(testee_id);
        String session_income = effortProfit.getSESSION_INCOME();
        profit.setHardworkIncome(session_income);

        profit.setTotalIncome(String.valueOf(Double.parseDouble(sum_income) + Double.parseDouble(session_income)));

        profit.setSTAGE_INCOME(profit.getTotalIncome());
        profit.setCREATED_TIME(simpleDateFormat.format(new Date()));
        profitMapper.saveStageIncome(profit);
        return profit;
    }

    public Profit finalProfit(String testee_id) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:ss:mm");
        DecimalFormat df = new DecimalFormat("#");
        DecimalFormat df1 = new DecimalFormat("#.0");
        Profit profitInfo = profitMapper.findRound(testee_id);

        List<Profit> stageIncomeList = profitMapper.findStageIncome(profitInfo);

        Profit profit = stageIncomeList.get(RandomUtils.nextInt(stageIncomeList.size()));
        String stageIncomeOne = profit.getSTAGE_INCOME();
        // 第一部分保留整数
        stageIncomeOne = df.format(Double.parseDouble(stageIncomeOne));

        String stageIncomeTwo = this.calLotteryRevenue(testee_id).getSTAGE_INCOME();
        // 第二部分保留整数
        if ("0".equals(stageIncomeTwo)){
            stageIncomeTwo = stageIncomeTwo;
        }else {
            stageIncomeTwo = df1.format(Double.parseDouble(stageIncomeTwo));
        }
        // 第一部分收益
        profit.setStageIncomeOne(stageIncomeOne);
        // 第二部分收益
        profit.setStageIncomeTwo(stageIncomeTwo);
        double income = Double.parseDouble(stageIncomeOne) + Double.parseDouble(stageIncomeTwo);
        // 总计一位小数
        String income1 = df1.format(income);
        // 总计
        profit.setTotalStageIncome(String.valueOf(income1));

        List<Profit> global = profitMapper.findGlobal();
        final String[] exitCost = {"0"};
        final String[] cashEquivalentRate = {"1"};
        global.forEach(item -> {
            if ("出场费".equals(item.getCONFIG_NAME())) {
                exitCost[0] = item.getCONFIG_VALUE();
            }
        });
        global.forEach(item -> {
            if ("实验点数与人民币的折算率".equals(item.getCONFIG_NAME())) {
                cashEquivalentRate[0] = item.getCONFIG_VALUE();
            }
        });
        // 折合现金 一位小数
        profit.setCashEquivalent(df1.format(Double.parseDouble(String.valueOf(income/Double.parseDouble(cashEquivalentRate[0])))));
        // 出场费 整数
        profit.setExitCost(df.format(Double.parseDouble(exitCost[0])));
        // 全部实验收益 一位小数
        String lastIncome = df1.format(Double.parseDouble(String.valueOf(Double.parseDouble(exitCost[0]) + Double.parseDouble(profit.getCashEquivalent()))));
        profit.setTotalEquipIncome(lastIncome);

        // 最终收益保存到阶段收益表
        profitInfo.setTEST_STAGE_ID("6");
        profitInfo.setSTAGE_INCOME(lastIncome);
        profitInfo.setCREATED_TIME(simpleDateFormat.format(new Date()));
        profitMapper.saveStageIncome(profitInfo);
        return profit;
    }

    public Profit viewRoundProfit(String testee_id) {
        Profit profitInfo = profitMapper.findRound(testee_id);

        Profit profit = profitMapper.viewRoundProfit(profitInfo);
        return profit;
    }

    public Profit presetScale(String testee_id) {
        DecimalFormat df = new DecimalFormat("#");
        DecimalFormat df1 = new DecimalFormat("#.0");

        Profit profitInfo = profitMapper.findRound(testee_id);

        Profit profit = profitMapper.presetScale(profitInfo);

        Profit profit1 = new Profit();
        if (null ==profit){
            profit1.setUNALLOCAT_INCOME_RATE("100");
            profit1.setFUND_ONE_INCOME_RATE("0");
            profit1.setFUND_TWO_INCOME_RATE("0");
            profit1.setFUND_THR_INCOME_RATE("0");
        }else {
            Double FUND_ONE_INCOME_RATE =Double.parseDouble(df.format(Double.parseDouble(profit.getFUND_ONE_INCOME())/Double.parseDouble(profit.getSUM_INCOME())*100));
            Double FUND_TWO_INCOME_RATE =Double.parseDouble(df.format(Double.parseDouble(profit.getFUND_TWO_INCOME())/Double.parseDouble(profit.getSUM_INCOME())*100));
            Double FUND_THR_INCOME_RATE =Double.parseDouble(df.format(Double.parseDouble(profit.getFUND_THR_INCOME())/Double.parseDouble(profit.getSUM_INCOME())*100));
            Double UNALLOCAT_INCOME_RATE = 100 - FUND_ONE_INCOME_RATE - FUND_TWO_INCOME_RATE - FUND_THR_INCOME_RATE;
            if (UNALLOCAT_INCOME_RATE <= 0){
                profit1.setUNALLOCAT_INCOME_RATE("0");
            }else {
                profit1.setUNALLOCAT_INCOME_RATE(String.valueOf(df.format(UNALLOCAT_INCOME_RATE)));
            }
            profit1.setFUND_ONE_INCOME_RATE(String.valueOf(df.format(FUND_ONE_INCOME_RATE)));
            profit1.setFUND_TWO_INCOME_RATE(String.valueOf(df.format(FUND_TWO_INCOME_RATE)));
            profit1.setFUND_THR_INCOME_RATE(String.valueOf(df.format(FUND_THR_INCOME_RATE)));
        }
        return profit1;
    }
}
