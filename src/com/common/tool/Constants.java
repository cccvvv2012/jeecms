package com.common.tool;

import java.util.Map;
import java.util.TreeMap;

public class Constants {

	/** ==============定义异常类型常量============== * */
	public static final String VALIDATION_BI_TIAN = "VALIDATION_BI_TIAN";
	public static final String VALIDATION_ZHENG_SHU = "VALIDATION_ZHENG_SHU";
	public static final String VALIDATION_FU_DIAN = "VALIDATION_FU_DIAN";
	public static final String VALIDATION_RI_QI = "VALIDATION_RI_QI";
	public static final String VALIDATION_YOU_JIAN = "VALIDATION_YOU_JIAN";
	public static final String VALIDATION_WANG_ZHI = "VALIDATION_WANG_ZHI";
	public static final String VALIDATION_ZI_DING_YI = "VALIDATION_ZI_DING_YI";
	public static final String VALIDATION_ZI_FU_CHANG_DU = "VALIDATION_ZI_FU_CHANG_DU";
	public static final String VALIDATION_SHU_ZI_DA_XIAO = "VALIDATION_SHU_ZI_DA_XIAO";
	public static final String VALIDATION_DENG_LU_MING = "VALIDATION_DENG_LU_MING";
	public static final String VALIDATION_CHAO_CHANG = "VALIDATION_CHAO_CHANG";
	public static final String VALIDATION_CUO_WU_LEI_XING = "VALIDATION_CUO_WU_LEI_XING";
	public static final String VALIDATION_WEI_ZHI_CUO_WU = "VALIDATION_WEI_ZHI_CUO_WU";

	/** ==============定义了逻辑异常常量============== * */
	// 返回上一页JS
	public static final String STRONG_FAN_HUI_SHANG_YI_YE = "STRONG_FAN_HUI_SHANG_YI_YE";
	// 用户未登录
	public static final String STRONG_WEI_DENG_LU = "STRONG_WEI_DENG_LU";
	// 用户登录失败 请检查登录名、密码是否正确
	public static final String STRONG_DENG_LU_SHI_BAI = "STRONG_DENG_LU_SHI_BAI";
	// 没有权限
	public static final String STRONG_MEI_YOU_QUAN_XIAN = "STRONG_MEI_YOU_QUAN_XIAN";
	// 用户登录超时
	public static final String STRONG_DENG_LU_CHAO_SHI = "STRONG_DENG_LU_CHAO_SHI";
	// 信息输入不完整
	public static final String STRONG_XIN_XI_BU_WAN_ZHENG = "STRONG_XIN_XI_BU_WAN_ZHENG";
	// 已参加过考试
	public static final String STRONG_YI_KAO_SHI = "STRONG_YI_KAO_SHI";
	// 考试系统验证错误，请使用专用的考试软件进行考试
	public static final String STRONG_KAO_SHI_YAN_ZHENG = "STRONG_KAO_SHI_YAN_ZHENG";
	// 下载失败
	public static final String STRONG_XIA_ZAI_SHI_BAI = "STRONG_XIA_ZAI_SHI_BAI";

	/** ==============定义了系统Session常量名称============== * */
	public static final String SESSION_YONG_HU = "SESSION_YONG_HU";

