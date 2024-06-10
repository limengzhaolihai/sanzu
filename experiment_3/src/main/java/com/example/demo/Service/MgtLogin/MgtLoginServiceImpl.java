package com.example.demo.Service.MgtLogin;

import com.example.demo.Dao.LoginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @BelongsProject: experiment
 * @BelongsPackage: com.example.demo.Service.MgtLogin
 * @Author: BeafJerky
 * @CreateTime: 2022-11-02  14:40
 * @Description: TODO
 * @Version: 1.0
 */
@Service
public class MgtLoginServiceImpl implements MgtLoginService {

    @Autowired
    private LoginMapper loginMapper;

    @Override
    public int checkIsUser(Map<String, Object> param) {
        System.out.println(param);
        System.out.println(loginMapper.checkIsUser(param));
        return loginMapper.checkIsUser(param);
    }
}
