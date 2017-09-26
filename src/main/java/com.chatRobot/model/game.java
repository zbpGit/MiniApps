package com.chatRobot.model;

/**
 * Created by V on 2017/9/11.
 * 玩法类
 */
public class game {
    private Integer id;//玩法id
    private String rule_headline;//玩法标题
    private String content;//玩法内容

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRule_headline() {
        return rule_headline;
    }

    public void setRule_headline(String rule_headline) {
        this.rule_headline = rule_headline;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "game{" +
                "id=" + id +
                ", rule_headline='" + rule_headline + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
