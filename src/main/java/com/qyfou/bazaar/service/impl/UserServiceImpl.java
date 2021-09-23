package com.qyfou.bazaar.service.impl;

import com.qyfou.bazaar.dao.UserDao;
import com.qyfou.bazaar.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public Long selectIdByOpenId(String openId) {
        return userDao.selectIdByOpenId(openId);
    }
}
