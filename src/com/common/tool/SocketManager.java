package com.common.tool;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketManager {
	// 服务器进程
	class SSocket implements Runnable {

		Socket client;

		public SSocket(Socket client) {
			this.client = client;
		}

		@Override
		public void run() {
			System.out.println("运行网络协议");
			DataInputStream input;
			DataOutputStream output;
			try {
				input = new DataInputStream(client.getInputStream());
				output = new DataOutputStream(client.getOutputStream());
				//   
				String listMsg = input.readUTF()
						+ (new java.util.Date()).toGMTString();
				output.writeUTF("Recive:  " + listMsg + "    \r\n Thx...");
				System.out.println("Recive:   " + listMsg);
				listMsg = input.readUTF();
				output.writeUTF("Recive Second:  " + listMsg
						+ "    \r\n Thx...");
				System.out.println("Recive Second:   " + listMsg);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) {
		SocketManager manager = new SocketManager();
		System.out.println("运行线程");
		manager.doListen();
	}

	public void doListen() {
		System.out.println("开始监听");
		ServerSocket server;
		try {
			server = new ServerSocket(8080, 10);
			while (true) {
				Socket client = server.accept();
				new Thread(new SSocket(client)).start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
