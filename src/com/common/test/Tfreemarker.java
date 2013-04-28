package com.common.test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.junit.Test;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;

public class Tfreemarker {
	@Test
	public void Test() {
		try {
			// 模板路径
			String dir = Tfreemarker.class.getResource("/").getPath().split(
					"WEB-INF")[0]
					+ "WEB-INF/classes/template/strong";
			System.out.println(dir);
			Configuration cfg = new Configuration();

			Properties p = new Properties();
			p.load(Thread.currentThread().getContextClassLoader()
					.getResourceAsStream("freemarker.properties"));
			cfg.setSettings(p);
			System.out.println("==" + p.getProperty("default_encoding"));

			System.out.println("++" + cfg.getSetting(""));
			// 加载freemarker模板文件

			cfg.setDirectoryForTemplateLoading(new File(dir));

			// 设置对象包装器
			cfg.setObjectWrapper(new DefaultObjectWrapper());

			// 设计异常处理器
			cfg
					.setTemplateExceptionHandler(TemplateExceptionHandler.IGNORE_HANDLER);

			// 定义并设置数据
			Map<String, String> data = new HashMap<String, String>();
			data.put("persion", "小吴");

			// 获取指定模板文件
			Template template = cfg.getTemplate("test.ftl");

			// 定义输入文件，默认生成在工程根目录
			Writer out = new OutputStreamWriter(new FileOutputStream(
					"WebRoot/freemarker/test.html"), "UTF-8");

			// 最后开始生成
			template.process(data, out);

			System.out.println("生成freemarker文件成功");

			/* 在整个应用的生命周期中，这个工作你可以执行多次 */
			/* 获取或创建模板 */
			// Template temp = cfg.getTemplate("test.xml");
			/* 创建数据模型 */
			// Map root = new HashMap();
			// root.put("user", "Big Joe");
			/* 将模板和数据模型合并 */
			// Writer out = new BufferedWriter(new
			// OutputStreamWriter(System.out));
			// temp.process(root, out);
			// out.flush();

		} catch (Exception e) {
		}

	}
}