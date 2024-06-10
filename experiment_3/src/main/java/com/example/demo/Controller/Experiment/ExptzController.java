package com.example.demo.Controller.Experiment;


import com.example.demo.Dao.CountDownMapper;
import com.example.demo.DemoApplication;
import com.example.demo.Pojo.Po.InvestDecision;
import com.example.demo.Pojo.Po.TestSession;
import com.example.demo.Pojo.Po.TesteeAction;
import com.example.demo.Pojo.Po.TesteeSchedule;
import com.example.demo.Pojo.reqInfoBo.ExpconfigurationBo;
import com.example.demo.Service.InvestDecision.InvestDecisionService;
import com.example.demo.Service.ProfitService.ProfitService;
import com.example.demo.Service.TestSession.TestSessionService;
import com.example.demo.Service.TesteeAction.TesteeActionService;
import com.example.demo.Service.TesteeSchedule.TesteeScheduleService;
import com.example.demo.Utils.ResponseConstant;
import net.sf.json.JSONObject;
import org.junit.Test;
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

@SpringBootTest(classes = DemoApplication.class)
@RunWith(SpringRunner.class)
//实验投资接口
@Controller
@RequestMapping("/demo")
public class ExptzController {

    @Autowired
    CountDownMapper countDownMapper;
    @Autowired
    TesteeScheduleService testeeScheduleService;

    @Autowired
    TestSessionService testSessionService;

    @Autowired
    InvestDecisionService investDecisionService;

    @Autowired
    TesteeActionService testeeActionService;

    @Autowired
    private ProfitService profitService;


    private Logger logger = LoggerFactory.getLogger(ExptzController.class);


    @Test
    public void test2() {
        List<TesteeSchedule> testeeSchedules = testeeScheduleService.queryTestScheduleById("ddddd");
        if (testeeSchedules.size() > 0) {
            TesteeSchedule testeeSchedule = testeeSchedules.get(0);
            List<TestSession> testSessions = testSessionService.queryInvest(testeeSchedule);
            logger.info("###" + testSessions.size());
            if (testSessions.size() > 0) {
                TestSession testSession = testSessions.get(0);
                System.out.println(testSession);
            }
        } else
            System.out.println(111);
    }


    @RequestMapping(value = "/Expconfiguration")
    public String Expconfiguration(ExpconfigurationBo expconfigurationBo, HttpServletRequest httpRequest) {
        logger.info("Expconfiguration###" + expconfigurationBo.toString());
        String testee_id = (String) httpRequest.getSession().getAttribute("TESTEE_ID");
        List<TesteeSchedule> testeeSchedules = testeeScheduleService.queryTestScheduleById(testee_id);
        String res = "";
        if (testeeSchedules.size() > 0) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            TesteeSchedule testeeSchedule = testeeSchedules.get(0);
            InvestDecision investDecision = new InvestDecision();

            String test_id = testeeSchedule.getTest_Id();
            String test_session_id = testeeSchedule.getTest_Session_Id();
            String test_round_id = testeeSchedule.getTest_Round_Id();
            String test_stage_id = testeeSchedule.getTest_Stage_Id();

            investDecision.setTest_Id(test_id);
            investDecision.setTest_Session_Id(test_session_id);
            investDecision.setTest_Round_Id(test_round_id);
            investDecision.setTest_Stage_Id(test_stage_id);
            investDecision.setTestee_Id(testee_id);
            String formatdate = simpleDateFormat.format(new Date());

            for (int i = 1; i <= 4; i++) {
                investDecision.setFund_Id(i + "");
                if (i == 1)
                    investDecision.setFund_Ratio(expconfigurationBo.getFundRatio1());
                else if (i == 2)
                    investDecision.setFund_Ratio(expconfigurationBo.getFundRatio2());
                else if (i == 3)
                    investDecision.setFund_Ratio(expconfigurationBo.getFundRatio3());
                else
                    investDecision.setFund_Ratio(expconfigurationBo.getResidueRatio());
                investDecision.setCreated_Time(formatdate);
                int result = investDecisionService.addInvestDecision(investDecision);
                if (result > 0)
                    logger.info("addInvestDecision插入成功");
                else
                    logger.info("addInvestDecision插入失败");

            }

            logger.info("expconfigurationBo###" + expconfigurationBo);
            //记录行为数据
            TesteeAction testeeAction = new TesteeAction();
            testeeAction.setTestee_Id(testee_id);
            testeeAction.setTest_Id(test_id);
            testeeAction.setTest_Session_Id(test_session_id);
            testeeAction.setTest_Stage_Id(test_stage_id);
            testeeAction.setTest_Round_Id(test_round_id);
            testeeAction.setPage_Flag(expconfigurationBo.getPage_Flag());
            testeeAction.setPage_Flag_Explain(expconfigurationBo.getPage_Flag_Explain());
            testeeAction.setModule_Name(expconfigurationBo.getModule_Name());
            testeeAction.setSelect_Condition(expconfigurationBo.getSelect_Condition());
            testeeAction.setStop_Time(expconfigurationBo.getStop_Time());
            testeeAction.setCreate_Time(formatdate);
            logger.info(testeeAction.toString());

            int i = testeeActionService.addTesteeAction(testeeAction);
            if (i > 0)
                logger.info("addTesteeAction插入成功");
            else
                logger.info("addTesteeAction插入失败");
        }
        profitService.calProfit(testee_id);
        //从进度表里查处场次编号   更新投资决策表
        if (countDownMapper.firstDown().equals(expconfigurationBo.getStop_Time()))
            return "redirect:/views/modules/experiment/inquiry.html";
        else
            return "redirect:/views/modules/experiment/rest.html";
    }

    //页面初始化
    @RequestMapping(value = "/ToExperiment")
    @ResponseBody
    public String ToExperiment(HttpServletRequest request) {
        String testeeId = (String) request.getSession().getAttribute("TESTEE_ID");
        //先用ID查询进度表  在用查出来的场次编号轮次查询配给表和 基金表的关联
        List<TesteeSchedule> testeeSchedules = testeeScheduleService.queryTestScheduleById(testeeId);
        String res = null;
        if (testeeSchedules.size() > 0) {
            TesteeSchedule testeeSchedule = testeeSchedules.get(0);

            List<TestSession> testSessions = testSessionService.queryInvest(testeeSchedule);
            if (testSessions.size() > 0) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("fundRatio1", testSessions.get(0).getFundSum().getExplain1());
                jsonObject.put("fundRatio2", testSessions.get(1).getFundSum().getExplain1());
                jsonObject.put("fundRatio3", testSessions.get(2).getFundSum().getExplain1());
                //后续改为从配置表读
//                jsonObject.put("alltime", "900");
                jsonObject.put("alltime", countDownMapper.allDown());
//                jsonObject.put("EnsureTime", "25");
                jsonObject.put("EnsureTime",countDownMapper.firstDown());
                jsonObject.put("testId", testeeSchedule.getTest_Id());
                jsonObject.put("testSessionId", testeeSchedule.getTest_Session_Id());
                jsonObject.put("testStageId", testeeSchedule.getTest_Stage_Id());
                jsonObject.put("testRoundId", testeeSchedule.getTest_Round_Id());
                String resdata = jsonObject.toString();
                logger.info(resdata);

                res = ResponseConstant.success(resdata);

                return res;
            }


        } else {
            res = ResponseConstant.failure("");

        }
        logger.info("ToExperiment##" + res);
        return res;
    }

}
