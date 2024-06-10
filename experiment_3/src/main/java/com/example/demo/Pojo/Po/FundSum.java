package com.example.demo.Pojo.Po;


public class FundSum {

  private String fund_Data_Type;
  private String fund_Group;
  private String fund_Id;
  private String test_Part;
  private String explain1;


  @Override
  public String toString() {
    return "FundSum{" +
            "fund_Data_Type='" + fund_Data_Type + '\'' +
            ", fund_Group='" + fund_Group + '\'' +
            ", fund_Id='" + fund_Id + '\'' +
            ", test_Part='" + test_Part + '\'' +
            ", explain1='" + explain1 + '\'' +
            '}';
  }

  public String getFund_Data_Type() {
    return fund_Data_Type;
  }

  public void setFund_Data_Type(String fund_Data_Type) {
    this.fund_Data_Type = fund_Data_Type;
  }

  public String getFund_Group() {
    return fund_Group;
  }

  public void setFund_Group(String fund_Group) {
    this.fund_Group = fund_Group;
  }

  public String getFund_Id() {
    return fund_Id;
  }

  public void setFund_Id(String fund_Id) {
    this.fund_Id = fund_Id;
  }

  public String getTest_Part() {
    return test_Part;
  }

  public void setTest_Part(String test_Part) {
    this.test_Part = test_Part;
  }

  public String getExplain1() {
    return explain1;
  }

  public void setExplain1(String explain1) {
    this.explain1 = explain1;
  }
}
