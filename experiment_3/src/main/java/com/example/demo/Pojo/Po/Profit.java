package com.example.demo.Pojo.Po;

/**
 * 收益
 *
 * @author bosonghua
 * @date 2022/11/1 - 8:53
 */
public class Profit {

    private String TESTEE_ID; // 被试者编号
    private String TEST_ID; // 实验编号
    private String TEST_SESSION_ID; // 实验场次
    private String TEST_STAGE_ID; // 实验阶段
    private String TEST_ROUND_ID; // 实验轮次
    private String CREATED_TIME; // 创建时间

    private String SUM_INCOME; // 总市值
    private String SESSION_INCOME; // 本轮收益
    private String ACC_INCOME; // 累计收益

    private String START_END; // 是否开始
    private String FUND_RATIO; // 投资比例
    private String FUND_ID; // 基金编号
    private String lastIncome; // 上一轮总市值

    private String FUND_NUM; // 基金详情表轮次
    private String PRICE; // 基金详情表价值
    private String FUND_GROUP; // A / B

    private String investmentIncome; // 投资任务收益
    private String hardworkIncome; // 努力任务收益
    private String totalIncome; // 总收益

    private String STAGE_INCOME; // 阶段收益

    private String stageIncomeOne; // 第一部分收益
    private String stageIncomeTwo; // 第二部分收益
    private String totalStageIncome; // 总计收益
    private String cashEquivalent; // 折合现金金额
    private String exitCost; // 出场费
    private String totalEquipIncome; // 全部实验报酬

    private String CONFIG_NAME; // 配置名称
    private String CONFIG_VALUE; // 配置值

    private String FUND_ONE_INCOME; // fund1资产
    private String FUND_TWO_INCOME; // fund2资产
    private String FUND_THR_INCOME; // fund3资产
    private String UNALLOCAT_INCOME; // 未配置资产

    private String FUND_ONE_INCOME_RATE; // fund1资产比例
    private String FUND_TWO_INCOME_RATE; // fund2资产比例
    private String FUND_THR_INCOME_RATE; // fund3资产比例
    private String UNALLOCAT_INCOME_RATE; // 未配置资产比例

    @Override
    public String toString() {
        return "Profit{" +
                "TESTEE_ID='" + TESTEE_ID + '\'' +
                ", TEST_ID='" + TEST_ID + '\'' +
                ", TEST_SESSION_ID='" + TEST_SESSION_ID + '\'' +
                ", TEST_STAGE_ID='" + TEST_STAGE_ID + '\'' +
                ", TEST_ROUND_ID='" + TEST_ROUND_ID + '\'' +
                ", CREATED_TIME='" + CREATED_TIME + '\'' +
                ", SUM_INCOME='" + SUM_INCOME + '\'' +
                ", SESSION_INCOME='" + SESSION_INCOME + '\'' +
                ", ACC_INCOME='" + ACC_INCOME + '\'' +
                ", START_END='" + START_END + '\'' +
                ", FUND_RATIO='" + FUND_RATIO + '\'' +
                ", FUND_ID='" + FUND_ID + '\'' +
                ", lastIncome='" + lastIncome + '\'' +
                ", FUND_NUM='" + FUND_NUM + '\'' +
                ", PRICE='" + PRICE + '\'' +
                ", FUND_GROUP='" + FUND_GROUP + '\'' +
                ", investmentIncome='" + investmentIncome + '\'' +
                ", hardworkIncome='" + hardworkIncome + '\'' +
                ", totalIncome='" + totalIncome + '\'' +
                ", STAGE_INCOME='" + STAGE_INCOME + '\'' +
                ", stageIncomeOne='" + stageIncomeOne + '\'' +
                ", stageIncomeTwo='" + stageIncomeTwo + '\'' +
                ", totalStageIncome='" + totalStageIncome + '\'' +
                ", cashEquivalent='" + cashEquivalent + '\'' +
                ", exitCost='" + exitCost + '\'' +
                ", totalEquipIncome='" + totalEquipIncome + '\'' +
                ", CONFIG_NAME='" + CONFIG_NAME + '\'' +
                ", CONFIG_VALUE='" + CONFIG_VALUE + '\'' +
                ", FUND_ONE_INCOME='" + FUND_ONE_INCOME + '\'' +
                ", FUND_TWO_INCOME='" + FUND_TWO_INCOME + '\'' +
                ", FUND_THR_INCOME='" + FUND_THR_INCOME + '\'' +
                ", UNALLOCAT_INCOME='" + UNALLOCAT_INCOME + '\'' +
                ", FUND_ONE_INCOME_RATE='" + FUND_ONE_INCOME_RATE + '\'' +
                ", FUND_TWO_INCOME_RATE='" + FUND_TWO_INCOME_RATE + '\'' +
                ", FUND_THR_INCOME_RATE='" + FUND_THR_INCOME_RATE + '\'' +
                ", UNALLOCAT_INCOME_RATE='" + UNALLOCAT_INCOME_RATE + '\'' +
                '}';
    }

