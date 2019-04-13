package com.rc.autoreplyrobots.model;

/**
 * @ClassName Message
 * @Description 消息类
 * @Author liux
 * @Date 19-4-10 下午12:18
 * @Version 1.0
 */
public class Message {

    private int id;

    private String command;//指令

    private String description;//描述

    private String content;//内容

    public Message() {
    }

    public Message(String command, String description) {
        this.command = command;
        this.description = description;
    }

    public Message(int id, String command, String description, String content) {
        this.id = id;
        this.command = command;
        this.description = description;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", command='" + command + '\'' +
                ", description='" + description + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
