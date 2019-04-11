package com.rc.autoreplyrobots.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName TalkInitServlet
 * @Description 对话初始类
 * @Author liux
 * @Date 19-4-11 下午3:16
 * @Version 1.0
 */
public class TalkInitServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
        req.getRequestDispatcher("/WEB-INF/jsp/front/talk.jsp").forward(req, resp);
    }
}
