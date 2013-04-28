package com.common.tool;

import java.io.IOException;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;

public class MultithreadedRemoteServer {
	public static void main(String args[]) {
		MultithreadedRemoteServer server = new MultithreadedRemoteServer(8080);
		server.acceptConnections();
	}

	int listenPort;

	public MultithreadedRemoteServer(int listenPort) {
		this.listenPort = listenPort;
	}

	// 允许客户机连接到服务器,等待客户机请求
	public void acceptConnections() {
		try {
			// 指定待发数（backlog 值）是5,一次可以放五个请求到队列中
			ServerSocket server = new ServerSocket(listenPort, 5);
			Socket incomingConnection = null;
			System.out.println("start listenPort Data");
			while (true) {
				incomingConnection = server.accept();
				handleConnection(incomingConnection);

			}
		} catch (BindException e) {
			System.out.println("Unable to bind to port " + listenPort);
		} catch (IOException e) {
			System.out.println("Unable to instantiate a ServerSocket on port: "
					+ listenPort);
		}
	}

	// 与客户机Socket交互以将客户机所请求的文件的内容发送到客户机
	public void handleConnection(Socket connectionToHandle) {
		new Thread(new ConnectionHandler(connectionToHandle)).start();
	}

}
