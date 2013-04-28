package com.common.tool;

import java.io.File;
import java.net.MalformedURLException;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.apache.commons.mail.SimpleEmail;

import com.common.datatype.MailSenderInfo;

public class MailServer {
	/**
	 * 以HTML格式发送邮件
	 * 
	 * @param mailInfo
	 *            待发送的邮件信息
	 * @return
	 * @throws EmailException
	 * @throws MalformedURLException
	 */
	public static void sendHtmlMail(MailSenderInfo mailInfo)
			throws EmailException, MalformedURLException {
		HtmlEmail email = new HtmlEmail();
		System.out.println("----------------------email");
		email.setHostName(mailInfo.getHostName()); // 设定smtp服务器
		email.setSSL(mailInfo.getIsSSL()); // 设定是否使用SSL
		email.setSslSmtpPort(mailInfo.getSslSmtpPort()); // 设定SSL端口
		email.setAuthentication(mailInfo.getUserName(), mailInfo.getPassword()); // 设定smtp服务器的认证资料信息
		email.setDebug(mailInfo.getIsDebug()); // 是否用debug模式
		email.addTo(mailInfo.getToAddress(), mailInfo.getToName()); // 设定收件人
		email.setFrom(mailInfo.getFromAddress(), mailInfo.getFromName());
		email.setSubject(mailInfo.getSubject());
		// embed the image and get the content id
		File file = new File(mailInfo.getFilePath());
		String cid = email.embed(file);
		// set the html message
		email.setHtmlMsg("<html>" + mailInfo.getHtmlMsg() + "<img src=\"cid:"
				+ cid + "\"></html>");

		// set the alternative message
		email.setTextMsg(mailInfo.getAltermessage());
		// send the email

		email.send();
	}

	/**
	 * 以文本格式发送邮件
	 * 
	 * @param mailInfo
	 *            待发送的邮件的信息
	 */
	public static boolean sendTextMail(MailSenderInfo mailInfo) {
		SimpleEmail email = new SimpleEmail();
		try {

			email.setHostName(mailInfo.getHostName()); // 设定smtp服务器
			email.setSSL(mailInfo.getIsSSL()); // 设定是否使用SSL
			email.setSslSmtpPort(mailInfo.getSslSmtpPort()); // 设定SSL端口
			email.setAuthentication(mailInfo.getUserName(), mailInfo
					.getPassword()); // 设定smtp服务器的认证资料信息
			email.setDebug(mailInfo.getIsDebug()); // 是否用debug模式
			email.addTo(mailInfo.getToAddress(), mailInfo.getToName()); // 设定收件人
			email.setFrom(mailInfo.getFromAddress(), mailInfo.getFromName());
			email.setSubject(mailInfo.getSubject());
			email.setCharset(mailInfo.getCharset());// 设定内容的语言集
			email.setMsg(mailInfo.getContent());// 设定邮件内容
			email.send();// 发送邮件
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

}