    public String getTESTEE_ID() {
        return TESTEE_ID;
    }

    public void setTESTEE_ID(String TESTEE_ID) {
        this.TESTEE_ID = TESTEE_ID;
    }

    public String getTEST_ID() {
        return TEST_ID;
    }

    public void setTEST_ID(String TEST_ID) {
        this.TEST_ID = TEST_ID;
    }

    public String getTEST_SESSION_ID() {
        return TEST_SESSION_ID;
    }

    public void setTEST_SESSION_ID(String TEST_SESSION_ID) {
        this.TEST_SESSION_ID = TEST_SESSION_ID;
    }

    public String getTEST_STAGE_ID() {
        return TEST_STAGE_ID;
    }

    public void setTEST_STAGE_ID(String TEST_STAGE_ID) {
        this.TEST_STAGE_ID = TEST_STAGE_ID;
    }

    public String getTEST_ROUND_ID() {
        return TEST_ROUND_ID;
    }

    public void setTEST_ROUND_ID(String TEST_ROUND_ID) {
        this.TEST_ROUND_ID = TEST_ROUND_ID;
    }

    public String getCREATED_TIME() {
        return CREATED_TIME;
    }

    public void setCREATED_TIME(String CREATED_TIME) {
        this.CREATED_TIME = CREATED_TIME;
    }

    public String getSUM_INCOME() {
        return SUM_INCOME;
    }

    public void setSUM_INCOME(String SUM_INCOME) {
        this.SUM_INCOME = SUM_INCOME;
    }

    public String getSESSION_INCOME() {
        return SESSION_INCOME;
    }

    public void setSESSION_INCOME(String SESSION_INCOME) {
        this.SESSION_INCOME = SESSION_INCOME;
    }

    public String getACC_INCOME() {
        return ACC_INCOME;
    }

    public void setACC_INCOME(String ACC_INCOME) {
        this.ACC_INCOME = ACC_INCOME;
    }

    public String getSTART_END() {
        return START_END;
    }

    public void setSTART_END(String START_END) {
        this.START_END = START_END;
    }

    public String getFUND_RATIO() {
        return FUND_RATIO;
    }

    public void setFUND_RATIO(String FUND_RATIO) {
        this.FUND_RATIO = FUND_RATIO;
    }

    public String getFUND_ID() {
        return FUND_ID;
    }

    public void setFUND_ID(String FUND_ID) {
        this.FUND_ID = FUND_ID;
    }

    public String getLastIncome() {
        return lastIncome;
    }

    public void setLastIncome(String lastIncome) {
        this.lastIncome = lastIncome;
    }

    public String getFUND_NUM() {
        return FUND_NUM;
    }

    public void setFUND_NUM(String FUND_NUM) {
        this.FUND_NUM = FUND_NUM;
    }

    public String getPRICE() {
        return PRICE;
    }

    public void setPRICE(String PRICE) {
        this.PRICE = PRICE;
    }

    public String getFUND_GROUP() {
        return FUND_GROUP;
    }

    public void setFUND_GROUP(String FUND_GROUP) {
        this.FUND_GROUP = FUND_GROUP;
    }

    public String getInvestmentIncome() {
        return investmentIncome;
    }

    public void setInvestmentIncome(String investmentIncome) {
        this.investmentIncome = investmentIncome;
    }

    public String getHardworkIncome() {
        return hardworkIncome;
    }

    public void setHardworkIncome(String hardworkIncome) {
        this.hardworkIncome = hardworkIncome;
    }

    public String getTotalIncome() {
        return totalIncome;
    }

