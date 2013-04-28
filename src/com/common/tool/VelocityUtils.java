package com.common.tool;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.util.Properties;
import java.util.Vector;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.context.Context;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.servlet.VelocityServlet;

@SuppressWarnings("deprecation")
public class VelocityUtils extends VelocityServlet {

	// 设置返回视图为text/html编码为gbk

	@Override
	public Template handleRequest(HttpServletRequest request,
			HttpServletResponse response, Context ctx) {

		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e1) {

			e1.printStackTrace();
		}

		Template template = null;
		Template template2 = null;

		try {
			/**
			 * 主要代码
			 */
			Velocity.init();

			// VelocityContext context = new VelocityContext();

			String p1 = "JAVA";
			String p2 = "C++";
			String p3 = "Ruby";
			String p4 = "D";
			Vector<String> personList = new Vector<String>();
			personList.addElement(p1);
			personList.addElement(p2);
			personList.addElement(p3);
			personList.addElement(p4);

			/**
			 * 将模板数据name, list 放置到上下文环境 context 中去
			 */
			ctx.put("name2", " 这里是在后台赋值! ");
			ctx.put("name3", " 小齐! ");
			ctx.put("theList", personList);

			template = Velocity.getTemplate("/index.vm");

		} catch (Exception e) {
			e.printStackTrace();
		}

		// 以下一段代码主要是获得模板的HTML内容 在后台显示
		try {

			template2 = Velocity.getTemplate("/index.vm");

			VelocityContext context = new VelocityContext();

			context.put("name2", "这里在后台第二次赋值！");

			StringWriter writer = new StringWriter();

			template2.merge(context, writer);

			// System.out.println(writer.toString());

		} catch (Exception e) {
			e.printStackTrace();
		}

		return template;
	}

	@Override
	protected Properties loadConfiguration(ServletConfig config)
			throws IOException, FileNotFoundException {

		VelocityEngine engine = new VelocityEngine();

		Properties p = new Properties();

		String path = config.getServletContext().getRealPath("/");

		if (path == null) {
			path = "/";
		}

		p.setProperty(RuntimeConstants.FILE_RESOURCE_LOADER_PATH, path);

		p.setProperty("runtime.log", path + "velocity.log");

		try {
			engine.init(p); // 载入模板的路径path ,即上下文路径
		} catch (Exception e) {
			e.printStackTrace();
		}

		return p;
	}

	@Override
	protected void setContentType(HttpServletRequest request,
			HttpServletResponse response) {

		response.setContentType("text/html;charset=utf-8");

	}
}
