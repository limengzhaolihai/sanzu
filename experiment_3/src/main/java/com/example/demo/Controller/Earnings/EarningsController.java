package com.example.demo.Controller.Earnings;

import com.example.demo.Controller.Experiment.ExptzController;
import com.example.demo.Pojo.Po.FundInfoTable;
import com.example.demo.Pojo.Po.TestSessionTable;
import com.example.demo.Pojo.Po.TesteeSchedule;
import com.example.demo.Service.Earnings.EarningsService;
import com.example.demo.Service.TesteeSchedule.TesteeScheduleService;
import com.example.demo.Utils.ResponseConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/Earnings")
@Controller
public class EarningsController {
    @Autowired
    EarningsService earningsService;
    @Autowired
    TesteeScheduleService testeeScheduleService;
    private Logger logger = LoggerFactory.getLogger(ExptzController.class);

    @RequestMapping(value = "/fundInfoTable")
    @ResponseBody
    public Map<String, Object> Earnings(String index, HttpServletRequest httpRequest) {
        String testee_id = (String) httpRequest.getSession().getAttribute("TESTEE_ID");
//        String testee_id ="sgd7";
        Map<String, Object> result = new HashMap<>();
        List<TesteeSchedule> testeeSchedules = testeeScheduleService.queryTestScheduleById(testee_id);
        if (testeeSchedules.size() > 0) {
            TestSessionTable testSessionTable = earningsService.findTestSesTable(testeeSchedules.get(0));
            List<FundInfoTable> fundInfoTable = earningsService.findFundList(testSessionTable, index);

            result.put("result", fundInfoTable);
        } else {
            result.put("result", ResponseConstant.failure("查询失败"));
        }
        return result;

    }
}
