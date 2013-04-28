package com.common.tool;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipFile;
import org.apache.tools.zip.ZipOutputStream;

/**
 * 压缩和解压缩zip文件的工具类（和Winzip速度相当） 需要引入ant jar包
 * 用java.util.zip包只能压缩和解压英文目录和文件，否则用winrar察看时显示文件名不正确
 * 
 * @author citysir
 * @version 1.0
 */
public final class ZipUtil {

	private static final int COMPRESS_BUFFER_SIZE = 8192; // 压缩文件时所用的缓冲区大小
	private static final int DECOMPRESS_BUFFER_SIZE = 8192; // 解压文件时所用的缓冲区大小
	private static final char fileSeparator = System.getProperty(
			"file.separator").charAt(0);

	private static void createDir(File file, boolean isFile) {
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

	private static void createDir(String path, boolean isFile) {
		createDir(new File(path), isFile);
	}

	public static void main(String[] args) {
		try {
			// ZipUtil.zip(new String[] { "e:\\ipms.rar", "e:\\src.rar" },
			// "e:\\ok.zip", true);
			List files = FileTool.getFilesOfDir("E:\\eclipse\\plugins");
			if (files != null) {
				for (Iterator iter = files.iterator(); iter.hasNext();) {
					File file = (File) iter.next();
					if (file.getPath().toLowerCase().endsWith("src.zip")) {
						System.out.println(file.getPath());
						ZipUtil.unZip(file.getPath(), "D:\\eclipse_src\\src",
								true);
					}
				}
			}
			System.out.println("解压结束");
		} catch (Exception e) {
		}
	}

	/**
	 * 解压文件到目录，不覆盖已存在的目录
	 * 
	 * @param inZipName
	 *            压缩文件名（完整路径）
	 * @param outDirName
	 *            解压出来的路径名（完整路径）
	 * @throws IOException
	 *             解压过程中失败
	 */
	public static List unZip(String inZipName, String outDirName)
			throws IOException {
		return unZip(inZipName, outDirName, false);
	}

	/**
	 * 解压缩文件到一个指定的目录
	 * 
	 * @param inZipName
	 *            压缩文件名（完整路径）
	 * @param outDirName
	 *            解压出来的路径名（完整路径）
	 * @param overWrite
	 *            如果指定的目录已经存在，是否覆盖该目录
	 * @throws IOException
	 *             解压过程中出现错误
	 */
	public static List unZip(String inZipName, String outDirName,
			boolean overWrite) throws IOException {
		List files = new ArrayList();
		if (inZipName == null || inZipName.equals("")) {
			throw new IllegalArgumentException("输入文件名为空值");
		}

		if (outDirName == null || outDirName.equals("")) {
			throw new IllegalArgumentException("输出目录名为空值");
		}

		File inZip = new File(inZipName);
		if (!inZip.exists()) {
			throw new IllegalArgumentException("输入文件名不存在");
		}

		// 判断要解压的文件名是否以.zip或.jar结尾
		String lowerZipName = inZipName.toLowerCase();
		if (!lowerZipName.endsWith(".zip") && !lowerZipName.endsWith(".jar")) {
			throw new IOException("只能解压以zip或jar为扩展名的压缩文件");
		}

		// 判断输出文件名是否存在
		createDir(outDirName, false);
		File outDir = new File(outDirName);
		// if(outDir.exists() && !overWrite)
		// throw new IOException("输出目录名已经存在");
		// outDir.mkdir();
		if (!outDir.exists() || overWrite) {
			outDir.mkdir();
		}

		try {
			ZipFile zf = new ZipFile(inZip, "GBK"); // 打开压缩文件
			byte[] buffer = new byte[DECOMPRESS_BUFFER_SIZE]; // 解压缩文件时的缓存区

			Enumeration e = zf.getEntries();
			while (e.hasMoreElements()) {
				ZipEntry entry = (ZipEntry) e.nextElement(); // 保存每次读到的entry的引用
				String path = outDir.getPath() + fileSeparator
						+ entry.getName().replace('/', fileSeparator);
				files.add(entry.getName().replace('/', fileSeparator));
				if (entry.isDirectory()) { // 处理目录类型的entry
					createDir(path, false);
				} // if
				else { // 处理文件类型的entry
					createDir(path, true);
					InputStream is = zf.getInputStream(entry); // 得到文件类型entry的输入流
					FileOutputStream os = new FileOutputStream(path); // 解压后的输出文件

					long leftSize = entry.getSize(); // 保存输入流中剩下未读的字节数
					int readSize = 0; // 保存实际每次读入的字节数
					while (leftSize > 0) { // 如果输入流中剩下的字节数大于0则继续读
						readSize = is.read(buffer); // 读入到缓冲区，readSize为实际读入的字节数
						leftSize -= readSize; // 更新输入流中剩下的字节数信息
						os.write(buffer, 0, readSize); // 写入缓冲区内容到输出文件流
					} // while
					os.close();
					is.close();
				} // else
			} // while
			zf.close();
		} catch (IOException ios) {
			ios.printStackTrace();
			throw new IOException("在解压缩文件过程中出现未知错误");
		}
		return files;
	}

	/**
	 * 压缩一个文件列表到一个指定的压缩文件
	 * 
	 * @param inFileName
	 *            要压缩的文件名或目录名列表（完整路径）
	 * @param outZipName
	 *            要生成的压缩文件名（完整路径）
	 * @param overWrite
	 *            如果指定的压缩文件已经存在，是否覆盖该文件
	 * @throws IOException
	 *             压缩过程中失败
	 */
	public static void zip(List inFileName, String outZipName, boolean overWrite)
			throws IOException {
		String[] inFileNameArray = new String[inFileName.size()];
		for (int i = 0; i < inFileName.size(); i++) {
			inFileNameArray[i] = inFileName.get(i).toString();
		}
		zip(inFileNameArray, outZipName, overWrite);
	}

	/**
	 * 压缩目录到文件，不覆盖已存在的文件
	 * 
	 * @param inDirName
	 *            要压缩的目录名（完整路径）
	 * @param outZipName
	 *            要生成的压缩文件名（完整路径）
	 * @throws IOException
	 *             压缩过程中失败
	 */
	public static void zip(String inDirName, String outZipName)
			throws IOException {
		zip(inDirName, outZipName, false);
	}

	/**
	 * 压缩一个目录到一个指定的压缩文件
	 * 
	 * @param inDirName
	 *            要压缩的目录名（完整路径）
	 * @param outZipName
	 *            要生成的压缩文件名（完整路径）
	 * @param overWrite
	 *            如果指定的压缩文件已经存在，是否覆盖该文件
	 * @throws IOException
	 *             压缩过程中失败
	 */
	public static void zip(String inDirName, String outZipName,
			boolean overWrite) throws IOException {

		if (inDirName == null || inDirName.equals("")) // 输入目录名不合法
		{
			throw new IllegalArgumentException("输入目录名为空值");
		}

		if (outZipName == null || outZipName.equals("")) // 输出压缩文件名不合法
		{
			throw new IllegalArgumentException("输出文件名为空值");
		}

		String lowerZipName = outZipName.toLowerCase();
		if (!lowerZipName.endsWith(".zip") && !lowerZipName.endsWith(".jar")) {
			outZipName += ".zip";
		}

		File inDir = new File(inDirName);
		if (!inDir.exists()) {
			throw new IllegalArgumentException("输入目录名不存在");
		}

		createDir(outZipName, true);
		File outZip = new File(outZipName);
		if (outZip.exists() && !overWrite) {
			throw new IOException("输出文件名已存在");
		}

		try {
			ZipOutputStream zout = new ZipOutputStream(new FileOutputStream(
					outZip.getPath()));
			zout.setEncoding("GBK");
			byte[] buffer = new byte[COMPRESS_BUFFER_SIZE]; // 把缓存区作为参数传入避免多次构造缓存区
			zipFile(inDir.getName(), inDir, zout, buffer);
			zout.close();
		} catch (IOException ioe) {
			throw new IOException("在生成压缩文件的过程中出现未知错误");
		}
	}

	/**
	 * 压缩一个文件列表到一个指定的压缩文件
	 * 
	 * @param inFileName
	 *            要压缩的文件名或目录名列表（完整路径）
	 * @param outZipName
	 *            要生成的压缩文件名（完整路径）
	 * @throws IOException
	 *             压缩过程中失败
	 */
	public static void zip(String[] inFileName, String outZipName)
			throws IOException {
		zip(inFileName, outZipName, false);
	}

	/**
	 * 压缩一个文件列表到一个指定的压缩文件
	 * 
	 * @param inFileName
	 *            要压缩的文件名或目录名列表（完整路径）
	 * @param outZipName
	 *            要生成的压缩文件名（完整路径）
	 * @param overWrite
	 *            如果指定的压缩文件已经存在，是否覆盖该文件
	 * @throws IOException
	 *             压缩过程中失败
	 */
	public static void zip(String[] inFileName, String outZipName,
			boolean overWrite) throws IOException {

		File[] inFile = new File[inFileName.length];
		for (int i = 0; i < inFileName.length; i++) {
			if (inFileName[i] == null || inFileName[i].equals("")) // 输入目录名不合法
			{
				throw new IllegalArgumentException("输入目录名为空值");
			}
			inFile[i] = new File(inFileName[i]);
			if (!inFile[i].exists()) {
				throw new IllegalArgumentException("输入目录名不存在");
			}
		}

		if (outZipName == null || outZipName.equals("")) // 输出压缩文件名不合法
		{
			throw new IllegalArgumentException("输出文件名为空值");
		}

		String lowerZipName = outZipName.toLowerCase();
		if (!lowerZipName.endsWith(".zip") && !lowerZipName.endsWith(".jar")) {
			outZipName += ".zip";
		}

		createDir(outZipName, true);
		File outZip = new File(outZipName);
		if (outZip.exists() && !overWrite) {
			throw new IOException("输出文件名已存在");
		}

		try {
			ZipOutputStream zout = new ZipOutputStream(new FileOutputStream(
					outZip.getPath()));
			zout.setEncoding("GBK");
			byte[] buffer = new byte[COMPRESS_BUFFER_SIZE]; // 把缓存区作为参数传入避免多次构造缓存区
			for (int i = 0; i < inFile.length; i++) {
				zipFile(inFile[i].getName(), inFile[i], zout, buffer);
			}
			zout.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
			throw new IOException("在生成压缩文件的过程中出现未知错误");
		}
	}

	/**
	 * 实现压缩文件的子方法（递归）
	 * 
	 * @param basePath
	 *            如果是目录类型，basePath + "\" 就代表当前entry的名字 如果是文件类型，basePath
	 *            就代表当前entry的名字
	 * @param file
	 *            要压缩的文件或目录
	 * @param zout
	 *            ZipOutputStream 压缩文件输出流
	 * @throws IOException
	 *             压缩过程中失败
	 */
	private static void zipFile(String basePath, File file,
			ZipOutputStream zout, byte[] buffer) throws IOException {

		if (file.isDirectory()) { // 处理目录

			ZipEntry entry = new ZipEntry(basePath + "/");
			entry.setSize(0);
			entry.setTime(System.currentTimeMillis());
			zout.putNextEntry(entry);

			String[] subFile = file.list(); // 子文件和目录的列表
			for (int i = 0; i < subFile.length; i++) {
				zipFile(basePath + "/" + subFile[i], new File(file.getPath()
						+ fileSeparator + subFile[i]), zout, buffer);
			}
		} else { // 处理文件
			FileInputStream is = new FileInputStream(file);

			ZipEntry entry = new ZipEntry(basePath);
			entry.setSize(is.available());
			entry.setTime(System.currentTimeMillis());
			zout.putNextEntry(entry);

			long leftSize = is.available(); // 保存输入流中剩下未读的字节数
			int readSize = 0; // 保存实际每次读入的字节数
			while (leftSize > 0) { // 如果输入流中剩下的字节数大于0则继续读
				readSize = is.read(buffer); // 读入到缓冲区，readSize为实际读入的字节数
				leftSize -= readSize; // 更新输入流中剩下的字节数信息
				zout.write(buffer, 0, readSize); // 写入缓冲区内容到输出文件流
			} // while
			is.close();
		}
	}
}