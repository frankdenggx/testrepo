/**
 * B224
 * LearnBasicJava
 * JDK1.6.17
 * Sort
 * 1.0
 * 
 * 2010-04-28
 * yoyudenghihi
 * 
 * 							
 * 2010.04.28		yoyudenghihi		
 */
package edu.frank.sorted;

/**
 * 
 * @see java.lang.Object
 * @since 1.0 2010/04/28
 * @author yoyudenghihi
 * @version 1.0
 */
public interface Sort {
	
	/**
	 * 
	 * @return 
	 */
	public String getTimeComplexity();	//
	
	/**
	 * 
	 * @return 
	 */
	public String getSpaceComplexity();	//
	
	/**
	 * 
	 * @param m_objArray 
	 * @param m_strSortedIndex  ASC/asc- DEC/dec-
	 * @return 
	 */
	public Object[] sorted(Object[] m_objArray,String m_strSortedIndex);	//
}