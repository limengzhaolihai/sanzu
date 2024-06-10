package com.example.demo.Pojo.Po;

//实验场次表
public class TestSession {

    private String test_Id;
    private String test_Session_Id;
    private String test_StageId;
    private String test_Round_Id;
    private FundSum fundSum;
    private String created_Time;


    @Override
    public String toString() {
        return "TestSession{" +
                "test_Id='" + test_Id + '\'' +
                ", test_Session_Id='" + test_Session_Id + '\'' +
                ", test_StageId='" + test_StageId + '\'' +
                ", test_Round_Id='" + test_Round_Id + '\'' +
                ", fundSum=" + fundSum +
                ", created_Time='" + created_Time + '\'' +
                '}';
    }

    public String getTest_Id() {
        return test_Id;
    }

    public void setTest_Id(String test_Id) {
        this.test_Id = test_Id;
    }

    public String getTest_Session_Id() {
        return test_Session_Id;
    }

    public void setTest_Session_Id(String test_Session_Id) {
        this.test_Session_Id = test_Session_Id;
    }

    public String getTest_StageId() {
        return test_StageId;
    }

    public void setTest_StageId(String test_StageId) {
        this.test_StageId = test_StageId;
    }

    public String getTest_Round_Id() {
        return test_Round_Id;
    }

    public void setTest_Round_Id(String test_Round_Id) {
        this.test_Round_Id = test_Round_Id;
    }

    public FundSum getFundSum() {
        return fundSum;
    }

    public void setFundSum(FundSum fundSum) {
        this.fundSum = fundSum;
    }

    public String getCreated_Time() {
        return created_Time;
    }

    public void setCreated_Time(String created_Time) {
        this.created_Time = created_Time;
    }
}
