<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>   
package ${basepackage}.dao;

<#include "/java_imports.include">

import com.common.base.BasePK;
import org.springframework.stereotype.Repository;
import ${basepackage}.entity.${className};
import com.common.base.IBaseModelDao; 
@Repository
public interface ${className}Dao  extends IBaseModelDao<${className},BasePK> {

	 
}
