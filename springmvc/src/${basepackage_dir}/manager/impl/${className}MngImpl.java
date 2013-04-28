<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 
package ${basepackage}.manager.impl;
import javax.annotation.Resource;

import com.common.base.IBaseDao;
import com.common.base.BaseSvrImpl;
import com.common.base.BasePK;
import ${basepackage}.manager.${className}Mng;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ${basepackage}.dao.${className}Dao;

<#include "/java_imports.include">
@Service
@Transactional
public class ${className}MngImpl extends BaseSvrImpl<${className},BasePK> {
 
	private ${className}Dao ${classNameLower}Dao;
	//增加setXXXX()方法,spring就可以通过autowire自动设置对象属性,请注意大小写
	public void set${className}Dao(${className}Dao dao) {
		this.${classNameLower}Dao = dao;
	}
	public IBaseDao getIBaseDao() {
		return this.${classNameLower}Dao;
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
