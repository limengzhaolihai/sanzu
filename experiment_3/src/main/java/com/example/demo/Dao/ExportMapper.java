package com.example.demo.Dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface ExportMapper {
    List<Map<String, Object>> listInvestDecision();

    List<Map<String, Object>> listTestIncome();

    List<Map<String, Object>> listCalTmp();

    List<Map<String, Object>> listLottery();

    List<Map<String, Object>> listQuest();

    List<Map<String, Object>> listStageIncome();

    List<Map<String, Object>> listAction();

    List<Map<String, Object>> listInvestDecisionByPkeys(@Param("param") Map<String, Object> param);

    List<Map<String, Object>> listTestIncomeByPkeys(@Param("param") Map<String, Object> param);

    List<Map<String, Object>> listCalTmpByPkeys(@Param("param") Map<String, Object> param);

    List<Map<String, Object>> listLotteryByPkeys(@Param("param") Map<String, Object> param);

    List<Map<String, Object>> listQuestByPkeys(@Param("param") Map<String, Object> param);

    List<Map<String, Object>> listStageIncomeByPkeys(@Param("param") Map<String, Object> param);

    List<Map<String, Object>> listActionByPkeys(@Param("param") Map<String, Object> param);

}
