package com.common.base;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import com.jeecms.common.hibernate3.HibernateBaseDao;


/**
 * Data access object (DAO) for domain model
 * 
 * @author MyEclipse Persistence Tools
 */

//BaseHibernateDaoImpl,BaseHibernateSpringDaoImpl,BaseDaoIbaImp,BaseDaoIbaSpringImp
//BaseHibernate4SpringDaoImpl,BaseHibernate3SpringDaoImpl  方法与数据连接
//这里根据需要修改连接的方式
//public   class BaseDaoImpl<T extends BaseModel,PK extends BasePK> extends HibernateBaseDao<T,PK> implements IBaseModelDao<T,PK> {
//public   class BaseDaoImpl<T extends BaseEntity,PK extends BasePK> extends HibernateBaseDao<T,PK> implements IBaseEntityDao<T,PK> {

public   class BaseDaoImpl<T extends BaseBean,PK extends BasePK> extends HibernateBaseDao<T,PK> implements IBaseBeanDao<T,PK> {

	 
	private Class<T> entityClass;
	public BaseDaoImpl() {
		if (getClass().getGenericSuperclass() instanceof ParameterizedType) {
			entityClass = (Class<T>) ((ParameterizedType) getClass()
					.getGenericSuperclass()).getActualTypeArguments()[0];
		}
	}


	@Override
	@SuppressWarnings("unchecked")
	public List<T> getList() {	 
		try {
			String queryString = "    from   " + entityClass.getName()+"     " ;
			List<T> list=getSession().createCriteria(queryString).list();
		 
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
			List<T> list=getSession().createSQLQuery(sql).list();		 
			return  list;
		} catch (RuntimeException re) {
			System.out.println(re.toString());
			log.error("find all failed", re);
			throw re;
		}
	}


	 
	/* 
	@Override
	@SuppressWarnings("unchecked")
	public T findById(BasePK id) {
		T entity = get(id);
		return entity;
	}

	public T save(T bean) {
		getSession().save(bean);
		return bean;
	}
	@Override
	@SuppressWarnings("unchecked")
	public T deleteById(BasePK id) {
		T entity = get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	 */

	@Override
	protected Class<T> getEntityClass() {
		// TODO Auto-generated method stub
		return entityClass;
	}

	public void setEntityClass(Class<T> entityClass) {
		this.entityClass = entityClass;
	}


	@Override
	public T[] deleteByIds(String[] id) {
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


	@Override
	public T update(T bean) {
		// TODO Auto-generated method stub
		return null;
	}

 
	
	 
}
