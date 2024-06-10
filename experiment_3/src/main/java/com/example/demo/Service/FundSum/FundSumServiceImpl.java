package com.example.demo.Service.FundSum;

import com.example.demo.Dao.FundSumMapper;
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
 * @BelongsPackage: com.example.demo.Service.FundSum
 * @Author: BeafJerky
 * @CreateTime: 2022-10-29  18:44
 * @Description: TODO
 * @Version: 1.0
 */
@Service
public class FundSumServiceImpl implements FundSumService {
    @Autowired
    private FundSumMapper fundSumMapper;

    @Override
    public Map<String, Object> listFundSum() {
        Map<String, Object> result = new HashMap<>(2);
        List<Map<String, Object>> list = new ArrayList<>();
        for (Map<String, Object> valueMap : fundSumMapper.listFundSum()) {
            list.add(EntityMap.toEntityMap(valueMap));
        }
        result.put("result", list);
        return result;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Map<String, Object> insertFundSum(Map<String, Object> param) {
        Map<String, Object> result = new HashMap<>(3);
        try {
            int resNum = fundSumMapper.insertFundSum(param);
            if (resNum == 0) {
                result.put("flag", "0");
                result.put("msg", "添加失败");
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
    public Map<String, Object> selectFundSum(Map<String, Object> param) {
        Map<String, Object> result = new HashMap<>(2);
        try {

            result.put("result", EntityMap.toEntityMap(fundSumMapper.selectFundSumByPkeys(param)));
            result.put("flag", "1");
        } catch (Exception e) {
            e.printStackTrace();
            result.put("flag", "1");
            result.put("result", "无结果请重新查询");
        }
        return result;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Map<String, Object> updateFundSum(Map<String, Object> param) {
        Map<String, Object> result = new HashMap<>(3);
        try {
            int resNum = fundSumMapper.updateFundSumByPkeys(param);
            if (resNum == 0) {
                result.put("flag", "0");
                result.put("msg", "更新失败");
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
    public Map<String, Object> deleteFundSum(Map<String, Object> param) {
        Map<String, Object> result = new HashMap<>(3);
        try {
            int resNum = fundSumMapper.deleteFundSumByPkeys(param);
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
