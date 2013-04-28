package com.common.util;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class SpringUtils {
	public static SessionFactory GetSessionFactory() {
		Resource resource = new ClassPathResource("/applicationContext.xml");
		BeanFactory factory = new XmlBeanFactory(resource);
		SessionFactory sessionFactory = (SessionFactory) factory
				.getBean("sessionFactory");
		return sessionFactory;

	}

	public static SessionFactory GetSessionFactoryForWeb() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "WebRoot/WEB-INF/applicationContext.xml" });
		BeanFactory factory = new XmlBeanFactory((Resource) context);
		SessionFactory sessionFactory = (SessionFactory) factory
				.getBean("sessionFactory");
		return sessionFactory;
	}

	public static void main(String argString[]) {
		readXmlWebRootForContext(); // 初始华spring
	}

	public static void readXml2() {
		Resource cr = new ClassPathResource("applicationContext.xml");
		BeanFactory bf = new XmlBeanFactory(cr);

	}

	// 读class目录下面的配置文件
	public static BeanFactory readXMlClassPathToBeanFactory() {
		// ApplicationContext
		ClassPathXmlApplicationContext resource = new ClassPathXmlApplicationContext(
				new String[] { "/applicationContext.xml" });
		BeanFactory factory = resource;

		return factory;

	}

	// 读webRoot下面的配置文件
	public static ApplicationContext readXmlWebRootForContext() {
		ApplicationContext context = new FileSystemXmlApplicationContext(
				new String[] { "WebRoot/WEB-INF/applicationContext.xml" });
		return context;
	}

}
