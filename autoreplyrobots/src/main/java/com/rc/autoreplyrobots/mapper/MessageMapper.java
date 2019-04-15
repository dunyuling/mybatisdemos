package com.rc.autoreplyrobots.mapper;

import com.rc.autoreplyrobots.model.Message;

import java.util.List;
import java.util.Map;

public interface MessageMapper {

    List<Message> queryMessageList(Message message);

    List<Message> queryMessageListByPage(Map<String,Object> map);
    List<Message> queryMessageListByPage2(Map<String,Object> map);//拦截器版本

    int countTotalNumber(Message message);

    void deleteOne(int id);

    void deleteBatch(List<Integer> ids);
}
