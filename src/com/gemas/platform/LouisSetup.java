package com.gemas.platform;

import org.nutz.dao.Dao;
import org.nutz.dao.entity.annotation.Table;
import org.nutz.log.Log;
import org.nutz.log.Logs;
import org.nutz.mvc.NutConfig;
import org.nutz.mvc.Setup;
import org.nutz.resource.Scans;

import com.gemas.platform.bean.User;

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
		if (dao.count(User.class) == 0) {
			User admin = new User();
			admin.setName("admin");
			admin.setPasswd("123456");
			dao.insert(admin);
		}

	}

	@Override
	public void destroy(NutConfig config) {

	}

}
