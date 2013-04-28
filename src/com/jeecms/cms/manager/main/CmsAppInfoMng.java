package com.jeecms.cms.manager.main;

import java.util.List;

import com.jeecms.cms.entity.main.CmsAppInfo;

public interface CmsAppInfoMng {

	/**
	 * 获得模型列表
	 * 
	 * @param containDisabled
	 *            是否所有模型（即包含禁用模型）
	 * @return
	 */
	public List<CmsAppInfo> getList(boolean containDisabled);

	/**
	 * 获得默认模型
	 * 
	 * @return
	 */
	public CmsAppInfo getDefModel();

	public CmsAppInfo findById(Integer id);

	public CmsAppInfo save(CmsAppInfo bean);

	public CmsAppInfo update(CmsAppInfo bean);

	public CmsAppInfo deleteById(Integer id);

	public CmsAppInfo[] deleteByIds(Integer[] ids);

	public CmsAppInfo[] updatePriority(Integer[] ids, Integer[] priority,
			Boolean[] disabled, Integer defId);
}
