package com.rc.autoreplyrobots.dynamicproxytest;

import java.lang.reflect.Proxy;

/**
 * @ClassName SqlSession
 * @Description 自定义SqlSession
 * @Author liux
 * @Date 19-4-12 下午1:33
 * @Version 1.0
 */
public class SqlSession  {

    public <T> T getMapper(Class<?> clazz) {
        return (T)Proxy.newProxyInstance(clazz.getClassLoader(),new Class[]{clazz}, new MapperProxy());
    }
}
