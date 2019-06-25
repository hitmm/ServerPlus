package com.report.server.controller;

import com.report.server.common.ErrorCode;
import com.report.server.service.result.LoginResult;
import com.report.service.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description TODO
 * @Author huguangyin
 * @Date 2019/6/25-16:15
 *  
 */
@RestController
@SpringBootApplication
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private ILoginService loginService;

    @RequestMapping("/user")
    public LoginResult login(@RequestParam("userName")String userName,@RequestParam("passWord")String passWord){
        LoginResult login = null;
        try {
            login = loginService.login(userName, passWord);
        } catch (Exception e) {
            login = LoginResult.failed(ErrorCode.CODE_UNKNOWN,"登录失败");
        }
        return login;
    }

}
