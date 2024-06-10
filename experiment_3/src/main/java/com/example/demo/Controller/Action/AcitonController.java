package com.example.demo.Controller.Action;

import com.example.demo.Controller.Experiment.ExptzController;
import com.example.demo.DemoApplication;
import com.example.demo.Pojo.Po.TesteeAction;
import com.example.demo.Pojo.Po.TesteeSchedule;
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

//@SpringBootTest(classes = DemoApplication.class)
//@RunWith(SpringRunner.class)
@RequestMapping("/action")
@Controller
public class AcitonController {
    private Logger logger = LoggerFactory.getLogger(ExptzController.class);

    @Autowired
    TesteeActionService testeeActionService;
    @Autowired
    TesteeScheduleService testeeScheduleService;

    @RequestMapping("/SaveAction")
    @ResponseBody
    public String SaveAction(TesteeAction testeeAction, HttpServletRequest httprequest) {

        String testee_id = (String) httprequest.getSession().getAttribute("TESTEE_ID");
        List<TesteeSchedule> testeeSchedules = testeeScheduleService.queryTestScheduleById(testee_id);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:ss:mm");
        String res = "";
        if (testeeSchedules.size() > 0) {
            TesteeSchedule testeeSchedule = testeeSchedules.get(0);
            testeeAction.setTestee_Id(testee_id);
            testeeAction.setTest_Id(testeeSchedule.getTest_Id());
            testeeAction.setTest_Session_Id(testeeSchedule.getTest_Session_Id());
            testeeAction.setTest_Stage_Id(testeeSchedule.getTest_Stage_Id());
            testeeAction.setTest_Round_Id(testeeSchedule.getTest_Round_Id());
            testeeAction.setCreate_Time(simpleDateFormat.format(new Date()));
            int i = testeeActionService.addTesteeAction(testeeAction);

            res = ResponseConstant.success("");
            logger.info("SaveAction" + res);
            return res;
        }

        res = ResponseConstant.failure("未查询到该用户记录");
        logger.info("SaveAction" + res);
        return res;

    }

    @RequestMapping("/QueryState")
    @ResponseBody
    public String QueryState(TesteeAction testeeAction, HttpServletRequest httprequest) {
        String testee_id = (String) httprequest.getSession().getAttribute("TESTEE_ID");

        List<TesteeSchedule> testeeSchedules = testeeScheduleService.queryTestScheduleById(testee_id);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:ss:mm");
        String Stage_Id = "";
        String res = "";
        if (testeeSchedules.size() > 0) {
            TesteeSchedule testeeSchedule = testeeSchedules.get(0);

//            更新行为记录
            testeeAction.setTestee_Id(testee_id);
            testeeAction.setTest_Id(testeeSchedule.getTest_Id());
            testeeAction.setTest_Session_Id(testeeSchedule.getTest_Session_Id());
            testeeAction.setTest_Stage_Id(testeeSchedule.getTest_Stage_Id());
            testeeAction.setTest_Round_Id(testeeSchedule.getTest_Round_Id());
            testeeAction.setCreate_Time(simpleDateFormat.format(new Date()));

            //新增行为数据
            int count = testeeActionService.addTesteeAction(testeeAction);

            Stage_Id = testeeSchedule.getTest_Stage_Id();
            testeeSchedule.setTest_Stage_Id(String.valueOf(Integer.valueOf(testeeSchedule.getTest_Stage_Id()) + 1));
            testeeSchedule.setTest_Round_Id("1");
            //更新进度表状态
            int i = testeeScheduleService.UpdateTestScheduleStage(testeeSchedule);

            if (Integer.valueOf(Stage_Id) < 3) {

                res = ResponseConstant.success("/views/modules/experiment/configuration.html");
                logger.info("QueryState##"+res);
                return res;
            } else {

                res = ResponseConstant.success("/views/modules/experiment/lotterySelection.html");
                logger.info("QueryState##"+res);
                return  res;
            }
        }
        res = ResponseConstant.failure("未查询到记录");
        logger.info("QueryState##"+res);
        return res;
    }


}
