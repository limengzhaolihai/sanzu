package com.example.demo.Service.TesteeSchedule;

import com.example.demo.Dao.TesteeScheduleMapper;
import com.example.demo.Pojo.Po.TesteeSchedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TesteeScheduleServiceImpl implements TesteeScheduleService {

    @Autowired
    TesteeScheduleMapper scheduleMapper;

//    @Override
//    public int addTestSchedule(TesteeSchedule testeeSchedule) {
//        int count = scheduleMapper.addTestSchedule(testeeSchedule);
//        return count;
//    }

    @Override
    public int UpdateTestScheduleById(TesteeSchedule testeeSchedule) {
        int count = scheduleMapper.UpdateTestScheduleById(testeeSchedule);
        return count;
    }

    @Override
    public int UpdateTestScheduleRound(TesteeSchedule testeeSchedule) {
        int count = scheduleMapper.UpdateTestScheduleRound(testeeSchedule);
        return count;
    }

    @Override
    public int UpdateTestScheduleStage(TesteeSchedule testeeSchedule) {
        int count = scheduleMapper.UpdateTestScheduleStage(testeeSchedule);
        return count;
    }


    @Override
    public List<TesteeSchedule> queryTestScheduleById(String testee_id) {
        List<TesteeSchedule> testeeSchedule = scheduleMapper.queryTestScheduleById(testee_id);
        return testeeSchedule;
    }
}
