package com.example.demo.Controller.Profit;

import com.example.demo.DemoApplication;
import com.example.demo.Pojo.Po.LotteryOne;
import com.example.demo.Pojo.Po.Profit;
import com.example.demo.Service.ProfitService.ProfitService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 收益
 *
 * @author bosonghua
 * @date 2022/11/1 - 8:48
 */
@SpringBootTest(classes = DemoApplication.class)
@RunWith(SpringRunner.class)
@Controller
public class ProfitController {

    @Autowired
    private ProfitService profitService;

    // 投资任务收益
    @RequestMapping(value = "/profitController/calProfit")
    @ResponseBody
    public Profit calProfit(HttpServletRequest httprequest) {
        String testee_id = (String) httprequest.getSession().getAttribute("TESTEE_ID");
        return profitService.calProfit(testee_id);
    }

    // 彩票收益
    @RequestMapping(value = "/profitController/lotteryRevenue")
    @ResponseBody
    public Profit lotteryRevenue(HttpServletRequest httprequest) {
        String testee_id = (String) httprequest.getSession().getAttribute("TESTEE_ID");
        return profitService.calLotteryRevenue(testee_id);
    }

    // 阶段收益
    @RequestMapping(value = "/profitController/stageProfit")
    @ResponseBody
    public Profit stageProfit(HttpServletRequest httprequest) {
        String testee_id = (String) httprequest.getSession().getAttribute("TESTEE_ID");
        return profitService.stageProfit(testee_id);
    }

    // 总收益
    @RequestMapping(value = "/profitController/finalProfit")
    @ResponseBody
    public Profit finalProfit(HttpServletRequest httprequest) {
        String testee_id = (String) httprequest.getSession().getAttribute("TESTEE_ID");
        // String testee_id = (String)"2022110501006";
        return profitService.finalProfit(testee_id);
    }

    // 显示轮次收益
    @RequestMapping(value = "/profitController/viewRoundProfit")
    @ResponseBody
    public Profit viewRoundProfit(HttpServletRequest httprequest) {
        String testee_id = (String) httprequest.getSession().getAttribute("TESTEE_ID");
        return profitService.viewRoundProfit(testee_id);
    }

    // 预设比例显示
    @RequestMapping(value = "/profitController/presetScale")
    @ResponseBody
    public Profit presetScale(HttpServletRequest httprequest) {
        String testee_id = (String) httprequest.getSession().getAttribute("TESTEE_ID");
        return profitService.presetScale(testee_id);
    }
}
