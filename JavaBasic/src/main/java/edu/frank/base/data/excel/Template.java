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
 *  : <BaseTemplate.java>
 *  : 1.0
 * 
 *
 *  : < Email:<a href="mailto:Guanxiong Deng@hozdo.com">Guanxiong Deng@hozdo.com</a>>
 * : <2011-6-24 09:21:16>
 *
 *
 */
package edu.frank.base.data.excel;

import org.apache.log4j.Logger;

import edu.frank.log4j.Log4JConfig;

/**
 * <p>
 * 	<>
 * </p>
 *  @author < Email:<a href="mailto:Guanxiong Deng@hozdo.com">Guanxiong Deng@hozdo.com</a>>
 * <p>
 *
 *		<> <p>
 *	<2011-6-24 09:21:16> <p>
 *	<>	 <p>
 *
 *
 * @since HOZDoEAS7.0 1.0
 * @Version HOZDoEAS7.0 1.0
 */
public abstract class Template implements Cloneable, Comparable {

	protected ITemplateManager templateManager;

	protected String templateId;

	protected String templateName;

	protected String templateDescription;

	/**
	 * <>
	 *
	 * @since HOZDoEAS7.0 1.0
	 */
	private static final Logger logger = Log4JConfig.getLogger(Template.class);

	/**
	 * <Excel>
	 *
	 * @since HOZDoEAS7.0 1.0
	 */
	protected ExcelUtils excelUtils = null;

	/**
	 *
	 * &lt  <code>BaseTemplate</code>  &gt
	 *
	 * @since HOZDoEAS7.0 1.0
	 */
	protected Template() {
		this.excelUtils = ExcelUtils.getInstance();
		if (this.templateManager == null) {
			this.templateManager = BasTemplateManager.getManager();
		}
	}
	/**
	 * @return the templateManager
	 */
	public ITemplateManager getTemplateManager() {
		return this.templateManager;
	}

	/**
	 * @param templateManager the templateManager to set
	 */
	public void setTemplateManager(ITemplateManager templateManager) {
		this.templateManager = templateManager;
	}

	/**
	 * @return the templateId
	 */
	public String getTemplateId() {
		return this.templateId;
	}

	/**
	 * @param templateId the templateId to set
	 */
	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}

	/**
	 * @return the templateName
	 */
	public String getTemplateName() {
		return this.templateName;
	}

	/**
	 * @param templateName the templateName to set
	 */
	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}

	/**
	 * @return the templateDescription
	 */
	public String getTemplateDescription() {
		return this.templateDescription;
	}

	/**
	 * @param templateDescription the templateDescription to set
	 */
	public void setTemplateDescription(String templateDescription) {
		this.templateDescription = templateDescription;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	@Override
	public String toString() {
		return this.getClass().getName() + ":[id=" + this.templateId + ",name=" + this.templateName + ",description=" + this.templateDescription + "]";
	}




}