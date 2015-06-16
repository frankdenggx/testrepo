/**
 * CopyRightHotel1802
 * ProNameLearnBasicJava
 * JDKVer1.6_10
 * FileVer1.0
 * FileDescObserver Pattern : Observer implement > CurrentConditionsDisplay
 * Date2010-07-17
 * Authordenggx
 * History
 * <date>			<person>				<content>
 * 2010-07-17		denggx					create
 */
package edu.frank.headfirst.observer;

/**
 * Observer implement > CurrentConditionsDisplay
 * @author denggx
 *
 */
public class CurrentConditionsDisplay implements IObserver, IDisplayElement {
	
	ISubject weatherData;
	
	private float temperature;
	private float humidity;
	private float pressure;
	
	
	/**
	 * Customize constructor
	 * @param weatherData Subject implement
	 */
	public CurrentConditionsDisplay(ISubject weatherData){
		this.weatherData = weatherData;
		this.weatherData.registerObserver(this);
	}

	/* (non-Javadoc)
	 * @see com.yoyudeng.headfirst.observer.IDisplayElement#display()
	 */
	@Override
	public void display() {
		System.out.println("Current conditions: " + temperature +
				" F degress and " + humidity + " % humidity and " +
				pressure + " P. ");

	}

	@Override
	public void update(float[] objects) {
		this.temperature = objects[0];
		this.humidity = objects[1];
		this.pressure = objects[2];
	}

}