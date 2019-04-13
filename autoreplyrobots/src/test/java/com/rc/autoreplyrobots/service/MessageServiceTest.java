package com.rc.autoreplyrobots.service;

import com.rc.autoreplyrobots.BaseTest;
import com.rc.autoreplyrobots.common.Page;
import com.rc.autoreplyrobots.model.Message;
import org.junit.Test;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * @ClassName MessageServiceTest
 * @Description MessageService测试类
 * @Author liux
 * @Date 19-4-13 下午1:30
 * @Version 1.0
 */
public class MessageServiceTest extends BaseTest {

    @Test
    public void testQueryMessageByJDBC() throws SQLException, ClassNotFoundException {
        MessageService messageService = new MessageService();
        List<Message> messages = messageService.queryMessageByJDBC(null,null);
        messages.forEach(System.out::println);
    }

    @Test
    public void testQueryMessageListByMybatis() throws IOException {
        MessageService messageService = new MessageService();
        List<Message> messages = messageService.queryMessageByMybatis(null,null);
        messages.forEach(System.out::println);
    }

    @Test
    public void testQueryMessageByPage() throws IOException {
        MessageService messageService = new MessageService();

        Page page = new Page();
        page.setCurrentPage(-1);
        List<Message> messages = messageService.queryMessageByPage(null,null, page);
        messages.forEach(System.out::println);
    }
}
