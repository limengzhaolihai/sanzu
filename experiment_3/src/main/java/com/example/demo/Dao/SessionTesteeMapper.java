package com.example.demo.Dao;


import com.example.demo.Pojo.Po.SessionTestee;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SessionTesteeMapper {
    //查询以开始实验
        List<SessionTestee> querybyStart();

}
