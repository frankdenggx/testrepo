/*
 * 
 * Copyright (c) 2011 - HOZDO Logistics Co.,Ltd All Right Reserved.
 * 
 *
 * 
 * 
 *
 */

/**
 *  : <>
 * EAS : <7.0>
 *  : <HOZDoEAS7.0>
 *
 *  : <com.kingdee.eas.hozdo.common.excel>
 *  : <BasTemplateManager.java>
 *  : 1.0
 * 
 *
 *  : < Email:<a href="mailto:Guanxiong Deng@hozdo.com">Guanxiong Deng@hozdo.com</a>>
 * : <2011-6-24 11:20:28>
 *
 *
 */
package edu.frank.office.excel;

/**
 * <p>
 * 	<>
 * </p>
 *  @author < Email:<a href="mailto:Guanxiong Deng@hozdo.com">Guanxiong Deng@hozdo.com</a>>
 * <p>
 *
 *		<> <p>
 *	<2011-6-24 11:20:28> <p>
 *	<>	 <p>
 *
 *
 * @since HOZDoEAS7.0 1.0
 * @Version HOZDoEAS7.0 1.0
 */
public class BasTemplateManager extends TemplateManager {

	private static BasTemplateManager manager = null;

	private BasTemplateManager() {
		super();
	}

	public static BasTemplateManager getManager() {
		if (manager == null) {
			manager = new BasTemplateManager();
		}
		return manager;
	}

	/* (non-Javadoc)
	 * @see com.kingdee.eas.hozdo.common.excel.TemplateManager#excuteAfterReadData()
	 */
	@Override
	void excuteAfterReadData() {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.kingdee.eas.hozdo.common.excel.TemplateManager#excuteBeforeReadData()
	 */
	@Override
	void excuteBeforeReadData() {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.kingdee.eas.hozdo.common.excel.TemplateManager#excuteBeforeReadFile()
	 */
	@Override
	void excuteBeforeReadFile() {
		// TODO Auto-generated method stub

	}

}