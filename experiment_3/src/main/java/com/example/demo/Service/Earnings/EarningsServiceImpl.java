package com.example.demo.Service.Earnings;

import com.example.demo.Dao.EarningsMapper;
import com.example.demo.Pojo.Po.FundInfoTable;
import com.example.demo.Pojo.Po.TestSessionTable;
import com.example.demo.Pojo.Po.TesteeSchedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EarningsServiceImpl implements EarningsService {
    @Autowired
    EarningsMapper earningsMapper;

    @Override
    public TestSessionTable findTestSesTable(TesteeSchedule testeeSchedule) {
        TestSessionTable table = earningsMapper.findTestSesTable(testeeSchedule);
        return table;
    }

    @Override
    public List<FundInfoTable> findFundList(TestSessionTable testSessionTable, String index) {
        List<FundInfoTable> tableList = earningsMapper.findFundList(testSessionTable, index);
        return tableList;
    }
}
