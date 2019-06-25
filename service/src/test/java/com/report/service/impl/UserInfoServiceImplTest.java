package com.report.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.report.server.dao.entity.UserInfoEntity;
import com.report.service.service.IUserInfoService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserInfoServiceImplTest {
    private IUserInfoService userInfoService;

    @Before
    public void setUp() throws Exception {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                "classpath:applicationContext.service.xml", "classpath:dubbo.xml");
        this.userInfoService = applicationContext.getBean(IUserInfoService.class);
    }

    @Test
    public void queryUserInfo() throws Exception {
        UserInfoEntity entity = this.userInfoService.queryUserInfo(1212L);
        System.out.println(JSONObject.toJSONString(entity));
    }
}
