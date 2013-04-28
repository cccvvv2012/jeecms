package com.common.tool;

/* 
 * Created on 17.05.2004 
 * 
 * This program is a solution for exercise 4.5. It implements the extended 
 * euklidean algorithm and computes some inverse in Z/mZ.    
 */

/**
 * @author Robert
 * 
 *         Implementation of the extended euklidean algorithm. The main part is
 *         done in the constructor. The class can also be used for invertation.
 *         In that case the parameter b stands for the module n and getXmodN
 *         returns x modulo n.
 */
public class Euklid {
	public static void main(String[] args) {
		Euklid euk1 = new Euklid(02, 119);

		System.out.println(euk1.getXmodN());

	}
	int g, x, y;

	int n;

	public Euklid(int a, int b) {

		n = b;
		int k;
		// The extended euklidean algorithm starts here
		int r[] = { a, b };
		int x[] = { 1, 0 };
		int y[] = { 0, 1 };
		for (k = 0; r[(k + 1) % 2] != 0; ++k) {
			int q = r[k % 2] / r[(k + 1) % 2];
			r[k % 2] = r[k % 2] - q * r[(k + 1) % 2];
			x[k % 2] = x[k % 2] - q * x[(k + 1) % 2];
			y[k % 2] = y[k % 2] - q * y[(k + 1) % 2];
			System.out.println(k + ": " + q + "  " + y[(k + 1) % 2] + "  "
					+ x[(k + 1) % 2] + "  " + r[(k + 1) % 2] + "  " + y[k % 2]
					+ "  " + x[k % 2] + "  " + r[k % 2]);
			// System.out.println();
		}

		this.g = r[k % 2];
		this.x = x[k % 2];
		this.y = y[k % 2];
		// ... and ends here. The next line only verifies the result
		if (a * this.x + b * this.y != this.g) {
			System.out.println("this should not happen!!");
		}
	}

	public int getG() {
		return g;
	}

	public int getX() {
		return x;
	}

	public int getXmodN() {
		System.out.println((x % n) + "  " + (x % n + n));
		return (x % n > 0 ? x % n : x % n + n);
	}

	public int getY() {
		return y;
	}
}