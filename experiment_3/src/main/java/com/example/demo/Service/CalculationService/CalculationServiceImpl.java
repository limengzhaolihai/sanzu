package com.example.demo.Service.CalculationService;

import com.example.demo.Dao.CalculationMapper;
import com.example.demo.Dao.ProfitMapper;
import com.example.demo.Pojo.Po.Profit;
import com.example.demo.Pojo.Po.SubjectBank;
import com.example.demo.Pojo.Po.TestCalTemp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 随机题
 *
 * @author bosonghua
 * @date 2022/10/31 - 15:24
 */
@Service
public class CalculationServiceImpl implements CalculationService {

    @Autowired
    CalculationMapper calculationMapper;

    @Autowired
    private ProfitMapper profitMapper;

    public SubjectBank findProblem(String testee_id) {
        // 获取轮次信息
        Profit profitInfo = profitMapper.findRound(testee_id);

        // 从总题库里拿取此人当前应做题号
        int count = calculationMapper.countCalTmp(testee_id);
        // 从总题库里拿取此人当前应做题
        SubjectBank problem = calculationMapper.findProblem(String.valueOf(count + 1));
        // 获取此人在当前阶段做了几道题
        int satgeCount = calculationMapper.stageCountCalTmp(profitInfo);
        problem.setNid(satgeCount+1);
        return problem;
    }

    public void saveCalTemp(TestCalTemp testCalTemp) {
        calculationMapper.saveCalTemp(testCalTemp);
    }

    // 收益保存
    public Profit effortIncome(String testee_id) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:ss:mm");

        // 轮次信息
        Profit profitInfo = profitMapper.findRound(testee_id);

        // 答对题数
        String rightNum = calculationMapper.answerResult(profitInfo).getRightNum();
        rightNum = null == rightNum ? "0" : rightNum;
        String rewardPoint = calculationMapper.rewardPoint().getRewardPoint();
        Integer sumIncome = Integer.valueOf(rightNum) * Integer.valueOf(rewardPoint);

        profitInfo.setSUM_INCOME("0");
        profitInfo.setSESSION_INCOME(String.valueOf(sumIncome));
        profitInfo.setACC_INCOME("0");
        profitInfo.setCREATED_TIME(simpleDateFormat.format(new Date()));

        List<String> existIncome = calculationMapper.isExistIncome(profitInfo);
        final int[] state = {1};
        existIncome.forEach(item -> {
            if (profitInfo.getTEST_ROUND_ID().equals(item)) {
                state[0] = 0;
            }
        });
        if (state[0] == 1) {
            calculationMapper.insertIncome(profitInfo);
        }
        return profitInfo;
    }
}
