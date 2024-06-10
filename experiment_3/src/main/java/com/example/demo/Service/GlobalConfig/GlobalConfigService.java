package com.example.demo.Service.GlobalConfig;

import java.util.Map;

public interface GlobalConfigService {

    Map<String, Object> selectGlobalConfig();

    Map<String, Object> updateGlobalConfig(Map<String, Object> param);
}
