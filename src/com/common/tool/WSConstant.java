package com.common.tool;

/*
 * 创建日期 2008-11-19
 * @author zhangjb
 */
public class WSConstant {
	/**
	 * 命名空间，在客户端需要用它创建OMNamespace，再创建OMElement；
	 * 在服务端接收到OMElement后，需要用到相同命名的OMNamespace， 所以在客户端与服务端要统一使用同一个名称
	 * 
	 * 使用方：客户端、服务端
	 */
	public static String NAMESPACE = "http://service.demo.webservice.tdp.toone.com";

	/**
	 * 根标签，在发送消息给服务端时，以此为根标签 在创建OMNamespace时用到
	 * 
	 * 使用方：客户端、服务端
	 */
	public static String TAG_ROOT_PREFIX = "wstns";

	/**
	 * 作为跟在Tag_root冒号后的前缀， 如：<wstns:wsroot
	 * xmlns:tns="http://service.test1.server">
	 * 
	 * 使用方：客户端、服务端
	 */
	public static String TAG_ROOT = "wsroot";

	/**
	 * 用来标记为参数类型的TAG
	 */
	public static String TAG_PARAMTYPE = "wsparamType";
	// 参数类型
	public static String PARAMTYPE_STR = "wsstring"; // 参数中的原子对象为字符串
	public static String PARAMTYPE_MODEL = "wsmodel"; // 参数中的原子对象为自定义对象

	/**
	 * 用来标记为普通字符串的Tag
	 * 
	 * 使用方：客户端
	 */
	public static String TAG_STR = "wsstr";

	/**
	 * 用来标记为自定义对象的Tag
	 * 
	 * 使用方：客户端、服务端
	 */
	public static String TAG_MODEL = "wsmodel";

	/**
	 * 用于拼接target EndpointReference target
	 * EndpointReference构造串形如：http://www.toone
	 * .com.cn:8000/services/WSTest1Service 其中：
	 * http://www.toone.com.cn:8000在界面配置，存在数据库中，可以取到
	 * WSTest1Service为服务名，也在界面配置，存在数据库中，也可以取到
	 * 
	 * 使用方：客户端
	 */
	public static String TARGET_CON_STR = "services";
}
