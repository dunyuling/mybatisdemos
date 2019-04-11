package com.rc.autoreplyrobots.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Command
 * @Description 指令类
 * @Author liux
 * @Date 19-4-11 下午5:12
 * @Version 1.0
 */
public class Command {

    private int id;

    private String name;

    private String description;

    private List<CommandContent> commandContents = new ArrayList<>();


    public Command() {
    }

    public Command(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<CommandContent> getCommandContents() {
        return commandContents;
    }

    public void setCommandContents(List<CommandContent> commandContents) {
        this.commandContents = commandContents;
    }
}
