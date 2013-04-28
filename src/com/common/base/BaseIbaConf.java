package com.common.base;

import java.io.Reader;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class BaseIbaConf extends BaseTools {
	protected static String resource = "ibatis.config.xml";
	protected static SqlMapClient client = null;
	static {
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
}
