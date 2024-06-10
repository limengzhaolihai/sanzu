package com.example.demo.Dao;

import com.example.demo.Pojo.Po.FundInfoTable;
import com.example.demo.Pojo.Po.TestSessionTable;
import com.example.demo.Pojo.Po.TesteeSchedule;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author admin
 * @title: EarningsController
 * @projectName experiment
 * @description: TODO
 * @date 2022/10/3015:38
 */
@Mapper
@Repository
public interface EarningsMapper {
    TestSessionTable findTestSesTable(TesteeSchedule testeeSchedule);

    List<FundInfoTable> findFundList(@Param("Param") TestSessionTable testSessionTable, @Param("index") String index);
}
