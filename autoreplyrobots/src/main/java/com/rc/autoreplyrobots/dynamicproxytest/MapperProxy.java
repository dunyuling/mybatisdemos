package com.rc.autoreplyrobots.dynamicproxytest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName MapperProxy
 * @Description 代理具体处理类
 * @Author liux
 * @Date 19-4-12 下午1:36
 * @Version 1.0
 */
public class MapperProxy implements InvocationHandler {
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String stringBuilder = method.getDeclaringClass().getName() +
                "." + method.getName();
        System.out.println(stringBuilder);

        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student(1,"aa",23));
        studentList.add(new Student(1,"bb",23));
        studentList.add(new Student(1,"cc",23));
        return studentList;
    }
}
