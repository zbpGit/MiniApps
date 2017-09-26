package com.chatRobot.model;

/**
 * Created by V on 2017/9/11.
 * 答题类
 */
public class selectTopic {
    private Integer id;//选题id
    private Integer pid;//项目id
    private Integer tid;//题目id
    private Integer uid;//用户id
    private Integer answer;//答案id

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

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getAnswer() {
        return answer;
    }

    public void setAnswer(Integer answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "selectTopic{" +
                "id=" + id +
                ", pid=" + pid +
                ", tid=" + tid +
                ", uid=" + uid +
                ", answer=" + answer +
                '}';
    }
}
