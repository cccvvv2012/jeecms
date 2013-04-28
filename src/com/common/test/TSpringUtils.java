/**
 * 
 */
package com.common.test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;

import com.common.util.SpringUtils;

/**
 * @author Administrator
 * 
 */
public class TSpringUtils {

	protected final Log log = LogFactory.getLog(getClass());

	private static final Long defaultLong = null;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link com.utils.system.SpringUtils#readXmlWebRoot()}.
	 */
	@Test
	public void testReadXmlWebRoot() {
		try {
			// spirng可以用在日志，事务，效率检查，权限，事务等上面，申明式事务
			// 用annotation实现动态代码要在xml中加 <aop:aspectj-autoproxy/> 然后在切面上加@aspect
			// @component 然后在
			// 切面的方法上加上@before,@pointcut等切面事务，但是我们一般不用这种方法，我们用xml方式来实现因为方便快捷
			// joinpint就是线与切面的点，pointcut就是切面(public * xyz..*.*(..))
			// aspect 是切面上的业务 @advice就是切面上的建议，比加@before @after等等
			// @target就是目标就是切入到的具体对象
			// weave就是织入，向XX类中织入方法业务逻辑
			// spring的核心概念就是IOC/DI APO 短连接，并发，负载均衡
			// 事务我们要建立在serivce层，因为dao层只是单个实体，有时我们需要多信实体进行事务处理，这时在service才能同步提交回滚

			// ApplicationContext context =
			// SpringUtils.readXmlWebRootForContext();
			BeanFactory factory = SpringUtils.readXMlClassPathToBeanFactory();
			/*Usertab users = new Usertab();
			users.setUserId(10);
			users.setPassword("zhanglin");
			users.setLoginName("zhanglin");
			Object obj = factory.getBean("userTabDao"); // 得到的是一个UsersDaoImpl对象
			if (obj instanceof UserTabDao) {
				// 在开发过程中能不能继承就不用继承，因为他们的偶合性太强，最好有组合的方式
				// 在spring开发过程中所有的对象都 是单例的，我们用到的日志需要用interceptor来处理
				// proxy是产生代理的，invocationhanle来处理
				// 但该类必须实现接口，当然hibernate可以动态产生代码，他是直接修改二制码
				// 面向切面的编程实际上就是把一条线切断，然后在其加上自己实现的业务方法
				UserTabDao usersDao = (UserTabDao) obj; // 需要通过一个接口来实现
				//usersDao.insert(users); // 很神奇的在这里可以用接口来操作数据。
				System.out.println("保存数据成功");
			} else {
				log.warn("Error type :-->" + obj + " :: " + obj.getClass()
						+ " :: ");
			}
*/
			if (log.isDebugEnabled()) {
				log.debug("Entering 'add' method");
			}
			// context.getBean("usersBizImpl");

			// userDao.save(users);
		} catch (Exception e) {
			log.error("调试错误但还是要继续通过：" + e);

		}

	}

}
