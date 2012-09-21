package com.gemas.platform.module;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.lang.Strings;
import org.nutz.log.Log;
import org.nutz.log.Logs;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Attr;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.annotation.Param;

import com.gemas.platform.bean.User;

@IocBean
@At("/usr")
public class UserModule {

	private static final Log log = Logs.get();

	@Inject
	private Dao dao;

	@At
	public boolean login(@Param("name") String name,
			@Param("passwd") String passwd, HttpSession session) {

		if (Strings.isBlank(name) || Strings.isBlank(passwd)) {
			return false;
		}
		name = name.trim().intern();
		passwd = passwd.trim().intern();

		User user = dao.fetch(User.class,
				Cnd.where("name", "=", name).and("passwd", "=", passwd));
		if (user == null) {
			return false;
		} else {
			session.setAttribute("user", user);
			return true;
		}
	}

	@At
	@Ok(">>:/")
	public void logout(HttpSession session) {
		session.invalidate();
	}

	@At
	public User me(@Attr("user") User user) {
		return user;
	}

	@At("/ping")
	public Object ping() {
		log.debug("Dao == " + dao);
		Date date = new Date();
		return date;
	}
}
