package com.common.tool;

import com.common.datatype.JavaType;

public class JavaUtils {

	/**
	 * 获取JAVA状态
	 * 
	 * @param jt
	 * @return
	 */
	public static JavaType getStatus(JavaType jt) {
		Runtime run = Runtime.getRuntime();
		double freeMemory = (double) run.freeMemory() / (1024 * 1024);
		double totalMemory = (double) run.totalMemory() / (1024 * 1024);
		jt.setVmTotalMemory(totalMemory);
		jt.setVmFreeMemory(freeMemory);
		return jt;
	}

	/**
	 * 获取JAVA参数
	 * 
	 * @param jt
	 * @return
	 */
	public static JavaType getVariables(JavaType jt) {
		Runtime run = Runtime.getRuntime();
		jt.setRuntimeName(System.getProperty("java.runtime.name"));
		jt.setSpecificationVendor(System
				.getProperty("java.vm.specification.vendor"));
		jt.setVmName(System.getProperty("java.vm.name"));
		jt.setRuntimeVersion(System.getProperty("java.runtime.version"));
		jt.setUserCountry(System.getProperty("user.country"));
		jt.setUserCountry(System.getProperty("user.language"));
		jt.setOsName(System.getProperty("os.name"));
		jt.setOsVersion(System.getProperty("os.version"));
		jt.setOsArch(System.getProperty("os.arch"));
		jt.setJnuEncoding(System.getProperty("sun.jnu.encoding"));
		jt.setFileEncoding(System.getProperty("file.encoding"));
		double totalMemory = (double) run.totalMemory() / (1024 * 1024);
		jt.setVmTotalMemory(totalMemory);
		return jt;
	}

}
