package com.example.demo.Service.InitExp;

import com.example.demo.Dao.InitMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class InitExpServiceImpl implements InitExpService {
    @Autowired
    private InitMapper initMapper;

    @Override
    public Map<String, Object> initExp() {
        initMapper.initExp();
        return null;
    }
}
