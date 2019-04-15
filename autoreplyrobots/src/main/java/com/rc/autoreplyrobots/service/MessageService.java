package com.rc.autoreplyrobots.service;

import com.rc.autoreplyrobots.common.Constant;
import com.rc.autoreplyrobots.common.Page;
import com.rc.autoreplyrobots.dao.MessageDao;
import com.rc.autoreplyrobots.model.Message;
import sun.util.resources.cldr.agq.CurrencyNames_agq;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName MessageService
 * @Description 消息业务类
 * @Author liux
 * @Date 19-4-10 下午4:36
 * @Version 1.0
 */
public class MessageService {

    /*
     * @Author liux
     * @Description  JDBC方式查询消息列表,查询前的逻辑处理
     * @Date 19-4-10 下午4:44
     * @param command
     * @param description
     * @return java.util.List<com.rc.autoreplyrobots.model.Message>
     **/
    public List<Message> queryMessageByJDBC(String command, String description) throws SQLException, ClassNotFoundException {
        return new MessageDao().queryMessageListByJDBC(command, description);
    }

    /*
     * @Author liux
     * @Description Mybatis方式查询消息列表,处理查询前的逻辑
     * @Date 19-4-10 下午6:12
     * @param command
     * @param description
     * @return java.util.List<com.rc.autoreplyrobots.model.Message>
     **/
    public List<Message> queryMessageByMybatis(String command, String description) throws IOException {
        return new MessageDao().queryMessageListByMybatis(new Message(command, description));
    }

    /*
     * @Author liux
     * @Description mybatis方式分页查询消息记录列表,处理查询前的逻辑
     * @Date 19-4-13 下午1:09
     * @param null
     * @return
     **/
    public List<Message> queryMessageByPage(String command, String description, Page page) throws IOException {
        Message message = new Message(command, description);

        MessageDao messageDao = new MessageDao();
        page = messageDao.configPage(message,page);

        Map<String, Object> map = new HashMap<>();
        map.put("message", message);
        map.put("page", page);
        return messageDao.queryMessageListByPage(map);
    }


    /*
     * @Author liux
     * @Description Mybatis方式查询消息列表,处理查询前的逻辑--拦截器版
     * @Date 19-4-15 下午2:15
     * @param command
     * @param description
     * @param page
     * @return java.util.List<com.rc.autoreplyrobots.model.Message>
     **/
    public List<Message> queryMessageByPage2(String command, String description, Page page) throws IOException {
        Message message = new Message(command, description);
        Map<String, Object> map = new HashMap<>();
        map.put("message", message);
        map.put("page", page);
        return new MessageDao().queryMessageListByPage2(map);
    }

    /*
     * @Author liux
     * @Description Mybatis方式删除一条消息,删除前的逻辑处理
     * @Date 19-4-11 上午9:44
     * @param
     * @return void
     **/
    public void deleteOne(String id) throws IOException {
        if (null != id && !"".equals(id)) {
            new MessageDao().deleteOne(Integer.parseInt(id));
        }
    }

    /*
     * @Author liux
     * @Description Mybatis方式删除多条消息,删除前的逻辑处理
     * @Date 19-4-11 下午1:18
     * @param ids
     * @return void
     **/
    public void deleteBatch(String ids) throws IOException {
        if (null != ids && !"".equals(ids)) {
            List<Integer> idList = new ArrayList<>();
            for (String idStr : ids.split(",")) {
                idList.add(Integer.parseInt(idStr));
            }
            new MessageDao().deleteBatch(idList);
        }
    }

    /*
     * @Author liux
     * @Description 通过指令查询自动回复的内容
     * @Date 19-4-11 下午4:22
     * @param null
     * @return
     **/
    public String queryByCommand(String command) throws IOException {
        MessageDao messageDao = new MessageDao();
        if (Constant.HELP_COMMAND.equals(command)) {
            List<Message> messages = messageDao.queryMessageListByMybatis(new Message());
            StringBuilder builder = new StringBuilder();

            for (int i = 0; i < messages.size(); i++) {
                if (i != 0) {
                    builder.append("<br/>");
                }
                builder.append("回复[").append(messages.get(i).getCommand())
                        .append("]可以查看").append(messages.get(i).getDescription());
            }
            return builder.toString();
        }

        List<Message> messages = messageDao.queryMessageListByMybatis(new Message(command, null));
        if (messages.size() > 0) {
            return messages.get(0).getContent();
        }
        return Constant.NO_MATCH_CONTENT;
    }
}