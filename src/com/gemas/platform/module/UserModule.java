package com.gemas.platform.module;

import java.util.Date;

import org.nutz.mvc.annotation.At;

public class UserModule {
	@At("ping")
	private Object ping() {
		return new Date();
	}
}
