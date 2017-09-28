package com.chatRobot.model;

/**
 * Created by V on 2017/9/27.
 */
public class income {
    private Integer id;//收入id
    private Integer uid;//用户id
    private Integer income_money;//收入金额
    private Integer pid;//项目id
    private String time;//收入时间
    private String headline;//标题

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getIncome_money() {
        return income_money;
    }

    public void setIncome_money(Integer income_money) {
        this.income_money = income_money;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    @Override
    public String toString() {
        return "income{" +
                "id=" + id +
                ", uid=" + uid +
                ", income_money=" + income_money +
                ", pid=" + pid +
                ", time='" + time + '\'' +
                ", headline='" + headline + '\'' +
                '}';
    }
}
