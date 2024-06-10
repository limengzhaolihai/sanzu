package com.example.demo.Service.FundInfo;

import java.util.List;
import java.util.Map;

public interface FundInfoService {

    Map<String, Object> listFundInfo();

    Map<String, Object> insertFundInfo(Map<String, Object> param, List<Map<String, Object>> list);

    Map<String, Object> selectFundInfo(Map<String, Object> param);

    Map<String, Object> updateFundInfo(Map<String, Object> param, List<Map<String, Object>> list);

    Map<String, Object> deleteFundInfo(Map<String, Object> param);
    Map<String, Object> deleteAllFundInfo();
}
