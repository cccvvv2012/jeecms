package com.common.base;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

import com.ibatis.sqlmap.client.SqlMapClient;

@Repository
public class BaseDaoIbaSpringImpl<T extends BaseModel> extends
		SqlMapClientDaoSupport {
	private String namespace;

	@Autowired
	@Resource(name = "sqlMapClient")  //这里是通spring注入的方式连接数据库
	private SqlMapClient sqlMapClient;

	public int deleteByAnd(String and) {
		int cnt = 0;
		try {
			cnt = getSqlMapClientTemplate().delete(namespace + ".delete", and);
		} catch (Exception e) {
			System.out.println(namespace + ".deleteByAnd(" + and + ")异常！"
					+ e.getMessage());
		}
		return cnt;
	}

	public T getBeanById(String id) {
		T bean = null;
		List<T> list = getList(" and fid='" + id + "'");
		if (list.size() > 0) {
			bean = list.get(0);
		}
		return bean;
	}

	public int getCount(String and) {
		int count = 0;
		try {
			Object obj = getSqlMapClientTemplate().queryForObject(
					namespace + ".getCount", and);
			if (obj != null)
				count = Integer.parseInt(obj + "");
		} catch (Exception e) {
			System.out.println(namespace + ".getCount(String)异常"
					+ e.getMessage());
		}
		return count;
	}

	public List<T> getList(String and) {
		List<T> list = new ArrayList<T>();
		try {

			list = getSqlMapClientTemplate().queryForList(
					namespace + ".getList", and);
		} catch (Exception e) {
			System.out.println(namespace + ".getList(" + and + ")异常！"
					+ e.getMessage());
		}
		return list;
	}
 

	public int getMaxId(String and) {
		int count = 0;
		try {
			Object obj = getSqlMapClientTemplate().queryForObject(
					namespace + ".getMaxId", and);
			if (obj != null)
				count = Integer.parseInt(obj + "");
		} catch (Exception e) {
			System.out.println(namespace + ".getMaxId(String)异常"
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
			list = getSqlMapClientTemplate().queryForList(
					namespace + ".getList", and, startIndex, pageSize);
		} catch (Exception e) {
			System.out.println(namespace + ".getList(" + and + ")异常！"
					+ e.getMessage());
		}
		return list;
	}

	/*
	 * @SuppressWarnings("unchecked") public List<T> getRowList(String and, int
	 * pageSize, int pageNo) { List<T> list = new ArrayList<T>(); try { int
	 * startIndex = (pageNo - 1) * pageSize; list =
	 * client.queryForList(namespace + ".getList", and , startIndex, pageSize);
	 * } catch (Exception e) { epln(namespace + ".getList(" + and + ")异常！" +
	 * e.getMessage()); } return list; }
	 */
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
			list = getSqlMapClientTemplate().queryForList(
					namespace + ".getRowList", map);
		} catch (Exception e) {
			System.out.println(namespace + ".getRowList(" + and + ")异常！"
					+ e.getMessage());
		}
		return list;
	}

	@PostConstruct
	public void initSqlMapClient() {
		super.setSqlMapClient(sqlMapClient);
	}

	public String insert(T bean) {
		try {
			getSqlMapClientTemplate().insert(namespace + ".insert", bean);
			return "1";
		} catch (Exception e) {
			System.out.println(namespace + ".insert(" + bean + ")异常！"
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
			flag = getSqlMapClientTemplate().update(namespace + ".updateById",
					bean) > 0;
		} catch (Exception e) {
			System.out.println(namespace + ".updateById(" + bean + ")异常！"
					+ e.getMessage());
		}
		return flag;
	}

}
