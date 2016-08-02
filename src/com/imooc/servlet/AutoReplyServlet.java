package com.imooc.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.imooc.service.QueryService;

@SuppressWarnings("serial")
public class AutoReplyServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// 设置页面编码
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html");
		// 接收页面的值
		String command = req.getParameter("content");
		QueryService queryService = new QueryService();
		// 查询指令的内容
		String content = queryService.queryByCommand(command);
		// 返回信息
		PrintWriter out = resp.getWriter();
		out.write(content);
		out.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//resp.setCharacterEncoding("UTF-8");
		this.doGet(req, resp);
	}

	
}
