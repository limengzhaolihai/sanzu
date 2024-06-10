package com.example.demo.Controller.Experiment;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.DemoApplication;
import com.example.demo.Pojo.Po.LotteryOne;
import com.example.demo.Pojo.Po.LotteryTwo;
import com.example.demo.Pojo.Po.TesteeAction;
import com.example.demo.Pojo.Po.TesteeSchedule;
import com.example.demo.Service.LotteryOne.LotteryOneService;
import com.example.demo.Service.LotteryTwo.LotteryTwoService;
import com.example.demo.Service.TesteeAction.TesteeActionService;
import com.example.demo.Service.TesteeSchedule.TesteeScheduleService;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@SpringBootTest(classes = DemoApplication.class)
@RunWith(SpringRunner.class)
@Controller
public class LotteryTwoController {
    private Logger logger = LoggerFactory.getLogger(ExptzController.class);
    @Autowired
    LotteryTwoService lotteryTwoService;
    @Autowired
    TesteeScheduleService testeeScheduleService;
    @Autowired
    TesteeActionService testeeActionService;
    @Autowired
    LotteryOneService lotteryOneService;

    @RequestMapping(value = "/lotteryController/addtwo")
    @ResponseBody
    public String Addlottery(@RequestBody Map<String,Object> param, HttpServletRequest httpRequest) {
        //拿到彩票表的被测试者编号
        String testee_id = (String) httpRequest.getSession().getAttribute("TESTEE_ID");
//        String testee_id ="yxm24";
        //获取进度表
        List<TesteeSchedule> testeeSchedules = testeeScheduleService.queryTestScheduleById(testee_id);
        //拿到answer
        param.get("answer");
        JSONArray json = (JSONArray) JSON.toJSON(param.get("answer"));
        //jsonarray 转list
        List<LotteryTwo> list = JSONObject.parseArray(json.toJSONString(), LotteryTwo.class);
        //遍历数组list---防止数据重复
        for(int i = list.size()-10 ; i<list.size();i++){
            int num = (int)(Math.random()*100);
            list.get(i).setTESTEE_ID(testeeSchedules.get(0).getTestee_Id());
            list.get(i).setTEST_ID(testeeSchedules.get(0).getTest_Id());
            list.get(i).setTEST_SESSION_ID(testeeSchedules.get(0).getTest_Session_Id());
            list.get(i).setTEST_STAGE_ID(testeeSchedules.get(0).getTest_Stage_Id());
            list.get(i).setTEST_ROUND_ID(testeeSchedules.get(0).getTest_Round_Id());
            list.get(i).setPROBABILITY_1(String.valueOf(num));
            list.get(i).setPROBABILITY_2(String.valueOf(100-num));
            lotteryTwoService.inertLotteryTwo(list.get(i));
        }



        /*int num = (int)(Math.random()*100);
        lotteryTwo.setTESTEE_ID(testeeSchedules.get(0).getTestee_Id());
        lotteryTwo.setTEST_ID(testeeSchedules.get(0).getTest_Id());
        lotteryTwo.setTEST_SESSION_ID(testeeSchedules.get(0).getTest_Session_Id());
        lotteryTwo.setTEST_STAGE_ID(testeeSchedules.get(0).getTest_Stage_Id());
        lotteryTwo.setTEST_ROUND_ID(testeeSchedules.get(0).getTest_Round_Id());
        lotteryTwo.setPROBABILITY_1(String.valueOf(num));
        lotteryTwo.setPROBABILITY_2(String.valueOf(100-num));
        lotteryTwoService.inertLotteryTwo(lotteryTwo);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:ss:mm");
*/

        if (testeeSchedules.size() > 0) {
            /*TesteeSchedule testeeSchedule = testeeSchedules.get(0);
            testeeAction.setTestee_Id(testee_id);
            testeeAction.setTest_Id(testeeSchedule.getTest_Id());
            testeeAction.setTest_Session_Id(testeeSchedule.getTest_Session_Id());
            testeeAction.setTest_Stage_Id(testeeSchedule.getTest_Stage_Id());
            testeeAction.setTest_Round_Id(testeeSchedule.getTest_Round_Id());
            testeeAction.setCreate_Time(simpleDateFormat.format(new Date()));
            int i = testeeActionService.addTesteeAction(testeeAction);
            logger.info("SaveAction" + "");*/

            LotteryOne lotteryOne = new LotteryOne();
            lotteryOne.setTEST_STAGE_ID("4");
            lotteryOne.setTEST_ROUND_ID("2");
            lotteryOne.setTESTEE_ID(testee_id);
            lotteryOne.setTEST_ID(testeeSchedules.get(0).getTest_Id());
            lotteryOne.setTEST_SESSION_ID(testeeSchedules.get(0).getTest_Session_Id());
            lotteryOneService.updateOne(lotteryOne);
        }
        return "";
    }

}
