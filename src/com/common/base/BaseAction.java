package com.common.base;

import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

public class BaseAction extends DispatchAction {

	public String txt = "yyyy-MM-dd HH:mm:ss";
	public SimpleDateFormat fmt = new SimpleDateFormat(txt);
	public int maxID = 0;
	public BaseIbatis baseTool = new BaseIbatis();

	 
	public void epln(Object obj) {
		System.err.println(obj);
	}

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Object fname = request.getSession().getAttribute("fname");
		if (fname == null)
			return mapping.findForward("login");
		else
			return super.execute(mapping, form, request, response);
	}

	// ��ҳҳ��
	public int getPageCount(int pageSize, int count) {
		return baseTool.getPageCount(pageSize, count);
	}

	public void pln(Object obj) {
		System.out.println(obj);
	}

	public ActionForward unspecified(
			org.apache.struts2.dispatcher.mapper.ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
