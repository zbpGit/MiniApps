package com.chatRobot.model;

/**
 * Created by V on 2017/9/21.
 * 默契度
 */
public class privity {
    private Integer id;//默契度id
    private Integer pid;//项目id
    private String  percentum;//默契度
    private Integer correct;//答对题数
    private user user;//答题用户
    private Integer money;//收入金额
    private String time;//时间


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getPercentum() {
        return percentum;
    }

    public void setPercentum(String percentum) {
        this.percentum = percentum;
    }

    public Integer getCorrect() {
        return correct;
    }

    public void setCorrect(Integer correct) {
        this.correct = correct;
    }

    public com.chatRobot.model.user getUser() {
        return user;
    }

    public void setUser(com.chatRobot.model.user user) {
        this.user = user;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "privity{" +
                "id=" + id +
                ", pid=" + pid +
                ", percentum='" + percentum + '\'' +
                ", correct=" + correct +
                ", user=" + user +
                ", money=" + money +
                ", time='" + time + '\'' +
                '}';
    }
}
