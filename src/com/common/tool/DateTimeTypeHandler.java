package com.common.tool;

import java.sql.SQLException;
import java.util.Date;

import com.common.base.BaseTools;
import com.ibatis.sqlmap.client.extensions.ParameterSetter;
import com.ibatis.sqlmap.client.extensions.ResultGetter;
import com.ibatis.sqlmap.client.extensions.TypeHandlerCallback;

public class DateTimeTypeHandler extends BaseTools implements
		TypeHandlerCallback {
	@Override
	public Object getResult(ResultGetter getter) throws SQLException {
		Date dd = getter.getTimestamp();
		if (dd == null)
			return "";
		else
			return fmt.format(dd);
	}

	@Override
	public void setParameter(ParameterSetter setter, Object parameter)
			throws SQLException {
	}

	@Override
	public Object valueOf(String s) {
		return null;
	}
}