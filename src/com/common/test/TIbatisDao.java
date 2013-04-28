package com.common.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class TIbatisDao {
	@Autowired
	// SampleResultSvr dao;
	//MenuSvr svr;

	@Test
	public void showData() {
		String sql = "";
		// List<SampleResult> list = dao.getList(sql);
		// System.out.println(list.size() + "------ibaits");
		// List<Menu> list2 = dao2.FindAll();
		// System.out.println(list2.size());
	}

	@Test
	public void tree() {
	/*	ArrayList<JSONTreeNode> TreeNodeArray = null;
		StringBuffer parentIDBuffer = new StringBuffer();

		List<Menu> listPID = svr.FindAll("      and leaf=0 ");
		parentIDBuffer.append("|");

		// parentIDBuffer.append(listPID.get(i).getText());// 这里是取得父结点

		String parentIDString = parentIDBuffer.toString();
		List<Menu> listLeaf = svr.FindAll("      and 1=1 ");
		TreeNodeArray = new ArrayList<JSONTreeNode>(); 

		for (int i = 0; i < listPID.size(); i++) {
			 
			for (int j = 0; j < listLeaf.size(); j++) {
				Menu mBean = listLeaf.get(j);
				JSONTreeNode TreeNode = new JSONTreeNode();
				TreeNode.setId(mBean.getFid());
				TreeNode.setText(mBean.getText());
				TreeNode.setDescription(mBean.getRemark());
				TreeNode.setHref(mBean.getHref()); // TreeNode.setId
				TreeNode.setHrefTarget(mBean.getHrefTarget());
				if (listPID.get(i).getFid() != listLeaf.get(j).getPid()) //子节点 
				// //TreeNode.setId
				{
					TreeNode.setCls("folder");
					TreeNode.setLeaf(false);
					TreeNode.setExpandable(false);
				} else // 父节点
				{
					
					TreeNode.setCls("file");
					TreeNode.setLeaf(true);
					TreeNode.setExpandable(false);
				}
				TreeNodeArray.add(TreeNode);
			}
		}
		 
		JSONArray JsonArray = JSONArray.fromObject(TreeNodeArray); // 得到JSON数组
	 
		System.out.println(JsonArray.toString());
	 */
	}
}
