package com.common.interceptor.exception;


import java.io.IOException;
import java.sql.SQLException;
import java.util.Locale;

import org.springframework.dao.DataAccessException;

import com.common.tool.StrongException;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.opensymphony.xwork2.util.LocalizedTextUtil;

public class ExceptionInterceptor extends AbstractInterceptor {

	private static final long serialVersionUID = -1728301555948986447L;

	// 定义错误类型在资源文件中的名称
	public static final String Exception_MESSAGE = "Exception_MESSAGE";
	public static final String DataAccessException_MESSAGE = "DataAccessException_MESSAGE";
	public static final String NullPointerException_MESSAGE = "NullPointerException_MESSAGE";
	public static final String IOException_MESSAGE = "IOException_MESSAGE";
	public static final String ClassNotFoundException_MESSAGE = "ClassNotFoundException_MESSAGE";
	public static final String ArithmeticException_MESSAGE = "ArithmeticException_MESSAGE";
	public static final String ArrayIndexOutOfBoundsException_MESSAGE = "ArrayIndexOutOfBoundsException_MESSAGE";
	public static final String IllegalArgumentException_MESSAGE = "IllegalArgumentException_MESSAGE";
	public static final String ClassCastException_MESSAGE = "ClassCastException_MESSAGE";
	public static final String SecurityException_MESSAGE = "SecurityException_MESSAGE";
	public static final String SQLException_MESSAGE = "SQLException_MESSAGE";
	public static final String NoSuchMethodError_MESSAGE = "NoSuchMethodError_MESSAGE";
	public static final String InternalError_MESSAGE = "InternalError_MESSAGE";

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		String result = "";
		Locale strLocale = invocation.getInvocationContext().getLocale();
		try {
			result = invocation.invoke();
		} catch (DataAccessException ex) {
			throw new StrongException(LocalizedTextUtil.findDefaultText(
					DataAccessException_MESSAGE, strLocale));
		} catch (NullPointerException ex) {
			throw new StrongException(LocalizedTextUtil.findDefaultText(
					NullPointerException_MESSAGE, strLocale));
		} catch (IOException ex) {
			throw new StrongException(LocalizedTextUtil.findDefaultText(
					IOException_MESSAGE, strLocale));
		} catch (ClassNotFoundException ex) {
			throw new StrongException(LocalizedTextUtil.findDefaultText(
					ClassNotFoundException_MESSAGE, strLocale));
		} catch (ArithmeticException ex) {
			throw new StrongException(LocalizedTextUtil.findDefaultText(
					ArithmeticException_MESSAGE, strLocale));
		} catch (ArrayIndexOutOfBoundsException ex) {
			throw new StrongException(LocalizedTextUtil.findDefaultText(
					ArrayIndexOutOfBoundsException_MESSAGE, strLocale));
		} catch (IllegalArgumentException ex) {
			throw new StrongException(LocalizedTextUtil.findDefaultText(
					IllegalArgumentException_MESSAGE, strLocale));
		} catch (ClassCastException ex) {
			throw new StrongException(LocalizedTextUtil.findDefaultText(
					ClassCastException_MESSAGE, strLocale));
		} catch (SecurityException ex) {
			throw new StrongException(LocalizedTextUtil.findDefaultText(
					SecurityException_MESSAGE, strLocale));
		} catch (SQLException ex) {
			throw new StrongException(LocalizedTextUtil.findDefaultText(
					SQLException_MESSAGE, strLocale));
		} catch (NoSuchMethodError ex) {
			throw new StrongException(LocalizedTextUtil.findDefaultText(
					NoSuchMethodError_MESSAGE, strLocale));
		} catch (InternalError ex) {
			throw new StrongException(LocalizedTextUtil.findDefaultText(
					InternalError_MESSAGE, strLocale));
		} catch (StrongException ex) {
			throw new StrongException(LocalizedTextUtil.findDefaultText(ex
					.getMessage(), strLocale));
		} catch (Exception ex) {
			throw new StrongException(LocalizedTextUtil.findDefaultText(
					Exception_MESSAGE, strLocale));
		}
		return result;
	}

}
