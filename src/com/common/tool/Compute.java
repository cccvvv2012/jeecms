package com.common.tool;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Compute {
	private static boolean getBoolean(Stack stack, char element) {
		Character c = (Character) stack.peek();
		if ((c == '+' || c == '-') && (element == '*' || element == '/'))
			return true;
		return false;
	}

	public static int getRes(String str) {
		char[] array = str.toCharArray();
		List<Character> output = new ArrayList<Character>();
		Stack<Character> sign = new Stack<Character>();
		for (int i = 0; i < array.length; i++) {
			if (array[i] > '0' && array[i] <= '9') {
				output.add(array[i]);
			} else if (sign.empty() || getBoolean(sign, array[i])) {
				sign.push(array[i]);
			} else {
				while (!sign.empty() && !getBoolean(sign, array[i]))
					output.add(sign.pop());
				sign.push(array[i]);
			}
		}
		while (!sign.empty()) {
			output.add(sign.pop());
		}
		System.out.println(output);
		Stack<Integer> res = new Stack<Integer>();
		Integer result = null;
		for (Character temp : output) {
			if (temp > '0' && temp <= '9') {
				res.push(temp - '0');
			} else {
				int top1 = res.pop();
				int top2 = res.pop();
				switch (temp) {
				case '+':
					result = top2 + top1;
					break;
				case '-':
					result = top2 - top1;
					break;
				case '*':
					result = top2 * top1;
					break;
				case '/':
					result = top2 / top1;
					break;
				}
				res.push(result);
			}
		}
		return result;
	}

	public static void main(String args[]) {
		String str = "1+2-3+5*2-9+5";
		System.out.println(getRes(str));
	}

}
