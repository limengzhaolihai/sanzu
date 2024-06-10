package com.example.demo.Service.ExperimentSession;

import com.example.demo.Dao.ExperimentSessionMapper;
import com.example.demo.Utils.EntityMap;
import com.example.demo.Utils.ListUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @BelongsProject: experiment
 * @BelongsPackage: com.example.demo.Service.ExperimentSession
 * @Author: BeafJerky
 * @CreateTime: 2022-10-31  11:45
 * @Description: TODO
 * @Version: 1.0
 */
@Service
public class ExperimentSessionServiceImpl implements ExperimentSessionService {
    @Autowired
    private ExperimentSessionMapper experimentSessionMapper;


    @Override
    @Transactional(rollbackFor = Exception.class)
    public Map<String, Object> insertExpSession(Map<String, Object> param) {
        Map<String, Object> result = new HashMap<>(3);
        try {
            experimentSessionMapper.insertExpSession(param);
            Map<String, Object> stageParam = new HashMap<>(8);
            stageParam.put("testId", param.get("testId"));
            stageParam.put("testSessionId", param.get("testSessionId"));
            stageParam.put("fundDataType", 1);
            stageParam.put("fundGroup", param.get("fundGroup"));
            for (int i = 1; i <= 3; i++) {
                for (int j = 1; j <= 13; j++) {
                    stageParam.put("testStageId", i);
                    stageParam.put("testRoundId", j);
                    System.out.println(stageParam);
                    experimentSessionMapper.insertExpStage(stageParam);
                }
            }
            stageParam.remove("fundDataType");
            stageParam.remove("fundGroup");
            for (int i = 1; i < 3; i++) {
                stageParam.put("testStageId", 4);
                stageParam.put("testRoundId", i);
                experimentSessionMapper.insertExpStage(stageParam);
            }
            stageParam.put("testStageId", 5);
            stageParam.put("testRoundId", 1);
            experimentSessionMapper.insertExpStage(stageParam);

            Map<String, Object> scheduleParam = new HashMap<>(4);
            scheduleParam.put("testId", param.get("testId"));
            scheduleParam.put("testSessionId", param.get("testSessionId"));
            int testeeNum = Integer.parseInt(param.get("testeeNum").toString());
            SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
            Date dd = sdf1.parse(param.get("startTime").toString());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            String dateNowStr = sdf.format(dd);
            for (int i = 0; i < testeeNum; i++) {
                scheduleParam.put("testeeId", dateNowStr + String.format("%02d", Integer.parseInt(scheduleParam.get("testSessionId").toString())) + String.format("%03d", (i + 1)));
                experimentSessionMapper.insertSchedule(scheduleParam);
            }

            result.put("flag", "1");
            result.put("msg", "添加成功");
        } catch (Exception e) {
            e.printStackTrace();
            result.put("flag", "0");
            result.put("msg", "添加失败");
        }
        return result;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Map<String, Object> updateExpSession(Map<String, Object> param) {
        Map<String, Object> result = new HashMap<>(3);
        try {
            experimentSessionMapper.updateExpSession(param);
            experimentSessionMapper.updateExpStagePkeysByOld(param);
            Map<String, Object> scheduleParam = new HashMap<>(4);
            scheduleParam.put("testId", param.get("oldTestId"));
            scheduleParam.put("testSessionId", param.get("oldTestSessionId"));
            experimentSessionMapper.deleteSchedule(scheduleParam);
            scheduleParam.put("testId", param.get("testId"));
            scheduleParam.put("testSessionId", param.get("testSessionId"));
            int testeeNum = Integer.parseInt(param.get("testeeNum").toString());
            SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
            Date dd = sdf1.parse(param.get("startTime").toString());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            String dateNowStr = sdf.format(dd);
            for (int i = 0; i < testeeNum; i++) {
                scheduleParam.put("testeeId", dateNowStr + String.format("%02d", Integer.parseInt(scheduleParam.get("testSessionId").toString())) + String.format("%03d", (i + 1)));
                experimentSessionMapper.insertSchedule(scheduleParam);
            }
            result.put("flag", "1");
            result.put("msg", "更新成功");
        } catch (Exception e) {
            e.printStackTrace();
            result.put("flag", "0");
            result.put("msg", "更新失败");
        }
        return result;
    }

    @Override
    public Map<String, Object> selectExpSession(Map<String, Object> param) {
        return EntityMap.toEntityMap(experimentSessionMapper.selectExpSession(param));
    }

    @Override
    public Map<String, Object> listExpSession() {
        Map<String, Object> result = new HashMap<>(3);
        List<Map<String, Object>> list = new ArrayList<>();
        for (Map<String, Object> valueMap : experimentSessionMapper.listExpSession()) {
            list.add(EntityMap.toEntityMap(valueMap));
        }
        result.put("result", list);
        return result;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Map<String, Object> deleteExpSession(Map<String, Object> param) {
        Map<String, Object> result = new HashMap<>(3);
        try {
            result.put("flag", "1");
            result.put("msg", "删除成功");
            int resNum = experimentSessionMapper.deleteExpSession(param);
            if (resNum == 0) {
                result.put("flag", "0");
                result.put("msg", "删除失败");
            }
            int resNum2 = experimentSessionMapper.deleteExpStage(param);
            if (resNum2 == 0) {
                result.put("flag", "0");
                result.put("msg", "删除失败");
            }
            int resNum3 = experimentSessionMapper.deleteSchedule(param);
            if (resNum3 == 0) {
                result.put("flag", "0");
                result.put("msg", "删除失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.put("flag", "0");
            result.put("msg", "删除失败");
        }
        return result;
    }

    @Override
    public Map<String, Object> selectExpStage(Map<String, Object> param) {
        Map<String, Object> result = new HashMap<>(3);
        List<Map<String, Object>> list = new ArrayList<>();
        for (Map<String, Object> valueMap : experimentSessionMapper.selectExpStage(param)) {
            list.add(EntityMap.toEntityMap(valueMap));
        }
        result.put("result", list);
        return result;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Map<String, Object> updateExpStage(Map<String, Object> param) {
        Map<String, Object> result = new HashMap<>(3);
        try {
            List<Map<String, Object>> list = ListUtils.castListMap(param.get("stageList"), String.class, Object.class);
            for (Map<String, Object> valueMap : list) {
                valueMap.put("testId", param.get("testId"));
                valueMap.put("testSessionId", param.get("testSessionId"));
                System.out.println(valueMap);
                experimentSessionMapper.updateExpStage(valueMap);
            }
            result.put("flag", "1");
            result.put("msg", "更新成功");

        } catch (Exception e) {
            e.printStackTrace();
            result.put("flag", "0");
            result.put("msg", "更新失败");
        }
        return result;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Map<String, Object> startExp(Map<String, Object> param) {
        Map<String, Object> result = new HashMap<>(3);
        try {
            experimentSessionMapper.updateTestStartEndTrueByPkeys(param);
            experimentSessionMapper.updateScheduleStartEndTrueByPkeys(param);
            result.put("flag", "1");
            result.put("msg", "状态更新成功");

        } catch (Exception e) {
            e.printStackTrace();
            result.put("flag", "0");
            result.put("msg", "状态更新失败");
        }
        return result;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Map<String, Object> finishExp(Map<String, Object> param) {
        Map<String, Object> result = new HashMap<>(3);
        try {
            experimentSessionMapper.updateTestStartEndFalseByPkeys(param);
            experimentSessionMapper.updateScheduleStartEndFalseByPkeys(param);
            result.put("flag", "1");
            result.put("msg", "状态更新成功");
        } catch (Exception e) {
            e.printStackTrace();
            result.put("flag", "0");
            result.put("msg", "状态更新失败");
        }
        return result;
    }

    @Override
    public Map<String, Object> listReward(Map<String, Object> param) {
        Map<String, Object> result = new HashMap<>(3);
        List<Map<String, Object>> list = new ArrayList<>();
        for (Map<String, Object> valueMap : experimentSessionMapper.listReward(param)) {
            list.add(EntityMap.toEntityMap(valueMap));
        }
        result.put("result", list);
        return result;
    }

    @Override
    public Map<String, Object> listSchedule(Map<String, Object> param) {
        Map<String, Object> result = new HashMap<>(3);
        List<Map<String, Object>> list = new ArrayList<>();
        for (Map<String, Object> valueMap : experimentSessionMapper.listScheduleByPkeys(param)) {
            list.add(EntityMap.toEntityMap(valueMap));
        }
        result.put("result", list);
        return result;
    }

}
