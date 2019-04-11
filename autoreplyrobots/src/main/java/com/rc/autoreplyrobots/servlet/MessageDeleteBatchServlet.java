package com.rc.autoreplyrobots.servlet;

import com.alibaba.fastjson.JSON;
import com.rc.autoreplyrobots.common.StatusCode;
import com.rc.autoreplyrobots.response.BaseResponse;
import com.rc.autoreplyrobots.service.MessageService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

/**
 * @ClassName MessageDeleteBatchServlet
 * @Description 删除多条消息控制层
 * @Author liux
 * @Date 19-4-11 上午9:47
 * @Version 1.0
 */
public class MessageDeleteBatchServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    /*
     * @Author liux
     * @Description 异步删除
     * @Date 19-4-11 下午12:06
     * @param req
     * @param resp
     * @return void
     **/
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BaseResponse baseResponse = new BaseResponse(StatusCode.Success);

        //获取参数
        String ids = req.getParameter("ids");
        //查询
        try {
            new MessageService().deleteBatch(ids);
//            throw new IOException();
        } catch (IOException e) {
            e.printStackTrace();
            baseResponse = new BaseResponse(StatusCode.Failure);
        } finally {
            Writer out = resp.getWriter();
            out.write(JSON.toJSONString(baseResponse));
            out.flush();
            out.close();
        }
    }
}