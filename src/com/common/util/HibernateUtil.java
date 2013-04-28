package com.common.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
 

/**
 * 16. * 这是一个工具类, 快速取得session 17. * 18.
 */
public class HibernateUtil {
	static SessionFactory sessionFactory = null;

	static {
		try {

			/*final String path = URLDecoder.decode(Thread.currentThread()
					.getContextClassLoader().getResource("jdbc.properties")
					.getPath(), "UTF-8"); // config.properties保存的真实路径
			// System.out.println(path);
			final Properties properties = new Properties();
			final InputStream fis = new FileInputStream(path); // config.properties
			// 文件对象，里面有数据库的连接信息，
			properties.load(fis);
			fis.close(); // 关流
			final String dbhost = properties.getProperty("127.0.0.1"); // 数据库IP(从jdbc.properties读)
			final String driver = properties.getProperty("jdbc.driver"); // 端口(从config.properties读)
			final String dburl = properties.getProperty("jdbc.url"); // 数据库名(从jdbc.properties读)
			final String dbuser = properties.getProperty("jdbc.username"); // 用户名(从jdbc.properties读)
			final String dbpw = properties.getProperty("jdbc.password"); // 密码(从jdbc.properties读)
			// 这里还需要配置connection.url,dialect,myeclipse.connection.profile,connection.driver_class
			final Properties extraProperties = new Properties();
			extraProperties.setProperty("hibernate.connection.url", dburl);
			extraProperties
					.setProperty("hibernate.connection.username", dbuser);
			extraProperties.setProperty("hibernate.connection.password", dbpw);
			extraProperties.setProperty("dialect",
					"org.hibernate.dialect.MySQLDialect");
			extraProperties
					.setProperty("myeclipse.connection.profile", "mysql");
			extraProperties.setProperty("connection.driver_class",
					"com.mysql.jdbc.Driver");*/
			// final Configuration cfg = new Configuration();
			// //这是读com/login/system/dao/impl/Users.hbm.xml
			final AnnotationConfiguration cfg = new AnnotationConfiguration(); // 这里读com.login.system.bean.Users
			//cfg.addProperties(extraProperties);
			cfg.configure();//("/hibernate.cfg.xml"); // 路径可以改变
			sessionFactory = cfg.buildSessionFactory();
		/*} catch (final UnsupportedEncodingException e) {
			// 不支持字符编码。
			e.printStackTrace();
		} catch (final FileNotFoundException e) {
			// jdbc.properties文件没找到
			e.printStackTrace();
		} catch (final HibernateException e) {
			// cfg.configure("hibernate.cfg.xml");时异常
			e.printStackTrace();*/
		} catch (final Exception e) {
			// 创建SessionFactory 异常
			e.printStackTrace();
		}
	}

	/**
	 * 取得session
	 * 
	 * @return session
	 */
	public static Session getSeesion() {
		return sessionFactory.getCurrentSession();
		// 在这里我不用openSession ，因为openSession每次都会打开一个新的session ,并且要手关掉
		// openSession不能用在DAO层的事务处理，因为可能有多个DAO要在同一个事务处理，这时就需要getCurrentSession
		// getCurrentSession 是不用关闭的，他是在一个线程中创建的上下文中，只有commit提交以后才重新创建
		// getCurrentSession可以界定事务的边界，防止事务与数据库不一致，不用close，事务提交后自动关闭
		// 分布式的事务要JTA管理多个数据库，这时我们就需要做一个单独的事务管理，这也叫XA驱动，要用Jboss,weblogic
		// 事务有两种依赖数据库的方式，一种是connection事务，一种是jta分布式的事务
		// 使用getCurrentSession必须在xml中设置current_session_context_class=Thread
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static void main(String argString[]) {

		sessionFactory = getSessionFactory();
		Session session = getSeesion();
		// UsersDao userDao = new UsersDaoImpl();
		session.beginTransaction();
		/*Users users = new Users();
		users.setPassword("new ");
		users.setUsename("new ");
		session.save(users);
		session.getTransaction().commit();
		session.close();
		Users u1 = new Users();

		try {
			BeanUtils.copyProperties(u1, users);
			System.out.println(u1.getPassword() + "---" + u1.getUsename());
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			System.out.println("IllegalAccessException");
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			System.out.println("InvocationTargetException");
		}
*/
	}
}
