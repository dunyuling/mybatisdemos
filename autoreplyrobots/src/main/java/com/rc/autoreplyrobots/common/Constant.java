package com.rc.autoreplyrobots.common;

/**
 * @ClassName Constant
 * @Description 常量类
 * @Author liux
 * @Date 19-4-10 下午4:38
 * @Version 1.0
 */
public interface Constant {
    public static final String driver = "com.mysql.cj.jdbc.Driver";
    public static final String url = "jdbc:mysql:///mybatis_autoreplyrobots?useUnicode=true&characterEncoding=utf-8&serverTimezone=Asia/Shanghai";
    public static final String user = "root";
    public static final String password = "mysql";

    //没有查询到相应命令时的回复内容
    public static final String NO_MATCH_CONTENT = "我听不懂你在说什么";
    //帮助指令
    public static final String HELP_COMMAND = "帮助";

}