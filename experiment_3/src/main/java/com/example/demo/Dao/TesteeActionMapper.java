package com.example.demo.Dao;

import com.example.demo.Pojo.Po.TesteeAction;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface TesteeActionMapper {
    int addTesteeAction(TesteeAction testeeAction);
}
