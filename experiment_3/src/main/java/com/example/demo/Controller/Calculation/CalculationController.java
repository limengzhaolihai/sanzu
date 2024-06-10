package com.example.demo.Controller.Calculation;

import com.example.demo.Controller.Login.LoginController;
import com.example.demo.DemoApplication;
import com.example.demo.Pojo.Po.*;
import com.example.demo.Service.CalculationService.CalculationService;
import com.example.demo.Service.TesteeAction.TesteeActionService;
import com.example.demo.Service.TesteeSchedule.TesteeScheduleService;
import com.example.demo.Utils.ResponseConstant;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 行为决策--计算
 *
 * @author bosonghua
 * @date 2022/10/31 - 15:20
 */
@SpringBootTest(classes = DemoApplication.class)
@RunWith(SpringRunner.class)
@Controller
public class CalculationController {
    private Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private CalculationService calculationService;

    @Autowired
    private TesteeScheduleService testeeScheduleService;

    @Autowired
    private TesteeActionService testeeActionService;

    @RequestMapping(value = "/calculationController/findProblem")
    @ResponseBody
    public SubjectBank findProblem(HttpServletRequest httpRequest) {
        String testee_id = (String) httpRequest.getSession().getAttribute("TESTEE_ID");
        return calculationService.findProblem(testee_id);
    }

    @RequestMapping(value = "/calculationController/saveData")
    @ResponseBody
    public String saveData(TestCalTemp testCalTemp, HttpServletRequest httpRequest) {
        TesteeAction testeeAction = new TesteeAction();
        testeeAction.setPage_Flag(testCalTemp.getPage_Flag());
        testeeAction.setPage_Flag_Explain(testCalTemp.getPage_Flag_Explain());
        testeeAction.setModule_Name(testCalTemp.getModule_Name());
        testeeAction.setSelect_Condition(testCalTemp.getSelect_Condition());
        testeeAction.setStop_Time(testCalTemp.getStop_Time());
        String testee_id = (String) httpRequest.getSession().getAttribute("TESTEE_ID");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:ss:mm");

        List<TesteeSchedule> testeeSchedules = testeeScheduleService.queryTestScheduleById(testee_id);
        String res = "";
        if (testeeSchedules.size() > 0) {
            TesteeSchedule testeeSchedule = testeeSchedules.get(0);
            testeeAction.setTestee_Id(testee_id);
            testeeAction.setTest_Id(testeeSchedule.getTest_Id()); // 实验编号
            testeeAction.setTest_Session_Id(testeeSchedule.getTest_Session_Id()); // 实验场次
            String test_stage_id = testeeSchedule.getTest_Stage_Id();
            testeeAction.setTest_Stage_Id(test_stage_id); // 实验阶段
            testeeAction.setTest_Round_Id(testeeSchedule.getTest_Round_Id());// 实验轮次
            testeeAction.setCreate_Time(simpleDateFormat.format(new Date())); // 创建时间
            testeeAction.setPage_Flag("work");
            int i = testeeActionService.addTesteeAction(testeeAction);

            testCalTemp.setFLAG(testCalTemp.getSum().equals(testCalTemp.getUserSum()) ? "1" : "0");
            testCalTemp.setTestee_Id(testee_id);
            testCalTemp.setTest_Stage_Id(test_stage_id);
            testCalTemp.setCreate_Time(simpleDateFormat.format(new Date()));
            calculationService.saveCalTemp(testCalTemp);

            res = ResponseConstant.success("成功");
            logger.info("SaveAction" + res);
            return res;
        }
        res = ResponseConstant.failure("未查询到该用户记录");
        logger.info("SaveAction" + res);
        return res;
    }

    /*
     * 努力收益保存
     * */
    @RequestMapping(value = "/calculationController/effortIncome")
    @ResponseBody
    public Profit effortIncome(HttpServletRequest httpRequest) {
        String testee_id = (String) httpRequest.getSession().getAttribute("TESTEE_ID");
        return calculationService.effortIncome(testee_id);
    }
}
