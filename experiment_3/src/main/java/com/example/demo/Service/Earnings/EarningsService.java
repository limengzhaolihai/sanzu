package com.example.demo.Service.Earnings;

import com.example.demo.Pojo.Po.FundInfoTable;
import com.example.demo.Pojo.Po.TestSessionTable;
import com.example.demo.Pojo.Po.TesteeSchedule;

import java.util.List;

public interface EarningsService {
    TestSessionTable findTestSesTable(TesteeSchedule testeeSchedule);

    List<FundInfoTable> findFundList(TestSessionTable testSessionTable, String index);
}
