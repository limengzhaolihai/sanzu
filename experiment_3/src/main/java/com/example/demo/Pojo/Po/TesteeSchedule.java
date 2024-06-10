package com.example.demo.Pojo.Po;


//实验进度
public class TesteeSchedule {

  private String testee_Id;
  private String test_Id;
  private String test_Session_Id;
  private String test_Stage_Id;
  private String test_Round_Id;
  private String start_end;

  @Override
  public String toString() {
    return "TesteeSchedule{" +
            "testee_Id='" + testee_Id + '\'' +
            ", test_Id='" + test_Id + '\'' +
            ", test_Session_Id='" + test_Session_Id + '\'' +
            ", test_Stage_Id='" + test_Stage_Id + '\'' +
            ", test_Round_Id='" + test_Round_Id + '\'' +
            ", start_end='" + start_end + '\'' +
            '}';
  }

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

  public String getStart_end() {
    return start_end;
  }

  public void setStart_end(String start_end) {
    this.start_end = start_end;
  }
}
