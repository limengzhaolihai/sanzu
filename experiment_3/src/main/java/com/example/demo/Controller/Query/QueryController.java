package com.example.demo.Controller.Query;

import com.example.demo.Controller.Experiment.ExptzController;
import com.example.demo.Pojo.Po.TesteeAction;
import com.example.demo.Pojo.Po.TesteeSchedule;
import com.example.demo.Service.TesteeAction.TesteeActionService;
import com.example.demo.Service.TesteeSchedule.TesteeScheduleService;
import com.example.demo.Utils.ResponseConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/query")
public class QueryController {
    private Logger logger = LoggerFactory.getLogger(ExptzController.class);

    @Autowired
    TesteeActionService testeeActionService;
    @Autowired
    TesteeScheduleService testeeScheduleService;

    @RequestMapping(value = "/NoQuery")
    @ResponseBody
    public String NoQuery(TesteeAction testeeAction, HttpServletRequest httprequest) {
        String testee_id = (String) httprequest.getSession().getAttribute("TESTEE_ID");
//        String testee_id = "111";
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
            testeeSchedule.setTest_Round_Id(String.valueOf(Integer.valueOf(testeeSchedule.getTest_Round_Id())+1));
            if (Integer.valueOf(testeeSchedule.getTest_Round_Id()) == 12)
                testeeSchedule.setTest_Round_Id("12");
                int i = testeeActionService.addTesteeAction(testeeAction);
            int j = testeeScheduleService.UpdateTestScheduleRound(testeeSchedule);

            res = ResponseConstant.success("");
            logger.info("SaveAction" + res);
            if (Integer.valueOf(testeeSchedule.getTest_Round_Id()) <= 12) {
                return "/views/modules/experiment/configuration.html";
            } else {
                return "/views/modules/experiment/work.html";
            }
        }

        return "";
    }
}
