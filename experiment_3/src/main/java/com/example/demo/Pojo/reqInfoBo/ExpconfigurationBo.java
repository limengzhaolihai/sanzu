package com.example.demo.Pojo.reqInfoBo;


public class ExpconfigurationBo {


  private String fundRatio1;
  private String fundRatio2;
  private String fundRatio3;
  private String residueRatio;
  private String page_Flag;
  private String page_Flag_Explain;
  private String module_Name;
  private String select_Condition;
  private String stop_Time;




  @Override
  public String toString() {
    return "ExpconfigurationBo{" +
            "fundRatio1='" + fundRatio1 + '\'' +
            ", fundRatio2='" + fundRatio2 + '\'' +
            ", fundRatio3='" + fundRatio3 + '\'' +
            ", residueRatio='" + residueRatio + '\'' +
            ", page_Flag='" + page_Flag + '\'' +
            ", page_Flag_Explain='" + page_Flag_Explain + '\'' +
            ", module_Name='" + module_Name + '\'' +
            ", select_Condition='" + select_Condition + '\'' +
            ", stop_Time='" + stop_Time + '\'' +
            '}';
  }

  public String getFundRatio1() {
    return fundRatio1;
  }

  public void setFundRatio1(String fundRatio1) {
    this.fundRatio1 = fundRatio1;
  }

  public String getFundRatio2() {
    return fundRatio2;
  }

  public void setFundRatio2(String fundRatio2) {
    this.fundRatio2 = fundRatio2;
  }

  public String getFundRatio3() {
    return fundRatio3;
  }

  public void setFundRatio3(String fundRatio3) {
    this.fundRatio3 = fundRatio3;
  }

  public String getResidueRatio() {
    return residueRatio;
  }

  public void setResidueRatio(String residueRatio) {
    this.residueRatio = residueRatio;
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
}
