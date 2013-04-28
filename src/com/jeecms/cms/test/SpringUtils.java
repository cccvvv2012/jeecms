package com.jeecms.cms.test;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class SpringUtils {
	public static void main(String argString[]) {
		readXmlWebRootForContext(); // 初始华spring
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
	public static SessionFactory readXmlWebRootForContext() {
		BeanFactory beanFactory = new FileSystemXmlApplicationContext(
				new String[] { "WebRoot/WEB-INF/config/applicationcontext.xml" });

		SessionFactory sessionFactory = (SessionFactory) beanFactory.getBean("sessionFactory");
		
		return sessionFactory;
	}

	public static void readXml2() {
		Resource cr = new ClassPathResource("applicationContext.xml");
		BeanFactory bf = new XmlBeanFactory(cr);

	}

	public static SessionFactory GetSessionFactoryForWeb() {
		// ClassPathXmlApplicationContext[只能读放在web-info/classes目录下的配置文件]
		ApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { " /applicationContext.xml" });
		BeanFactory factory = new XmlBeanFactory((Resource) context);
		SessionFactory sessionFactory = (SessionFactory) factory
				.getBean("sessionFactory");
		return sessionFactory;
	}

	public static SessionFactory GetSessionFactory() {
		Resource resource = new ClassPathResource("/applicationcontext.xml");
		BeanFactory factory = new XmlBeanFactory(resource);
		SessionFactory sessionFactory = (SessionFactory) factory
				.getBean("sessionFactory");
		return sessionFactory;

	}

}
