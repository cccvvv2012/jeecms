package com.common.base;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaseDaoIbaImp<T> extends BaseIbaConf {
	private String namespace;

	public int deleteByAnd(String and) {
		int cnt = 0;
		try {
			cnt = client.delete(namespace + ".deleteByAnd", and);
			System.out.println(namespace + "deleteByAnd(" + and + ")"
					 );
		} catch (Exception e) {
			System.out.println(namespace + "deleteByAnd(" + and + ")"
					+ e.getMessage());
		}
		return cnt;
	}

	public T getBeanById(String id) {
		T bean = null;
		List<T> list = new ArrayList<T>();
		try {
			list = client.queryForList(namespace + ".getbeanById", id);
			if (list.size() > 0) {
				bean = list.get(0);
			}
		} catch (Exception e) {
			System.out.println(namespace + ".getbeanById(" + id + ")"
					+ e.getMessage());
		}
		return bean;
	}

	public int getCount(String and) {
		int count = 0;
		try {
			Object obj = client.queryForObject(namespace + ".getCount", and);
			if (obj != null)
				count = Integer.parseInt(obj + "");
		} catch (Exception e) {
			System.out.println(namespace + ".getCount(" + and + ")"
					+ e.getMessage());
		}
		return count;
	}

	public List<T> getList(String and) {
		List<T> list = new ArrayList<T>();
		try {

			list = client.queryForList(namespace + ".getList", and);
		} catch (Exception e) {
			System.out.println(namespace + ".getList(" + and + ")"
					+ e.getMessage());
		}
		return list;
	}

	public int getMaxId(String and) {
		int count = 0;
		try {
			Object obj = client.queryForObject(namespace + ".getMaxId", and);
			if (obj != null)
				count = Integer.parseInt(obj + "");
		} catch (Exception e) {
			System.out.println(namespace + ".getMaxId(" + and + ")"
					+ e.getMessage());
		}
		return count;
	}

	public String getNamespace() {
		return namespace;
	}

	@SuppressWarnings("unchecked")
	public List<T> getPageList(String and, int pageSize, int pageNo) {
		List<T> list = new ArrayList<T>();
		try {
			int startIndex = (pageNo - 1) * pageSize;
			list = client.queryForList(namespace + ".getList", and, startIndex,
					pageSize);
		} catch (Exception e) {
			System.out.println(namespace + ".getPageList(" + and + ")"
					+ e.getMessage());
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<T> getRowList(String and, int pageSize, int pageNo) {
		List<T> list = new ArrayList<T>();
		try {
			int startIdx = (pageNo - 1) * pageSize;
			int endIdx = pageNo * pageSize;
			Map<Object, Object> map = new HashMap<Object, Object>();
			map.put("condition", and);
			map.put("startIdx", startIdx);
			map.put("endIdx", endIdx);
			list = client.queryForList(namespace + ".getRowList", and,
					startIdx, pageSize);
		} catch (Exception e) {
			System.out.println(namespace + ".getRowList(" + and + ")"
					+ e.getMessage());
		}
		return list;
	}

	public String insert(T bean) {
		try {
			client.insert(namespace + ".insert", bean);
			return "1";
		} catch (Exception e) {
			System.out.println(namespace + ".insert(" + bean + ")"
					+ e.getMessage());
			return "0";
		}
	}

	public void setNamespace(String namespace) {
		this.namespace = namespace;
	}

	public boolean updateById(T bean) {
		boolean flag = false;
		try {
			flag = client.update(namespace + ".updateById", bean) > 0;
		} catch (Exception e) {
			System.out.println(namespace + ".updateById(" + bean + ")"
					+ e.getMessage());
		}
		return flag;
	}

}
