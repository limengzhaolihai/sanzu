package com.example.demo.Pojo.Po;

/**
 * @author wzz
 * @date 2022/10/29-21:17
 */
public class Quest {
    private String testee_Id;
    private String test_Id;
    private String test_Session_Id;
    private String test_Stage_Id;
    private String test_Round_Id;
    private String topic_Id;
    private String options;
    private String created_Time;

    public String getTestee_Id() {
        return testee_Id;
    }

    public void setTestee_Id(String testee_Id) {
        this.testee_Id = testee_Id;
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

    public String getTopic_Id() {
        return topic_Id;
    }

    public void setTopic_Id(String topic_Id) {
        this.topic_Id = topic_Id;
    }

    public String getOptions() {
        return options;
    }

    public void setOptions(String options) {
        this.options = options;
    }

    public String getCreated_Time() {
        return created_Time;
    }

    public void setCreated_Time(String created_Time) {
        this.created_Time = created_Time;
    }

    @Override
    public String toString() {
        return "Quest{" +
                "testee_Id='" + testee_Id + '\'' +
                ", test_Id='" + test_Id + '\'' +
                ", test_Session_Id='" + test_Session_Id + '\'' +
                ", test_Stage_Id='" + test_Stage_Id + '\'' +
                ", test_Round_Id='" + test_Round_Id + '\'' +
                ", topic_Id='" + topic_Id + '\'' +
                ", options='" + options + '\'' +
                ", created_Time='" + created_Time + '\'' +
                '}';
    }
}
