<#assign itemCount = 0/>

<#if parameters.nameValue?exists>
  <#assign nameValues = parameters.nameValue.toString()?replace(" ","")?split(",")/>
<#else>
  <#assign nameValues = ""/>
</#if>
<#if parameters.list?exists>
    <@s.iterator value="parameters.list">
        <#assign itemCount = itemCount + 1/>
        <#if parameters.listKey?exists>
            <#assign itemKey = stack.findValue(parameters.listKey)/>
        <#else>
            <#assign itemKey = stack.findValue('top')/>
        </#if>
        <#if parameters.listValue?exists>
            <#assign itemValue = stack.findString(parameters.listValue)/>
        <#else>
            <#assign itemValue = stack.findString('top')/>
        </#if>
<#assign itemKeyStr=itemKey.toString() />
<span class="nobreak">
<input class="checkboxInput" type="checkbox" name="${parameters.name?html}" value="${itemKeyStr?html}" id="${parameters.name?html}-${itemCount}"<#rt/>
        <#if tag.contains(nameValues, itemKey) || tag.contains(parameters.nameValue, itemKey)>
 checked="checked"<#rt/>
        </#if>
        <#if parameters.disabled?default(false)>
 disabled="disabled"<#rt/>
        </#if>
        <#if parameters.title?exists>
 title="${parameters.title?html}"<#rt/>
        </#if>
        <#include "/${parameters.templateDir}/simple/scripting-events.ftl" />
        <#include "/${parameters.templateDir}/simple/common-attributes.ftl" />
/>
<#if parameters.accesskey?exists>
  <label for="${parameters.name?html}-${itemCount}" class="checkboxLabel">${action.getText("${itemValue?html}")}</label>
<#else>
  <label for="${parameters.name?html}-${itemCount}" class="checkboxLabel">${itemValue?html}</label>
</#if>
    </span>&nbsp;
    </@s.iterator>
<#else>
  &nbsp;
</#if>
