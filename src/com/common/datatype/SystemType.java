package com.common.datatype;

import java.util.Map;

import org.hyperic.sigar.CpuInfo;
import org.hyperic.sigar.CpuPerc;
import org.hyperic.sigar.Mem;
import org.hyperic.sigar.NetInterfaceConfig;
import org.hyperic.sigar.NetInterfaceStat;
import org.hyperic.sigar.OperatingSystem;
import org.hyperic.sigar.Swap;

public class SystemType {

	private String serverInfo; // WEB容器版本

	private DataBaseServerType dbsType; // 数据库参数
	private JavaType javaType; // JAVA参数
	private CpuPerc[] cpuPercs;
	private CpuInfo[] cpuInfos;
	private double[] cpuCombined;
	private Mem mem;
	private Swap swap;
	private double uptime;
	private OperatingSystem sys;

	private String[] netNames; // 网络设备名称
	private Map<String, NetInterfaceConfig> netConfigs;
	private Map<String, NetInterfaceStat> netStats;
	private Map<String, Double> netRxSpeed;
	private Map<String, Double> netTxSpeed;

	public double[] getCpuCombined() {
		return cpuCombined;
	}

	public CpuInfo[] getCpuInfos() {
		return cpuInfos;
	}

	public CpuPerc[] getCpuPercs() {
		return cpuPercs;
	}

	public DataBaseServerType getDbsType() {
		return dbsType;
	}

	public JavaType getJavaType() {
		return javaType;
	}

	public Mem getMem() {
		return mem;
	}

	public Map<String, NetInterfaceConfig> getNetConfigs() {
		return netConfigs;
	}

	public String[] getNetNames() {
		return netNames;
	}

	public Map<String, Double> getNetRxSpeed() {
		return netRxSpeed;
	}

	public Map<String, NetInterfaceStat> getNetStats() {
		return netStats;
	}

	public Map<String, Double> getNetTxSpeed() {
		return netTxSpeed;
	}

	public String getServerInfo() {
		return serverInfo;
	}

	public Swap getSwap() {
		return swap;
	}

	public OperatingSystem getSys() {
		return sys;
	}

	public double getUptime() {
		return uptime;
	}

	public void setCpuCombined(double[] cpuCombined) {
		this.cpuCombined = cpuCombined;
	}

	public void setCpuInfos(CpuInfo[] cpuInfos) {
		this.cpuInfos = cpuInfos;
	}

	public void setCpuPercs(CpuPerc[] cpuPercs) {
		this.cpuPercs = cpuPercs;
	}

	public void setDbsType(DataBaseServerType dbsType) {
		this.dbsType = dbsType;
	}

	public void setJavaType(JavaType javaType) {
		this.javaType = javaType;
	}

	public void setMem(Mem mem) {
		this.mem = mem;
	}

	public void setNetConfigs(Map<String, NetInterfaceConfig> netConfigs) {
		this.netConfigs = netConfigs;
	}

	public void setNetNames(String[] netNames) {
		this.netNames = netNames;
	}

	public void setNetRxSpeed(Map<String, Double> netRxSpeed) {
		this.netRxSpeed = netRxSpeed;
	}

	public void setNetStats(Map<String, NetInterfaceStat> netStats) {
		this.netStats = netStats;
	}

	public void setNetTxSpeed(Map<String, Double> netTxSpeed) {
		this.netTxSpeed = netTxSpeed;
	}

	public void setServerInfo(String serverInfo) {
		this.serverInfo = serverInfo;
	}

	public void setSwap(Swap swap) {
		this.swap = swap;
	}

	public void setSys(OperatingSystem sys) {
		this.sys = sys;
	}

	public void setUptime(double uptime) {
		this.uptime = uptime;
	}
}
