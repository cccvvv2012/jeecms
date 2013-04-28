package com.common.interceptor.security;


import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class SecurityInterceptor extends AbstractInterceptor {

	/**
   * 
   */
	private static final long serialVersionUID = 4768589931958157389L;
	private static Log log = LogFactory.getLog(SecurityInterceptor.class);

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// 取得请求的Action名
		String name = invocation.getInvocationContext().getName();
		// 获取到namespace，还能够获取到要执行的方法，class等
		String namespace = invocation.getProxy().getNamespace();
		if ((namespace != null) && (namespace.trim().length() > 0)) {
			if ("/".equals(namespace.trim())) {
				// 说明是根路径，不需要再增加反斜杠了。
			} else {
				namespace += "/";
			}
		}
		String URL = namespace + invocation.getProxy().getActionName();

		URL += ".action";
		// System.out.println(txtqxDAO);
		log.debug("actionname=" + name + "||fullActionName=" + URL);

		if (name.equals("login") || name.equals("loginAccess")) {
			// 如果用户想登录，则使之通过
			return invocation.invoke();
		}
		Map session = invocation.getInvocationContext().getSession();
		// TODO 在这里判断用户是否已经登陆,更改此方法，和OnLineUserManager联系起来，
		// OnLineUserManager 是线程安全的，效率上可能会比较低！所以暂时还不更改！。
		// String success = (String) session.get(QxglConstants.AUTH_SUCCESS);
		//
		// log.debug("success=" + success);
		//
		// // 如果没有登陆，那么就退出系统
		// if (success == null || !"true".equals(success)) {
		// log.debug("please login");
		// return Action.LOGIN;
		// }
		//
		// String userid = (String) session.get("userid");
		// if (userid == null || "".equals(userid)) {
		// log.error("用户id不能为空!");
		// return Action.LOGIN;
		// }
		//
		// // 如果是超级管理员，那么直接返回
		// if ("admin1111222233334444555566admin".equals(userid)) {
		// return invocation.invoke();
		// }
		//
		// UserModelServiceDao userModelServiceDao = (UserModelServiceDao)
		// MyBeanUtil.getBean("userModelServiceDao");
		// // 获取当前用户所拥有的角色
		// List<QxglRole> userRoles = userModelServiceDao.getRoles(userid);
		//
		// if (userRoles == null || userRoles.size() < 1) {
		// // 没有任何角色
		// log.warn("此用户" + userid + "没有任何角色，没有权限执行任何功能");
		// return "noPermit";
		// }
		//
		// List<QxglRole> urlRoles = userModelServiceDao.getRolesByUrl(URL);
		//
		// // 如果此URL没有赋给任何角色，说明是合法用户就可以访问
		// if (urlRoles == null || urlRoles.size() < 1) {
		// log.debug("此资源未赋给任何角色，合法用户就可以访问");
		// return invocation.invoke();
		// }
		//
		// // 根据角色来判断用户是否有权限来使用当前的URL（action）
		// boolean flag = false;// 如果有权限访问设置为true；
		// int userLen = userRoles.size();
		// int urlLen = urlRoles.size();
		// QxglRole tempUserRole = null;
		// QxglRole tempUrlRole = null;
		//
		// START: for (int i = 0; i < userLen; i++) {
		// // 首先初始化
		// tempUserRole = null;
		// tempUrlRole = null;
		// tempUserRole = userRoles.get(i);
		// for (int j = 0; j < urlLen; j++) {
		// tempUrlRole = urlRoles.get(j);
		// if (tempUserRole.getId().equals(tempUrlRole.getId())) {
		// flag = true;
		// break START;
		// }
		// }
		// }
		// if (flag) {
		// log.debug("success auth");
		// return invocation.invoke();
		// } else {
		// //
		// 用户如果在主页面中输入其他的任何链接，系统将自动执行logout动作，因为在/sysmenu/top.jsp中配置了onunload事件。
		// log.warn("此用户" + userid + "没有权限执行此功能" + URL);
		// return "noPermit";
		// }
		return invocation.invoke();
	}

}
