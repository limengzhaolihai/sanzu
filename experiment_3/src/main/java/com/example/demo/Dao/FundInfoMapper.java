package com.example.demo.Dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface FundInfoMapper {
    List<Map<String, Object>> listFundInfo();

    int insertFundInfo(@Param("param") Map<String, Object> param);

    List<Map<String, Object>> selectFundInfoByPkeys(@Param("param") Map<String, Object> param);

    int updateFundInfoByPkeys(@Param("param") Map<String, Object> param);

    int deleteFundInfoByPkeys(@Param("param") Map<String, Object> param);

    int deleteAllFundInfo();
}
