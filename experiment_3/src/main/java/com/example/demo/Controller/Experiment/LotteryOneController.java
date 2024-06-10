package com.example.demo.Controller.Experiment;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.DemoApplication;
import com.example.demo.Pojo.Po.LotteryOne;
import com.example.demo.Pojo.Po.TesteeAction;
import com.example.demo.Pojo.Po.TesteeSchedule;
import com.example.demo.Service.LotteryOne.LotteryOneService;
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
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.*;

@SpringBootTest(classes = DemoApplication.class)
@RunWith(SpringRunner.class)

//彩票选择一接口
@Controller
public class LotteryOneController {
   //生成日志
    private Logger logger = LoggerFactory.getLogger(ExptzController.class);

    @Autowired
    LotteryOneService lotteryOneService;

    @Autowired
    TesteeScheduleService testeeScheduleService;

    @Autowired
    TesteeActionService testeeActionService;

    @RequestMapping(value = "/lotteryController/addone")
    @ResponseBody
    public String Addlottery(@RequestBody Map<String,Object> param,  HttpServletRequest httpRequest) {
        //拿到彩票表的被测试者编号---从缓存中读取
        String testee_id = (String) httpRequest.getSession().getAttribute("TESTEE_ID");

//        String testee_id ="yxm23";
        //获取进度表
        List<TesteeSchedule> testeeSchedules = testeeScheduleService.queryTestScheduleById(testee_id);
        //拿到answer
        param.get("answer");

        JSONArray json = (JSONArray) JSON.toJSON(param.get("answer"));
//        List<LotteryOne> a =new ArrayList<>();
        //jsonarray 转list
        List<LotteryOne> list = JSONObject.parseArray(json.toJSONString(), LotteryOne.class);

        //遍历数组list---防止数据重复
        for(int i = list.size()-10 ; i<list.size();i++){
            list.get(i).setTESTEE_ID(testeeSchedules.get(0).getTestee_Id());
            list.get(i).setTEST_ID(testeeSchedules.get(0).getTest_Id());
            list.get(i).setTEST_SESSION_ID(testeeSchedules.get(0).getTest_Session_Id());
            list.get(i).setTEST_STAGE_ID(testeeSchedules.get(0).getTest_Stage_Id());
            list.get(i).setTEST_ROUND_ID(testeeSchedules.get(0).getTest_Round_Id());
            lotteryOneService.inertLotteryOne(list.get(i));
        }
       /* for(LotteryOne lotteryOne:list){
            lotteryOne.setTESTEE_ID(testeeSchedules.get(0).getTestee_Id());
            lotteryOne.setTEST_ID(testeeSchedules.get(0).getTest_Id());
            lotteryOne.setTEST_SESSION_ID(testeeSchedules.get(0).getTest_Session_Id());
            lotteryOne.setTEST_STAGE_ID(testeeSchedules.get(0).getTest_Stage_Id());
            lotteryOne.setTEST_ROUND_ID(testeeSchedules.get(0).getTest_Round_Id());
            lotteryOneService.inertLotteryOne(lotteryOne);
        }*/
        LotteryOne lotteryOne = new LotteryOne();
        lotteryOne.setTESTEE_ID(testeeSchedules.get(0).getTestee_Id());
        lotteryOne.setTEST_ID(testeeSchedules.get(0).getTest_Id());
        lotteryOne.setTEST_SESSION_ID(testeeSchedules.get(0).getTest_Session_Id());
        lotteryOne.setTEST_STAGE_ID(testeeSchedules.get(0).getTest_Stage_Id());
        lotteryOne.setTEST_ROUND_ID(testeeSchedules.get(0).getTest_Round_Id());
        lotteryOne.setTEST_STAGE_ID("4");
        lotteryOne.setTEST_ROUND_ID("2");
        lotteryOneService.updateOne(lotteryOne);


//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:ss:mm");
      //获取行为数据
//        if (testeeSchedules.size() > 0) {
//            TesteeAction testeeAction = new TesteeAction();
//            TesteeSchedule testeeSchedule = testeeSchedules.get(0);
//            Map<String,String> b= toMap(param.get("actionData"));
//
//            TesteeAction  c= (TesteeAction)param.get("actionData");
//
//            Set<Map.Entry<String,Object>> lottery1 = param.entrySet();
//
//            testeeAction.setPage_Flag(b.get("page_Flag"));
//            testeeAction.setPage_Flag_Explain(b.get("page_Flag_Explain"));
//            testeeAction.setModule_Name(b.get("module_Name"));
//            testeeAction.setSelect_Condition(b.get("selection_Condition"));
//            testeeAction.setStop_Time(b.get("stop_Time"));
//            testeeAction.setTestee_Id(testee_id);
//            testeeAction.setTest_Id(testeeSchedule.getTest_Id());
//            testeeAction.setTest_Session_Id(testeeSchedule.getTest_Session_Id());
//            testeeAction.setTest_Stage_Id(testeeSchedule.getTest_Stage_Id());
//            testeeAction.setTest_Round_Id(testeeSchedule.getTest_Round_Id());
//            testeeAction.setCreate_Time(simpleDateFormat.format(new Date()));
//            int x = testeeActionService.addTesteeAction(testeeAction);
//            logger.info("SaveAction" + "");
//        }
        return "";
    }
    /*简单Object转成map*/
//    public static Map<String,String> toMap(Object o){
//        Map<String,String> map=new HashMap<String, String>();
//        Field[] fields=o.getClass().getDeclaredFields();
//        try {
//            for (int i=0;i<fields.length;i++) {
//                String name=fields[i].getName();
//                Field field=o.getClass().getDeclaredField(name);
//                field.setAccessible(true);
//                if (null!=field){
//                    map.put(name,field.get(o).toString());
//                }
//            }
//        }catch(Exception e){
//            e.printStackTrace();
//        }
//        return map;
//    }
//
//    public  static Map<String,Object> ObjectTpMap(Object obj) throws IllegalAccessException{
//        Map<String,Object> map = new HashMap<String,Object>();
//        Class<?> cla = obj.getClass();
//        Field[] fields = cla.getDeclaredFields();
//        for(Field field:fields){
//            field.setAccessible(true);
//            String keyName = field.getName();
//            Object value = field.get(obj);
//            if( value == null){
//                value = "";
//                map.put(keyName,value);
//            }
//        }
//        return map;
//    }

    }
