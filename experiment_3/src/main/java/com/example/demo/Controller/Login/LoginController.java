package com.example.demo.Controller.Login;

import com.example.demo.DemoApplication;
import com.example.demo.Pojo.Po.SessionTestee;
import com.example.demo.Pojo.Po.TesteeAction;
import com.example.demo.Pojo.Po.TesteeSchedule;
import com.example.demo.Service.SessionTestee.SessionTesteeService;
import com.example.demo.Service.TestSession.TestSessionService;
import com.example.demo.Service.TesteeAction.TesteeActionService;
import com.example.demo.Service.TesteeSchedule.TesteeScheduleService;
import com.example.demo.Utils.ResponseConstant;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@SpringBootTest(classes = DemoApplication.class)
@RunWith(SpringRunner.class)
@Controller
public class LoginController {


    private Logger logger = LoggerFactory.getLogger(LoginController.class);


    @Autowired
    TesteeScheduleService testeeScheduleService;
    @Autowired
    TestSessionService testSessionService;
    @Autowired
    SessionTesteeService sessionTesteeService;
    @Autowired
    TesteeActionService testeeActionService;

    @Test
    public void test1() {
        List<TesteeSchedule> testeeSchedules = testeeScheduleService.queryTestScheduleById("ddddd");
        if (testeeSchedules.size() > 0) {
            TesteeSchedule testeeSchedule = testeeSchedules.get(0);
            System.out.println("######" + testeeSchedule);
        } else
            System.out.println(111);

    }


    @RequestMapping(value = "/ExpLogin", method = RequestMethod.POST)
    @ResponseBody
    public String toLogin(HttpServletRequest request, @RequestBody String TESTEE_ID) {

        logger.info("ExpLogin##" + TESTEE_ID);
        TESTEE_ID = TESTEE_ID.substring(1, TESTEE_ID.length() - 1);

        String res = null;


        //修改表
        List<SessionTestee> sessionTestees = sessionTesteeService.querybyStart();
        if (sessionTestees.size()>0){
            SessionTestee sessionTestee = sessionTestees.get(0);
            String start_end = sessionTestee.getStart_End();
            TesteeSchedule testeeSchedule = new TesteeSchedule();
            testeeSchedule.setStart_end(start_end);
            testeeSchedule.setTestee_Id(TESTEE_ID);
            int result = testeeScheduleService.UpdateTestScheduleById(testeeSchedule);

            if (result == 1) {
                res = ResponseConstant.success(null);
                HttpSession httpSession = request.getSession();
                httpSession.setAttribute("TESTEE_ID", TESTEE_ID);
                //后续修改session生效时间
                httpSession.setMaxInactiveInterval(60 * 120);
            } else {

                res = ResponseConstant.failure("未查询到该用户或用户已登录");
            }
        }else
            res = ResponseConstant.failure("实验未开始");


//        List<TestSession> testSessions = testSessionService.querybyStart();
//        TestSession testSession = testSessions.get(0);
//        logger.info("testid###############" + testSession.getTest_Id());
//               String Test_id = testSession.getTest_Id();
//        String test_session_id = testSession.getTest_Session_Id();
//        TesteeSchedule testeeSchedule = new TesteeSchedule();
//        testeeSchedule.setTestee_Id(TESTEE_ID);
//        testeeSchedule.setTest_Id(Test_id);
//        testeeSchedule.setTest_Session_Id(test_session_id);
//        testeeSchedule.setTest_Stage_Id("1");
//        testeeSchedule.setTest_Round_Id("1");
//        testeeSchedule.setStart_end("1");
//        int i = testeeScheduleService.addTestSchedule(testeeSchedule);
        logger.info("ExpLogin##res"+res);
        return res;
    }

//    @RequestMapping(value = "/index")
//    public String Exptologin() {
//        return "/views/include/login.html";
//    }

    @RequestMapping(value = "/index")
    public String Exptologin() {
        return "/views/modules/experiment/main.html";
    }
    @RequestMapping(value = "/shgz")
    public String shgz() {
        return "/views/modules/shgz/pages/homePage/homePage.html";
    }
    @RequestMapping(value = "/shgzpad")
    public String shgzpad() {
        return "/views/modules/shgz/pages/fieldInspection/fieldInspection.html";
    }
    @RequestMapping(value = "/indexLogin")
    public String indextologin() {
        return "/views/include/login.html";
    }


    @RequestMapping(value = "/JumpPage/{path}")
    public String ExptoPage(@PathVariable("path") String id) {
        return "/views/modules/experiment/" + id + ".html";
    }


    @RequestMapping(value = "/JumpInExp")
    @ResponseBody
    public String JumpInExp(HttpServletRequest request, TesteeAction testeeAction) {
        String testee_id = (String) request.getSession().getAttribute("TESTEE_ID");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        List<TesteeSchedule> testeeSchedules = testeeScheduleService.queryTestScheduleById(testee_id);
        String res = null;
        if (testeeSchedules.size() > 0) {
            TesteeSchedule testeeSchedule = testeeSchedules.get(0);
            String start_end = testeeSchedule.getStart_end();
            res = ResponseConstant.success(start_end);


            String test_id = testeeSchedule.getTest_Id();
            String test_session_id = testeeSchedule.getTest_Session_Id();
            String test_round_id = testeeSchedule.getTest_Round_Id();
            String test_stage_id = testeeSchedule.getTest_Stage_Id();
            String formatdate = simpleDateFormat.format(new Date());

            //记录行为数据
            testeeAction.setTestee_Id(testee_id);
            testeeAction.setTest_Id(test_id);
            testeeAction.setTest_Session_Id(test_session_id);
            testeeAction.setTest_Stage_Id(test_stage_id);
            testeeAction.setTest_Round_Id(test_round_id);
            testeeAction.setPage_Flag(testeeAction.getPage_Flag());
            testeeAction.setPage_Flag_Explain(testeeAction.getPage_Flag_Explain());
            testeeAction.setModule_Name(testeeAction.getModule_Name());
            testeeAction.setSelect_Condition(testeeAction.getSelect_Condition());
            testeeAction.setStop_Time(testeeAction.getStop_Time());
            testeeAction.setCreate_Time(formatdate);
            int i = testeeActionService.addTesteeAction(testeeAction);
            if (i > 0)
                logger.info("addTesteeAction插入成功");
            else
                logger.info("addTesteeAction插入失败");


        } else {
            res = ResponseConstant.failure("查询失败");

        }
        return res;
    }


}
