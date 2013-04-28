package com.common.util;

import org.hibernate.Session;

public class MyHibernateTemplate {
	public void executeWithNativeSession(MyHibernateCallback callback) {
		Session s = null;
		try {
			s = getSession();
			s.beginTransaction();

			callback.doInHibernate(s);// 通过钩子也就是回调函数来自已实现方法

			s.getTransaction().commit();
		} catch (Exception e) {
			s.getTransaction().rollback();
		} finally {
			// ...
		}
	}

	private Session getSession() {
		// TODO Auto-generated method stub
		return null;
	}

	public void save(final Object o) {

		// 用匿名类的方法来实现接口的方法，这也就是自定义的扩展
		new MyHibernateTemplate()
				.executeWithNativeSession(new MyHibernateCallback() {
					@Override
					public void doInHibernate(Session s) {
						s.save(o); // 具体实现方法由我们自己写
					}
				});
	}

}
