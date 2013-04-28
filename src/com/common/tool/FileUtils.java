package com.common.tool;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;

import com.common.datatype.FileType;
import com.common.datatype.UploadFileType;

/**
 * 用于文件名及目录的排序类
 * 
 * @author Boris von Loesch
 * @version 1.0
 */
class FileComp implements Comparator<Object> {
	int mode = 1;

	/**
	 * @param mode
	 *            1=Filename, 2=Size, 3=Date反向
	 */
	FileComp(int mode) {
		this.mode = mode;
	}

	@Override
	public int compare(Object o1, Object o2) {
		File f1 = (File) o1;
		File f2 = (File) o2;
		if (f1.isDirectory()) {
			if (f2.isDirectory()) {
				switch (mode) {
				case 1:
					return f1.getAbsolutePath().toUpperCase().compareTo(
							f2.getAbsolutePath().toUpperCase());
				case 2:
					return new Long(f1.length())
							.compareTo(new Long(f2.length()));
				case 3:
					return new Long(f2.lastModified()).compareTo(new Long(f1
							.lastModified()));
				default:
					return 1;
				}
			} else {
				return -1;
			}
		} else if (f2.isDirectory()) {
			return 1;
		} else {
			switch (mode) {
			case 1:
				return f1.getAbsolutePath().toUpperCase().compareTo(
						f2.getAbsolutePath().toUpperCase());
			case 2:
				return new Long(f1.length()).compareTo(new Long(f2.length()));
			case 3:
				return new Long(f2.lastModified()).compareTo(new Long(f1
						.lastModified()));
			default:
				return 1;
			}
		}
	}
}

public class FileUtils {

	// 目录已存在
	public static final String MU_LU_YI_CUN_ZAI = "MU_LU_YI_CUN_ZAI";
	// 建目录失败
	public static final String JIAN_MU_LU_SHI_BAI = "JIAN_MU_LU_SHI_BAI";
	private static final int BUFFER_SIZE = 16 * 1024;

