package com.example.demo.Dao;

import com.example.demo.Pojo.Po.TesteeSchedule;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
@Repository
public interface TesteeScheduleMapper {
    //    根据后台配置初始化进度表
//    int addTestSchedule(TesteeSchedule testeeSchedule);
//登录验证ID是否存在并更新状态
    int UpdateTestScheduleById(TesteeSchedule testeeSchedule);

    // 更新轮次  轮次+1
    int UpdateTestScheduleRound(TesteeSchedule testeeSchedule);

    int UpdateTestScheduleStage(TesteeSchedule testeeSchedule);

    //    根据实验者ID查询进度表
    List<TesteeSchedule> queryTestScheduleById(String testee_id);

}
