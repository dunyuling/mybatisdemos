package com.rc.autoreplyrobots;

import com.alibaba.fastjson.JSON;
import com.rc.autoreplyrobots.common.StatusCode;
import com.rc.autoreplyrobots.db.DBAccess;
import com.rc.autoreplyrobots.response.BaseResponse;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.io.IOException;

/**
 * @ClassName BaseTest
 * @Description TODO
 * @Author liux
 * @Date 19-4-10 下午3:37
 * @Version 1.0
 */
public class BaseTest {

    @Test
    public void test() {
        String a = null;
        /*if (!a.equals("")) {
            System.out.println("----");
        } else {
            System.out.println("+++++");
        }*/

        /*if (!"".equals(a)) {
            System.out.println("----");
        } else {
            System.out.println("+++++");
        }*/

        /*if (null != a) {
            System.out.println("----");
        } else {
            System.out.println("++++");
        }*/

        /*try {
            SqlSession sqlSession = DBAccess.getSqlSession();
            System.out.println(sqlSession == null);
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        BaseResponse baseResponse = new BaseResponse(StatusCode.Success);
        String jsonStr = JSON.toJSONString(baseResponse);
        System.out.println(jsonStr);
        baseResponse = JSON.parseObject(jsonStr,BaseResponse.class);
        System.out.println(baseResponse);
    }
}
