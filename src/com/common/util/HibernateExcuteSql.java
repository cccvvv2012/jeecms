package com.common.util;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class HibernateExcuteSql extends HibernateDaoSupport {
	protected Session session = null;
	protected Transaction tr = null;
    public void insert()
    {
    	
    }
}
