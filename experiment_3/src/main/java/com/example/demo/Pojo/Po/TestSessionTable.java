package com.example.demo.Pojo.Po;

/**
 * @author admin
 * @title: TestSessionTable
 * @projectName experiment
 * @description: TODO
 * @date 2022/10/3015:41
 */
public class TestSessionTable {
    private String test_Id;
    private String test_Session_Id;
    private String test_Stage_Id;
    private String test_Round_Id;
    private String fund_data_type;
    private String fund_group;
    private String created_Time;

    @Override
    public String toString() {
        return "TestSessionTable{" +
                "test_Id='" + test_Id + '\'' +
                ", test_Session_Id='" + test_Session_Id + '\'' +
                ", test_Stage_Id='" + test_Stage_Id + '\'' +
                ", test_Round_Id='" + test_Round_Id + '\'' +
                ", fund_data_type=" + fund_data_type + '\'' +
                ", fund_group=" + fund_group + '\'' +
                ", created_Time='" + created_Time +
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

    public String getTest_Stage_Id() {
        return test_Stage_Id;
    }

    public void setTest_Stage_Id(String test_Stage_Id) {
        this.test_Stage_Id = test_Stage_Id;
    }

    public String getTest_Round_Id() {
        return test_Round_Id;
    }

    public void setTest_Round_Id(String test_Round_Id) {
        this.test_Round_Id = test_Round_Id;
    }

    public String getFund_data_type() {
        return fund_data_type;
    }

    public void setFund_data_type(String fund_data_type) {
        this.fund_data_type = fund_data_type;
    }

    public String getFund_group() {
        return fund_group;
    }

    public void setFund_group(String fund_group) {
        this.fund_group = fund_group;
    }

    public String getCreated_Time() {
        return created_Time;
    }

    public void setCreated_Time(String created_Time) {
        this.created_Time = created_Time;
    }
}
