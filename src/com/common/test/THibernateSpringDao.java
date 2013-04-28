package com.common.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

@ContextConfiguration(locations = { "classpath:com/spring-base.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class THibernateSpringDao {
	//@Autowired
	//@Qualifier("sessionFactory")
	//private SessionFactory sessionFactory;
 
	@Autowired
	//private UserTabSvr userTabSvr;
	//private HibernateTemplate hibernateTemplate;

	// @Rollback(false)
	// 这里是能过读配置文件测试的方法
	  @Test
	public void TestContextSpring() {
		/*try {
			System.out.println("开始读取数据");
			// userTabSvr = SpringContextHolder.getBean("userTabSvrImpl");
			List<Usertab> list = userTabSvr.FindAll();
			System.out.println(list.size());
			for (int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i).getLoginName() + "--"
						+ list.get(0).getName());
			}

		} catch (Exception e) {
			System.out.println(e.toString());
			// TODO: handle exception
		}*/
	}

	/*public HibernateTemplate getHibernateTemplate() {
		// 首先，检查原来的hibernateTemplate实例是否还存在
		if (hibernateTemplate == null) {
			// 如果不存在，新建一个HibernateTemplate实例
			hibernateTemplate = new HibernateTemplate(sessionFactory);
			System.out.println("创建了一个hibernate");
		} else {
			System.out.println("已经存在一个hibernate");
		}
		return hibernateTemplate;

	}

	// 这里sessionFactory需要用org.springframework.orm.hibernate3.LocalSessionFactoryBean
	// 才行
	// 但目前sessionFactory是org.springframework.orm.hibernate4.LocalSessionFactoryBean所以会报如下错误
	// org.springframework.orm.hibernate4.SessionHolder cannot be cast to
	// org.springframework.orm.hibernate3.SessionHolder
	@SuppressWarnings("unchecked")
	public List FindAll(final String sql) {
		HibernateTemplate ht = getHibernateTemplate();
		return (List) ht.execute(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException {
				try {
					SQLQuery query = session.createSQLQuery(sql);
					return query.list();
				} catch (RuntimeException e) {

					throw e;
				}
			}
		});

	}

	public Session getSession() {
		// 事务必须是开启的，否则获取不到
		return sessionFactory.getCurrentSession();
	}

	//@Test
	public void test() { // SampleResult
		System.out.println("-------------------");
		String sq2 = "select ItemParameter.EnglishShortening as Item,ItemParameter.ChineseFullName as FullName,SampleTestData.ItemResult as checkResult,SampleTestData.ItemResult,SampleTestData.InGearRange as ReRange,SampleTestData.ItemResultUnit as Unit,SampleTestData.TestVerdict as Prompt,SampleBaseInfor.SampleTrayID,SampleBaseInfor.SampleLocation,SampleTestData.TestDate,SampleTestData.Bak as Remark ,null as IsReTest,"
				+ "SampleTestData.TestMomentSign,SampleTestData.ReTestSign,SampleTestData.ID as fid,SampleTestData.ItemID,ItemParameter.ReagentTrayID, "
				+ " SampleTestData.ModifySign ,SampleTestData.ModifyTime,SampleTestData.OriginalityResult,SampleTestData.ModifyUserName,SampleTestData.TestResult,SampleTestData.ReactionChroma,SampleTestData.ResultExceptionSign,ItemParameter.CalcItemSign "
				+ " from SampleTestData INNER JOIN ItemParameter ON SampleTestData.ItemID =  ItemParameter.ID,SampleBaseInfor where "
				+ " SampleTestData.SampleID=6  and (SampleTestData.connItem=0 or ItemParameter.CalcItemSign='1')  AND SampleBaseInfor.ID=6"
				+ " order by ItemParameter.PrintSerial ";
		 
		//System.out.println("测试到的数据2:" + list.size());
	}
 */
}
