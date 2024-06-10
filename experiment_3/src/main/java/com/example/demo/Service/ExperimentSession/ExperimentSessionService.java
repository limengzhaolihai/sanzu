package com.example.demo.Service.ExperimentSession;

import java.util.Map;

public interface ExperimentSessionService {

    Map<String, Object> insertExpSession(Map<String, Object> param);

    Map<String, Object> updateExpSession(Map<String, Object> param);

    Map<String, Object> selectExpSession(Map<String, Object> param);

    Map<String, Object> listExpSession();

    Map<String, Object> deleteExpSession(Map<String, Object> param);

    Map<String, Object> selectExpStage(Map<String, Object> param);

    Map<String, Object> updateExpStage(Map<String, Object> param);

    Map<String, Object> startExp(Map<String, Object> param);

    Map<String, Object> finishExp(Map<String, Object> param);

    Map<String, Object> listReward(Map<String, Object> param);

    Map<String, Object> listSchedule(Map<String, Object> param);
}
