<#include "/macro.include"/>
<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 
package ${basepackage}.entity;

import javax.persistence.*;
import ${basepackage}.entity.base.Base${className};
import org.hibernate.annotations.GenericGenerator;
import com.common.base.BaseEntity;
import javax.validation.constraints.*;
import org.hibernate.validator.constraints.*;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

<#include "/java_imports.include">

@Entity
@Table(name = "${table.sqlName}")
public class ${className} extends Base${className}  {
	private static final long serialVersionUID = 5454155825314635342L;
	
	 
}
