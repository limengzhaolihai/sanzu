package com.example.demo.Service.CountDown;

import com.example.demo.Dao.CountDownMapper;
import com.example.demo.Pojo.Po.CountDown;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CountDownServiceImpl implements CountDownService {
    @Autowired
    private CountDownMapper countDownMapper;

    @Override
    public String startDown() {
        String startDown = countDownMapper.startDown().getStartDown();
        return startDown;
    }

    @Override
    public String finishDown() {
         String finishDown = countDownMapper.finishDown().getFinishDown();
        return finishDown;
        }

    @Override
    public String halfDown() {
        String halfDown = countDownMapper.halfDown().getHalfDown();
        return halfDown;
    }

    @Override
    public Map<String, Object> startDow12n() {
        return null;
    }
}
