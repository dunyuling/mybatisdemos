package com.rc.autoreplyrobots.dao;

import com.rc.autoreplyrobots.common.Constant;
import com.rc.autoreplyrobots.db.DBAccess;
import com.rc.autoreplyrobots.model.Message;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName MessageDao
 * @Description 处理消息的数据库类
 * @Author liux
 * @Date 19-4-10 下午4:36
 * @Version 1.0
 */
public class MessageDao {

    /*
     * @Author liux
     * @Description JDBC方式查询消息列表，具体执行
     * @Date 19-4-10 下午4:39
     * @param command
     * @param description
     * @return java.util.List<com.rc.autoreplyrobots.model.Message>
     **/
    public List<Message> queryMessageListByJDBC(String command, String description) throws ClassNotFoundException, SQLException {

        Class.forName(Constant.driver);
        Connection connection = DriverManager.getConnection(Constant.url, Constant.user, Constant.password);

        //TODO 不要使用select * ，影响性能
        StringBuilder sqlBuilder = new StringBuilder("select id, command, description, content from message where 1 = 1");
        List<String> paramList = new ArrayList<>();
        if (null != command && !"".equals(command.trim())) {
            sqlBuilder.append(" and command = ?");
            paramList.add(command);
        }
        //TODO 注意like的设置方法
        if (null != description && !"".equals(description.trim())) {
            sqlBuilder.append(" and description like '%' ? '%'");
            paramList.add(description);
        }


        PreparedStatement preparedStatement = connection.prepareStatement(sqlBuilder.toString());
        for (int i = 0; i < paramList.size(); i++) {
            preparedStatement.setString(i + 1, paramList.get(i));
        }
        ResultSet resultSet = preparedStatement.executeQuery();
        System.out.println("sql: " + preparedStatement.toString());

        List<Message> messages = new ArrayList<>();
        while (resultSet.next()) {
            Message message = new Message();
            message.setId(resultSet.getInt("id"));
            message.setCommand(resultSet.getString("command"));
            message.setDescription(resultSet.getString("description"));
            message.setContent(resultSet.getString("content"));

            messages.add(message);
        }
        return messages;
    }

    /*
     * @Author liux
     * @Description Mybatis方式查询消息列表，具体执行
     * @Date 19-4-10 下午5:23
     * @param
     * @return java.util.List<com.rc.autoreplyrobots.model.Message>
     **/
    public List<Message> queryMessageListByMybatis(String command, String description) throws IOException {
        SqlSession sqlSession = DBAccess.getSqlSession();

        Message message = new Message();
        message.setCommand(command);
        message.setDescription(description);

        List<Message> messages = sqlSession.selectList("com.rc.autoreplyrobots.mapper.MessageMapper.queryMessageList",message);
        sqlSession.close();
        return messages;
    }
    
    /*
     * @Author liux
     * @Description 删除一条信息
     * @Date 19-4-11 上午9:42
     * @param 
     * @return void
     **/
    public void deleteOne(int id) throws IOException {
        SqlSession sqlSession = DBAccess.getSqlSession();
        sqlSession.delete("com.rc.autoreplyrobots.mapper.MessageMapper.deleteOne",id);
        //必须提交事务
        sqlSession.commit();
        sqlSession.close();
    }

    /*
     * @Author liux
     * @Description 删除多条消息
     * @Date 19-4-11 下午1:20
     * @param idList
     * @return void
     **/
    public void deleteBatch(List<Integer> idList) throws IOException {
        SqlSession sqlSession = DBAccess.getSqlSession();
        sqlSession.delete("com.rc.autoreplyrobots.mapper.MessageMapper.deleteBatch",idList);
        //必须提交事务
        sqlSession.commit();
        sqlSession.close();
    }
    

}