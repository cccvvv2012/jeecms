package com.common.tool;
//: Listmgr.c
//Used by NameCollector.java to manage
//the email list file on the server
 
import java.util.BitSet;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Stack;
 
/**
 * <pre>
 * </pre>
 * @author zhanglin
 * 
 */
/** @dll.import("USER32") */
public class GetSystemInfo {
	// ArrayList<String> fruit = new ArrayList<String>();
	// fruit.add("grape");
	// fruit.add("plum");
	// fruit.add("strawberry");

	// Iterator<String> iter = fruit.iterator();
	// if (iter.hasNext()) {
	// iter.next();
	// iter.remove(); //在删除元素的时候必须有next才行
	// }

	// 不论Collection的实际类型如何，它都支持一个iterator()的方法，该方法返回一个迭代子，使用该迭代子即可逐一访问Collection中每一个元素。典型的用法如下：
	// Iterator it = collection.iterator(); // 获得一个迭代子
	// while(it.hasNext()) {
	// 　　Object obj = it.next(); // 得到下一个元素
	// }
	public static void main(String[] args) {
		// map则需要通过迭代来取得key值
		Map map = System.getenv();
		for (Iterator it = map.keySet().iterator(); it.hasNext();)
		{
			String key = (String) it.next();
			String value = (String) map.get(key);
			System.out.println(key + ":" + value);
		}

		// 属性需要通过枚举来获得key值
		Properties props = System.getProperties();
		Enumeration enums = props.keys();
		while (enums.hasMoreElements()) {
			String key = (String) enums.nextElement();
			//AA: 差不多是goto语句
			System.out.println(key + ":" + System.getProperty(key));
		}
		BitSet set=new BitSet();
	    Stack stk=new Stack();
	    for(int i = 0; i <5; i++)
	    	stk.push(i + " ");
	    while(!stk.empty())
	    	System.out.println(stk.pop());
		//System.out.println(~1); ^，异或
      Runtime rt=Runtime.getRuntime();
      try {
		Thread.currentThread().sleep(1000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
        
    
	}
}
