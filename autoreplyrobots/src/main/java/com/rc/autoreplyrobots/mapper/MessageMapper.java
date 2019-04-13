package com.rc.autoreplyrobots.mapper;

import com.rc.autoreplyrobots.model.Message;

import java.util.List;
import java.util.Map;

public interface MessageMapper {

    List<Message> queryMessageList(Message message);

    List<Message> queryMessageListByPage(Map<String,Object> map);

    int countTotalNumber(Message message);

    void deleteOne(int id);

    void deleteBatch(List<Integer> ids);
}
