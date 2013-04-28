package com.common.datatype;

import java.io.File;

public class UploadFileType {
	private File[] uploadFiles;
	private String[] uploadFilesContentType;
	private String[] uploadFilesFileName;

	public File[] getUploadFiles() {
		return uploadFiles;
	}

	public String[] getUploadFilesContentType() {
		return uploadFilesContentType;
	}

	public String[] getUploadFilesFileName() {
		return uploadFilesFileName;
	}

	public void setUploadFiles(File[] uploadFiles) {
		this.uploadFiles = uploadFiles;
	}

	public void setUploadFilesContentType(String[] uploadFilesContentType) {
		this.uploadFilesContentType = uploadFilesContentType;
	}

	public void setUploadFilesFileName(String[] uploadFilesFileName) {
		this.uploadFilesFileName = uploadFilesFileName;
	}
}
