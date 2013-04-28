package com.jeecms.cms.test;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import com.jeecms.cms.entity.main.CmsLog;
/*
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)*/
public class test {
	 @Test
	public void testInsertOrUpdate() {

	 	SessionFactory sessionFactory = SpringUtils.readXmlWebRootForContext();
		Session session = sessionFactory.openSession();

		CmsLog cmslog = new CmsLog();

		cmslog.setCategory(10);
		cmslog.setIp("192.167.1");
		Date d = new Date();
		cmslog.setTime(d);

		Transaction tx = session.beginTransaction();
		session.save(cmslog);
		session.flush();// 清空缓存后customer对象处于游离状态
		tx.commit();

		System.out.println("保存对象数据成功");
		int recordCount = session.createQuery(
				"from  com.jeecms.cms.entity.main.CmsLog ").list().size();

		System.out.println("查询到数据jc_log表数据：" + recordCount + "条");
		session.close();
 
	}
	/*@Test
	public void testClassPathApp()
	{
		System.out.println("------------");
		CmsLogMng  cmsLogMng = new CmsLogMngImpl();
		System.out.println(cmsLogMng.findById(100));
	}*/
}
