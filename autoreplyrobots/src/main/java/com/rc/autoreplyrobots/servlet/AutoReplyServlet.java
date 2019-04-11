package com.rc.autoreplyrobots.servlet;

import com.rc.autoreplyrobots.common.Constant;
import com.rc.autoreplyrobots.service.CommandService;
import com.rc.autoreplyrobots.service.MessageService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

/**
 * @ClassName AutoReplyServlet
 * @Description 自动回复控制类
 * @Author liux
 * @Date 19-4-11 下午4:12
 * @Version 1.0
 */
public class AutoReplyServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        String content = Constant.NO_MATCH_CONTENT;
        String name = req.getParameter("command");
        try {
//            content = new MessageService().queryByCommand(command);
            content = new CommandService().queryByName(name);
        } catch (IOException e) {
            e.printStackTrace();
        }

        PrintWriter printWriter = resp.getWriter();
        printWriter.write(content);
        printWriter.flush();
        printWriter.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
