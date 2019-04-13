package com.rc.autoreplyrobots.dynamicproxytest;

/**
 * @ClassName Student
 * @Description 学生类,用作动态代理的类型测试
 * @Author liux
 * @Date 19-4-12 下午1:29
 * @Version 1.0
 */
public class Student {

    private int id;

    private String name;

    private int age;

    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Student(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
