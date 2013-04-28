package com.common.web.support.task;

import org.apache.log4j.Logger;

public class AutoExcute {
	 public static Logger log = Logger
             .getLogger(AutoExcute.class);

	public void Task() {
		 // TODO Auto-generated method stub
        try {
               //log.info("Start hand Task>........");
               // 业务逻辑代码调用
              // System.out.println("Time [" + new java.util.Date().toLocaleString()
                //             + "]----->hello my name is zhanglin ！");
             //  log.info("End hand Task!");
        } catch (Exception e) {
               log.error("Hand task Exception  ", e);
        }

	}
}
