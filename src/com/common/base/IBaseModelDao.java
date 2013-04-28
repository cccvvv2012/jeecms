package com.common.base;

import java.util.List;

import com.jeecms.common.hibernate3.Updater;

public interface IBaseModelDao<T extends BaseModel, PK extends BasePK> {
	public List<T> getList();

	public List<T> getList(String sql);

	public List<T> getList(boolean containDisabled);

	public T findById(Integer id);

	public T save(T bean);

	public T update(T bean);

	public T[] deleteByIds(Integer[] id);
 

}
