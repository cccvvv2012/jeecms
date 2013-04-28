package com.common.base;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.jeecms.common.hibernate3.Updater;

@Repository 
public abstract class BaseHibernateSpringDaoImpl<M extends BaseModel,PK extends BasePK> extends
		HibernateDaoSupport implements IBaseModelDao<M,PK> {

	private Class<M> entityClass;

	private static final Logger log = LoggerFactory.getLogger("开始操作");

	public BaseHibernateSpringDaoImpl() {
		if (getClass().getGenericSuperclass() instanceof ParameterizedType) {
			entityClass = (Class<M>) ((ParameterizedType) getClass()
					.getGenericSuperclass()).getActualTypeArguments()[0];
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<M> getList() {
		StringBuilder b = new StringBuilder(1024);
		 

		try {
			String queryString = "    from   " + entityClass.getName()+"     " ;
			List<M> list=getHibernateTemplate().find(queryString);
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

	public Class<M> getEntityClass() {
		return entityClass;
	}

 
	public void setEntityClass(Class<M> entityClass) {
		this.entityClass = entityClass;
	}

	@Resource(name = "sessionFactory")
	public void setSuperSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

 

}