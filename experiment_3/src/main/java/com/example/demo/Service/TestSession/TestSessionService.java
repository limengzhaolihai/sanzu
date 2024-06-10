package com.example.demo.Service.TestSession;

import com.example.demo.Pojo.Po.TestSession;
import com.example.demo.Pojo.Po.TesteeSchedule;

import java.util.List;


public interface TestSessionService {

    List<TestSession> queryInvest(TesteeSchedule testeeSchedule);

}
