/*
 * FIleTool.java
 *
 * Created on 2008年8月25日, 下午10:13
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.common.tool;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author xieqz
 */
public class FileTool {

	/**
	 * 复制文件
	 * 
	 * @param srcFile
	 *            源文件
	 * @param desFile
	 *            目标文件
	 */
	public static void copy(File srcFile, File desFile) {
		if (desFile.exists()) {
			desFile.delete();
		}
		try {
			java.io.FileInputStream fosfrom = new java.io.FileInputStream(
					srcFile);
			java.io.FileOutputStream fosto = new FileOutputStream(desFile);
			byte bt[] = new byte[1024];
			int c;
			while ((c = fosfrom.read(bt)) > 0) {
				fosto.write(bt, 0, c);
			}
			fosfrom.close();
			fosto.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	/**
	 * 复制文件
	 * 
	 * @param srcFilePath
	 *            源文件路径
	 * @param desFilePath
	 *            目标文件路径
	 */
	public static void copy(String srcFilePath, String desFilePath) {
		File srcFile = new File(srcFilePath);
		File desFile = new File(desFilePath);
		copy(srcFile, desFile);
	}

	/**
	 * 创建目录
	 * 
	 * @param file
	 * @param isFile
	 */
	public static void createDir(File file, boolean isFile) {
		if (isFile) {
			if (file.getParent() != null && file.getParent().length() != 0) {
				createDir(file.getParent(), false);
			}
		} else {
			if (!file.exists()) {
				file.mkdirs();
			}
		}
	}

	/**
	 * 创建目录
	 * 
	 * @param path
	 * @param isFile
	 */
	public static void createDir(String path, boolean isFile) {
		createDir(new File(path), isFile);
	}

	/**
	 * 删除文件
	 * 
	 * @param file
	 */
	public static void delete(File file) {
		if (file.exists()) {
			file.delete();
		}
	}

	/**
	 * 删除文件
	 * 
	 * @param filePath
	 *            文件路径
	 */
	public static void delete(String filePath) {
		File file = new File(filePath);
		delete(file);
	}

	/**
	 * 获取目录下的所有文件（包含子目录的文件）
	 * 
	 * @param directorie
	 * @return
	 */
	public static List getFilesOfDir(File directorie) {
		List fileList = new ArrayList();
		File[] files = directorie.listFiles();
		for (int i = 0; i < files.length; i++) {
			File file = files[i];
			// 判断是文件还是目录
			if (file.isDirectory()) {
				fileList.addAll(getFilesOfDir(file));
			} else {
				fileList.add(file);
			}
		}
		return fileList;
	}

	/**
	 * 获取目录下的所有文件（包含子目录的文件）
	 * 
	 * @param path
	 * @return
	 */
	public static List getFilesOfDir(String path) {
		return getFilesOfDir(new File(path));
	}
}
