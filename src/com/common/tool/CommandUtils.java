package com.common.tool;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;

public class CommandUtils {

	public static void main(String[] args) {
		try {
			String[] dd = { "dd", "fd" };
			String[] cc = new String[dd.length];
			System.out.println(dd.length);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

	private static String run(Process p) throws IOException,
			InterruptedException {
		StringBuffer strReturn = new StringBuffer("");
		p.getOutputStream().close();
		InputStreamReader ir = new InputStreamReader(p.getInputStream());
		LineNumberReader input = new LineNumberReader(ir);
		String lineStr = "";
		while ((lineStr = input.readLine()) != null) {
			strReturn.append(lineStr).append("\n");
		}
		// 检查命令是否执行失败。p.exitValue()==0表示正常结束，1：非正常结束
		if (p.waitFor() != 0 && p.exitValue() == 1) {
			BufferedInputStream err = new BufferedInputStream(p
					.getErrorStream());
			BufferedReader errBr = new BufferedReader(
					new InputStreamReader(err));
			// 获取执行错误的返回代码
			while ((lineStr = errBr.readLine()) != null) {
				strReturn.append(lineStr).append("\n");
			}
			err.close();
			errBr.close();
			// 如果有错误返回代码则将其作为错误抛出
			if (strReturn.length() > 0) {
				throw new StrongException("命令执行失败:" + strReturn.toString());
			}
		}
		p.destroy();
		ir.close();
		input.close();
		return strReturn.toString();
	}

	public static String runCommand(String arg) throws InterruptedException,
			IOException {
		if (arg == null || arg.length() <= 0) {
			return "";
		}
		Runtime run = Runtime.getRuntime();
		Process p = run.exec(arg);
		String strReturn = run(p);
		run.freeMemory();
		return strReturn;
	}

	public static String runCommand(String[] args) throws InterruptedException,
			IOException {
		if (args == null || args.length <= 0) {
			return "";
		}
		Runtime run = Runtime.getRuntime();
		Process p = run.exec(args);
		String strReturn = run(p);
		run.freeMemory();
		return strReturn;
	}

	public String runWaitCommand(String arg) throws InterruptedException,
			IOException {
		if (arg == null || arg.length() <= 0) {
			return "";
		}
		String strTemp = "";
		Runtime run = Runtime.getRuntime();
		final Process prc = run.exec(arg);
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					prc.waitFor();
				} catch (InterruptedException e) {
				}
				if (prc.exitValue() != 0) {
					// 在指定的seconds之内子进程没有结束,就强制结束子进程。
					prc.destroy();
				}
			}
		});
		thread.start();
		synchronized (this) {
			try {
				this.wait(1000);
				StringBuffer strReturn = new StringBuffer("");
				BufferedInputStream in = new BufferedInputStream(prc
						.getInputStream());
				BufferedInputStream err = new BufferedInputStream(prc
						.getErrorStream());
				BufferedReader inBr = new BufferedReader(new InputStreamReader(
						in));
				BufferedReader errBr = new BufferedReader(
						new InputStreamReader(err));
				String lineStr;
				// 获取执行错误的返回代码
				while ((lineStr = errBr.readLine()) != null) {
					strReturn.append(lineStr).append("\n");
				}
				// 如果有错误返回代码则将其作为错误抛出
				if (strReturn.length() > 0) {
					throw new StrongException(strReturn.toString());
				}
				// 获取执行正确的返回代码
				while ((lineStr = inBr.readLine()) != null) {
					strReturn.append(lineStr).append("\n");
				}
				// 检查命令是否执行失败。p.exitValue()==0表示正常结束，1：非正常结束
				if (prc.waitFor() != 0 && prc.exitValue() == 1) {
					throw new StrongException("命令执行失败!");
				}
				prc.destroy();
				in.close();
				err.close();
				inBr.close();
				errBr.close();
				strTemp = strReturn.toString();
			} catch (Exception e) {
			}
			if (thread.isAlive())
				thread.interrupt();
		}
		return strTemp;
	}
}