/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2013
 */

package com.jeecms.extend.biz.impl;
import javax.annotation.Resource;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import com.common.base.IBaseBeanDao;
import com.common.base.BaseBizImpl;
import com.common.base.BasePK;
import com.jeecms.extend.biz.UserInfoBiz;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.jeecms.extend.dao.UserInfoDao;

import java.util.*;


import com.jeecms.extend.bean.UserInfoBean;
import com.jeecms.extend.dao.UserInfoDao;
import com.jeecms.extend.form.UserInfoForm;
 
/**
 * @author zhanglin
 * @version 1.0
 * @since 1.0
 */

@Service
@Transactional
public class UserInfoBizImpl extends BaseBizImpl<UserInfoBean,BasePK> {
 
	private UserInfoDao userInfoDao;
	//增加setXXXX()方法,spring就可以通过autowire自动设置对象属性,请注意大小写
	public void setUserInfoDao(UserInfoDao dao) {
		this.userInfoDao = dao;
	}
	public IBaseBeanDao getIBaseBeanDao() {
		return this.userInfoDao;
	}
	
	
	public void edit(ActionForm form, HttpServletRequest request) {

	}

	public void save(ActionForm form, HttpServletRequest request) {

	}

	public void list(ActionForm form, HttpServletRequest request) {

	}

	public String getJsonByForm(ActionForm form, HttpServletRequest request) {

		return "";
	}
 
	 
}
