package com.common.base;

import java.util.List;

public interface IBaseModelBiz<T extends BaseModel, PK extends BasePK> {
	public List<T> getList();

	public List<T> getList(String sql);

	public List<T> getList(boolean containDisabled);

	public T findById(Integer id);

	public T save(T bean);

	public T update(T bean);

	public T[] deleteByIds(String[] id);

	public T get(BasePK id);

}
