package com.rc.autoreplyrobots.db;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

/**
 * @ClassName DBAccess
 * @Description 访问数据库类
 * @Author liux
 * @Date 19-4-10 下午5:15
 * @Version 1.0
 */
public class DBAccess {

    /*
     * @Author liux
     * @Description 获取SqlSession
     * @Date 19-4-10 下午5:21
     * @param null
     * @return
     **/
    public static SqlSession getSqlSession() throws IOException {
        Reader reader =  Resources.getResourceAsReader("Configuration.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        return sqlSessionFactory.openSession();
    }
}
