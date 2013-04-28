package com.common.tool;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hyperic.sigar.NetInterfaceConfig;
import org.hyperic.sigar.NetInterfaceStat;
import org.hyperic.sigar.OperatingSystem;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;

import com.common.datatype.SystemType;

public class SystemUtils {

	public static SystemType getStatus(SystemType st, List<SystemType> stList) {
		try {
			Sigar sigar = new Sigar();
			// 初始化系统状态
			st.setCpuInfos(sigar.getCpuInfoList());
			st.setCpuPercs(sigar.getCpuPercList());
			st.setMem(sigar.getMem());
			st.setSwap(sigar.getSwap());
			st.setSys(OperatingSystem.getInstance());
			st.setUptime(sigar.getUptime().getUptime());

			String netNames[] = sigar.getNetInterfaceList();
			st.setNetNames(netNames);
			Map<String, NetInterfaceConfig> netConfigs = new HashMap<String, NetInterfaceConfig>();
			Map<String, NetInterfaceStat> netStats = new HashMap<String, NetInterfaceStat>();
			Map<String, Double> netRxSpeed = new HashMap<String, Double>();
			Map<String, Double> netTxSpeed = new HashMap<String, Double>();
			SystemType stTemp = stList.get(stList.size() - 1);
			for (int i = 0; i < netNames.length; i++) {
				// if (netNames[i].toLowerCase().equals("lo")) {
				// continue;
				// }
				NetInterfaceConfig netConfig = sigar
						.getNetInterfaceConfig(netNames[i]);
				NetInterfaceStat netStat = sigar
						.getNetInterfaceStat(netNames[i]);
				netConfigs.put(netNames[i], netConfig);
				netStats.put(netNames[i], netStat);
				double doubRx = 0.0;
				double doubTx = 0.0;
				if (stTemp != null && stTemp.getNetStats() != null) {
					NetInterfaceStat netStatTemp = stTemp.getNetStats().get(
							netNames[i]);
					if (netStatTemp != null && netStatTemp.getRxBytes() > 0
							&& netStatTemp.getTxBytes() > 0) {
						doubRx = (netStat.getRxBytes() - netStatTemp
								.getRxBytes()) / 5;
						doubTx = (netStat.getTxBytes() - netStatTemp
								.getTxBytes()) / 5;
					}
				}
				netRxSpeed.put(netNames[i], doubRx);
				netTxSpeed.put(netNames[i], doubTx);
			}
			st.setNetConfigs(netConfigs);
			st.setNetStats(netStats);
			st.setNetRxSpeed(netRxSpeed);
			st.setNetTxSpeed(netTxSpeed);
		} catch (SigarException e) {
			e.printStackTrace();
		}
		return st;
	}

	public static SystemType getVariables(SystemType st) {
		try {
			Sigar sigar = new Sigar();
			// 初始化系统状态
			st.setCpuInfos(sigar.getCpuInfoList());
			st.setCpuPercs(sigar.getCpuPercList());
			st.setMem(sigar.getMem());
			st.setSwap(sigar.getSwap());
			st.setSys(OperatingSystem.getInstance());
			st.setUptime(sigar.getUptime().getUptime());

			String netNames[] = sigar.getNetInterfaceList();
			st.setNetNames(netNames);
			Map<String, NetInterfaceConfig> netConfigs = new HashMap<String, NetInterfaceConfig>();
			Map<String, NetInterfaceStat> netStats = new HashMap<String, NetInterfaceStat>();
			Map<String, Double> netRxSpeed = new HashMap<String, Double>();
			Map<String, Double> netTxSpeed = new HashMap<String, Double>();
			for (int i = 0; i < netNames.length; i++) {
				// if (netNames[i].toLowerCase().equals("lo")) {
				// continue;
				// }
				NetInterfaceConfig netConfig = sigar
						.getNetInterfaceConfig(netNames[i]);
				NetInterfaceStat netStat = sigar
						.getNetInterfaceStat(netNames[i]);
				netConfigs.put(netNames[i], netConfig);
				netStats.put(netNames[i], netStat);
				double doubRx = 0.0;
				double doubTx = 0.0;
				netRxSpeed.put(netNames[i], doubRx);
				netTxSpeed.put(netNames[i], doubTx);
			}
			st.setNetConfigs(netConfigs);
			st.setNetStats(netStats);
			st.setNetRxSpeed(netRxSpeed);
			st.setNetTxSpeed(netTxSpeed);
		} catch (SigarException e) {
			e.printStackTrace();
		}
		return st;
	}
}
