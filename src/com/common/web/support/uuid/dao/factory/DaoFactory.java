package com.common.web.support.uuid.dao.factory;

import com.common.web.support.uuid.dao.dao.UuidDAO;
import com.common.web.support.uuid.dao.impl.JdbcImpl;

public class DaoFactory {
	private DaoFactory(){}
	
	public static UuidDAO getUuidDAO(){
		return new JdbcImpl();
	}
}
