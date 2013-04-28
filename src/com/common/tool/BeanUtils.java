package com.common.tool;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.apache.commons.beanutils.PropertyUtils;

public class BeanUtils {

	/**
	 * 将两个Bean中同名的对象绑定
	 * 
	 * @param objFromBean
	 * @param objToBean
	 * @return
	 * @throws ClassNotFoundException
	 */
	@SuppressWarnings("unchecked")
	public static Object bind(Object objFromBean, Object objToBean)
			throws ClassNotFoundException {
		Class classFromBean = Class.forName(objFromBean.getClass().getName());
		Class classToBean = Class.forName(objToBean.getClass().getName());
		Method[] methodsToBean = classToBean.getDeclaredMethods();
		for (int i = 0; i < methodsToBean.length; i++) {
			Method methodToBean = methodsToBean[i];
			String strMethodName = methodToBean.getName();
			if (strMethodName.startsWith("set")) {
				String strGetMethodName = getGetMethodName(strMethodName);
				try {
					Method methodFromBean = classFromBean
							.getDeclaredMethod(strGetMethodName);
					Class classField = classToBean.getDeclaredField(
							getFieldName(strMethodName)).getType();
					if (methodFromBean != null) {
						Object objFromBeanMethod = methodFromBean
								.invoke(objFromBean);
						if (objFromBeanMethod != null
								&& (objFromBeanMethod.getClass().equals(
										classField)
										|| (objFromBeanMethod.getClass()
												.equals(java.sql.Date.class) && classField
												.equals(java.util.Date.class)) || (objFromBeanMethod
										.getClass()
										.equals(java.util.Date.class) && classField
										.equals(java.sql.Date.class)))) {
							if (!objFromBeanMethod.getClass().equals(
									String.class)
									|| (objFromBeanMethod.getClass().equals(
											String.class) && objFromBeanMethod
											.toString().trim().length() > 0)) {
								methodToBean.invoke(objToBean,
										objFromBeanMethod);
							}
						}
					}
				} catch (SecurityException e) {
					// System.out.println(e.getMessage());
				} catch (NoSuchMethodException e) {
					// System.out.println(e.getMessage());
				} catch (IllegalArgumentException e) {
					// System.out.println(e.getMessage());
				} catch (IllegalAccessException e) {
					// System.out.println(e.getMessage());
				} catch (InvocationTargetException e) {
					// System.out.println(e.getMessage());
				} catch (NoSuchFieldException e) {
					// System.out.println(e.getMessage());
				}
			}
		}
		return null;
	}

	public static void copyBeanProperties(Object oldObject, Object newObject) {
		try {
			// BeanUtils.copyProperties(newObject,oldObject);//����File��Doubleʱ��������
			PropertyUtils.copyProperties(newObject, oldObject);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
	}

	public static Object getBeanProperty(Object bean, String name) {
		try {
			return PropertyUtils.getProperty(bean, name);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 根据方法名得到其对应的field名
	 * 
	 * @param strMethodName
	 * @return
	 */
	public static String getFieldName(String strMethodName) {
		if (strMethodName.startsWith("set") || strMethodName.startsWith("get")) {
			StringBuffer strTemp = new StringBuffer("");
			strTemp.append(strMethodName.substring(3, 4).toLowerCase());
			strTemp.append(strMethodName.substring(4, strMethodName.length()));
			return strTemp.toString();
		} else {
			return null;
		}
	}

	/**
	 * 根据方法名得到get的方法名
	 * 
	 * @param strMethodName
	 * @return
	 */
	public static String getGetMethodName(String strMethodName) {
		if (strMethodName.startsWith("set") || strMethodName.startsWith("get")) {
			StringBuffer strTemp = new StringBuffer("get");
			strTemp.append(strMethodName.substring(3, strMethodName.length()));
			return strTemp.toString();
		} else {
			return null;
		}
	}

	/**
	 * 根据方法名得到set的方法名
	 * 
	 * @param strMethodName
	 * @return
	 */
	public static String getSetMethodName(String strMethodName) {
		if (strMethodName.startsWith("set") || strMethodName.startsWith("get")) {
			StringBuffer strTemp = new StringBuffer("set");
			strTemp.append(strMethodName.substring(3, strMethodName.length()));
			return strTemp.toString();
		} else {
			return null;
		}
	}
}
