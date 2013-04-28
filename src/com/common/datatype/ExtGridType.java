package com.common.datatype;

import java.util.ArrayList;
import java.util.List;

public class ExtGridType<T> {
	private Integer limit = 10;
	private Integer start = 0;
	private Integer total = 0;
	private List<T> list = new ArrayList<T>();
	private String success = "true";

	public Integer getLimit() {
		return limit;
	}

	public List<T> getList() {
		return list;
	}

	public Integer getStart() {
		return start;
	}

	public String getSuccess() {
		return success;
	}

	public Integer getTotal() {
		return total;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public void setSuccess(String success) {
		this.success = success;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

}
