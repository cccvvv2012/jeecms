<?xml version="1.0" encoding="UTF-8"?>
 <beans xmlns="http://www.springframework.org/schema/beans" 
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xmlns:p="http://www.springframework.org/schema/p" 
    xsi:schemaLocation="
        http://www.springframework.org/schema/beans 
        http://www.springframework.org/schema/beans/spring-beans-2.5.xsd"        
    default-autowire="byName"   >

<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 

<bean id="${classNameLower}Manager" class="${basepackage}.service.${className}Manager"/>
<bean id="${classNameLower}Dao" class="${basepackage}.dao.${className}Dao"/>
<!-- 文件包含后面的这段字符: generator-...-location,则在模板输出的地方,如果发现同名文件,则可将生成内容插入在该标记之后 -->
<!--  generator-insert-location -->
</beans>