package edu.frank.copy;

import java.sql.Date;

import org.apache.commons.beanutils.ConversionException;
import org.apache.commons.beanutils.Converter;

public final class SqlDateConverter implements Converter {

	private Object defaultValue = null;
	private boolean useDefault = false;

	public SqlDateConverter() {
		this.defaultValue = null;
		this.useDefault = false;
	}
	public SqlDateConverter(Object defaultValue) {
		this.defaultValue = defaultValue;
		this.useDefault = true;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Object convert(Class type, Object value) {
		if (value == null || "".equals(value)) {
			if (useDefault) {
				return this.defaultValue;
			} else {
				throw new ConversionException("No value specified");
			}
		}
		if (value instanceof Date) {
			return value;
		}
		try {
			return Date.valueOf(value.toString());
		}catch (Exception e) {
			if (useDefault) {
				return value;
			} else {
				throw new ConversionException(e);
			}
		}
	}

}