    public void setTotalIncome(String totalIncome) {
        this.totalIncome = totalIncome;
    }

    public String getSTAGE_INCOME() {
        return STAGE_INCOME;
    }

    public void setSTAGE_INCOME(String STAGE_INCOME) {
        this.STAGE_INCOME = STAGE_INCOME;
    }

    public String getStageIncomeOne() {
        return stageIncomeOne;
    }

    public void setStageIncomeOne(String stageIncomeOne) {
        this.stageIncomeOne = stageIncomeOne;
    }

    public String getStageIncomeTwo() {
        return stageIncomeTwo;
    }

    public void setStageIncomeTwo(String stageIncomeTwo) {
        this.stageIncomeTwo = stageIncomeTwo;
    }

    public String getTotalStageIncome() {
        return totalStageIncome;
    }

    public void setTotalStageIncome(String totalStageIncome) {
        this.totalStageIncome = totalStageIncome;
    }

    public String getCashEquivalent() {
        return cashEquivalent;
    }

    public void setCashEquivalent(String cashEquivalent) {
        this.cashEquivalent = cashEquivalent;
    }

    public String getExitCost() {
        return exitCost;
    }

    public void setExitCost(String exitCost) {
        this.exitCost = exitCost;
    }

    public String getTotalEquipIncome() {
        return totalEquipIncome;
    }

    public void setTotalEquipIncome(String totalEquipIncome) {
        this.totalEquipIncome = totalEquipIncome;
    }

    public String getCONFIG_NAME() {
        return CONFIG_NAME;
    }

    public void setCONFIG_NAME(String CONFIG_NAME) {
        this.CONFIG_NAME = CONFIG_NAME;
    }

    public String getCONFIG_VALUE() {
        return CONFIG_VALUE;
    }

    public void setCONFIG_VALUE(String CONFIG_VALUE) {
        this.CONFIG_VALUE = CONFIG_VALUE;
    }

    public String getFUND_ONE_INCOME() {
        return FUND_ONE_INCOME;
    }

    public void setFUND_ONE_INCOME(String FUND_ONE_INCOME) {
        this.FUND_ONE_INCOME = FUND_ONE_INCOME;
    }

    public String getFUND_TWO_INCOME() {
        return FUND_TWO_INCOME;
    }

    public void setFUND_TWO_INCOME(String FUND_TWO_INCOME) {
        this.FUND_TWO_INCOME = FUND_TWO_INCOME;
    }

    public String getFUND_THR_INCOME() {
        return FUND_THR_INCOME;
    }

    public void setFUND_THR_INCOME(String FUND_THR_INCOME) {
        this.FUND_THR_INCOME = FUND_THR_INCOME;
    }

    public String getUNALLOCAT_INCOME() {
        return UNALLOCAT_INCOME;
    }

    public void setUNALLOCAT_INCOME(String UNALLOCAT_INCOME) {
        this.UNALLOCAT_INCOME = UNALLOCAT_INCOME;
    }

    public String getFUND_ONE_INCOME_RATE() {
        return FUND_ONE_INCOME_RATE;
    }

    public void setFUND_ONE_INCOME_RATE(String FUND_ONE_INCOME_RATE) {
        this.FUND_ONE_INCOME_RATE = FUND_ONE_INCOME_RATE;
    }

    public String getFUND_TWO_INCOME_RATE() {
        return FUND_TWO_INCOME_RATE;
    }

    public void setFUND_TWO_INCOME_RATE(String FUND_TWO_INCOME_RATE) {
        this.FUND_TWO_INCOME_RATE = FUND_TWO_INCOME_RATE;
    }

    public String getFUND_THR_INCOME_RATE() {
        return FUND_THR_INCOME_RATE;
    }

    public void setFUND_THR_INCOME_RATE(String FUND_THR_INCOME_RATE) {
        this.FUND_THR_INCOME_RATE = FUND_THR_INCOME_RATE;
    }

    public String getUNALLOCAT_INCOME_RATE() {
        return UNALLOCAT_INCOME_RATE;
    }

    public void setUNALLOCAT_INCOME_RATE(String UNALLOCAT_INCOME_RATE) {
        this.UNALLOCAT_INCOME_RATE = UNALLOCAT_INCOME_RATE;
    }
}
