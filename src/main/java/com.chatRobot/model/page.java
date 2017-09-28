package com.chatRobot.model;

/**
 * Created by V on 2017/9/11.
 * 红包类
 */
public class page {
    private Integer id;//项目id
    private Integer uid;//用户id
    private Integer page_money;//打赏金额
    private Integer page_number;//所有红包个数
    private Integer residue;//剩余红包数
    private String  page_time;//时间
    private String  page_condition;//状态
    private String  view;//能不能观看答案
    private String service;//服务费
    private String headline;//标题

    public String getView() {
        return view;
    }

    public void setView(String view) {
        this.view = view;
    }

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

    public Integer getPage_money() {
        return page_money;
    }

    public void setPage_money(Integer page_money) {
        this.page_money = page_money;
    }

    public Integer getPage_number() {
        return page_number;
    }

    public void setPage_number(Integer page_number) {
        this.page_number = page_number;
    }

    public Integer getResidue() {
        return residue;
    }

    public void setResidue(Integer residue) {
        this.residue = residue;
    }

    public String getPage_time() {
        return page_time;
    }

    public void setPage_time(String page_time) {
        this.page_time = page_time;
    }

    public String getPage_condition() {
        return page_condition;
    }

    public void setPage_condition(String page_condition) {
        this.page_condition = page_condition;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    @Override
    public String toString() {
        return "page{" +
                "id=" + id +
                ", uid=" + uid +
                ", page_money=" + page_money +
                ", page_number=" + page_number +
                ", residue=" + residue +
                ", page_time='" + page_time + '\'' +
                ", page_condition='" + page_condition + '\'' +
                ", view='" + view + '\'' +
                ", service='" + service + '\'' +
                ", headline='" + headline + '\'' +
                '}';
    }
}
