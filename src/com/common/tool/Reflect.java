package com.common.tool;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class Reflect {
	public Map getDbInfo(Object object, String mname) {
		Map<String, String> map = new HashMap<String, String>();
		try {
			Method md = object.getClass().getMethod(mname, null);
			map = (Map) md.invoke(object, null);
		} catch (Exception e) {
			System.out.println("反射数据类型错误!");
		}
		return map;
	}

	// 得到某个对象的属性

	public Object getProperty(Object owner, String fieldName) throws Exception {
		Class ownerClass = owner.getClass();

		Field field = ownerClass.getField(fieldName);

		Object property = field.get(owner);

		return property;
	}

	// Object property =
	// field.get(owner)：通过对象得到该属性的实例，如果这个属性是非公有的，这里会报IllegalAccessException。

	// 2. 得到某个类的静态属性

	public Object getStaticProperty(String className, String fieldName)
			throws Exception {
		Class ownerClass = Class.forName(className);

		Field field = ownerClass.getField(fieldName);

		Object property = field.get(ownerClass);

		return property;
	}

	// 执行某对象的方法

	public Object invokeMethod(Object owner, String methodName, Object[] args)
			throws Exception {

		Class ownerClass = owner.getClass();

		Class[] argsClass = new Class[args.length];

		for (int i = 0, j = args.length; i < j; i++) {
			argsClass[i] = args[i].getClass();
		}

		Method method = ownerClass.getMethod(methodName, argsClass);

		return method.invoke(owner, args);
	}

	// Class owner_class = owner.getClass() ：首先还是必须得到这个对象的Class

	// 4. 执行某个类的静态方法

	public Object invokeStaticMethod(String className, String methodName,
			Object[] args) throws Exception {
		Class ownerClass = Class.forName(className);

		Class[] argsClass = new Class[args.length];

		for (int i = 0, j = args.length; i < j; i++) {
			argsClass[i] = args[i].getClass();
		}

		Method method = ownerClass.getMethod(methodName, argsClass);

		return method.invoke(null, args);
	}

	// 新建实例

	public Object newInstance(String className, Object[] args) throws Exception {
		Class newoneClass = Class.forName(className);

		Class[] argsClass = new Class[args.length];

		for (int i = 0, j = args.length; i < j; i++) {
			argsClass[i] = args[i].getClass();
		}

		Constructor cons = newoneClass.getConstructor(argsClass);

		return cons.newInstance(args);

	}

}
