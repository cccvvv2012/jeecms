package com.common.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.common.util.MyJdbcTemplate;

@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class TMyJdbcTemplate {
	@Test
	public void readData() {
		MyJdbcTemplate myJdbcTemplate = new MyJdbcTemplate();
		myJdbcTemplate.sett();
	}
}
