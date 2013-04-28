package com.common.tool;

class MyThread extends Thread {
	public int i = 0;

	@Override
	public void run() { // 覆写Thread类中的run方法此方法是线程中
		while (i < 100) {
			System.out.println(Thread.currentThread().getName() + "++"
					+ System.currentTimeMillis());
			i++;
		}
	}
}

public class ThreadDemo {

	public static void main(String[] args) {
		/*
		 * ThreadTest t = new ThreadTest(); new Thread(t).start(); new
		 * Thread(t).start(); new Thread(t).start(); new Thread(t).start();
		 */
		MyThread m1 = new MyThread();// 实例化对象
		m1.start();// 启动多线程
		m1.run();
		MyThread m2 = new MyThread();// 实例化对象
		m2.start();// 启动多线程
		m2.run();

	}
}

class ThreadTest implements Runnable {
	private int tickets = 100;

	@Override
	public void run() {
		while (true) {
			if (tickets > 0) {
				System.out.println(Thread.currentThread().getName()
						+ " is saling ticket " + tickets--);
			}
		}
	}
}
