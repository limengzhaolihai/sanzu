package com.example.demo.Dao;

import com.example.demo.Pojo.Po.Profit;
import com.example.demo.Pojo.Po.SubjectBank;
import com.example.demo.Pojo.Po.TestCalTemp;
import com.example.demo.Pojo.Po.TesteeAction;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 类的模板注释
 *
 * @author bosonghua
 * @date 2022/10/31 - 15:56
 */
@Mapper
@Repository
public interface CalculationMapper {

    SubjectBank findProblem(@Param("id") String id);

    int countCalTmp(@Param("testee_id") String testee_id);

    int stageCountCalTmp(Profit profit);

    void saveCalTemp(TestCalTemp testCalTemp);

    TestCalTemp answerResult(Profit profit);

    // 努力收益保存
    void insertIncome(Profit profit);

    List<String> isExistIncome(Profit profit);

    // 全局配置点数
    TestCalTemp rewardPoint();

}
