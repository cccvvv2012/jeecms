package com.common.base;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.jeecms.common.hibernate3.Updater;

// HibernateDaoSupport这个是hibernate 30的时候才需要继承
// hibernate4.0不需要继承了
@Repository
//public class BaseHibernate4SpringDaoImpl<M extends BaseModel, PK extends BasePK> implements IBaseDao<M, PK> {

public abstract class BaseHibernate4SpringDaoImpl<M extends BaseModel,PK extends BasePK> implements IBaseModelDao<M,PK> {

	protected static final Logger LOGGER = LoggerFactory
			.getLogger(BaseHibernateDao.class);

	private Class<M> entityClass;
	private String HQL_LIST_ALL;
	private String HQL_COUNT_ALL;
	private String HQL_OPTIMIZE_PRE_LIST_ALL;
	private String HQL_OPTIMIZE_NEXT_LIST_ALL;
	private String pkName = null;

	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public BaseHibernate4SpringDaoImpl() {
		if (getClass().getGenericSuperclass() instanceof ParameterizedType) {
			entityClass = (Class<M>) ((ParameterizedType) getClass()
					.getGenericSuperclass()).getActualTypeArguments()[0];
		}
	}

	public void delete(BaseModel t) {
		getSession().delete(t);
	}

	/*
	 * this.entityClass = (Class<T>) ((ParameterizedType) getClass()
	 * .getGenericSuperclass()).getActualTypeArguments()[0]; Field[] fields =
	 * this.entityClass.getDeclaredFields(); for (Field f : fields) { if
	 * (f.isAnnotationPresent(Id.class)) { this.pkName = f.getName(); } }
	 * 
	 * // Assert.notNull(pkName); // TODO @Entity name not null HQL_LIST_ALL =
	 * "from " + this.entityClass.getSimpleName() + " order by " + pkName +
	 * " desc"; HQL_OPTIMIZE_PRE_LIST_ALL = "from " +
	 * this.entityClass.getSimpleName() + " where " + pkName + " > ? order by "
	 * + pkName + " asc"; HQL_OPTIMIZE_NEXT_LIST_ALL = "from " +
	 * this.entityClass.getSimpleName() + " where " + pkName + " < ? order by "
	 * + pkName + " desc"; HQL_COUNT_ALL = " select count(*) from " +
	 * this.entityClass.getSimpleName();
	 */

	@Override
	@SuppressWarnings("unchecked")
	public List<M> getList() {
		StringBuilder b = new StringBuilder(1024);

		try {
			String queryString = "    from   " + entityClass.getName()
					+ "     ";
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
	@SuppressWarnings("unchecked")
	public List<M> getList(String sql) {
		StringBuilder b = new StringBuilder(1024);

		try {
			String queryString = "    from   " + entityClass.getName()
					+ " where 1=1 "+sql;
			Query list = getSession().createQuery(queryString);
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

	public Class<M> getEntityClass() {
		return entityClass;
	}

	public Session getSession() {
		// 事务必须是开启的，否则获取不到
		return sessionFactory.getCurrentSession();
	}

	 

	public void setEntityClass(Class<M> entityClass) {
		this.entityClass = entityClass;
	}

 
 

 
 

 
}