package com.rc.autoreplyrobots.dynamicproxytest;

import java.util.List;

/**
 * @ClassName DynamicProxyTestMain
 * @Description 自定义动态代理类入口
 * @Author liux
 * @Date 19-4-12 下午1:28
 * @Version 1.0
 */
public class DynamicProxyTestMain {

    public static void main(String[] args) {
        SqlSession sqlSession = new SqlSession();
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);

        Student student = new Student(23);
        List<Student> students = studentMapper.queryStudentList(student);
        students.forEach(System.out::println);


    }
}
