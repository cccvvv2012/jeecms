package com.common.tool;

import java.net.UnknownHostException;

public class GetIPInfo {
	public static String GetIp() {
		String ip = "";
		try {
			ip = java.net.InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ip;
	}
}
