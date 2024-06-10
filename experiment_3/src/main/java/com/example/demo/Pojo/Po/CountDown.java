package com.example.demo.Pojo.Po;

public class CountDown {
    private String allDown; // 全局配置总倒计时时间（秒）
    private String startDown; // 全局配置开始倒计时时间（秒）
    private String finishDown; // 全局配置阶段倒计时时间（秒）
    private String halfDown; // 全局配置阶段等待倒计时时间（秒）


    public String getAllDown() {
        return allDown;
    }

    public void setAllDown(String allDown) {
        this.allDown = allDown;
    }

    public String getStartDown() {
        return startDown;
    }

    public void setStartDown(String startDown) {
        this.startDown = startDown;
    }

    public String getFinishDown() {
        return finishDown;
    }

    public void setFinishDown(String finishDown) {
        this.finishDown = finishDown;
    }

    public String getHalfDown() {
        return halfDown;
    }

    public void setHalfDown(String halfDown) {
        this.halfDown = halfDown;
    }
}
