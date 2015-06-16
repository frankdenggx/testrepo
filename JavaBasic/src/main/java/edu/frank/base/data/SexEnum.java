/*
 * 
 * Copyright (c) 2011 - HOZDO Logistics Co.,Ltd All Right Reserved.
 *  HOTEL1802 STUDIO 
 *
 * 
 * 
 *
 */

/**
 *  : <HOTEL1802 STUDIO>
 * JDK  : <1.6.10>
 *  : <JavaBasic>
 *
 *  : <edu.frank.base.data>
 *  : <SEXEnum.java>
 *  : 1.0
 * <...>
 *
 *  : <Frank Deng Email:<a href="mailto:yoyudneghihi@gmail.com">Frank Deng</a>>
 *  : <2011-9-26 01:48:08>
 *  :
 * <>				<>					<>
 *
 */
package edu.frank.base.data;

/**
 * <p>
 * 	<>
 * </p>
 *
 * @author &lt Frank Deng Email:<a href="mailto:yoyudneghihi@gmail.com?subject=Java Program Communication">Frank Deng</a> &gt
 * <p>
 *  
 * 	Frank Deng <p>
 * <2011-9-26 01:48:08> <p>
 * <> <p>
 * 
 * @Since JavaBasic 1.0.0.0
 * @Version JavaBasic 1.0.0.0
 */
public enum SexEnum {
	
	MALE(0),		// male 
	FMALE(1);		// female
	
	/**
	 * <>
	 * 
	 * @since JavaBasic 1.0.0.0
	 */
	private int sexNo;
	
	/**
	 *
	 * <  <code>SEXEnum</code> >
	 *
	 * @author &lt Frank Deng Email:<a href="mailto:yoyudneghihi@gmail.com?subject=Java Program Communication">Frank Deng</a> &gt
	 * <p>
	 *
	 * Frank Deng	<p>
	 * <2011-9-26 01:56:49> 		<p>
	 * <> 			<p>
	 *
	 * @param sexNo
	 * 						
	 * 
	 * @since JavaBasic 1.0.0.0
	 * 
	 */
	private SexEnum(int sexNo) {
		this.sexNo = sexNo;
	}

	/* (non-Javadoc)
	 * @see java.lang.Enum#toString()
	 */
	@Override
	public String toString() {
		if (this.sexNo == 0) {
			return "male";
		}
		return "female";
	}

}