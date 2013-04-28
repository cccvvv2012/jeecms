<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 
package ${basepackage}.biz;
 
import com.common.base.IBaseBiz;
import com.common.base.BasePK;
import com.common.base.BasePK;
import ${basepackage}.bean.${className}Bean;
public interface ${className}Biz extends   IBaseBiz<${className}Bean,BasePK> 
{

}