package com.report.service.impl;


import com.alibaba.fastjson.JSONObject;
import com.report.server.service.result.LoginResult;
import com.report.service.service.ILoginService;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LoginServiceImplTest {
    private final Logger logger = LoggerFactory.getLogger(LoginServiceImplTest.class);

    private ILoginService loginService;

    @Before
    public void setUp() throws Exception {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                "classpath:applicationContext.service.xml", "classpath:dubbo.xml");
        this.loginService = applicationContext.getBean(ILoginService.class);
        PropertyConfigurator.configure("D:\\codingData\\Server\\web\\src\\main\\resources\\log4j2.xml");
        logger.warn("1111111111111111111L");
    }

    @Test
    public void login() throws Exception {
        String passWord = "3";
        LoginResult login = loginService.login("2", passWord);

        System.out.println(JSONObject.toJSONString(login));
    }

    @Test
    public void loginEncryption() {
    }
}
