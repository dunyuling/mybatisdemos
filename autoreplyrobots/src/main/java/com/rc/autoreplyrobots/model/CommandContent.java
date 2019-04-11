package com.rc.autoreplyrobots.model;

/**
 * @ClassName CommandContent
 * @Description 指令对应内容类
 * @Author liux
 * @Date 19-4-11 下午5:13
 * @Version 1.0
 */
public class CommandContent {

    private int id;

    private String content;

    private int commandId;

    public CommandContent() {
    }

    public CommandContent(String content, int commandId) {
        this.content = content;
        this.commandId = commandId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getCommandId() {
        return commandId;
    }

    public void setCommandId(int commandId) {
        this.commandId = commandId;
    }
}