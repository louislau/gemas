package com.gemas.platform.module;

import java.util.Date;

import org.nutz.mvc.annotation.At;

public class UserModule {
	@At("ping")
	public Object ping() {
		Date date = new Date();
		System.out.println("时间：" + date);
		return date;
	}
}
