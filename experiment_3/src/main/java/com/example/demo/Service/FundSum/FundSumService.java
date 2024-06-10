package com.example.demo.Service.FundSum;

import java.util.Map;

public interface FundSumService {
    Map<String, Object> listFundSum();

    Map<String, Object> insertFundSum(Map<String, Object> param);

    Map<String, Object> selectFundSum(Map<String, Object> param);

    Map<String, Object> updateFundSum(Map<String, Object> param);

    Map<String, Object> deleteFundSum(Map<String, Object> param);

}
