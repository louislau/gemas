package com.gemas.platform;

import org.nutz.dao.Dao;
import org.nutz.dao.entity.annotation.Table;
import org.nutz.log.Log;
import org.nutz.log.Logs;
import org.nutz.mvc.NutConfig;
import org.nutz.mvc.Setup;
import org.nutz.resource.Scans;

public class LouisSetup implements Setup {
	private static final Log log = Logs.get();

	@Override
	public void init(NutConfig config) {
		// log.debug("config ioc:" + config.getIoc());
		Dao dao = config.getIoc().get(Dao.class);
		for (Class<?> clazz : Scans.me().scanPackage("com.gemas.platform")) {
			if (null != clazz.getAnnotation(Table.class)) {
				dao.create(clazz, false);
			}
		}
	}

	@Override
	public void destroy(NutConfig config) {

	}

}
