<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 
package ${basepackage}.biz.impl;
import javax.annotation.Resource;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import com.common.base.IBaseBeanDao;
import com.common.base.BaseBizImpl;
import com.common.base.BasePK;
import ${basepackage}.biz.${className}Biz;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ${basepackage}.dao.${className}Dao;

<#include "/java_imports.include">
@Service
@Transactional
public class ${className}BizImpl extends BaseBizImpl<${className}Bean,BasePK> {
 
	private ${className}Dao ${classNameLower}Dao;
	//增加setXXXX()方法,spring就可以通过autowire自动设置对象属性,请注意大小写
	public void set${className}Dao(${className}Dao dao) {
		this.${classNameLower}Dao = dao;
	}
	public IBaseBeanDao getIBaseBeanDao() {
		return this.${classNameLower}Dao;
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
 
	 
<#list table.columns as column>
	<#if column.unique && !column.pk>
	@Transactional(readOnly=true)
	public ${className} getBy${column.columnName}(${column.javaType} v) {
		return ${classNameLower}Dao.getBy${column.columnName}(v);
	}	
	
	</#if>
</#list>
}
