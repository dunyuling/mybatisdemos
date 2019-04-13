package com.rc.autoreplyrobots;

/**
 * @ClassName Test
 * @Description TODO
 * @Author liux
 * @Date 19-4-13 上午11:53
 * @Version 1.0
 */
public class Test {

    public static void main(String[] args) {
        char ch = 'a';
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 16; i++,ch++) {
           builder.append("insert into message values(")
                   .append(i+1).append(",")
                   .append("'").append(ch).append("'").append(",")
                   .append("'").append(ch).append(" desc").append("'").append(",")
                   .append("'").append(ch).append(" content").append("'")
                   .append(")").append(";").append("\n");
        }
        System.out.println(builder.toString());
    }
}
