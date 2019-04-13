package com.rc.autoreplyrobots.mapper;

import com.rc.autoreplyrobots.model.Message;

import java.util.List;

public interface MessageMapper {

    List<Message> queryMessageList(Message message);

    void deleteOne(int id);

    void deleteBatch(List<Integer> ids);
}
