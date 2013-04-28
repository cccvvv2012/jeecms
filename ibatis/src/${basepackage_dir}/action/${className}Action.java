<#include "/custom.include">
<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>   
package ${basepackage}.action;
 
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
 
import ${basepackage}.biz.impl.${className}BizImpl;
import org.apache.struts.action.*;
 
import com.common.base.BaseAction;
 


<#include "/java_imports.include">

@Controller
public class ${className}Action extends BaseAction  {
	private ${className}BizImpl biz = new ${className}BizImpl();
	
	
	@Override
	protected ActionForward unspecified(ActionMapping mapping, ActionForm form,
	HttpServletRequest request, HttpServletResponse response)throws Exception {
		return list(mapping, form, request, response);
	}
	public ActionForward delete(ActionMapping mapping, ActionForm form,
	HttpServletRequest request, HttpServletResponse response)throws Exception {
		${className}Form frm=(${className}Form)form;
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