package com.common.datatype;

import java.util.Properties;

//java.version  Java 运行时环境版本
//java.vendor   Java 运行时环境供应商
//java.vendor.url   Java 供应商的 URL
//java.home   Java 安装目录
//java.vm.specification.version   Java 虚拟机规范版本
//java.vm.specification.vendor  Java 虚拟机规范供应商
//java.vm.specification.name  Java 虚拟机规范名称
//java.vm.version   Java 虚拟机实现版本
//java.vm.vendor  Java 虚拟机实现供应商
//java.vm.name  Java 虚拟机实现名称
//java.specification.version  Java 运行时环境规范版本
//java.specification.vendor   Java 运行时环境规范供应商
//java.specification.name   Java 运行时环境规范名称
//java.class.version  Java 类格式版本号
//java.class.path   Java 类路径
//java.library.path   加载库时搜索的路径列表
//java.io.tmpdir  默认的临时文件路径
//java.compiler   要使用的 JIT 编译器的名称
//java.ext.dirs   一个或多个扩展目录的路径
//os.name   操作系统的名称
//os.arch   操作系统的架构
//os.version  操作系统的版本
//file.separator  文件分隔符（在 UNIX 系统中是“/”）
//path.separator  路径分隔符（在 UNIX 系统中是“:”）
//line.separator  行分隔符（在 UNIX 系统中是“/n”）
//user.name   用户的账户名称
//user.home   用户的主目录
//user.dir  用户的当前工作目录
//java.runtime.name=JAVA运行名称Java(TM) SE Runtime Environment
//java.vm.name=JAVA虚拟机名称Java HotSpot(TM) 64-Bit Server VM
//java.runtime.version=JAVA运行版本1.6.0_17-b04
//user.country=用户所在国家代码CN
//user.language=用户语言zh
//sun.jnu.encoding=JAVA运行编码UTF-8
//file.encoding=使用文件编码UTF-8
public class JavaType {
	public static void main(String[] args) {
		// Scanner input = new Scanner(System.in);
		// int arr[] = new int[1000];
		// for (int i = 1; i <= arr.length; i++) {
		// System.out.println("输出数字：" + i);
		// }
		Runtime run = Runtime.getRuntime();

		double freeMemory = (double) run.freeMemory() / (1024 * 1024);
		double totalMemory = (double) run.totalMemory() / (1024 * 1024);
		double usedMemory = totalMemory - freeMemory;
		double percentFree = (freeMemory / totalMemory) * 100.0;
		int free = 100 - (int) Math.round(percentFree);
		System.out.println("JVM总内存是：" + totalMemory);
		System.out.println("剩余内存是：" + freeMemory);
		System.out.println("已使用内存是：" + usedMemory);
		System.out.println("内存使用百分比：" + free + "%");
		// 通过获得系统属性构造属性类 prop
		Properties prop = new Properties(System.getProperties());
		// 在标准输出中输出系统属性的内容
		prop.list(System.out);
		// System.out.println(System.getProperty("sun.cpu.isalist") + "====");
	}
	private String Version;// Java 运行时环境版本
	private String Vendor;// Java 运行时环境供应商
	private String VendorUrl;// Java 供应商的 URL
	private String Home;// Java 安装目录
	private String VmSpecificationVersion;// Java 虚拟机规范版本
	private String VmSpecificationVendor;// Java 虚拟机规范供应商
	private String VmSpecificationName;// Java 虚拟机规范名称
	private String VmSersion;// Java 虚拟机实现版本
	private String VmSendor;// Java 虚拟机实现供应商
	private String VmSame;// Java 虚拟机实现名称
	private double VmTotalMemory;// java虚拟机总内存
	private double VmFreeMemory;// java虚拟机可用内容
	private double VmUsedMemory;// java虚拟机已用内容
	private double VmUsedPercent;// java虚拟机已用内存百分比
	private String SpecificationVersion;// Java 运行时环境规范版本
	private String SpecificationVendor;// Java 运行时环境规范供应商
	private String SpecificationName;// Java 运行时环境规范名称
	private String ClassVersion;// Java 类格式版本号
	private String ClassPath;// Java 类路径
	private String LibraryPath;// 加载库时搜索的路径列表
	private String IoTmpdir;// 默认的临时文件路径
	private String Compiler;// 要使用的 JIT 编译器的名称
	private String ExtDirs;// 一个或多个扩展目录的路径
	private String OsName;// 操作系统的名称
	private String OsArch;// 操作系统的架构
	private String OsVersion;// 操作系统的版本
	private String FileSeparator;// 文件分隔符（在 UNIX 系统中是“/”）
	private String PathSeparator;// 路径分隔符（在 UNIX 系统中是“:”）
	private String LineSeparator;// 行分隔符（在 UNIX 系统中是“/n”）
	private String UserName;// 用户的账户名称
	private String UserHome;// 用户的主目录
	private String UserDir;// 用户的当前工作目录
	private String RuntimeName;// =JAVA运行名称Java(TM) SE Runtime Environment
	private String VmName;// JAVA虚拟机名称Java HotSpot(TM) 64-Bit Server VM
	private String RuntimeVersion;// JAVA运行版本1.6.0_17-b04
	private String UserCountry;// 用户所在国家代码CN
	private String UserLanguage;// 用户语言zh
	private String JnuEncoding;// JAVA运行编码UTF-8

