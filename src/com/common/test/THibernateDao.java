package com.common.test;

import org.junit.Test;

public class THibernateDao {
	@Test
	public void TestTHibernateDao() {
		/*Session session = HibernateUtil.getSeesion();
		session.beginTransaction();
		List<Usertab> usertabs = session.createQuery(
				"  from com.senlo.analyze.main.bean.Usertab").list();
		System.out.println(usertabs.size());
		for (int i = 0; i < usertabs.size(); i++) {
			System.out.println(usertabs.get(i).getLoginName() + "---"
					+ usertabs.get(i).getName());
		}*/
		//Usertab users = new Usertab();
		//users.setUserId(100);
		//users.setPassword("zhanglin");
		//users.setLoginName("zhanglin");
		//session.save(users);
	//	session.getTransaction().commit();
		// session.close();
		System.out.println("保存数据成功");
	}
 
}
