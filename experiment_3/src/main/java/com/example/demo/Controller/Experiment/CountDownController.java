package com.example.demo.Controller.Experiment;

import com.example.demo.DemoApplication;
import com.example.demo.Service.CountDown.CountDownService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@SpringBootTest(classes = DemoApplication.class)
@RunWith(SpringRunner.class)
//倒计时
@Controller
@RequestMapping("/down")
public class CountDownController {
    @Autowired
    private CountDownService countDownService;
    @RequestMapping(value = "/startTime")
    @ResponseBody
    public String StartTime(HttpServletRequest request) {
        String startDown = countDownService.startDown();
        return startDown;
    }
    @RequestMapping(value = "/finishTime")
    @ResponseBody
    public String FinishTime(HttpServletRequest request) {
        String finishDown = countDownService.finishDown();
        return finishDown;
    }
    @RequestMapping(value = "/halfTime")
    @ResponseBody
    public String HalfTime(HttpServletRequest request) {
        String halfDown = countDownService.halfDown();
        return halfDown;
    }
}
