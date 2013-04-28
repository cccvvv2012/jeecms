/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2013
 */

package com.jeecms.extend.test.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.junit.Test;
import com.common.test.BaseDaoTestCase;
import com.common.test.TestMethodContext;
import com.jeecms.extend.dao.UserInfoDao;
import com.jeecms.extend.bean.UserInfoBean;
import com.common.page.Page;

import static junit.framework.Assert.*;

import java.util.*;


import com.jeecms.extend.bean.UserInfoBean;
import com.jeecms.extend.dao.UserInfoDao;
import com.jeecms.extend.form.UserInfoForm;
 
/**
 * @author zhanglin
 * @version 1.0
 * @since 1.0
 */


public class UserInfoDaoTest extends BaseDaoTestCase{
	
	private UserInfoDao dao;
	
	@Autowired
	public void setUserInfoDao(UserInfoDao dao) {
		this.dao = dao;
	}

	@Override 
	protected String[] getDbUnitDataFiles() {
	    //通过 TestMethodContext.getMethodName() 可以得到当前正在运行的测试方法名称
		return new String[]{"classpath:testdata/common.xml","classpath:testdata/UserInfo.xml",
		                    "classpath:testdata/UserInfo_"+TestMethodContext.getMethodName()+".xml"};
	}
	
	//数据库单元测试前会开始事务，结束时会回滚事务，所以测试方法可以不用关心测试数据的删除
	@Test
	public void findPage() {

		UserInfoBean query = new UserInfoBean();
        List list = dao.getList();
	
	    System.out.println("测试 ：com.jeecms.extend.test.dao.UserInfo查询得到的数据条数："+list.size());
		assertEquals(pageSize,list.size());
		
	}
	
	static int pageNumber = 1;
	static int pageSize = 10;	
	 
}
