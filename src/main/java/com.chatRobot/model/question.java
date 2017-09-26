package com.chatRobot.model;

/**
 * Created by V on 2017/9/26.
 * 问题类（用来传正确跟错误答案）
 */
public class question {
    private Integer topicId;
    private String topic;
    private Integer answerId;
    private String answer;
    private Integer errorId;
    private String error;

    public Integer getTopicId() {
        return topicId;
    }

    public void setTopicId(Integer topicId) {
        this.topicId = topicId;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public Integer getAnswerId() {
        return answerId;
    }

    public void setAnswerId(Integer answerId) {
        this.answerId = answerId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Integer getErrorId() {
        return errorId;
    }

    public void setErrorId(Integer errorId) {
        this.errorId = errorId;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return "question{" +
                "topicId=" + topicId +
                ", topic='" + topic + '\'' +
                ", answerId=" + answerId +
                ", answer='" + answer + '\'' +
                ", errorId=" + errorId +
                ", error='" + error + '\'' +
                '}';
    }
}
