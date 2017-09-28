package com.chatRobot.service;

import com.chatRobot.model.page;

import java.util.List;

/**
 * Created by V on 2017/9/11.
 * 红包服务层
 */
public interface pageService {

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

    /***
     * 查找发红包记录
     * @param uid
     * @return
     */
    List<page> pageSelect(Integer uid);

    page selectNumber(Integer id);

}
