/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.common.tool;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * 
 * @author Chilam
 */
public class NetUtil {

	/**
	 * 绑定端口，用于测试端口是否被占用，如果抛出异常则证明端口被用
	 * 
	 * @param host
	 * @param port
	 * @throws Exception
	 */
	public static void bindPort(String host, int port) throws Exception {
		Socket s = new Socket();
		s.bind(new InetSocketAddress(host, port));
		s.close();
	}

	/**
	 * 测试端口是否可用。
	 * 
	 * @return
	 */
	public static boolean testPort(int port) {
		try {
			NetUtil.bindPort("0.0.0.0", port);
			NetUtil.bindPort(InetAddress.getLocalHost().getHostAddress(), port);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
