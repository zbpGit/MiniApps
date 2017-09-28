package com.chatRobot.dao;

import com.chatRobot.model.user;

/**
 * Created by V on 2017/9/11.
 * 用户Dao层
 */
public interface userDao {
    /***
     * 添加用户
     * @param user
     */
    void add(user user);

    /***
     * 跟距项目id查找发红包用户
     * @param id
     * @return
     */
    user select(Integer id);

    Integer selectUser(String openid);
}
