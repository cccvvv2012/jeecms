package com.common.util;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class MyJdbcTemplate {
	@Resource(name = "dbcp")
	private DataSource dbcp;

	@Test
	public void sett() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dbcp);
        System.out.println(jdbcTemplate.queryForList("select * from usertab").size());
	}
}
