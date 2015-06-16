/**
 * CopyRightHotel1802
 * ProNameLearnBasicJava
 * JDKVer1.6_10
 * FileVer1.0
 * FileDescObserver Pattern : Observer Interface
 * Date2010-07-17
 * Authordenggx
 * History
 * <date>			<person>				<content>
 * 2010-07-17		denggx					create
 */
package edu.frank.headfirst.observer;

/**
 * Observer Interface
 * @author denggx
 *
 */
public interface IObserver {
	
	/**
	 * update data
	 * @param objects data
	 */
	public void update(float[] objects);
	
}
