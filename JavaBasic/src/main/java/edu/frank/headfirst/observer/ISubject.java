/**
 * CopyRightHotel1802
 * ProNameLearnBasicJava
 * JDKVer1.6_10
 * FileVer1.0
 * FileDescObserver Pattern : Observable Interface
 * Date2010-07-17
 * Authordenggx
 * History
 * <date>			<person>				<content>
 * 2010-07-17		denggx					create
 */
package edu.frank.headfirst.observer;

/**
 * Observable Interface
 * @author denggx
 *
 */
public interface ISubject {
	
	/**
	 * register observer
	 * @param obs observer case
	 * @return true-reister success false-register fail
	 */
	public boolean registerObserver(IObserver obs);
	
	/**
	 * remove observer
	 * @param obs observer case
	 * @return true-remove success false-remove fail
	 */
	public boolean removeObserver(IObserver obs);
	
	/**
	 * notify all observer
	 */
	public void notifyObservers();
}