package com.rc.autoreplyrobots.dao;

import com.rc.autoreplyrobots.servlet.CommandDeleteOneServlet;
import org.junit.Test;

import java.io.IOException;

/**
 * @ClassName CommandDaoTest
 * @Description  指令类操作数据库的测试类
 * @Author liux
 * @Date 19-4-11 下午11:03
 * @Version 1.0
 */
public class CommandDaoTest {

    @Test
    public void insert() {
        CommandDao commandDao = new CommandDao();
        try {
            commandDao.insertOne();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
