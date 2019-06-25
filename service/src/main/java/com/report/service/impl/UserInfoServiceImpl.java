package com.report.service.impl;

import com.report.dao.impl.UserInfoDAO;
import com.report.server.dao.entity.UserInfoEntity;
import com.report.service.service.IUserInfoService;
import org.springframework.stereotype.Service;

/**
 * @Description TODO
 * @Author huguangyin
 * @Date 2019/6/20-13:47
 *  
 */
@Service("userInfoService")
public class UserInfoServiceImpl implements IUserInfoService {

    private UserInfoDAO userInfoDAO;

    public UserInfoServiceImpl(UserInfoDAO userInfoDAO) {
        this.userInfoDAO = userInfoDAO;
    }

    @Override
    public UserInfoEntity queryUserInfo(Long id) throws Exception {
        return userInfoDAO.queryUserInfoById(id);
    }

    @Override
    public UserInfoEntity queryUserInfo(String userName) throws Exception {
        return userInfoDAO.queryUserInfoByName(userName);
    }

    @Override
    public Integer countUserInfo() throws Exception {
        return userInfoDAO.countUserInfo();
    }

    @Override
    public Long insertUserInfo(UserInfoEntity entity) throws Exception {
        return userInfoDAO.insertUserInfo(entity);
    }

    @Override
    public Long insertOrUpdateUserInfo(UserInfoEntity entity) throws Exception {
        return userInfoDAO.updateOrInsertUserInfo(entity);
    }

    @Override
    public Long updateUserInfo(UserInfoEntity entity) throws Exception {
        return userInfoDAO.updateUserInfo(entity);
    }

    @Override
    public void deleteUserInfo(Long id) throws Exception {
        userInfoDAO.deleteUserInfo(id);
    }

    public void setUserInfoDAO(UserInfoDAO userInfoDAO) {
        this.userInfoDAO = userInfoDAO;
    }
}
