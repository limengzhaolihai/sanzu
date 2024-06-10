package com.example.demo.Service.SessionTestee;

import com.example.demo.Dao.SessionTesteeMapper;
import com.example.demo.Pojo.Po.SessionTestee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SessionTesteeServiceImpl implements SessionTesteeService{
    @Autowired
    SessionTesteeMapper sessionTesteeMapper;
    @Override
    public List<SessionTestee> querybyStart() {
        List<SessionTestee> sessionTestees = sessionTesteeMapper.querybyStart();
        return sessionTestees;
    }
}
