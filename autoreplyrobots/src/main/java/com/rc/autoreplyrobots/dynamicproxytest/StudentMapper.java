package com.rc.autoreplyrobots.dynamicproxytest;

import java.util.List;

/**
 * @ClassName StudentMapper
 * @Description 学生类映射接口--根配置文件信息关联,此处只做模拟，无相应XML
 * @Author liux
 * @Date 19-4-12 下午1:30
 * @Version 1.0
 */
public interface StudentMapper {

    List<Student> queryStudentList(Student student);

}
