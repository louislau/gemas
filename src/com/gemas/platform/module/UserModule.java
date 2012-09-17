package com.gemas.platform.module;

import java.util.Date;

import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.log.Log;
import org.nutz.log.Logs;
import org.nutz.mvc.annotation.At;

@IocBean
public class UserModule {

	private static final Log log = Logs.get();

	@Inject
	private Dao dao;

	@At("ping")
	public Object ping() {
		log.debug("Dao == " + dao);
		Date date = new Date();
		return date;
	}
}
