package com.lsl.service;

import com.lsl.dao.UserDao;
import com.lsl.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author shiliang.li
 * @version 1.0.0
 * @Title: lsl_study
 * @Package com.lsl.service
 * @Description: :
 * @time 2020/3/9 17:52
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserDao userDao;

    public List<User> getUserList() {
        userDao.selectById(1,2);
        return null;
    }

    public void updateUserById() {

    }

    public void saveUser() {

    }
}
