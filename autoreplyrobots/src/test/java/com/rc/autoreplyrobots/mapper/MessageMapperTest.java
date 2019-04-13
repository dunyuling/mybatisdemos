package com.rc.autoreplyrobots.mapper;

import com.rc.autoreplyrobots.BaseTest;
import com.rc.autoreplyrobots.db.DBAccess;
import com.rc.autoreplyrobots.model.Message;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName MessageMapperTest
 * @Description MessageMapper的测试类
 * @Author liux
 * @Date 19-4-12 上午1:18
 * @Version 1.0
 */
public class MessageMapperTest extends BaseTest {

    /*
     * @Author liux
     * @Description 查询消息列表
     * @Date 19-4-12 上午1:38
     * @param 
     * @return void
     **/
    @Test
    public void testQueryMessageList() throws IOException {
        MessageMapper messageMapper = sqlSession.getMapper(MessageMapper.class);

        Message message = new Message("a","c");
        List<Message> messageList = messageMapper.queryMessageList(message);
        messageList.forEach(System.out::println);
    }

    /*
     * @Author liux
     * @Description 删除单条消息
     * @Date 19-4-12 上午1:38
     * @param 
     * @return void
     **/
    @Test
    public void testDeleteOne() {
        MessageMapper messageMapper = sqlSession.getMapper(MessageMapper.class);
        messageMapper.deleteOne(1);
        sqlSession.commit();
    }

    /*
     * @Author liux
     * @Description 删除多条消息
     * @Date 19-4-12 上午1:39
     * @param 
     * @return void
     **/
    @Test
    public void testDeleteBatch() {
        MessageMapper messageMapper = sqlSession.getMapper(MessageMapper.class);
        List<Integer> list = Arrays.asList(2,3,4,5);
        messageMapper.deleteBatch(list);
        sqlSession.commit();
    }
}
