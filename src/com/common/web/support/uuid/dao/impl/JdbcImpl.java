package com.common.web.support.uuid.dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.common.util.JDBCTemplate;
import com.common.web.support.uuid.dao.dao.UuidDAO;
import com.common.web.support.uuid.vo.UuidModel;
import com.common.web.support.uuid.vo.UuidQueryModel;

//这里就用jdbc到时读porpertes文件，看表名是字段怎么确定
public class JdbcImpl extends JDBCTemplate<UuidModel,UuidQueryModel> implements UuidDAO{

	@Override
	protected String getUpdateSql(UuidModel m) {
		return "update tbl_uuid set num=? where preFix=?";
	}

	@Override
	protected void setUpdateValue(PreparedStatement pstmt, UuidModel m)
			throws SQLException {
		pstmt.setInt(1,m.getNum());
		pstmt.setString(2,m.getPreFix());
	}
	
}
