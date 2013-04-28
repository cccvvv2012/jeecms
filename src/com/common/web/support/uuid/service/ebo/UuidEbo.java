package com.common.web.support.uuid.service.ebo;

import java.util.List;

import com.common.web.support.uuid.dao.factory.DaoFactory;
import com.common.web.support.uuid.service.ebi.UuidEbi;
import com.common.web.support.uuid.service.factory.UuidFactory;
import com.common.web.support.uuid.vo.UuidModel;
import com.common.web.support.uuid.vo.UuidQueryModel;

public class UuidEbo implements UuidEbi{
	public static void main(String[] args) {
		int num = UuidFactory.getUuidEbi().getNextUuid("cc");
		System.out.println("num=="+num);
		num = UuidFactory.getUuidEbi().getNextUuid("cc");
		System.out.println("num22=="+num);
	}
	@Override
	public void create(UuidModel m) {
		DaoFactory.getUuidDAO().create(m);
	}

	@Override
	public void update(UuidModel m) {
		DaoFactory.getUuidDAO().update(m);		
	}

	@Override
	public void delete(UuidModel m) {
		DaoFactory.getUuidDAO().delete(m);
	}

	@Override
	public UuidModel getByUuid(int uuid) {
		return DaoFactory.getUuidDAO().getByUuid(new UuidQueryModel(), uuid);
	}

	@Override
	public List<UuidModel> getAll(int fromNum,int toNum) {
		return DaoFactory.getUuidDAO().getAll(new UuidQueryModel(),fromNum,toNum);
	}

	@Override
	public List<UuidModel> getByCondition(UuidQueryModel qm,int fromNum,int toNum) {
		return DaoFactory.getUuidDAO().getByCondition(qm,fromNum,toNum);
	}

	@Override
	public int getNextUuid(String tblName) {
		//1：应该跟据表名做前缀，去数据库tbl_uuid里面查找数据
		UuidQueryModel uqm = new UuidQueryModel();
		uqm.setPreFix(tblName);
		
		List<UuidModel> list = this.getByCondition(uqm,1,100);
		if(list==null || list.size()==0){
			//2：如果找不到，说明是第一次用，那么nextUuid=1,同时向tbl_uuid新增一条数据
			UuidModel um = new UuidModel();
			um.setNum(1);
			um.setPreFix(tblName);
			
			this.create(um);
			
			return 1;
		}else{
			//3：如果找到了，就对num+1,这就是nextuuid，同时修改这条数据
			UuidModel um = list.get(0);
			int num = um.getNum()+1;
			um.setNum(num);			
			
			this.update(um);
			
			return num;
		}
	}
	@Override
	public int getCount(UuidQueryModel qm) {
		return DaoFactory.getUuidDAO().getCount(qm);
	}


}
