package com.common.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;

import com.common.util.SpringUtils;

public class TBaseHibernateDao {

	/**
	 * @param args
	 */
	@Test
	public void TBaseHibernateDaoImpl() {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = SpringUtils.GetSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		System.out.println("进入到结果查看的页面");
		/*
		 * ItemParameterSvr svr1 = new ItemParameterSvrImpl();
		 * List<Itemparameter> list1 = svr1.FindAll();
		 * System.out.println(list1); UserTabSvr svr = new UserTabSvrImpl();
		 * List<Usertab> list = svr.FindAll(); System.out.println(list.size());
		 * System.out.println(list);
		 */
		/*
		 * SampleTypeSvr svr2 = new SampleTypeSvrImpl(); List<Sampletype> list2
		 * = svr2.FindAll();
		 * 
		 * ClinicDiagnoseTypeSvr svr3 = new ClinicDiagnoseTypeSvrImpl();
		 * List<Clinicdiagnosetype> list3 = svr3.FindAll();
		 * 
		 * HospitalInformationSvr svr4 = new HospitalInformationSvrImpl();
		 * List<Hospitalinformation> list4 = svr4.FindAll();
		 * 
		 * SampleStatusSvr svr5 = new SampleStatusSvrImpl(); List<Samplestatus>
		 * list5 = svr5.FindAll();
		 * 
		 * SampleTypeSvr svr6 = new SampleTypeSvrImpl(); List<Sampletype> list6
		 * = svr6.FindAll();
		 * 
		 * // for (int i = 1; i < 6; i++) { System.out.println(list1 + "--" +
		 * list2 + "--" + list3 + "--" + list4 + "--" + list5 + "--" + list6 +
		 * "--");
		 */
	}

}
