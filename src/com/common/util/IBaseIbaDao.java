package com.common.util;

import java.util.List;

import com.common.base.BaseModel;

public   interface IBaseIbaDao<M extends BaseModel> {
	public int deleteByAnd(String and);

	public M getBeanById(String id);

	public int getCount(String and);

	public List<M> getList(String and);

	public int getMaxId(String and);

	@SuppressWarnings("unchecked")
	public List<M> getPageList(String and, int pageSize, int pageNo);

	public List<M> getRowList(String and, int pageSize, int pageNo);

	public String insert(M bean);

	public boolean updateById(M bean);
}