	/** ==============定义了系统Application常量名称============== * */
	// 系统Application名称
	public static final String APPLICATION_SYSTEM = "APPLICATION_SYSTEM";
	// 数据库用户名
	public static final String APPLICATION_HIBERNATE_CONNECTION_USERNAME = "hibernate.connection.username";
	// 数据库密码
	public static final String APPLICATION_HIBERNATE_CONNECTION_PASSWORD = "hibernate.connection.password";
	// 数据库连接URL
	public static final String APPLICATION_HIBERNATE_CONNECTION_URL = "hibernate.connection.url";
	// 数据库状态列表
	public static final String APPLICATION_SHU_JU_KU_ZHUANG_TAI_LIE_BIAO = "APPLICATION_SHU_JU_KU_ZHUANG_TAI_LIE_BIAO";
	// 数据库参数
	public static final String APPLICATION_SHU_JU_CAN_SHU = "APPLICATION_SHU_JU_CAN_SHU";
	// 上传文件相对路径
	public static final String APPLICATION_SHANG_CHUAN_XIANG_DUI_LU_JING = "APPLICATION_SHANG_CHUAN_XIANG_DUI_LU_JING";
	// 数据库备份文件绝对路径
	public static final String APPLICATION_SHU_JU_KU_BEI_FEN_LU_JING = "APPLICATION_SHU_JU_KU_BEI_FEN_LU_JING";
	// mysql执行文件地址
	public static final String APPLICATION_MYSQL_DI_ZHI = "APPLICATION_MYSQL_DI_ZHI";
	// mysqldump执行文件地址
	public static final String APPLICATION_MYSQLDUMP_DI_ZHI = "APPLICATION_MYSQLDUMP_DI_ZHI";
	// 是否开启自动备份
	public static final String APPLICATION_KAI_QI_ZI_DONG_BEI_FEN = "APPLICATION_KAI_QI_ZI_DONG_BEI_FEN";
	// JAVA环境参数
	public static final String APPLICATION_JAVA_CAN_SHU = "APPLICATION_JAVA_CAN_SHU";
	// JAVA环境状态列表
	public static final String APPLICATION_JAVA_ZHUANG_TAI_LIE_BIAO = "APPLICATION_JAVA_ZHUANG_TAI_LIE_BIAO";
	// 系统环境参数
	public static final String APPLICATION_XI_TONG_CAN_SHU = "APPLICATION_XI_TONG_CAN_SHU";
	// 系统环境状态列表
	public static final String APPLICATION_XI_TONG_ZHUANG_TAI_LIE_BIAO = "APPLICATION_XI_TONG_ZHUANG_TAI_LIE_BIAO";
	// 系统逻辑日志路径
	public static final String APPLICATION_LUO_JI_RI_ZHI_LU_JING = "log4j.appender.A1.File";
	// 系统名称
	public static final String APPLICATION_XI_TONG_MING_CHENG = "APPLICATION_XI_TONG_MING_CHENG";
	// 使用单位
	public static final String APPLICATION_SHI_YONG_DAN_WEI = "APPLICATION_SHI_YONG_DAN_WEI";
	/** ==============定义了系统选项常量============== * */
	// 定义选项分类
	public static final Map<String, String> TXX_LIE_BIAO = getTxxMap();
	public static final String XX_GUANG_WEI = "001";
	public static final String XX_SHE_BEI = "002";
	public static final String XX_WAI_LAI_DA_WEI = "003";

	public static final String XING_BIE_NAN = "01";

	public static final String XING_BIE_NV = "02";
	public static final Map<String, String> XING_BIE = getXingBieMap();
	public static final Map<String, String> SHI_FOU = getShiFouMap();

	public static final String SHI_FOU_SHI = "00";

	public static final String SHI_FOU_FOU = "01";
	/** ==============定义了系统基本常量============== * */
	public static final String SHANG_CHUAN_XIANG_DUI_LU_JING = "/uploadfile";
	public static final String[] FEN_YE_TI_SHI = { "共", "页", "条", "首页", "上一页",
			"下一页", "末页" };

	public static final Integer FEN_YE_DA_XIAO = 20;

	public static final String YAN_SE_DUI_BI[] = { "#990033", "#660099",
			"#990066", "#0000CC", "#000033", "#CC0033", "#CC3300", "#FF0000",
			"#009933", "#00CC00", "#FF00CC", "#3366CC", "#000033", "#FF0000",
			"#FF3300", "#FF3333" };
	// 上传图片最大大小
	public static final Integer TU_PIAN_DA_XIAO_XIAN_ZHI = 2000000;
	public static final Map<String, String> getShiFouMap() {
		Map<String, String> ShiFou = new TreeMap<String, String>();
		ShiFou.put("00", "否");
		ShiFou.put("01", "是");
		return ShiFou;
	}
	public static final Map<String, String> getTxxMap() {
		Map<String, String> TXX_LIE_BIAO = new TreeMap<String, String>();
		TXX_LIE_BIAO.put(XX_GUANG_WEI, "省份");
		TXX_LIE_BIAO.put(XX_SHE_BEI, "核武种类");
		TXX_LIE_BIAO.put(XX_WAI_LAI_DA_WEI, "生化武器种类");
		return TXX_LIE_BIAO;
	}
	public static final Map<String, String> getXingBieMap() {
		Map<String, String> XingBie = new TreeMap<String, String>();
		XingBie.put(XING_BIE_NAN, "女");
		XingBie.put(XING_BIE_NV, "男");
		return XingBie;
	}

}
