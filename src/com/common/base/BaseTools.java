package com.common.base;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

//��������
public class BaseTools {
	public SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public SimpleDateFormat fmt1 = new SimpleDateFormat("yyyy-MM-dd");
	public SimpleDateFormat pkt = new SimpleDateFormat("yyyyMMddHHmmss");

	// ���ʱ������������ʱ����+3λ������+3λ������+4λ�����
	public String createTimePK() {
		String time = pkt.format(new Date());
		String nano = (System.nanoTime() + "");
		nano = nano.substring(nano.length() - 6);
		int ran = new Random().nextInt(10000);
		String sran = ran + "";
		if (ran < 10)
			sran = "000" + ran;
		else if (ran < 100)
			sran = "00" + ran;
		else if (ran < 1000)
			sran = "0" + ran;
		return time + "" + nano + "" + sran + "";
	}

	// ���UUID����������
	public String createUUID() {
		UUID uuid = UUID.randomUUID();
		return uuid.toString().replaceAll("-", "").toUpperCase();
	}

	// �쳣���
	public void epln(Object obj) {
		System.err.println(obj);
	}

	// ��ҳҳ��
	public int getPageCount(int pageSize, int count) {
		int pageCount = 0;
		if (pageSize > 0 && count > 0) {
			if (count % pageSize > 0)
				pageCount = count / pageSize + 1;
			else
				pageCount = count / pageSize;
		}
		return pageCount;
	}

	// �����
	public void pln(Object obj) {
		System.out.println(obj);
	}
}