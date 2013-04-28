<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 
package ${basepackage}.manager;

import ${basepackage}.entity.${className};
import com.common.base.IBaseMng;
import com.common.base.BasePK;

public interface ${className}Mng extends   IBaseMng<${className},BasePK> 
{

}