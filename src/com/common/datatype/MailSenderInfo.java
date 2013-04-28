package com.common.datatype;

/**
 * 发送邮件需要使用的基本信息
 */
public class MailSenderInfo {
	// 发送邮件的服务器的IP和端口
	private String HostName = "smtp.gmail.com";
	// 是否使用SSL
	private Boolean isSSL = true;
	// 邮件发送者的地址
	private String SslSmtpPort = "465";
	// 邮件发接收者的地址
	private String toAddress;
	private String toName;
	private String Charset = "GBK";
	private String fromAddress;
	private Boolean isDebug = true;
	private String fromName;
	// 登陆邮件发送服务器的用户名和密码
	private String userName;
	private String password;

	// 邮件主题
	private String subject;
	// 邮件的文本内容
	private String content;

	// 邮件附件的文件名
	private String[] attachFileNames;
	private String attachmentPath;
	private String attachmentDescription;
	private String attachmentName;

	// HTML
	private String filePath;
	// 图片的地址

	private String HtmlMsg;
	// HTML代码参考："<html>The apache logo - <img src=\"cid:" + cid + "\"></html>"
	private String altermessage;

	// 图片显示不出来的文字

	public String getAltermessage() {
		return altermessage;
	}

	public String[] getAttachFileNames() {
		return attachFileNames;
	}

	public String getAttachmentDescription() {
		return attachmentDescription;
	}

	public String getAttachmentName() {
		return attachmentName;
	}

	public String getAttachmentPath() {
		return attachmentPath;
	}

	public String getCharset() {
		return Charset;
	}

	public String getContent() {
		return content;
	}

	public String getFilePath() {
		return filePath;
	}

	public String getFromAddress() {
		return fromAddress;
	}

	public String getFromName() {
		return fromName;
	}

	public String getHostName() {
		return HostName;
	}

	public String getHtmlMsg() {
		return HtmlMsg;
	}

	public Boolean getIsDebug() {
		return isDebug;
	}

	public Boolean getIsSSL() {
		return isSSL;
	}

	public String getPassword() {
		return password;
	}

	public String getSslSmtpPort() {
		return SslSmtpPort;
	}

	public String getSubject() {
		return subject;
	}

	public String getToAddress() {
		return toAddress;
	}

	public String getToName() {
		return toName;
	}

	public String getUserName() {
		return userName;
	}

	public void setAltermessage(String altermessage) {
		this.altermessage = altermessage;
	}

	public void setAttachFileNames(String[] attachFileNames) {
		this.attachFileNames = attachFileNames;
	}

	public void setAttachmentDescription(String attachmentDescription) {
		this.attachmentDescription = attachmentDescription;
	}

	public void setAttachmentName(String attachmentName) {
		this.attachmentName = attachmentName;
	}

	public void setAttachmentPath(String attachmentPath) {
		this.attachmentPath = attachmentPath;
	}

	public void setCharset(String charset) {
		Charset = charset;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public void setFromAddress(String fromAddress) {
		this.fromAddress = fromAddress;
	}

	public void setFromName(String fromName) {
		this.fromName = fromName;
	}

	public void setHostName(String hostName) {
		HostName = hostName;
	}

	public void setHtmlMsg(String htmlMsg) {
		HtmlMsg = htmlMsg;
	}

	public void setIsDebug(Boolean isDebug) {
		this.isDebug = isDebug;
	}

	public void setIsSSL(Boolean isSSL) {
		this.isSSL = isSSL;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setSslSmtpPort(String sslSmtpPort) {
		SslSmtpPort = sslSmtpPort;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public void setToAddress(String toAddress) {
		this.toAddress = toAddress;
	}

	public void setToName(String toName) {
		this.toName = toName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}