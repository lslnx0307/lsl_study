package com.lsl.service;

import com.lsl.model.User;

import java.util.List;

/**
 * @author shiliang.li
 * @version 1.0.0
 * @Title: lsl_study
 * @Package com.lsl.service
 * @Description: :
 * @time 2020/3/9 17:51
 */
public interface UserService {

    List<User> getUserList();

    void updateUserById();

    void saveUser();
}
