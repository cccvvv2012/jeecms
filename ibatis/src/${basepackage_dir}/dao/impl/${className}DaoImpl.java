<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>   
package ${basepackage}.dao.impl;

<#include "/java_imports.include">

 
import com.jeecms.common.hibernate3.HibernateBaseDao;
import org.springframework.stereotype.Repository;
 
import com.common.base.BasePK;
import com.common.base.BaseDaoImpl;
@Repository
public class ${className}DaoImpl extends BaseDaoImpl<${className}Bean,BasePK> implements ${className}Dao{
  
	
	<#list table.columns as column>
	<#if column.unique && !column.pk>
	public ${className} getBy${column.columnName}(${column.javaType} v) {
		return (${className}) findByProperty("${column.columnNameLower}",v);
	}	
	</#if>
	</#list>

	 
}
