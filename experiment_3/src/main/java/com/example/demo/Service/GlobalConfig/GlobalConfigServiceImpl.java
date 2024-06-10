package com.example.demo.Service.GlobalConfig;

import com.example.demo.Dao.GlobalConfigMapper;
import com.example.demo.Utils.EntityMap;
import com.example.demo.Utils.ListUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @BelongsProject: experiment
 * @BelongsPackage: com.example.demo.Service.GlobalConfig
 * @Author: BeafJerky
 * @CreateTime: 2022-10-31  10:16
 * @Description: TODO
 * @Version: 1.0
 */
@Service
public class GlobalConfigServiceImpl implements GlobalConfigService {
    @Autowired
    private GlobalConfigMapper globalConfigMapper;

    @Override
    public Map<String, Object> selectGlobalConfig() {
        Map<String, Object> result = new HashMap<>(3);
        List<Map<String, Object>> list = new ArrayList<>();
        for (Map<String, Object> valueMap : globalConfigMapper.selectGlobalConfig()) {
            list.add(EntityMap.toEntityMap(valueMap));
        }
        result.put("result", list);
        return result;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Map<String, Object> updateGlobalConfig(Map<String, Object> param) {
        Map<String, Object> result = new HashMap<>(3);
        List<Map<String, Object>> list = ListUtils.castListMap(param.get("configList"), String.class, Object.class);
        try {
            for (Map<String, Object> valueMap : list) {
                globalConfigMapper.updateGlobalConfig(valueMap);
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

   
}
