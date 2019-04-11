package com.rc.autoreplyrobots.servlet;

import com.rc.autoreplyrobots.model.Command;
import com.rc.autoreplyrobots.model.Message;
import com.rc.autoreplyrobots.service.CommandService;
import com.rc.autoreplyrobots.service.MessageService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName CommandListServlet
 * @Description 命令列表类
 * @Author liux
 * @Date 19-4-11 下午6:01
 * @Version 1.0
 */
public class CommandListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取参数
        String command = req.getParameter("name");
        String description = req.getParameter("description");
        //传递参数
        req.setAttribute("name", command);
        req.setAttribute("description", description);

        //查询
        List<Command> commands = new ArrayList<>();
        try {
            commands = new CommandService().queryCommands(command, description);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            req.setAttribute("commands", commands);
        }
        //返回页面
        req.getRequestDispatcher("/WEB-INF/jsp/console/command.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
