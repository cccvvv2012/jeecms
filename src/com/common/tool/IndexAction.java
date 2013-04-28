package com.common.tool;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionContext;

@Component("htindexAction")
@Scope("prototype")
public class IndexAction extends StrongActionSupport {

	private static final long serialVersionUID = -6354020537482101532L;

	// private static Logger logger =
	// Logger.getLogger(IndexAction.class.getName());

	@Override
	public String execute() throws Exception {
		ActionContext ctx = ActionContext.getContext();
		// 获取浏览器版本
		// System.out.println(ServletActionContext.getServletContext().getServerInfo());
		// System.out.println(ServletActionContext.getServletContext().getContextPath());
		// System.out.println(ServletActionContext.getRequest().getRequestURL());
		// System.out.println(System.getProperty("os.name"));;
		String strUserAgent = ServletActionContext.getRequest().getHeader(
				"user-agent").toLowerCase();
		if (strUserAgent.indexOf("firefox") > 0) {
			strUserAgent = "-ff";
		} else {
			strUserAgent = "";
		}
		ctx.put("strUserAgent", strUserAgent);
		// logger.info(ServletActionContext.getRequest().getRemoteAddr() +
		// "打开后台管理界面");
		// 如果存在用户信息 则进入主界面 否则转入登录界面
		// if (ctx.getSession().get(Constants.SESSION_YONG_HU) != null) {
		return SUCCESS;
		// } else {
		// this.setStrAction("sht_DengLu_XianShi");
		// return TIAOZHUAN_ACTION;
		// }
	}

	public String js() {
		return JAVASCRIPT;
	}
}
