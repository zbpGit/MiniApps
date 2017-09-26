package com.chatRobot.model;

/**
 * Created by V on 2017/9/21.
 * 答题类
 */
public class response {
    private Integer id;//答题id
    private Integer uid;//答题用户id
    private Integer sid;//选题表id
    private Integer response_answer;//选择的答案id;

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

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Integer getResponse_answer() {
        return response_answer;
    }

    public void setResponse_answer(Integer response_answer) {
        this.response_answer = response_answer;
    }

    @Override
    public String toString() {
        return "response{" +
                "id=" + id +
                ", uid=" + uid +
                ", sid=" + sid +
                ", response_answer=" + response_answer +
                '}';
    }
}
