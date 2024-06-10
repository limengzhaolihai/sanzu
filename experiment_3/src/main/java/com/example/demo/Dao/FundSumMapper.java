package com.example.demo.Dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface FundSumMapper {

    List<Map<String, Object>> listFundSum();

    int insertFundSum(@Param("param") Map<String, Object> param);

    Map<String, Object> selectFundSumByPkeys(@Param("param") Map<String, Object> param);

    int updateFundSumByPkeys(@Param("param") Map<String, Object> param);

    int deleteFundSumByPkeys(@Param("param") Map<String, Object> param);


}
