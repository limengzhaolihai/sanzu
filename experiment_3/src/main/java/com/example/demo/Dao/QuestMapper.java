package com.example.demo.Dao;

import com.example.demo.Pojo.Po.Quest;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author wzz
 * @date 2022/10/30-9:27
 */
@Mapper
@Repository
public interface QuestMapper {
    int addQuest(Quest quest);
}
