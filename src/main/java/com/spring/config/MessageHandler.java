package com.spring.config;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * 
 * Handle message Internationalization (i18n)
 *
 */
@Component
public class MessageHandler {
	@Autowired
	ApplicationContext applicationContext;


	public String getMessage(String code) {
		return applicationContext.getMessage(code, null, Locale.ENGLISH);
	}

	
	public String getMessage(String code, Object[] objs) {
		return applicationContext.getMessage(code, objs, Locale.ENGLISH);
	}
}
