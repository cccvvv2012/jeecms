package com.common.base;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.common.util.HibernateSessionFactory;
import com.common.util.IBaseHibernateDAO;
import com.jeecms.common.hibernate3.Updater;

/**
 * Data access object (DAO) for domain model
 * 
 * @author MyEclipse Persistence Tools
 */
public abstract class BaseHibernateDaoImpl<T extends BaseModel,PK extends BasePK> implements IBaseModelDao<T,PK>,
		IBaseHibernateDAO {
	protected Class<T> entityClass;

	private static final Logger log = LoggerFactory.getLogger("开始操作");

	public BaseHibernateDaoImpl() {
		if (getClass().getGenericSuperclass() instanceof ParameterizedType) {
			entityClass = (Class<T>) ((ParameterizedType) getClass()
					.getGenericSuperclass()).getActualTypeArguments()[0];
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<T> getList() {
		StringBuilder b = new StringBuilder(1024);

		try {
			String queryString = "    from   " + entityClass.getName()
					+ "     ";
			Query queryObject = getSession().createQuery(queryString);
			System.out.println("BaseHibernateDaoImpl:" + queryString + "->"
					+ queryObject.list().size());
			return queryObject.list();
		} catch (RuntimeException re) {
			System.out.println(re.toString());
			log.error("find all failed", re);
			throw re;
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public List getList(String sql) {
		 

		try {
			String queryString =  sql;
			Query list = getSession().createSQLQuery(queryString);
			System.out.println("BaseHibernateSpringDaoImpl:" + queryString
					+ "->" + list.list().size());
			return list.list();
		} catch (RuntimeException re) {
			System.out.println(re.toString());

			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List FindAll1(String[] columns) {
		StringBuilder b = new StringBuilder(1024);
		for (String s : columns) {
			b.append("t." + s + ",");
		}
		b.setLength(b.length() - 1);

		try {
			String queryString = " select  " + b + "   from   "
					+ entityClass.getName() + " t    ";
			Query list = getSession().createQuery(queryString);
			System.out.println("BaseHibernateSpringDaoImpl:" + queryString
					+ "->" + list.list().size());
			return list.list();
		} catch (RuntimeException re) {
			System.out.println(re.toString());

			throw re;
		}
	}


	@Override
	public Session getSession() {
		return HibernateSessionFactory.getSession();
	}

	@Override
	public T[] deleteByIds(Integer[] id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	 
 

	@Override
	public List<T> getList(boolean containDisabled) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T save(T bean) {
		// TODO Auto-generated method stub
		return null;
	}
 
 


}
