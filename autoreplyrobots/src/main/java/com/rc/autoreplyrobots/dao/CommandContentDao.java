package com.rc.autoreplyrobots.dao;

import com.rc.autoreplyrobots.db.DBAccess;
import com.rc.autoreplyrobots.model.CommandContent;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;

/**
 * @ClassName CommandContentDao
 * @Description 数据库-指令内容处理类
 * @Author liux
 * @Date 19-4-11 下午7:53
 * @Version 1.0
 */
public class CommandContentDao {

    /*
     * @Author liux
     * @Description 删除单条指令的内容
     * @Date 19-4-11 下午7:54
     * @param 
     * @return void
     **/
    public void deleteOne() throws IOException {
        SqlSession sqlSession = DBAccess.getSqlSession();

        sqlSession.commit();
        sqlSession.close();
    }

    /*
     * @Author liux
     * @Description 删除多条指令的内容
     * @Date 19-4-11 下午7:56
     * @param 
     * @return void
     **/
    public void deleteBatch() throws IOException {
        SqlSession sqlSession = DBAccess.getSqlSession();

        sqlSession.commit();
        sqlSession.close();
    }

    /*
     * @Author liux
     * @Description 新增一条指令对应的内容
     * @Date 19-4-11 下午10:48
     * @param 
     * @return void
     **/
    public void insertOne(String content, int command_id) throws IOException {
        CommandContent commandContent = new CommandContent(content,command_id);

        SqlSession sqlSession = DBAccess.getSqlSession();
        sqlSession.insert("com.rc.autoreplyrobots.model.CommandContent.insertOne",commandContent);
        if (commandContent.getContent().contains("2")) {
            throw new IOException("特设异常，测试事务的连贯性");
        }
        sqlSession.commit();
        sqlSession.close();
    }
}
