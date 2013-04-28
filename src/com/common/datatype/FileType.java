package com.common.datatype;

import java.io.File;
import java.util.Date;

public class FileType {
	private String strName;
	private String strPath;
	private boolean boolDirectory;
	private boolean boolFile;
	private boolean boolHidden;
	private boolean boolCanRead;
	private boolean boolCanWrite;
	private boolean boolExists;
	private long longLength;
	private long longLastModified;
	private Date dateLastModified;

	public FileType() {

	}

	public FileType(File fl) {
		this.setStrName(fl.getName());
		this.setStrPath(fl.getPath());
		this.setBoolDirectory(fl.isDirectory());
		this.setBoolFile(fl.isFile());
		this.setBoolHidden(fl.isHidden());
		this.setBoolCanWrite(fl.canRead());
		this.setBoolCanWrite(fl.canWrite());
		this.setBoolExists(fl.exists());
		this.setLongLength(fl.length());
		this.setLongLastModified(fl.lastModified());
	}

	public Date getDateLastModified() {
		dateLastModified = new Date(longLastModified);
		return dateLastModified;
	}

	public long getLongLastModified() {
		return longLastModified;
	}

	public long getLongLength() {
		return longLength;
	}

	public String getStrName() {
		return strName;
	}

	public String getStrPath() {
		return strPath;
	}

	public boolean isBoolCanRead() {
		return boolCanRead;
	}

	public boolean isBoolCanWrite() {
		return boolCanWrite;
	}

	public boolean isBoolDirectory() {
		return boolDirectory;
	}

	public boolean isBoolExists() {
		return boolExists;
	}

	public boolean isBoolFile() {
		return boolFile;
	}

	public boolean isBoolHidden() {
		return boolHidden;
	}

	public void setBoolCanRead(boolean boolCanRead) {
		this.boolCanRead = boolCanRead;
	}

	public void setBoolCanWrite(boolean boolCanWrite) {
		this.boolCanWrite = boolCanWrite;
	}

	public void setBoolDirectory(boolean boolDirectory) {
		this.boolDirectory = boolDirectory;
	}

	public void setBoolExists(boolean boolExists) {
		this.boolExists = boolExists;
	}

	public void setBoolFile(boolean boolFile) {
		this.boolFile = boolFile;
	}

	public void setBoolHidden(boolean boolHidden) {
		this.boolHidden = boolHidden;
	}

	public void setDateLastModified(Date dateLastModified) {
		this.dateLastModified = dateLastModified;
	}

	public void setLongLastModified(long longLastModified) {
		this.longLastModified = longLastModified;
	}

	public void setLongLength(long longLength) {
		this.longLength = longLength;
	}

	public void setStrName(String strName) {
		this.strName = strName;
	}

	public void setStrPath(String strPath) {
		this.strPath = strPath;
	}

}
