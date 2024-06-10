package com.example.demo.Controller.Experiment;

import com.example.demo.Pojo.Po.Quest;
import com.example.demo.Pojo.Po.TesteeSchedule;
import com.example.demo.Service.Quest.QuestService;
import com.example.demo.Service.TesteeSchedule.TesteeScheduleService;
import com.example.demo.Utils.ResponseConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author wzz
 * @date 2022/10/30-10:23
 */
@Controller
@RequestMapping("/quest")
@ResponseBody
public class QuestController {
    private Logger logger = LoggerFactory.getLogger(ExptzController.class);

    @Autowired
    QuestService questService;
    @Autowired
    TesteeScheduleService testeeScheduleService;

    @PostMapping("/SaveQuest")
    public String SaveQuest(@RequestBody Map<String,Object> quest, HttpServletRequest httpRequest){

        String testee_id = (String) httpRequest.getSession().getAttribute("TESTEE_ID");
//        String testee_id ="yxm10" ;
        List<TesteeSchedule> testeeSchedules = testeeScheduleService.queryTestScheduleById(testee_id);
        String res = "";
        if (testeeSchedules.size() > 0){
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            TesteeSchedule testeeSchedule = testeeSchedules.get(0);

            String test_id = testeeSchedule.getTest_Id();
            String test_session_id = testeeSchedule.getTest_Session_Id();
            String test_stage_id = "5";
            String formatdate = simpleDateFormat.format(new Date());

            // 测试数据
            /*String testee_id = "1";
            String test_id = "1";
            String test_session_id = "2";
            String test_stage_id = "5";
            String formatdate = simpleDateFormat.format(new Date());*/

            Set<Map.Entry<String,Object>> entryset = quest.entrySet();
            for(Map.Entry<String,Object> entry:entryset){
                Quest quests = new Quest();
                quests.setTestee_Id(testee_id);
                quests.setTest_Id(test_id);
                quests.setTest_Session_Id(test_session_id);
                quests.setTest_Stage_Id(test_stage_id);
                quests.setTest_Round_Id("1");
                quests.setCreated_Time(formatdate);
                quests.setTopic_Id(entry.getKey());
                quests.setOptions((String)entry.getValue());
                logger.info(quests.toString());

                int q = questService.addQuest(quests);
                if (q > 0)
                    logger.info("addQuest插入成功");
                else
                    logger.info("addQuest插入失败");
            }

            // res = ResponseConstant.success("/views/modules/experiment/end.html");
        }

        return "/views/modules/experiment/end.html";
    }
}
