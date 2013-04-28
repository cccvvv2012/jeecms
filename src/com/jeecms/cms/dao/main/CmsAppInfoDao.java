package com.jeecms.cms.dao.main;

import java.util.List;

import com.jeecms.cms.entity.main.CmsAppInfo;
import com.jeecms.common.hibernate3.Updater;

public interface CmsAppInfoDao {
	public List<CmsAppInfo> getList(boolean containDisabled);

	public CmsAppInfo getDefModel();

	public CmsAppInfo findById(Integer id);

	public CmsAppInfo save(CmsAppInfo bean);

	public CmsAppInfo updateByUpdater(Updater<CmsAppInfo> updater);

	public CmsAppInfo deleteById(Integer id);

}
