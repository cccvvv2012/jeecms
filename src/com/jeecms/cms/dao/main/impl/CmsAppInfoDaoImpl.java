package com.jeecms.cms.dao.main.impl;

import java.util.List;

import com.jeecms.cms.dao.main.CmsAppInfoDao;
import com.jeecms.cms.entity.main.CmsAppInfo;
import com.jeecms.common.hibernate3.Finder;
import com.jeecms.common.hibernate3.HibernateBaseDao;

public class CmsAppInfoDaoImpl extends HibernateBaseDao<CmsAppInfo, Integer>
		implements CmsAppInfoDao {
	@SuppressWarnings("unchecked")
	public List<CmsAppInfo> getList(boolean containDisabled) {
		Finder f = Finder.create("from CmsAppInfo bean");
		if (!containDisabled) {
			f.append(" where bean.disabled=false");
		}
		f.append(" order by bean.priority");
		return find(f);
	}

	@SuppressWarnings("unchecked")
	public CmsAppInfo getDefModel() {
		String hql = "from CmsAppInfo bean where bean.def=true";
		List<CmsAppInfo> list = getSession().createQuery(hql).setMaxResults(1)
				.list();
		if (list.size() > 0) {
			return list.get(0);
		} else {
			return null;
		}
	}

	public CmsAppInfo findById(Integer id) {
		CmsAppInfo entity = get(id);
		return entity;
	}

	public CmsAppInfo save(CmsAppInfo bean) {
		getSession().save(bean);
		return bean;
	}

	public CmsAppInfo deleteById(Integer id) {
		CmsAppInfo entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}

	@Override
	protected Class<CmsAppInfo> getEntityClass() {
		return CmsAppInfo.class;
	}
}