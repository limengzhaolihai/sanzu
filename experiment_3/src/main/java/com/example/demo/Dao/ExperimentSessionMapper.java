package com.example.demo.Dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface ExperimentSessionMapper {

    int insertExpSession(@Param("param") Map<String, Object> param);

    int updateExpSession(@Param("param") Map<String, Object> param);

    List<Map<String, Object>> listExpSession();

    Map<String, Object> selectExpSession(@Param("param") Map<String, Object> param);

    int deleteExpSession(@Param("param") Map<String, Object> param);

    List<Map<String, Object>> selectExpStage(@Param("param") Map<String, Object> param);

    int insertExpStage(@Param("param") Map<String, Object> param);

    int updateExpStage(@Param("param") Map<String, Object> param);

    int updateExpStagePkeysByOld(@Param("param") Map<String, Object> param);

    int deleteExpStage(@Param("param") Map<String, Object> param);

    int updateTestStartEndTrueByPkeys(@Param("param") Map<String, Object> param);

    List<Map<String, Object>> listQuestion();

    int insertSchedule(@Param("param") Map<String, Object> param);

    int deleteSchedule(@Param("param") Map<String, Object> param);

    int insertCalTmp(@Param("param") Map<String, Object> param);

    int updateTestStartEndFalseByPkeys(@Param("param") Map<String, Object> param);

    int updateScheduleStartEndTrueByPkeys(@Param("param") Map<String, Object> param);

    int updateScheduleStartEndFalseByPkeys(@Param("param") Map<String, Object> param);

    List<Map<String, Object>> listReward(@Param("param") Map<String, Object> param);

    List<Map<String, Object>> listScheduleByPkeys(@Param("param") Map<String, Object> param);
}
