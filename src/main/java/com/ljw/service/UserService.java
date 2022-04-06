package com.ljw.service;

import com.ljw.dao.UserMapper;
import com.ljw.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lanjuwen
 * @create 2022-04-05  14:32
 */
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public User findUserById(int id) {
        return userMapper.selectById(id);
    }
}
