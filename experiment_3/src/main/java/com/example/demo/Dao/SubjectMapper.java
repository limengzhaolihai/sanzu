package com.example.demo.Dao;

import com.example.demo.Pojo.Subject300;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface SubjectMapper {
    public int addSubject(Subject300 subject300);
}