	private String FileEncoding;// 使用文件编码UTF-8

	public String getClassPath() {
		return ClassPath;
	}

	public String getClassVersion() {
		return ClassVersion;
	}

	public String getCompiler() {
		return Compiler;
	}

	public String getExtDirs() {
		return ExtDirs;
	}

	public String getFileEncoding() {
		return FileEncoding;
	}

	public String getFileSeparator() {
		return FileSeparator;
	}

	public String getHome() {
		return Home;
	}

	public String getIoTmpdir() {
		return IoTmpdir;
	}

	public String getJnuEncoding() {
		return JnuEncoding;
	}

	public String getLibraryPath() {
		return LibraryPath;
	}

	public String getLineSeparator() {
		return LineSeparator;
	}

	public String getOsArch() {
		return OsArch;
	}

	public String getOsName() {
		return OsName;
	}

	public String getOsVersion() {
		return OsVersion;
	}

	public String getPathSeparator() {
		return PathSeparator;
	}

	public String getRuntimeName() {
		return RuntimeName;
	}

	public String getRuntimeVersion() {
		return RuntimeVersion;
	}

	public String getSpecificationName() {
		return SpecificationName;
	}

	public String getSpecificationVendor() {
		return SpecificationVendor;
	}

	public String getSpecificationVersion() {
		return SpecificationVersion;
	}

	public String getUserCountry() {
		return UserCountry;
	}

	public String getUserDir() {
		return UserDir;
	}

	public String getUserHome() {
		return UserHome;
	}

	public String getUserLanguage() {
		return UserLanguage;
	}

	public String getUserName() {
		return UserName;
	}

	public String getVendor() {
		return Vendor;
	}

	public String getVendorUrl() {
		return VendorUrl;
	}

	public String getVersion() {
		return Version;
	}

	public double getVmFreeMemory() {
		return VmFreeMemory;
	}

	public String getVmName() {
		return VmName;
	}

	public String getVmSame() {
		return VmSame;
	}

	public String getVmSendor() {
		return VmSendor;
	}

	public String getVmSersion() {
		return VmSersion;
	}

	public String getVmSpecificationName() {
		return VmSpecificationName;
	}

	public String getVmSpecificationVendor() {
		return VmSpecificationVendor;
	}

	public String getVmSpecificationVersion() {
		return VmSpecificationVersion;
	}

	public double getVmTotalMemory() {
		return VmTotalMemory;
	}

	public double getVmUsedMemory() {
		if (this.VmFreeMemory > 0 && this.VmTotalMemory > 0
				&& this.VmTotalMemory > this.VmFreeMemory) {
			return this.VmTotalMemory - this.VmFreeMemory;
		} else {
			return VmUsedMemory;
		}
	}

