package com.example.demo.Pojo.Po;

public class LotteryTwo {
    private String TESTEE_ID;//被试者编号
    private String TEST_ID;//实验编号
    private String TEST_SESSION_ID;//实验场次
    private String TEST_STAGE_ID;//实验阶段
    private String TEST_ROUND_ID;//实验轮次
    private String TOPIC_ID;//题目ID
    private String OPTION;//选择项
    private String PROBABILITY_1;//概率1
    private String COUNT_1;//点数1
    private String PROBABILITY_2;//概率2
    private String COUNY_2;//点数2
    private String CREATED_TIME;//创建时间
    private String PAGE_FLAG;//页面标识
    private String PAGE_FLAG_EXPLAIN;//页面标识说明
    private String MODULE_NAME;//组件名称
    private String SELECT_CONDITION;//选择条件
    private String STOP_TIME;//停留时间（秒）

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

    public String getTOPIC_ID() {
        return TOPIC_ID;
    }

    public void setTOPIC_ID(String TOPIC_ID) {
        this.TOPIC_ID = TOPIC_ID;
    }

    public String getOPTION() {
        return OPTION;
    }

    public void setOPTION(String OPTION) {
        this.OPTION = OPTION;
    }

    public String getPROBABILITY_1() {
        return PROBABILITY_1;
    }

    public void setPROBABILITY_1(String PROBABILITY_1) {
        this.PROBABILITY_1 = PROBABILITY_1;
    }

    public String getCOUNT_1() {
        return COUNT_1;
    }

    public void setCOUNT_1(String COUNT_1) {
        this.COUNT_1 = COUNT_1;
    }

    public String getPROBABILITY_2() {
        return PROBABILITY_2;
    }

    public void setPROBABILITY_2(String PROBABILITY_2) {
        this.PROBABILITY_2 = PROBABILITY_2;
    }

    public String getCOUNY_2() {
        return COUNY_2;
    }

    public void setCOUNY_2(String COUNY_2) {
        this.COUNY_2 = COUNY_2;
    }

    public String getCREATED_TIME() {
        return CREATED_TIME;
    }

    public void setCREATED_TIME(String CREATED_TIME) {
        this.CREATED_TIME = CREATED_TIME;
    }

    public String getPAGE_FLAG() {
        return PAGE_FLAG;
    }

    public void setPAGE_FLAG(String PAGE_FLAG) {
        this.PAGE_FLAG = PAGE_FLAG;
    }

    public String getPAGE_FLAG_EXPLAIN() {
        return PAGE_FLAG_EXPLAIN;
    }

    public void setPAGE_FLAG_EXPLAIN(String PAGE_FLAG_EXPLAIN) {
        this.PAGE_FLAG_EXPLAIN = PAGE_FLAG_EXPLAIN;
    }

    public String getMODULE_NAME() {
        return MODULE_NAME;
    }

    public void setMODULE_NAME(String MODULE_NAME) {
        this.MODULE_NAME = MODULE_NAME;
    }

    public String getSELECT_CONDITION() {
        return SELECT_CONDITION;
    }

    public void setSELECT_CONDITION(String SELECT_CONDITION) {
        this.SELECT_CONDITION = SELECT_CONDITION;
    }

    public String getSTOP_TIME() {
        return STOP_TIME;
    }

    public void setSTOP_TIME(String STOP_TIME) {
        this.STOP_TIME = STOP_TIME;
    }

    @Override
    public String toString() {
        return "lottery_table{" +
                "TESTEE_ID='" + TESTEE_ID + '\'' +
                "TEST_ID='" + TEST_ID + '\'' +
                "TEST_SESSION_ID='" + TEST_SESSION_ID + '\'' +
                "TEST_STAGE_ID='" + TEST_STAGE_ID + '\'' +
                "TEST_ROUND_ID='" + TEST_ROUND_ID + '\'' +
                "TOPIC_ID='" + TOPIC_ID + '\'' +
                ", OPTION='" + OPTION + '\'' +
                ", PROBABILITY_1='" + PROBABILITY_1 + '\'' +
                ", COUNT_1='" + COUNT_1 + '\'' +
                ", PROBABILITY_2=" + PROBABILITY_2 +
                ", COUNY_2=" + COUNY_2 +
                ", CREATED_TIME=" + CREATED_TIME +
                '}';
    }
}
