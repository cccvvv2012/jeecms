/*
 * LFSR.java
 * Created on Feb 21, 2005
 */
package com.common.tool;

/**
 * Linear Feedback Shift Register
 */
public final class LFSR {

	private static final int M = 32;
	// hard-coded for 32-bits
	private static final int[] TAPS = { 1, 0, 1 };

	public static void main(String[] args) {
		LFSR rng = new LFSR();
		for (int i = 1; i <= 10; i++) {
			boolean next = rng.nextBoolean();
			System.out.println(next);
		}
	}

	private final boolean[] bits = new boolean[M + 1];

	public LFSR() {
		this((int) System.currentTimeMillis());
	}

	public LFSR(int seed) {
		for (int i = 0; i < M; i++) {
			bits[i] = (((1 << i) & seed) >>> i) == 1;
		}
	}

	/** returns random boolean */
	public boolean nextBoolean() {
		return nextInt() >= 0;
	}

	/** returns random double uniformly over [0, 1) */
	public double nextDouble() {
		return ((nextInt() / (Integer.MAX_VALUE + 1.0)) + 1.0) / 2.0;
	}

	/* generate a random int uniformly on the interval [-2^31 + 1, 2^31 - 1] */
	public int nextInt() {
		// printBits();

		// calculate the integer value from the registers
		int next = 0;
		for (int i = 0; i < M; i++) {
			next |= (bits[i] ? 1 : 0) << i;
		}

		// allow for zero without allowing for -2^31
		if (next < 0)
			next++;

		// calculate the last register from all the preceding
		bits[M] = false;
		for (int i = 0; i < TAPS.length; i++) {
			bits[M] ^= bits[M - TAPS[i]];
		}

		// shift all the registers
		for (int i = 0; i < M; i++) {
			bits[i] = bits[i + 1];
		}

		return next;
	}

	private void printBits() {
		System.out.print(bits[M] ? 1 : 0);
		System.out.print(" -> ");
		for (int i = M - 1; i >= 0; i--) {
			System.out.print(bits[i] ? 1 : 0);
		}
		System.out.println();
	}

}
