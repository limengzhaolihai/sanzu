package com.example.demo.Service.TestSession;

import com.example.demo.Dao.TestSessionMapper;
import com.example.demo.Pojo.Po.TestSession;
import com.example.demo.Pojo.Po.TesteeSchedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TestSessionServiceImpl implements TestSessionService {

   @Autowired
    TestSessionMapper testSessionMapper;

//    @Override
//    public List<TestSession> querybyStart() {
//        List<TestSession> testSessions = testSessionMapper.querybyStart();
//
//        return testSessions;
//    }

    @Override
    public List<TestSession> queryInvest(TesteeSchedule testeeSchedule) {
        List<TestSession> testSessions = testSessionMapper.queryInvest(testeeSchedule);
        return testSessions;
    }
}
