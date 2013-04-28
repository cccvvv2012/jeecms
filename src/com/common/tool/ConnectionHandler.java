package com.common.tool;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ConnectionHandler implements Runnable {
	protected Socket socket;

	public ConnectionHandler(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			System.out.println("start connection ");
			BufferedReader in = new BufferedReader(new InputStreamReader(socket
					.getInputStream()));

			PrintWriter out = new PrintWriter(socket.getOutputStream());
			String a = in.readLine();
			while (true) {
				System.out.println(a);
				out.print("information alread recive");
				out.flush();
				if (a.equals("end")) {
					socket.close();
					break;
				}
				a = in.readLine();
			}
		} catch (Exception e) {
			System.out.println("Error handling a client: " + e);
			e.printStackTrace();
		}
	}

}
