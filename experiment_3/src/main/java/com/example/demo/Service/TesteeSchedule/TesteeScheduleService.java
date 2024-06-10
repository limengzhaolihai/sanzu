package com.example.demo.Service.TesteeSchedule;

import com.example.demo.Pojo.Po.TesteeSchedule;

import java.util.List;

public interface TesteeScheduleService {
//    int addTestSchedule(TesteeSchedule testeeSchedule);
    int  UpdateTestScheduleById(TesteeSchedule testeeSchedule);
    int  UpdateTestScheduleRound(TesteeSchedule testeeSchedule);

    int UpdateTestScheduleStage(TesteeSchedule testeeSchedule);

    List<TesteeSchedule> queryTestScheduleById(String testee_id);

}
