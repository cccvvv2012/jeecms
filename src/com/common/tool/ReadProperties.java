package com.common.tool;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Enumeration;
import java.util.Properties;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class ReadProperties {
	public static String fileName = "";
	static {
		try {
			fileName = URLDecoder.decode(Thread.currentThread()
					.getContextClassLoader().getResource("jdbc.properties")
					.getPath(), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		;
	}

	public static void ClassPathXmlApplicationContext1() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:/user.xml");
		/*Users helloBean = (Users) context.getBean("Users");
		System.out.println(helloBean.getUsename());*/

	}

	public static void main(String[] arg) {
		ReadProperties p = new ReadProperties();
		// FileSystemResource();
		System.out.println("========================");
		// ClassPathXmlApplicationContext ();
		// readProperties();
		ReadAndPrintXMLFile();
		// System.out.println(p.getProperties("mysql.jdbc.password"));
	}

	/**
	 * * 获取指定xml文档的Document对象,xml文件必须在classpath中可以找到 * * @param xmlFilePath
	 * xml文件路径 * @return Document对象
	 */
	public static void ReadAndPrintXMLFile() {
		try {

			DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
			Document doc = docBuilder.parse(new File(
					"E:/workspace/zl/src/user.xml"));

			// normalize text redivsentation
			doc.getDocumentElement().normalize();
			System.out.println("Root element of the doc is "
					+ doc.getDocumentElement().getNodeName());

			NodeList listOfPersons = doc.getElementsByTagName("beans");
			int totalPersons = listOfPersons.getLength();
			System.out.println("Total no of people : " + totalPersons);

			for (int s = 0; s < listOfPersons.getLength(); s++) {

				Node firstPersonNode = listOfPersons.item(s);
				if (firstPersonNode.getNodeType() == Node.ELEMENT_NODE) {

					Element firstPersonElement = (Element) firstPersonNode;

					// -------
					NodeList firstNameList = firstPersonElement
							.getElementsByTagName("first");
					Element firstNameElement = (Element) firstNameList.item(0);

					NodeList textFNList = firstNameElement.getChildNodes();
					System.out
							.println("First Name : "
									+ (textFNList.item(0))
											.getNodeValue().trim());

					// -------
					NodeList lastNameList = firstPersonElement
							.getElementsByTagName("last");
					Element lastNameElement = (Element) lastNameList.item(0);

					NodeList textLNList = lastNameElement.getChildNodes();
					System.out
							.println("Last Name : "
									+ (textLNList.item(0))
											.getNodeValue().trim());

					// ----
					NodeList ageList = firstPersonElement
							.getElementsByTagName("Users");
					Element ageElement = (Element) ageList.item(0);

					NodeList textAgeList = ageElement.getChildNodes();
					System.out.println("Age : "
							+ (textAgeList.item(0)).getNodeValue()
									.trim());

					// ------

				}// end of if clause

			}// end of for loop with s var

		} catch (SAXParseException err) {
			System.out.println("** Parsing error" + ", line "
					+ err.getLineNumber() + ", uri " + err.getSystemId());
			System.out.println(" " + err.getMessage());

		} catch (SAXException e) {
			Exception x = e.getException();
			((x == null) ? e : x).printStackTrace();

		} catch (Throwable t) {
			t.printStackTrace();
		}
		// System.exit (0);
	}// end of main

	public static void readIbatisXml() {
		String resource = "ibatis.config.xml";
		SqlMapClient client = null;

		try {
			if (client == null) {
				Reader reader = Resources.getResourceAsReader(resource);
				client = SqlMapClientBuilder.buildSqlMapClient(reader);

				reader.close();
				reader = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void readProperties() {
		InputStream in = null;
		try {
			in = new BufferedInputStream(new FileInputStream(fileName));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Properties p = new Properties();
		try {
			p.load(in);
			Enumeration emnu = p.keys();
			while (emnu.hasMoreElements()) {
				String key = (String) emnu.nextElement();
				System.out.println(p.get(key));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public String getProperties(String key) {
		Properties prop = new Properties();
		InputStream inputStream = this.getClass().getResourceAsStream(fileName);
		try {
			prop.load(inputStream);
			if (null != inputStream) {
				inputStream.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return prop.getProperty(key);
	}

}
