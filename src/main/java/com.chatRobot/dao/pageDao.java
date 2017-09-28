package com.chatRobot.dao;

import com.chatRobot.model.page;

import java.util.List;

/**
 * Created by V on 2017/9/11.
 * 项目Dao层
 */
public interface pageDao {
    /***
     * 添加项目
     * @param page
     */
    void add(page page);

    /***
     * 设置项目
     * @param page
     */
    void update(page page);

    /***
     * 查找红包金额
     * @param id
     * @return
     */
    Integer selectMoney(Integer id);

    /***
     * 查找剩余红包数
     * @param id
     * @return
     */
    Integer number(Integer id);

    /***
     * 查看答案
     * @param id
     * @return
     */
    String view(Integer id);

    /***
     * 查找标题
     * @param id
     * @return
     */
    String headline(Integer id);

    List<page> pageSelect(Integer uid);

    page selectNumber(Integer id);
}
