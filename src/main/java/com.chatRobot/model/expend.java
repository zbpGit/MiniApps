package com.chatRobot.model;

/**
 * Created by V on 2017/9/20.
 * 支出类
 */
public class expend {
    private Integer id;//支出id
    private Integer uid;//用户id
    private Integer pid;//项目id
    private String  indent;//订单号
    private String  page_money;//支出了多少钱
    private String  expend_conditon;//状态

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

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getIndent() {
        return indent;
    }

    public void setIndent(String indent) {
        this.indent = indent;
    }

    public String getPage_money() {
        return page_money;
    }

    public void setPage_money(String page_money) {
        this.page_money = page_money;
    }

    public String getExpend_conditon() {
        return expend_conditon;
    }

    public void setExpend_conditon(String expend_conditon) {
        this.expend_conditon = expend_conditon;
    }

    @Override
    public String toString() {
        return "expend{" +
                "id=" + id +
                ", uid=" + uid +
                ", pid=" + pid +
                ", indent='" + indent + '\'' +
                ", page_money='" + page_money + '\'' +
                ", expend_conditon='" + expend_conditon + '\'' +
                '}';
    }
}
