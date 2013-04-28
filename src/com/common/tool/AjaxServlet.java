package com.common.tool;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import common.Logger;

public class AjaxServlet extends HttpServlet {

	// Logger log = Logger.getLogger(this.getClass());

	// Clean up resources
	@Override
	public void destroy() {
	}

	// Process the HTTP Delete request
	@Override
	public void doDelete(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/xml; charset=GBK");
		PrintWriter out = response.getWriter();
		out.print(2);
	}

	// Process the HTTP Post request
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	// Process the HTTP Put request
	@Override
	public void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
}
