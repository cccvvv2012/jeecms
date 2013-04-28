<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>   
package ${basepackage}.dao;

<#include "/java_imports.include">
import java.util.List;
import org.springframework.stereotype.Repository;
 
import com.common.base.BasePK;
import com.common.base.IBaseBeanDao; 
@Repository
public interface ${className}Dao  extends IBaseBeanDao<${className}Bean,BasePK>    {

	 
}
