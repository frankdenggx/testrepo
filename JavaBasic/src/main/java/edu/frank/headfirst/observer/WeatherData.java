/**
 * CopyRightHotel1802
 * ProNameLearnBasicJava
 * JDKVer1.6_10
 * FileVer1.0
 * FileDescObserver Pattern : Observable implement > WeatherData
 * Date2010-07-17
 * Authordenggx
 * History
 * <date>			<person>				<content>
 * 2010-07-17		denggx					create
 */
package edu.frank.headfirst.observer;

import java.util.ArrayList;

/**
 * Observable implement > WeatherData
 * 
 * @author denggx
 * 
 */
public class WeatherData implements ISubject {

	private ArrayList<IObserver> observer;
	
	private float temperature;
	private float humidity;
	private float pressure;

	/**
	 * Customize constructor
	 */
	public WeatherData(){
		observer = new ArrayList<IObserver>();
	}
	
	/**
	 * @return the temperature
	 */
	public float getTemperature() {
		return temperature;
	}

	/**
	 * @param temperature the temperature to set
	 */
	public void setTemperature(float temperature) {
		this.temperature = temperature;
	}

	/**
	 * @return the humidity
	 */
	public float getHumidity() {
		return humidity;
	}

	/**
	 * @param humidity the humidity to set
	 */
	public void setHumidity(float humidity) {
		this.humidity = humidity;
	}

	/**
	 * 
	 * @param pressure the pressure to set
	 */
	public void setPressure(float pressure){
		this.pressure = pressure;
	}
	
	/**
	 * @return the pressure
	 */
	public float getPressure() {
		return pressure;
	}

	@Override
	public void notifyObservers() {
		for (int i = 0; i < observer.size(); i++){
			IObserver obs = (IObserver) observer.get(i);
			float[] objects = {temperature,humidity,pressure};
			obs.update(objects);
		}
		
	}

	@Override
	public boolean registerObserver(IObserver obs) {
		observer.add(obs);
		return true;
	}

	@Override
	public boolean removeObserver(IObserver obs) {
		int i = observer.indexOf(obs);
		if(i >= 0)
			observer.remove(i);
		return true;
	}
	
	/**
	 * data change
	 */
	public void messurementsChanged(){
		notifyObservers();
	}
	
	//other method ...

}