package com.chatRobot.model;

/**
 * 答案类
 */
public class answer {
    private int aid;//答案id
    private String content;//内容

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "answer{" +
                "aid=" + aid +
                ", content='" + content + '\'' +
                '}';
    }
}
