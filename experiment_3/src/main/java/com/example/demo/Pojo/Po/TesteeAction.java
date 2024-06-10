package com.example.demo.Pojo.Po;


public class TesteeAction {

  private String testee_Id;
  private String test_Id;
  private String test_Session_Id;
  private String test_Stage_Id;
  private String test_Round_Id;
  private String page_Flag;
  private String page_Flag_Explain;
  private String module_Name;
  private String select_Condition;
  private String stop_Time;
  private String create_Time;

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

  public String getPage_Flag() {
    return page_Flag;
  }

  public void setPage_Flag(String page_Flag) {
    this.page_Flag = page_Flag;
  }

  public String getPage_Flag_Explain() {
    return page_Flag_Explain;
  }

  public void setPage_Flag_Explain(String page_Flag_Explain) {
    this.page_Flag_Explain = page_Flag_Explain;
  }

  public String getModule_Name() {
    return module_Name;
  }

  public void setModule_Name(String module_Name) {
    this.module_Name = module_Name;
  }

  public String getSelect_Condition() {
    return select_Condition;
  }

  public void setSelect_Condition(String select_Condition) {
    this.select_Condition = select_Condition;
  }

  public String getStop_Time() {
    return stop_Time;
  }

  public void setStop_Time(String stop_Time) {
    this.stop_Time = stop_Time;
  }

  public String getCreate_Time() {
    return create_Time;
  }

  public void setCreate_Time(String create_Time) {
    this.create_Time = create_Time;
  }

  @Override
  public String toString() {
    return "TesteeAction{" +
            "testee_Id='" + testee_Id + '\'' +
            ", test_Id='" + test_Id + '\'' +
            ", test_Session_Id='" + test_Session_Id + '\'' +
            ", test_Stage_Id='" + test_Stage_Id + '\'' +
            ", test_Round_Id='" + test_Round_Id + '\'' +
            ", page_Flag='" + page_Flag + '\'' +
            ", page_Flag_Explain='" + page_Flag_Explain + '\'' +
            ", module_Name='" + module_Name + '\'' +
            ", select_Condition='" + select_Condition + '\'' +
            ", stop_Time='" + stop_Time + '\'' +
            ", create_Time='" + create_Time + '\'' +
            '}';
  }
}
