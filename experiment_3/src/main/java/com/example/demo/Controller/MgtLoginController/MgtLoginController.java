package com.example.demo.Controller.MgtLoginController;

import com.example.demo.Controller.Login.LoginController;
import com.example.demo.DemoApplication;
import com.example.demo.Service.MgtLogin.MgtLoginService;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @BelongsProject: experiment
 * @BelongsPackage: com.example.demo.Controller.MgtLoginController
 * @Author: BeafJerky
 * @CreateTime: 2022-10-29  17:46
 * @Description: TODO
 * @Version: 1.0
 */
@SpringBootTest(classes = DemoApplication.class)
@RunWith(SpringRunner.class)
@Controller
public class MgtLoginController {
    @Autowired
    private MgtLoginService mgtLoginService;

    private Logger logger = LoggerFactory.getLogger(LoginController.class);


    @RequestMapping(value = "/MgtIndex")
    public String mgtToLogin() {
        return "/views/modules/management/main.html";
    }

    @RequestMapping(value = "/MgtJumpPage/{path}")
    public String mgtToPage(@PathVariable("path") String id) {
        return "/views/modules/management/" + id + ".html";
    }

    @RequestMapping(value = "/checkLogin")
    public String mgtCheckLogin(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("name") == null) {
            return "/views/modules/management/login.html";
        } else {
            Map<String, Object> param = new HashMap<>(3);
            param.put("user", session.getAttribute("user"));
            param.put("password", session.getAttribute("password"));
            if (mgtLoginService.checkIsUser(param) == 0) {
                return "/views/modules/management/login.html";
            }
        }
        return "/views/modules/management/indexPage.html";
    }

    @RequestMapping(value = "/mgtLogin")
    public String mgtLogin(String user, String password, HttpServletRequest request) {
        Map<String, Object> param = new HashMap<>(3);
        param.put("user", user);
        param.put("password", password);
//        Map<String, Object> result = new HashMap<>(2);
        if ("".equals(user) || "".equals(password)) {
            System.out.println("+++");
            return "/views/modules/management/login.html";
        }
        if (mgtLoginService.checkIsUser(param) == 0) {
            System.out.println("______");
            System.out.println("______");
            return "/views/modules/management/login.html";
        }
//        else {
//            HttpSession session = request.getSession();
//            session.setAttribute("user", param.get("user"));
//            session.setAttribute("password", param.get("password"));
//        }
        System.out.println("=============");
        return "/views/modules/management/indexPage.html";
    }
}
