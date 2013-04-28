package com.common.base;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;

import com.jeecms.common.hibernate3.Updater;
 
//public class BaseHibernate4SpringDaoImpl<M extends BaseModel, PK extends BasePK> implements IBaseDao<M, PK> {

@Component
public abstract class BaseHibernate3SpringDaoImpl<T extends BaseModel,PK extends BasePK> extends
		HibernateDaoSupport implements IBaseModelDao<T,PK> {

	private Class<T> entityClass;

	private static final Logger log = LoggerFactory.getLogger("开始操作");

	public BaseHibernate3SpringDaoImpl() {
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
			String queryString = "    from   " + entityClass.getName()+"     " ;
			List<T> list=getHibernateTemplate().find(queryString);
			System.out.println("BaseHibernateSpringDaoImpl:"+queryString+"->"+list.size());
			return  list;
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

	public Class<T> getEntityClass() {
		return entityClass;
	}

	 

	public void setEntityClass(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

	@Resource(name = "sessionFactory")
	public void setSuperSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Override
	public T[] deleteByIds(Integer[] id) {
		// TODO Auto-generated method stub
		return null;
	}

 

 




}