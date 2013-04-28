/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2013
 */

package com.jeecms.extend.xml;

import com.common.base.BaseModel;
import javax.validation.constraints.*;
import org.hibernate.validator.constraints.*;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import com.common.util.DateConvertUtils;
import java.util.*;


import com.jeecms.extend.bean.UserInfoBean;
import com.jeecms.extend.dao.UserInfoDao;
import com.jeecms.extend.form.UserInfoForm;
 
/**
 * @author zhanglin
 * @version 1.0
 * @since 1.0
 */


public class UserInfo extends BaseModel implements java.io.Serializable {
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "UserInfo";
	public static final String ALIAS_USER_ID = "userId";
	public static final String ALIAS_USERNAME = "username";
	public static final String ALIAS_PASSWORD = "password";
	public static final String ALIAS_BIRTH_DATE = "birthDate";
	public static final String ALIAS_SEX = "sex";
	public static final String ALIAS_AGE = "age";
	
	//date formats
	public static final String FORMAT_BIRTH_DATE = DATE_FORMAT;
	
	//鍙互鐩存帴浣跨敤: @Length(max=50,message="鐢ㄦ埛鍚嶉暱搴︿笉鑳藉ぇ浜�0")鏄剧ず閿欒娑堟伅
	//columns START
    /**
     * userId       db_column: user_id 
     */ 	
	
	private java.lang.Long userId;
    /**
     * username       db_column: username 
     */ 	
	@NotBlank @Length(max=50)
	private java.lang.String username;
    /**
     * password       db_column: password 
     */ 	
	@Length(max=50)
	private java.lang.String password;
    /**
     * birthDate       db_column: birth_date 
     */ 	
	
	private java.util.Date birthDate;
    /**
     * sex       db_column: sex 
     */ 	
	
	private java.lang.Integer sex;
    /**
     * age       db_column: age 
     */ 	
	
	private java.lang.Integer age;
	//columns END

	public UserInfo(){
	}

	public UserInfo(
		java.lang.Long userId
	){
		this.userId = userId;
	}

	public void setUserId(java.lang.Long value) {
		this.userId = value;
	}
	
	public java.lang.Long getUserId() {
		return this.userId;
	}
	public void setUsername(java.lang.String value) {
		this.username = value;
	}
	
	public java.lang.String getUsername() {
		return this.username;
	}
	public void setPassword(java.lang.String value) {
		this.password = value;
	}
	
	public java.lang.String getPassword() {
		return this.password;
	}
	public String getBirthDateString() {
		return DateConvertUtils.format(getBirthDate(), FORMAT_BIRTH_DATE);
	}
	public void setBirthDateString(String value) {
		setBirthDate(DateConvertUtils.parse(value, FORMAT_BIRTH_DATE,java.util.Date.class));
	}
	
	public void setBirthDate(java.util.Date value) {
		this.birthDate = value;
	}
	
	public java.util.Date getBirthDate() {
		return this.birthDate;
	}
	public void setSex(java.lang.Integer value) {
		this.sex = value;
	}
	
	public java.lang.Integer getSex() {
		return this.sex;
	}
	public void setAge(java.lang.Integer value) {
		this.age = value;
	}
	
	public java.lang.Integer getAge() {
		return this.age;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("UserId",getUserId())
			.append("Username",getUsername())
			.append("Password",getPassword())
			.append("BirthDate",getBirthDate())
			.append("Sex",getSex())
			.append("Age",getAge())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getUserId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof UserInfo == false) return false;
		if(this == obj) return true;
		UserInfo other = (UserInfo)obj;
		return new EqualsBuilder()
			.append(getUserId(),other.getUserId())
			.isEquals();
	}
}

