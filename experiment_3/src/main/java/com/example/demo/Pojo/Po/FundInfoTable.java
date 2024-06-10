package com.example.demo.Pojo.Po;

/**
 * @author admin
 * @title: TestSessionTable
 * @projectName experiment
 * @description: TODO
 * @date 2022/10/3015:41
 */
public class FundInfoTable {
    private String fund_data_type;
    private String fund_group;
    private String fund_id;
    private String fund_num;
    private String price;


    @Override
    public String toString() {
        return "TestSessionTable{" +
                "fund_data_type='" + fund_data_type + '\'' +
                ", fund_group='" + fund_group + '\'' +
                ", fund_id='" + fund_id + '\'' +
                ", fund_num='" + fund_num + '\'' +
                ", price=" + price +
                '}';
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

    public String getFund_id() {
        return fund_id;
    }

    public void setFund_id(String fund_id) {
        this.fund_id = fund_id;
    }

    public String getFund_num() {
        return fund_num;
    }

    public void setFund_num(String fund_num) {
        this.fund_num = fund_num;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
