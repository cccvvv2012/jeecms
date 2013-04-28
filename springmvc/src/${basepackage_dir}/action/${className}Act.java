<#include "/custom.include">
<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>   
package ${basepackage}.action;

import java.io.IOException;
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

import com.jeecms.cms.entity.main.CmsModel;
 
import com.jeecms.cms.manager.main.CmsLogMng;
import com.jeecms.cms.web.CmsUtils; 
import com.jeecms.core.web.WebErrors;
import com.jeecms.extend.entity.${className};
import com.jeecms.extend.manager.${className}Mng; 
 


<#include "/java_imports.include">

@Controller
public class ${className}Act  {
	private static final Logger log = LoggerFactory.getLogger(${className}Act.class);
	@RequestMapping("/${classNameLower}/v_list.do")
	public String list(Integer pageNo, HttpServletRequest request,
			ModelMap model) {
		List<${className}> list = manager.getList();
		model.addAttribute("list", list);
		return "${classNameLower}/list";
	}
	
	@RequestMapping("/${classNameLower}/v_add.do")
	public String add(ModelMap model) {
		List<${className}> list = manager.getList();
		model.addAttribute("list", list);
		return "${classNameLower}/add";
	}

	@RequestMapping("/${classNameLower}/v_edit.do")
	public String edit(Integer id, HttpServletRequest request, ModelMap model) {
		WebErrors errors = validateEdit(id, request);
		if (errors.hasErrors()) {
			return errors.showErrorPage(model);
		}
		List<${className}> list = manager.getList();
		model.addAttribute("list", list);
		model.addAttribute("${className}", manager.findById(id));
		return "${classNameLower}/edit";
	}

	@RequestMapping("/${classNameLower}/o_save.do")
	public String save(${className} bean, Integer uploadFtpId,
			HttpServletRequest request, ModelMap model) throws IOException {
		WebErrors errors = validateSave(bean, request);
		if (errors.hasErrors()) {
			return errors.showErrorPage(model);
		}
		bean = manager.save(bean);
		log.info("save ${className} id={}", bean.getUserId());
		cmsLogMng.operating(request, "${className}.log.save", "id=" + bean.getUserId()
				+ ";name=" + bean.getUsername());
		return "redirect:v_list.do";
	}

	@RequestMapping("/${classNameLower}/o_update.do")
	public String update(${className} bean, Integer uploadFtpId, Integer pageNo,
			HttpServletRequest request, ModelMap model) {
		WebErrors errors = validateUpdate(bean.getUserId(),   request);
		if (errors.hasErrors()) {
			return errors.showErrorPage(model);
		}
		bean = manager.update(bean);
		log.info("update ${className} id={}.", bean.getUserId());
		cmsLogMng.operating(request, "${className}.log.update", "id=" + bean.getUserId()
				+ ";name=" + bean.getUsername());
		return list(pageNo, request, model);
	}

	@RequestMapping("/${classNameLower}/o_delete.do")
	public String delete(Integer[] ids, Integer pageNo,
			HttpServletRequest request, ModelMap model) {
		WebErrors errors = validateDelete(ids, request);
		if (errors.hasErrors()) {
			return errors.showErrorPage(model);
		}
		${className}[] beans = manager.deleteByIds(ids);
		for (${className} bean : beans) {
			log.info("delete ${className} id={}", bean.getUserId());
			cmsLogMng.operating(request, "${className}.log.delete", "id="
					+ bean.getUserId() + ";name=" + bean.getUsername());
		}
		return list(pageNo, request, model);
	}
	
	
	private WebErrors validateSave(${className} bean, HttpServletRequest request) {
		WebErrors errors = WebErrors.create(request);
		return errors;
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
	
	
	private boolean vldExist(Integer id, WebErrors errors) {
		if (errors.ifNull(id, "id")) {
			return true;
		}
		${className} entity = manager.findById(id);
		if (errors.ifNotExist(entity, ${className}.class, id)) {
			return true;
		}
		return false;
	}
	
	@Autowired
	private ${className}Mng manager;

	@Autowired
	private CmsLogMng cmsLogMng;
}

<#macro generateIdParameter>
	<#if table.compositeId>
		${className}Id id = new ${className}Id();
		bind(request, id);
	<#else>
		<#list table.compositeIdColumns as column>
		${column.javaType} id = new ${column.javaType}(request.getParameter("${column.columnNameLower}"));
		</#list>
	</#if>
</#macro>