	public double getVmUsedPercent() {
		if (this.VmFreeMemory > 0 && this.VmTotalMemory > 0
				&& this.VmTotalMemory > this.VmFreeMemory) {
			return (this.VmTotalMemory - this.VmFreeMemory)
					/ this.VmTotalMemory * 100;
		} else {
			return VmUsedPercent;
		}
	}

	public void setClassPath(String classPath) {
		ClassPath = classPath;
	}

	public void setClassVersion(String classVersion) {
		ClassVersion = classVersion;
	}

	public void setCompiler(String compiler) {
		Compiler = compiler;
	}

	public void setExtDirs(String extDirs) {
		ExtDirs = extDirs;
	}

	public void setFileEncoding(String fileEncoding) {
		FileEncoding = fileEncoding;
	}

	public void setFileSeparator(String fileSeparator) {
		FileSeparator = fileSeparator;
	}

	public void setHome(String home) {
		Home = home;
	}

	public void setIoTmpdir(String ioTmpdir) {
		IoTmpdir = ioTmpdir;
	}

	public void setJnuEncoding(String jnuEncoding) {
		JnuEncoding = jnuEncoding;
	}

	public void setLibraryPath(String libraryPath) {
		LibraryPath = libraryPath;
	}

	public void setLineSeparator(String lineSeparator) {
		LineSeparator = lineSeparator;
	}

	public void setOsArch(String osArch) {
		OsArch = osArch;
	}

	public void setOsName(String osName) {
		OsName = osName;
	}

	public void setOsVersion(String osVersion) {
		OsVersion = osVersion;
	}

	public void setPathSeparator(String pathSeparator) {
		PathSeparator = pathSeparator;
	}

	public void setRuntimeName(String runtimeName) {
		RuntimeName = runtimeName;
	}

	public void setRuntimeVersion(String runtimeVersion) {
		RuntimeVersion = runtimeVersion;
	}

	public void setSpecificationName(String specificationName) {
		SpecificationName = specificationName;
	}

	public void setSpecificationVendor(String specificationVendor) {
		SpecificationVendor = specificationVendor;
	}

	public void setSpecificationVersion(String specificationVersion) {
		SpecificationVersion = specificationVersion;
	}

	public void setUserCountry(String userCountry) {
		UserCountry = userCountry;
	}

	public void setUserDir(String userDir) {
		UserDir = userDir;
	}

	public void setUserHome(String userHome) {
		UserHome = userHome;
	}

	public void setUserLanguage(String userLanguage) {
		UserLanguage = userLanguage;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public void setVendor(String vendor) {
		Vendor = vendor;
	}

	public void setVendorUrl(String vendorUrl) {
		VendorUrl = vendorUrl;
	}

	public void setVersion(String version) {
		Version = version;
	}

	public void setVmFreeMemory(double vmFreeMemory) {
		VmFreeMemory = vmFreeMemory;
	}

	public void setVmName(String vmName) {
		VmName = vmName;
	}

	public void setVmSame(String vmSame) {
		VmSame = vmSame;
	}

	public void setVmSendor(String vmSendor) {
		VmSendor = vmSendor;
	}

	public void setVmSersion(String vmSersion) {
		VmSersion = vmSersion;
	}

	public void setVmSpecificationName(String vmSpecificationName) {
		VmSpecificationName = vmSpecificationName;
	}

	public void setVmSpecificationVendor(String vmSpecificationVendor) {
		VmSpecificationVendor = vmSpecificationVendor;
	}

	public void setVmSpecificationVersion(String vmSpecificationVersion) {
		VmSpecificationVersion = vmSpecificationVersion;
	}

	public void setVmTotalMemory(double vmTotalMemory) {
		VmTotalMemory = vmTotalMemory;
	}

	public void setVmUsedMemory(double vmUsedMemory) {
		VmUsedMemory = vmUsedMemory;
	}

	public void setVmUsedPercent(double vmUsedPercent) {
		VmUsedPercent = vmUsedPercent;
	}
}
