package com.example.demo.Dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @BelongsProject: experiment
 * @BelongsPackage: com.example.demo.Dao
 * @Author: BeafJerky
 * @CreateTime: 2022-10-31  10:07
 * @Description: TODO
 * @Version: 1.0
 */
@Mapper
@Repository
public interface GlobalConfigMapper {
    List<Map<String, Object>> selectGlobalConfig();

    int updateGlobalConfig(@Param("param") Map<String, Object> param);
}
