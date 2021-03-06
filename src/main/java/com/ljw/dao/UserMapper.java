package com.ljw.dao;

import com.ljw.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author lanjuwen
 * @create 2022-04-05  9:50
 */
@Mapper
public interface UserMapper {
    User selectById(int id);

    User selectByName(String username);

    User selectByEmail(String email);

    int insertUser(User user);

    int updateStatus(int id, int status);

    int updateHeader(int id, String headerUrl);

    int updatePassword(int id, String password);

}
