package com.example.demo.Service.TesteeAction;

import com.example.demo.Dao.TesteeActionMapper;
import com.example.demo.Pojo.Po.TesteeAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TesteeActionServiceImpl  implements  TesteeActionService{
    @Autowired
    TesteeActionMapper testeeActionMapper;

    @Override
    public int addTesteeAction(TesteeAction testeeAction) {
        int i = testeeActionMapper.addTesteeAction(testeeAction);
        return i;
    }
}
