package com.example.demo.Service.FundInfo;

import com.example.demo.Dao.FundInfoMapper;
import com.example.demo.Utils.EntityMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @BelongsProject: experiment
 * @BelongsPackage: com.example.demo.Service.FundInfo
 * @Author: BeafJerky
 * @CreateTime: 2022-10-29  17:24
 * @Description: TODO
 * @Version: 1.0
 */
@Service
public class FundInfoServiceImpl implements FundInfoService {
    @Autowired
    private FundInfoMapper fundInfoMapper;

    @Override
    public Map<String, Object> listFundInfo() {
        Map<String, Object> result = new HashMap<>(3);
        List<Map<String, Object>> list = new ArrayList<>();
        for (Map<String, Object> valueMap : fundInfoMapper.listFundInfo()) {
            list.add(EntityMap.toEntityMap(valueMap));
        }
        result.put("result", list);
        return result;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Map<String, Object> insertFundInfo(Map<String, Object> param, List<Map<String, Object>> list) {
        Map<String, Object> params = new HashMap<>(7);
        params.put("testStageId", param.get("testStageId"));
        params.put("fundGroup", param.get("fundGroup"));
        for (Map<String, Object> valueMap : list) {
            for (int i = 1; i <= 3; i++) {
                params.put("fundId", i);
                params.put("fundNum", valueMap.get("A"));
                params.put("price", valueMap.get("Fund" + i));
                System.out.println(params);
                fundInfoMapper.insertFundInfo(params);
            }
        }
        return null;
    }

    @Override
    public Map<String, Object> selectFundInfo(Map<String, Object> param) {
        Map<String, Object> result = new HashMap<>(2);
        try {
            List<Map<String, Object>> list = new ArrayList<>();
            for (Map<String, Object> valueMap : fundInfoMapper.selectFundInfoByPkeys(param)) {
                list.add(EntityMap.toEntityMap(valueMap));
            }
            result.put("result", list);
            result.put("flag", "1");
        } catch (Exception e) {
            e.printStackTrace();
            result.put("flag", "0");
            result.put("result", "无结果请重新查询");
        }
        return result;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Map<String, Object> updateFundInfo(Map<String, Object> param, List<Map<String, Object>> list) {
        Map<String, Object> result = new HashMap<>(3);
        try {
            for (Map<String, Object> valueMap : list) {
                param.put("fundNum", valueMap.get("A"));
                param.put("price", valueMap.get("Fund" + param.get("fundId")));
                fundInfoMapper.updateFundInfoByPkeys(param);
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

    public Map<String, Object> deleteFundInfo(Map<String, Object> param) {
        Map<String, Object> result = new HashMap<>(3);
        try {
            int resNum = fundInfoMapper.deleteFundInfoByPkeys(param);
            if (resNum == 0) {
                result.put("flag", "0");
                result.put("msg", "删除失败");
            }
            result.put("flag", "1");
            result.put("msg", "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            result.put("flag", "0");
            result.put("msg", "删除失败");
        }
        return result;
    }
    public Map<String,Object> deleteAllFundInfo(){
        Map<String, Object> result = new HashMap<>(3);
        try {
            int resNum = fundInfoMapper.deleteAllFundInfo();
            if (resNum == 0) {
                result.put("flag", "0");
                result.put("msg", "删除失败");
            }
            result.put("flag", "1");
            result.put("msg", "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            result.put("flag", "0");
            result.put("msg", "删除失败");
        }
        return result;
    }

}
