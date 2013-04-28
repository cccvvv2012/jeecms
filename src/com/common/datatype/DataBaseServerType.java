package com.common.datatype;

import java.util.Map;

public class DataBaseServerType {
	private Integer intChaXunShu; // 当前查询数
	private Integer intZuiDaChaXunShu; // 最大查询数
	private Integer intLianJieShu; // 当前线程数
	private Integer intZuiDaLianJieShu; // 最大线程数
	private String strBanBen; // 数据库版本 含机器版本
	private int intYunXingShiJian; // 数据库已经运行时间
	private String strYuYan; // 数据库语言
	private String strLianJieYuYan; // 连接语言
	private String strCaoZuoXitongBanBen; // 操作系统版本
	private Map<String, String> mapVariables; // 系统参数map
	private Map<String, String> mapStatus; // 系统参数map

	public Integer getIntChaXunShu() {
		return intChaXunShu;
	}

	public Integer getIntLianJieShu() {
		return intLianJieShu;
	}

	public int getIntYunXingShiJian() {
		return intYunXingShiJian;
	}

	public Integer getIntZuiDaChaXunShu() {
		return intZuiDaChaXunShu;
	}

	public Integer getIntZuiDaLianJieShu() {
		return intZuiDaLianJieShu;
	}

	public Map<String, String> getMapStatus() {
		return mapStatus;
	}

	public Map<String, String> getMapVariables() {
		return mapVariables;
	}

	public String getStrBanBen() {
		return strBanBen;
	}

	public String getStrCaoZuoXitongBanBen() {
		return strCaoZuoXitongBanBen;
	}

	public String getStrLianJieYuYan() {
		return strLianJieYuYan;
	}

	public String getStrYuYan() {
		return strYuYan;
	}

	public void setIntChaXunShu(Integer intChaXunShu) {
		this.intChaXunShu = intChaXunShu;
	}

	public void setIntLianJieShu(Integer intLianJieShu) {
		this.intLianJieShu = intLianJieShu;
	}

	public void setIntYunXingShiJian(int intYunXingShiJian) {
		this.intYunXingShiJian = intYunXingShiJian;
	}

	public void setIntZuiDaChaXunShu(Integer intZuiDaChaXunShu) {
		this.intZuiDaChaXunShu = intZuiDaChaXunShu;
	}

	public void setIntZuiDaLianJieShu(Integer intZuiDaLianJieShu) {
		this.intZuiDaLianJieShu = intZuiDaLianJieShu;
	}

	public void setMapStatus(Map<String, String> mapStatus) {
		this.mapStatus = mapStatus;
	}

	public void setMapVariables(Map<String, String> mapVariables) {
		this.mapVariables = mapVariables;
	}

	public void setStrBanBen(String strBanBen) {
		this.strBanBen = strBanBen;
	}

	public void setStrCaoZuoXitongBanBen(String strCaoZuoXitongBanBen) {
		this.strCaoZuoXitongBanBen = strCaoZuoXitongBanBen;
	}

	public void setStrLianJieYuYan(String strLianJieYuYan) {
		this.strLianJieYuYan = strLianJieYuYan;
	}

	public void setStrYuYan(String strYuYan) {
		this.strYuYan = strYuYan;
	}

}
