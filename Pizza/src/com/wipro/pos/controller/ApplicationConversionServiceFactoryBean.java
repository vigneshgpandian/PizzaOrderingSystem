

package com.wipro.pos.controller;


import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.support.FormattingConversionServiceFactoryBean;


public class ApplicationConversionServiceFactoryBean extends FormattingConversionServiceFactoryBean {

	@Override
	protected void installFormatters (final FormatterRegistry registry) {
		super.installFormatters(registry);
		registry.addConverter(getStringToDateConverter());
	}
	public Converter<String, java.util.Date> getStringToDateConverter () {
		return new Converter<String, java.util.Date>() {

			@Override
			public java.util.Date convert (final String source) {
				SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
				try {
					return sdf.parse(source);
				} catch (ParseException e) {
					return null;
				}
			}
		};
	}
}