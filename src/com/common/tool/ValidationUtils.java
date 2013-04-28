package com.common.tool;

import com.opensymphony.xwork2.ActionContext;

public class ValidationUtils {

	// 验证key 与资源文件对应
	public static final String VALIDATION_BI_TIAN = "VALIDATION_BI_TIAN";
	public static final String VALIDATION_ZHENG_SHU = "VALIDATION_ZHENG_SHU";
	public static final String VALIDATION_FU_DIAN = "VALIDATION_FU_DIAN";
	public static final String VALIDATION_RI_QI = "VALIDATION_RI_QI";
	public static final String VALIDATION_RI_QI_SHI_JIAN = "VALIDATION_RI_QI_SHI_JIAN";
	public static final String VALIDATION_SHI_JIAN = "VALIDATION_SHI_JIAN";
	public static final String VALIDATION_YOU_JIAN = "VALIDATION_YOU_JIAN";
	public static final String VALIDATION_WANG_ZHI = "VALIDATION_WANG_ZHI";
	public static final String VALIDATION_ZI_DING_YI = "VALIDATION_ZI_DING_YI";
	public static final String VALIDATION_ZI_FU_CHANG_DU = "VALIDATION_ZI_FU_CHANG_DU";
	public static final String VALIDATION_SHU_ZI_DA_XIAO = "VALIDATION_SHU_ZI_DA_XIAO";
	public static final String VALIDATION_DENG_LU_MING = "VALIDATION_DENG_LU_MING";

	// 验证正则表达式
	public static final String EXPRESSION_YOU_JIAN = "\\b(^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@([A-Za-z0-9-])+(\\.[A-Za-z0-9-]+)*((\\.[A-Za-z0-9]{2,})|(\\.[A-Za-z0-9]{2,}\\.[A-Za-z0-9]{2,}))$)\\b";

	public static Object getValidation(ActionContext ctx) {
		try {
			Object tyhYanZheng = ctx.getSession().get(
					Constants.SESSION_YONG_HU);
			if (tyhYanZheng == null) {
				throw new StrongException(Constants.STRONG_WEI_DENG_LU);
			} else {
				return tyhYanZheng;
			}
		} catch (Exception e) {
			throw new StrongException(Constants.STRONG_WEI_DENG_LU);
		}
	}
}
