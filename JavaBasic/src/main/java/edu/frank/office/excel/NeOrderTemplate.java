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
 *  : <NeOrderTemplate.java>
 *  : 1.0
 * 
 *
 *  : < Email:<a href="mailto:Guanxiong Deng@hozdo.com">Guanxiong Deng@hozdo.com</a>>
 * : <2011-6-23 09:15:22>
 *
 *
 */
package edu.frank.office.excel;

import org.apache.log4j.Logger;

import edu.frank.log4j.Log4JConfig;

/**
 * <p>
 * 	<>
 * </p>
 *
 *  @author < Email:<a href="mailto:Guanxiong Deng@hozdo.com">Guanxiong Deng@hozdo.com</a>>
 * <p>
 *
 *		<> <p>
 *	<2011-6-23 09:15:22> <p>
 *	<>	 <p>
 *
 *
 * @since HOZDoEAS7.0 1.0
 * @Version HOZDoEAS7.0 1.0
 */
public class NeOrderTemplate extends Template {

	/**
	 * <>
	 *
	 * @since HOZDoEAS7.0 1.0
	 */
	private static Logger logger = Log4JConfig.getLogger(NeOrderTemplate.class);

	/**
	 *
	 * <p>
	 * &lt  <code>NeOrderTemplate</code> &gt
	 * </p>
	 *
	 *
	 * @since HOZDoEAS7.0 1.0
	 */
	public NeOrderTemplate() {
		super();
		this.templateId = getClass().toString();
		this.templateName = getClass().getName();
		this.templateDescription = "";
		this.templateManager = NeOrderTemplateManager.getManager();
	}
}