package com.example.demo.Pojo;


public class Subject300 {

    private int nid;

    private int add1;
    private int add2;
    private int sum;

    public Subject300() {
    }

    public Subject300(int add1, int add2, int sum) {
        this.add1 = add1;
        this.add2 = add2;
        this.sum = sum;
    }


    public int getNid() {
        return nid;
    }

    public void setNid(int nid) {
        this.nid = nid;
    }

    public int getAdd1() {
        return add1;
    }

    public void setAdd1(int add1) {
        this.add1 = add1;
    }

    public int getAdd2() {
        return add2;
    }

    public void setAdd2(int add2) {
        this.add2 = add2;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }
}
