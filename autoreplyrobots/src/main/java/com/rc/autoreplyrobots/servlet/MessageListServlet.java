package com.rc.autoreplyrobots.servlet;

import com.rc.autoreplyrobots.common.Page;
import com.rc.autoreplyrobots.model.Message;
import com.rc.autoreplyrobots.service.MessageService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @ClassName MessageListServlet
 * @Description 列表展示控制层，servlet方式
 * @Author liux
 * @Date 19-4-10 上午11:18
 * @Version 1.0
 */
public class MessageListServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取参数
        String command = req.getParameter("command");
        String description = req.getParameter("description");
        String currentPage = req.getParameter("currentPage");


        //创建分页对象
        Page page = new Page();
        Pattern pattern = Pattern.compile("[0-9]{1,9}");
        if (currentPage == null || !pattern.matcher(currentPage).matches()) {
            page.setCurrentPage(1);
        } else {
            page.setCurrentPage(Integer.valueOf(currentPage));
        }


        //查询
        List<Message> messages = new ArrayList<>();
        try {
            messages = new MessageService().queryMessageByPage2(command, description, page);
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //传递参数
            req.setAttribute("command", command);
            req.setAttribute("description", description);
            req.setAttribute("page", page);
            req.setAttribute("messages", messages);
        }
        //返回页面
        req.getRequestDispatcher("/WEB-INF/jsp/console/message.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}