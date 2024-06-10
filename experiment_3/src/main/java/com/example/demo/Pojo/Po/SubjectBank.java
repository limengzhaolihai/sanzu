package com.example.demo.Pojo.Po;

/**
 * 类的模板注释
 *
 * @author bosonghua
 * @date 2022/10/31 - 16:04
 */
public class SubjectBank {

    private Integer Nid;
    private String Add1;
    private String Add2;
    private String SUM;

    @Override
    public String toString() {
        return "SubjectBank{" +
                "Nid=" + Nid +
                ", Add1='" + Add1 + '\'' +
                ", Add2='" + Add2 + '\'' +
                ", SUM='" + SUM + '\'' +
                '}';
    }

    public Integer getNid() {
        return Nid;
    }

    public void setNid(Integer nid) {
        Nid = nid;
    }

    public String getAdd1() {
        return Add1;
    }

    public void setAdd1(String add1) {
        Add1 = add1;
    }

    public String getAdd2() {
        return Add2;
    }

    public void setAdd2(String add2) {
        Add2 = add2;
    }

    public String getSUM() {
        return SUM;
    }

    public void setSUM(String SUM) {
        this.SUM = SUM;
    }
}
