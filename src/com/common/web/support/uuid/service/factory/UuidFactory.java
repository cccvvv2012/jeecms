package com.common.web.support.uuid.service.factory;

import com.common.web.support.uuid.service.ebi.UuidEbi;
import com.common.web.support.uuid.service.ebo.UuidEbo;

public class UuidFactory {
	private UuidFactory(){}
	public static UuidEbi getUuidEbi(){
		return new UuidEbo();
	}
}