	public static void copy(final File src, final File dst) {
		try {
			InputStream in = null;
			OutputStream out = null;
			try {
				in = new BufferedInputStream(new FileInputStream(src),
						BUFFER_SIZE);
				out = new BufferedOutputStream(new FileOutputStream(dst),
						BUFFER_SIZE);
				byte[] buffer = new byte[BUFFER_SIZE];
				while (in.read(buffer) > 0) {
					out.write(buffer);
				}
			} finally {
				if (null != in) {
					in.close();
				}
				if (null != out) {
					out.close();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 删除指定目录下的所有文件
	 * 
	 * @param filepath
	 * @throws IOException
	 */
	public static void delAllFilesByPath(String filepath) throws IOException {
		File f = new File(filepath);// 定义文件路径
		if (f.exists() && f.isDirectory()) {// 判断是文件还是目录
			if (f.listFiles().length == 0) {// 若目录下没有文件则直接删除
				f.delete();
			} else {// 若有则把文件放进数组，并判断是否有下级目录
				File delFile[] = f.listFiles();
				int i = f.listFiles().length;
				for (int j = 0; j < i; j++) {
					if (delFile[j].isDirectory()) {
						delAllFilesByPath(delFile[j].getAbsolutePath());// 递归调用del方法并取得子目录路径
					}
					delFile[j].delete();// 删除文件
				}
			}
			delAllFilesByPath(filepath);// 递归调用
		}
	}

	/**
	 * 删除指定WEB路径的文件
	 * 
	 * @param application
	 * @param filePath
	 */
	public static void deleteFile(ServletContext application, String filePath) {
		if (filePath != null && filePath.trim().length() >= 0) {
			String physicalFilePath = application.getRealPath(filePath);
			if (physicalFilePath != null
					&& physicalFilePath.trim().length() >= 0) {
				java.io.File file = new java.io.File(physicalFilePath);
				file.delete();
			}
		}
	}

	/**
	 * 删除指定文件
	 * 
	 * @param strFilePath
	 */
	public static void deleteFile(String strFilePath) {
		File pathToDel = new File(strFilePath.trim().replaceAll("\\+", "/")
				.replaceAll("/+", "/"));
		if (pathToDel.exists()) {
			pathToDel.delete();
		}
	}

	/**
	 * 根据文件数组删除指定文件
	 * 
	 * @param strFilePath
	 */
	public static void deleteFiles(String strPath, String[] strFileNames) {
		if (strFileNames.length > 0) {
			for (String strZP : strFileNames) {
				FileUtils.deleteFile(strPath + strZP.trim());
			}
		}
	}

	/**
	 * 获取当前路径下的文件列表
	 * 
	 * @param strPath
	 * @param intOrder
	 * @return
	 */
	public static List<FileType> getFileListByPath(String strPath, int intOrder) {
		File f = new File(strPath);
		File[] fileList = f.listFiles();
		FileComp fileComp = new FileComp(intOrder);
		Arrays.sort(fileList, fileComp);
		List<FileType> ls = new ArrayList<FileType>();
		Long longTemp = new Long(0);
		StringBuffer strTemp = new StringBuffer("");
		ls.add(new FileType());
		for (File fl : fileList) {
			if (fl.isFile()) {
				ls.add(new FileType(fl));
				longTemp += fl.length();
				strTemp.append(fl.getName() + ",");
			}
		}
		String strName = strTemp.toString();
		if (!strName.equals("") && strName.length() > 0) {
			FileType ft = new FileType();
			ft.setStrName(strName.substring(0, strName.length() - 1));
			ft.setLongLength(longTemp);
			ls.set(0, ft);
		}
		return ls;
	}

	/**
	 * 生成不重名文件名
	 * 
	 * @param strPath
	 * @param strFileName
	 * @return
	 */
	public static String getFileName(String strPath, String strFileName) {
		long intWithioutExt = Long.parseLong(new SimpleDateFormat(
				"yyyyMMddHHmmss").format(new Date())) * 1000;
		String ext = strFileName.substring(strFileName.lastIndexOf(".") + 1);
		String strNewName = String.valueOf(intWithioutExt) + "." + ext;
		File pathToSave = new File((strPath.replace("\\", "/") + "/").replace(
				"//", "/"), strNewName);
		// System.out.println((strPath.replace("\\", "/") + "/").replace("//",
		// "/")
		// + strNewName);
		while (pathToSave.exists()) {
			strNewName = String.valueOf(intWithioutExt++) + "." + ext;
			pathToSave = new File((strPath.replace("\\", "/") + "/").replace(
					"//", "/"), strNewName);
		}
		return strNewName;
	}

	/**
	 * 创建目录
	 * 
	 * @param strDir
	 * @throws Exception
	 */
	public static void mkDirs(String strDir) throws Exception {
		File baseFile = new File(strDir.replace("\\", "/"));
		if (!baseFile.exists()) {
			if (!baseFile.mkdirs()) {
				throw new Exception(JIAN_MU_LU_SHI_BAI);
			}
		}
		// else {
		// throw new Exception(MU_LU_YI_CUN_ZAI);
		// }
	}

	/**
	 * 移动文件到指定位置 不覆盖之前文件
	 * 
	 * @param strSrc
	 * @param strDst
	 */
	public static void moveFile(String strSrc, String strDst) {
		File pathToMove = new File(strSrc.trim());
		File pathMoveTo = new File(strDst.trim());
		if (pathToMove.exists() && !pathMoveTo.exists()) {
			pathToMove.renameTo(pathMoveTo);
		}
	}

	/**
	 * 向文本文件中写入内容或追加新内容,如果append为true则直接追加新内容,<br>
	 * 如果append为false则覆盖原来的内容<br>
	 * 
	 * @param path
	 * @param content
	 * @param append
	 * @throws IOException
	 */
	public static void writeFile(String path, String content, boolean append)
			throws IOException {
		// 通过这个对象来判断是否向文本文件中追加内容
		// boolean addStr = append;
		File writefile = new File(path);
		// 如果文本文件不存在则创建它
		if (writefile.exists() == false) {
			writefile.createNewFile();
			writefile = new File(path); // 重新实例化
		}
		FileOutputStream fw = new FileOutputStream(writefile);
		// System.out.println("###content:" + content);
		fw.write(content.getBytes());
		fw.flush();
		fw.close();
	}

	public static String[] writeStrutsFile(final String strPath,
			final UploadFileType uft) throws Exception {
		if (uft != null && uft.getUploadFiles() != null
				&& uft.getUploadFiles().length > 0) {
			Date dateNow = new Date();
			String strNewPath = "/" + DateUtils.getDateYM(dateNow);
			mkDirs(strPath + strNewPath);
			String strReturn[] = new String[uft.getUploadFiles().length];
			for (int i = 0; i < uft.getUploadFiles().length; i++) {
				if (uft.getUploadFiles()[i] != null) {
					String strTypePath = (strNewPath + "/" + uft
							.getUploadFilesContentType()[i].replace("/", "-")
							.replace(".", "-").replace("\\", "-")).replace(
							"\\", "/");
					String strNewFileName = getFileName(strPath + strTypePath,
							uft.getUploadFilesFileName()[i]);
					mkDirs(strPath + strTypePath);
					File fileDst = new File(
							((strPath + strTypePath + "/" + strNewFileName)
									.replace("\\", "/")).replace("//", "/"));
					copy(uft.getUploadFiles()[i], fileDst);
					// System.out.println(strTypePath + "============" +
					// fileDst);
					strReturn[i] = strTypePath + "/" + strNewFileName;
					// System.out.println((strPath + strTypePath + "/" +
					// strNewFileName).replace("\\", "/"));
				} else {
					continue;
				}
			}
			return strReturn;
		} else {
			return null;
		}
	}

	public static String[] writeStrutsFile(final String strPath,
			final UploadFileType uft, final boolean includeDate,
			final boolean includeType, final long longSize, final String strType)
			throws Exception {
		if (uft != null && uft.getUploadFiles() != null
				&& uft.getUploadFiles().length > 0) {
			Date dateNow = new Date();
			String strNewPath = "";
			if (includeDate) {
				strNewPath = "/" + DateUtils.getDateYM(dateNow);
			}
			mkDirs(strPath + strNewPath);
			String strReturn[] = new String[uft.getUploadFiles().length];
			for (int i = 0; i < uft.getUploadFiles().length; i++) {
				if (uft.getUploadFiles()[i] != null) {
					if (uft.getUploadFiles()[i].length() > longSize) {
						strReturn[i] = Constants.VALIDATION_CHAO_CHANG;
						continue;
					}
					String strTypePath = strNewPath;
					if (includeType) {
						String strFileType = uft.getUploadFilesContentType()[i]
								.replace("/", "-").replace(".", "-").replace(
										"\\", "-").toLowerCase();
						// 图片格式字符串
						String strTuPianGeShi = "/image-gif/image-x-png/image-pjpeg/image-png/image-bmp/image-jpeg/";
						// 允许的文件格式字符串
						String strWenJianGeShi = "/application-msword/application-octet-stream/application-pdf/application-vnd-ms-excel/application-vnd-ms-powerpoint/application-x-gzip/application-x-gzip-compressed/application-x-java-archive/application-x-rar/application-x-tar/application-x-zip-compressed/application-zip/text-plain/";
						if (strTuPianGeShi.indexOf("/" + strFileType + "/") >= 0) {
							strFileType = "pic";
						} else if (strWenJianGeShi.indexOf(strFileType) >= 0) {
							strFileType = "file";
						} else {
							strReturn[i] = Constants.VALIDATION_CUO_WU_LEI_XING;
							continue;
						}
						// 如果要求的文件格式不为空，且不为file，且与文件格式不同则返回类型错误
						if (strType != null && !strType.equals("file")
								&& !strType.equals(strFileType)) {
							strReturn[i] = Constants.VALIDATION_CUO_WU_LEI_XING;
							continue;
						}
						// 如果要求的文件格式不为空，则上传格式路径为要求上传的格式字符串
						if (strType != null) {
							strFileType = strType;
						}
						strTypePath = (strTypePath + "/" + strFileType);
					}
					String strNewFileName = getFileName(strPath + strTypePath,
							uft.getUploadFilesFileName()[i]);
					mkDirs(strPath + strTypePath);
					File fileDst = new File(
							(strPath + strTypePath + "/" + strNewFileName)
									.replaceAll("\\+", "/").replaceAll("/+",
											"/"));
					copy(uft.getUploadFiles()[i], fileDst);
					strReturn[i] = (strTypePath + "/" + strNewFileName)
							.replaceAll("\\+", "/").replaceAll("/+", "/");
				} else {
					continue;
				}
			}
			return strReturn;
		} else {
			return null;
		}
	}
}
