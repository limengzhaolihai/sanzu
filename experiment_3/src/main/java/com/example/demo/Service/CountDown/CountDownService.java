package com.example.demo.Service.CountDown;

import com.example.demo.Pojo.Po.CountDown;

import java.util.Map;

public interface CountDownService {
    String startDown();
    String finishDown();
    String halfDown();
    Map<String,Object> startDow12n();
}
