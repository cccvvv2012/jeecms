package com.common.base;

import org.apache.struts.action.ActionForm;
 
public class BaseForm extends ActionForm {
	private static final long serialVersionUID = 1L;
	private int fid;
	private String keyword;
	private String[] chkId;
	private String condition; // ��ѯ����
	private int pageNo; // �ڼ�ҳ
	private int pageSize = 20; // ÿҳ��ʾ������¼
	private String stat;// Ŀǰҳ��״̬
	private String pagename;// ���������
	private Integer forder;// �������
	private String msg;// ������Ϣ
	private String remark;

	public String[] getChkId() {
		return chkId;
	}

	public String getCondition() {
		return condition;
	}

	public Integer getForder() {
		return forder;
	}

	public int getPageNo() {
		return pageNo;
	}

	public String getRemark() {
		return remark;
	}

	public void setChkId(String[] chkId) {
		this.chkId = chkId;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public void setForder(Integer forder) {
		this.forder = forder;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}


}