/**
 * CopyRightHotel1802
 * ProNameLearnBasicJava
 * JDKVer1.6_10
 * FileVer1.0
 * FileDescObserver Pattern : Observer implement > StatisticDisplay
 * Date2010-07-17
 * Authordenggx
 * History
 * <date>			<person>				<content>
 * 2010-07-17		denggx					create
 */
package edu.frank.headfirst.observer;

/**
 * Observer implement > StatisticDisplay
 * @author denggx
 *
 */
public class StatisticDisplay implements IObserver, IDisplayElement {

	ISubject weatherData;
	
	private float currTemperature;
	private float lastTemperature;
	private float currHumidity;
	private float lastHumidity;
	private float currPressure;
	private float lastPressure;
	
	/**
	 * Customize constructor
	 * @param weaterData Subject implement
	 */
	public StatisticDisplay(ISubject weatherData){
		currTemperature = 0.0f;
		currHumidity = 0.0f;
		currPressure = 0.0f;
		this.weatherData = weatherData;
		this.weatherData.registerObserver(this);
	}
	
	/* (non-Javadoc)
	 * @see com.yoyudeng.headfirst.observer.IObserver#update(float[])
	 */
	@Override
	public void update(float[] objects) {
		lastTemperature = currTemperature;
		lastHumidity = currHumidity;
		lastPressure = currPressure;
		
		this.currTemperature = objects[0];
		this.currHumidity = objects[1];
		this.currPressure = objects[2];
	}

	/* (non-Javadoc)
	 * @see com.yoyudeng.headfirst.observer.IDisplayElement#display()
	 */
	@Override
	public void display() {
		System.out.println("Weather statistic: " + "temperature " + 
				lastTemperature + "/" + currTemperature + " Humidity " +
				lastHumidity + "/" + currHumidity + " Pressure " +
				lastPressure + "/" + currPressure);

	}

}