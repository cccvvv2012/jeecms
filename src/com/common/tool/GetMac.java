package com.common.tool;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;

/**
 * ��ȡMAC��ַ��ת�ء�
 * 
 */
public class GetMac {
	// ͨ��IP��ȡ���ַ
	public static String getMacAddressIP(String remotePcIP) {
		String str = "";
		String macAddress = "";
		try {
			Process pp = Runtime.getRuntime().exec("nbtstat -A " + remotePcIP);
			InputStreamReader ir = new InputStreamReader(pp.getInputStream());
			LineNumberReader input = new LineNumberReader(ir);
			for (int i = 1; i < 100; i++) {
				str = input.readLine();
				if (str != null) {
					if (str.indexOf("MAC Address") > 1) {
						macAddress = str.substring(
								str.indexOf("MAC Address") + 14, str.length());
						break;
					}
				}
			}
		} catch (IOException ex) {
		}
		return macAddress;
	}

	// ͨ��������ȡ���ַ
	public static String getMacAddressName(String remotePcIP) {
		String str = "";
		String macAddress = "";
		try {
			Process pp = Runtime.getRuntime().exec("nbtstat -a " + remotePcIP);
			InputStreamReader ir = new InputStreamReader(pp.getInputStream());
			LineNumberReader input = new LineNumberReader(ir);
			for (int i = 1; i < 100; i++) {
				str = input.readLine();
				if (str != null) {
					if (str.indexOf("MAC Address") > 1) {
						macAddress = str.substring(
								str.indexOf("MAC Address") + 14, str.length());
						break;
					}
				}
			}
		} catch (IOException ex) {
		}
		return macAddress;
	}

	public static void main(String[] args) {
		/*
		 * GetMac getmac; getmac = new GetMac(); String mac = ""; mac =
		 * getmac.getMacAddressIP("192.168.0.100");// YOUR IP
		 * System.out.println(mac); mac = getmac.getMacAddressName("R61007");//
		 * YOUR HOST-NAME System.out.println(mac);
		 */
	}

}
