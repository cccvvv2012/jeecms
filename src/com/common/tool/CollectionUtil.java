package com.common.tool;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

public class CollectionUtil {
	/* 判断集合是否为空 */
	public static boolean isCollectionEmpty(Collection pCollection) {
		return null != pCollection && pCollection.size() > 0;
	}

	/**
	 * 把一个List根据其中对象的属性值进行分组，返回一个Map，属性值为key，分组（list）对象为value。
	 * 
	 * @param list
	 * @param property
	 * @return
	 */
	public static LinkedHashMap listToGroupByProperty(List list, String property) {
		LinkedHashMap map = new LinkedHashMap();
		if (list == null || list.isEmpty() || StringUtils.isBlankStr(property))
			return map;
		for (Iterator iter = list.iterator(); iter.hasNext();) {
			Object object = iter.next();
			Object key = null;
			try {
				key = BeanUtils.getBeanProperty(object, property);
				List keyList = null;
				if (map.containsKey(key)) {
					keyList = (List) map.get(key);
					keyList.add(object);
				} else {
					keyList = new ArrayList();
					keyList.add(object);
					map.put(key, keyList);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return map;
	}

	/**
	 * 把一个list转换成一个Map，以list中每个对象的property属性的值为Key，对象自身为value。 <br>
	 * 适用场景：list中对象的property值具有唯一性。
	 * 
	 * @param list
	 * @param property
	 * @return 传入无效的参数时，返回一个空的Map实例。
	 */
	public static LinkedHashMap listToMapByProperty(List list, String property) {
		LinkedHashMap map = new LinkedHashMap();
		if (list == null || list.isEmpty() || StringUtils.isBlankStr(property)) {
			return map;
		}
		for (Iterator iter = list.iterator(); iter.hasNext();) {
			Object object = iter.next();
			Object key = null;
			try {
				key = BeanUtils.getBeanProperty(object, property);
				map.put(key, object);
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException("获取对象属性时产生异常:" + e);
			}

		}
		return map;
	}
}
