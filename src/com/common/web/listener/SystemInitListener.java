package com.common.web.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * 系统初始化监听器
 * 
 * @author zhang lin
 *  
 */
public class SystemInitListener implements ServletContextListener {

	// @Override
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("Desotroyed Listener System Init");
	}

	// @Override
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// ServletContext servletContext = sce.getServletContext();
		// BaseFieldsService baseFieldsService =
		// SpringContextHolder.getBean("baseFieldsServiceImpl");
		// Criteria criteria = new Criteria();
		// criteria.setOrderByClause(" field desc ,sort asc ");
		// criteria.put("enabled", "1");
		// servletContext.setAttribute("fields",
		// baseFieldsService.selectAllByExample(criteria));
		System.out.println("Start Listener System Init");
	}

}
