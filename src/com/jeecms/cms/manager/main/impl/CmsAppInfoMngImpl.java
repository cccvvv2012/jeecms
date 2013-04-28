package com.jeecms.cms.manager.main.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeecms.cms.dao.main.CmsAppInfoDao;
import com.jeecms.cms.entity.main.CmsAppInfo;
import com.jeecms.cms.manager.main.CmsAppInfoMng;
import com.jeecms.common.hibernate3.Updater;

@Service
@Transactional
public class CmsAppInfoMngImpl implements CmsAppInfoMng {
	
	@Transactional(readOnly = true)
	public List<CmsAppInfo> getList(boolean containDisabled) {
		return dao.getList(containDisabled);
	}

	public CmsAppInfo getDefModel() {
		return dao.getDefModel();
	}

	@Transactional(readOnly = true)
	public CmsAppInfo findById(Integer id) {
		CmsAppInfo entity = dao.findById(id);
		return entity;
	}

	public CmsAppInfo save(CmsAppInfo bean) {
		 
		dao.save(bean);
		return bean;
	}

	public CmsAppInfo update(CmsAppInfo bean) {
		Updater<CmsAppInfo> updater = new Updater<CmsAppInfo>(bean);
		CmsAppInfo entity = dao.updateByUpdater(updater);
		return entity;
	}

	public CmsAppInfo deleteById(Integer id) {
		CmsAppInfo bean = dao.deleteById(id);
		return bean;
	}

	public CmsAppInfo[] deleteByIds(Integer[] ids) {
		CmsAppInfo[] beans = new CmsAppInfo[ids.length];
		for (int i = 0, len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}

	 

	private CmsAppInfoDao dao;

	@Autowired
	public void setDao(CmsAppInfoDao dao) {
		this.dao = dao;
	}

	@Override
	public CmsAppInfo[] updatePriority(Integer[] ids, Integer[] priority,
			Boolean[] disabled, Integer defId) {
		// TODO Auto-generated method stub
		return null;
	}
}
