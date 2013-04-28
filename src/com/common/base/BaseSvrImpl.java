/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2013
 */

package com.common.base;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public   class BaseSvrImpl<T extends BaseModel, PK extends BasePK> implements IBaseMng {

	protected Log log = LogFactory.getLog(getClass());

	protected IBaseModelDao getIBaseDao() {
		return null;
	}

	@Override
	public T[] deleteByIds(Integer[] id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> getList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> getList(String sql) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T get(BasePK id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> getList(boolean containDisabled) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BaseModel save(BaseModel bean) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BaseModel update(BaseModel bean) {
		// TODO Auto-generated method stub
		return null;
	}
 

 
}
