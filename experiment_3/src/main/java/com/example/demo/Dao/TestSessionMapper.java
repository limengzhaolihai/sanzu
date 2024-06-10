package com.example.demo.Dao;


import com.example.demo.Pojo.Po.TestSession;
import com.example.demo.Pojo.Po.TesteeSchedule;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TestSessionMapper {
//    List<TestSession> querybyStart();
    List<TestSession> queryInvest(TesteeSchedule testeeSchedule);
}
