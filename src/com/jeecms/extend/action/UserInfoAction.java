/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2013
 */

package com.jeecms.extend.action;
 
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.*;
 
import com.jeecms.extend.biz.impl.UserInfoBizImpl;
import org.apache.struts.action.*;
 
import com.common.base.BaseAction;
 


import java.util.*;


import com.jeecms.extend.bean.UserInfoBean;
import com.jeecms.extend.dao.UserInfoDao;
import com.jeecms.extend.form.UserInfoForm;
 
/**
 * @author zhanglin
 * @version 1.0
 * @since 1.0
 */


@Controller
public class UserInfoAction extends BaseAction  {
	private UserInfoBizImpl biz = new UserInfoBizImpl();
	
	
	@Override
	protected ActionForward unspecified(ActionMapping mapping, ActionForm form,
	HttpServletRequest request, HttpServletResponse response)throws Exception {
		return list(mapping, form, request, response);
	}
	public ActionForward delete(ActionMapping mapping, ActionForm form,
	HttpServletRequest request, HttpServletResponse response)throws Exception {
		UserInfoForm frm=(UserInfoForm)form;
		String[] chkId=frm.getChkId();
		/*if(chkId!=null)for (int i = 0; i < chkId.length; i++) {
		biz.deleteById(chkId[i]);
	    }*/
	    if(chkId!=null) 
		biz.deleteByIds(chkId);
	    return null;
	}
	public ActionForward edit(ActionMapping mapping, ActionForm form,
	HttpServletRequest request, HttpServletResponse response)throws Exception {
		biz.edit(form, request);
		return mapping.findForward("edit");
	}
	public ActionForward save(ActionMapping mapping, ActionForm form,
	HttpServletRequest request, HttpServletResponse response)throws Exception {
		biz.save(form, request);
		return mapping.findForward("edit");
	}
	public ActionForward list(ActionMapping mapping, ActionForm form,
	HttpServletRequest request, HttpServletResponse response)throws Exception {
		biz.list(form,request);return mapping.findForward("list");
	}
	public ActionForward list_table(ActionMapping mapping, ActionForm form,
	HttpServletRequest request, HttpServletResponse response)throws Exception {
		PrintWriter out = response.getWriter();
		String json=biz.getJsonByForm(form,request);
		out.println(json);out.flush();out.close();return null;
	}
	 
	
}

