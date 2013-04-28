package com.common.tool;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.struts2.dispatcher.Dispatcher;
import org.apache.struts2.dispatcher.ng.InitOperations;
import org.apache.struts2.dispatcher.ng.filter.FilterHostConfig;

public class Struts2 implements Filter {
	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// String notFilters = SystemCfg.getValueByKey(SystemCfg.NOFILTER);//
		// paramMap.get("notFilter");
		// noPermissionDefaultUrl =
		// SystemCfg.getValueByKey(SystemCfg.NOPERMISSIONDEFAULTURL);//
		// paramMap.get("noPermissionDefaultUrl");
		// urlAfterLogin = SystemCfg.getValueByKey(SystemCfg.URLAFTERLOGIN);//
		// paramMap.get("hasPermissionDefaultUrl");
		// loginURL = SystemCfg.getValueByKey(SystemCfg.LOGINURL);//
		// paramMap.get("noLoginDefaultUrl");
		// notFilter = notFilters.split(",");
		// uriPermission = (IURIPermission)
		// IntegrationFactory.INSTANCE.getImp("tor.integration.permissionURIFilter");
		InitOperations init = new InitOperations();
		try {
			FilterHostConfig config = new FilterHostConfig(filterConfig);
			init.initLogging(config);
			/**
			 * 定制struts.xml目录
			 */
			String path = filterConfig.getServletContext().getRealPath("");
			Map<String, String> params = new HashMap<String, String>();
			for (Iterator<String> e = config.getInitParameterNames(); e
					.hasNext();) {
				String name = e.next();
				String value = filterConfig.getInitParameter(name);
				if ("config".equals(name)) {
					String[] values = value.split(",");
					StringBuilder builder = new StringBuilder(1024);
					for (String v : values) {
						File file = new File(v);
						if (file.getParent() != null) {
							builder.append(path + v + ",");
						} else {
							builder.append(v + ",");
						}
					}
					if (builder.length() > 0) {
						builder.setLength(builder.length() - 1);
					}
					value = builder.toString();
				}
				params.put(name, value);
			}
			Dispatcher dispatcher = new Dispatcher(filterConfig
					.getServletContext(), params);
			dispatcher.init();
			init.initStaticContentLoader(config, dispatcher);

			/*
			 * prepare = new PrepareOperations(filterConfig.getServletContext(),
			 * dispatcher); execute = new
			 * ExecuteOperations(filterConfig.getServletContext(), dispatcher);
			 * this.excludedPatterns =
			 * init.buildExcludedPatternsList(dispatcher);
			 * 
			 * postInit(dispatcher, filterConfig);
			 */
		} finally {
			init.cleanup();
		}
	}
}
