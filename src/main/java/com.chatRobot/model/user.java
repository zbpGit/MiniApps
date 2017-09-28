package com.chatRobot.model;

/**
 * Created by V on 2017/9/11.
 * 用户类
 */
public class user {
    private Integer id;//用户id
    private String name;//用户名
    private String head;//用户头像
    private String sex;//性别
    private String openid;//用户openid
    private Integer count_income;//总收入
    private Integer count_expend;//总支出
    private String time;//时间

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public Integer getCount_income() {
        return count_income;
    }

    public void setCount_income(Integer count_income) {
        this.count_income = count_income;
    }

    public Integer getCount_expend() {
        return count_expend;
    }

    public void setCount_expend(Integer count_expend) {
        this.count_expend = count_expend;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "user{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", head='" + head + '\'' +
                ", sex='" + sex + '\'' +
                ", openid='" + openid + '\'' +
                ", count_income=" + count_income +
                ", count_expend=" + count_expend +
                ", time='" + time + '\'' +
                '}';
    }
}
