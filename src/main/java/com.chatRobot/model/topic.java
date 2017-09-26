package com.chatRobot.model;

import java.util.List;

/**
 * Created by V on 2017/9/11.
 * 题目类
 */
public class topic {
    private Integer id;//题目id
    private String topic_content;//题目内容
    private List<answer> answerList;//答案
    private Integer answer;//正确答案id
    private Integer userSelect;//用户选的id
    private Integer sid;//选题id

    public Integer getAnswer() {
        return answer;
    }

    public void setAnswer(Integer answer) {
        this.answer = answer;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTopic_content() {
        return topic_content;
    }

    public void setTopic_content(String topic_content) {
        this.topic_content = topic_content;
    }

    public List<answer> getAnswerList() {
        return answerList;
    }

    public void setAnswerList(List<answer> answerList) {
        this.answerList = answerList;
    }

    public Integer getUserSelect() {
        return userSelect;
    }

    public void setUserSelect(Integer userSelect) {
        this.userSelect = userSelect;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    @Override
    public String toString() {
        return "topic{" +
                "id=" + id +
                ", topic_content='" + topic_content + '\'' +
                ", answerList=" + answerList +
                ", answer=" + answer +
                ", userSelect=" + userSelect +
                ", sid=" + sid +
                '}';
    }
}
