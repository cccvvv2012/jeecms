package com.common.tool;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.SmartUpload;

public class ServletDownload extends HttpServlet {
	private ServletConfig config;

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String temp_p = request.getParameter("downloadFileName");
		byte[] temp_t = temp_p.getBytes("UTF-8");
		String fileName = new String(temp_t, "UTF-8");
		SmartUpload mySmartUpload = new SmartUpload();
		try {
			// 初始化
			mySmartUpload.initialize(config, request, response);
			// 设置不自动打开
			mySmartUpload.setContentDisposition(null);
			mySmartUpload.downloadFile("/upload/" + fileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	@Override
	final public void init(ServletConfig config) throws ServletException {
		this.config = config;
	}
}
