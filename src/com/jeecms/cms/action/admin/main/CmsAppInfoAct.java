package com.jeecms.cms.action.admin.main;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jeecms.cms.entity.main.CmsAppInfo;
import com.jeecms.cms.manager.main.CmsAppInfoMng;
import com.jeecms.cms.manager.main.CmsLogMng;
import com.jeecms.cms.web.WebErrors;
@Controller
public class CmsAppInfoAct {
	@RequestMapping("/appInfo/v_list.do")
	public String list(HttpServletRequest request, ModelMap model) {
		//List<CmsModel> list = manager.getList(true);
		System.out.println("开始读左边菜单两个栏目 模块,com.jeecms.cms.action.admin.main.CmsAppInfoAct");
		 //	model.addAttribute("list", list);
		return "appInfo/list";
	}

	@RequestMapping("/appInfo/v_add.do")
	public String add(ModelMap appInfo) {
		return "appInfo/add";
	}

	@RequestMapping("/appInfo/v_edit.do")
	public String edit(Integer id, HttpServletRequest request, ModelMap appInfo) {
		WebErrors errors = validateEdit(id, request);
		if (errors.hasErrors()) {
			return errors.showErrorPage(appInfo);
		}
		appInfo.addAttribute("cmsappInfo", manager.findById(id));
		return "appInfo/edit";
	}

	 

	@RequestMapping("/appInfo/o_update.do")
	public String update(CmsAppInfo bean, HttpServletRequest request,
			ModelMap appInfo) {
		WebErrors errors = validateUpdate(bean.getId(), request);
		if (errors.hasErrors()) {
			return errors.showErrorPage(appInfo);
		}
		bean = manager.update(bean);
		 
		return list(request, appInfo);
	}

	 

	private WebErrors validateEdit(Integer id, HttpServletRequest request) {
		WebErrors errors = WebErrors.create(request);
		if (vldExist(id, errors)) {
			return errors;
		}
		return errors;
	}

	private WebErrors validateUpdate(Integer id, HttpServletRequest request) {
		WebErrors errors = WebErrors.create(request);
		if (vldExist(id, errors)) {
			return errors;
		}
		return errors;
	}

	private WebErrors validateDelete(Integer[] ids, HttpServletRequest request) {
		WebErrors errors = WebErrors.create(request);
		errors.ifEmpty(ids, "ids");
		for (Integer id : ids) {
			vldExist(id, errors);
		}
		return errors;
	}

	private WebErrors validatePriority(Integer[] wids, Integer[] priority,
			Boolean[] disabled, Integer defId, HttpServletRequest request) {
		WebErrors errors = WebErrors.create(request);
		if (errors.ifEmpty(wids, "wids")) {
			return errors;
		}
		if (errors.ifEmpty(priority, "priority")) {
			return errors;
		}
		if (wids.length != priority.length || wids.length != disabled.length) {
			String s = "wids length not equals priority length or disabled length";
			errors.addErrorString(s);
			return errors;
		}
		for (int i = 0, len = wids.length; i < len; i++) {
			if (vldExist(wids[i], errors)) {
				return errors;
			}
			if (priority[i] == null) {
				priority[i] = 0;
			}
			if (disabled[i] == null) {
				disabled[i] = false;
			}
		}
		if (vldExist(defId, errors)) {
			return errors;
		}
		return errors;
	}

	private boolean vldExist(Integer id, WebErrors errors) {
		if (errors.ifNull(id, "id")) {
			return true;
		}
		CmsAppInfo entity = manager.findById(id);
		if (errors.ifNotExist(entity, CmsAppInfo.class, id)) {
			return true;
		}
		return false;
	}

	@Autowired
	private CmsLogMng cmsLogMng;
	@Autowired
	private CmsAppInfoMng manager;
}