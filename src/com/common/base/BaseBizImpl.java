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

public   class BaseBizImpl<T extends BaseBean, PK extends BasePK> implements IBaseBeanBiz<T, PK> {

	protected Log log = LogFactory.getLog(getClass());

	protected IBaseBeanDao getIBaseBeanDao() {
		return null;
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
	public T get(BasePK id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List getList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List getList(String sql) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List getList(boolean containDisabled) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T save(BaseBean bean) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T update(BaseBean bean) {
		// TODO Auto-generated method stub
		return null;
	}

 

	 

 
}
