package com.common.tool;

import java.util.Scanner;

public class javaex {
	private static int max;

	public static boolean eachPrime(int m, int n) {// 判断m和n是不是互素
		if (m < n) {
			int temp = n;
			n = m;
			m = temp;
		}
		if (m == 1 || n == 1) {
			return true;
		} else if (m == n + 1 || m == n - 1) {
			return true;
		} else if (isPrime(m) && isPrime(n)) {
			return true;
		} else if (m % max != 0) {
			return true;
		} else if (m % max == 0) {
			return false;
		}
		return true;
	}

	public static int extEuclid(int m, int n) {// 扩展欧几里德算法
		int x = 0, y = 0;
		int d, temp;
		if (n == 0) {
			d = m;
			x = 1;
			y = 0;
			return d;
		}
		d = extEuclid(n, m % n);
		temp = x;
		x = y;
		y = temp - m / n * y;
		return d;
	}

	public static int gcd(int m, int n) {// 求最大公约数
		while (n != 0) {
			int temp = m;
			m = n;
			n = temp % m;
		}
		return m;
	}

	public static boolean isPrime(int k) {// 判断是不是素数
		int sqrt = (int) Math.sqrt(k);
		for (int i = 2; i <= sqrt; i++) {
			if (k % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int m = s.nextInt();
		int n = s.nextInt();
		max = gcd(m, n);
		System.out.println("gcd(" + m + "," + n + ")=" + max);
		if (eachPrime(m, n)) {
			System.out.println(extEuclid(m, n));
		}
	}
}