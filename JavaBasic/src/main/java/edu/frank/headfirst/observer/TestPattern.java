/**
 * CopyRightHotel1802
 * ProNameLearnBasicJava
 * JDKVer1.6_10
 * FileVer1.0
 * FileDescObserver Pattern test class
 * Date2010-07-17
 * Authordenggx
 * History
 * <date>			<person>				<content>
 * 2010-07-17		denggx					create
 */
package edu.frank.headfirst.observer;

/**
 * Observer Pattern test class
 * @author denggx
 *
 */
public class TestPattern {

	/**
	 * main method
	 * @param args console arguments
	 */
	public static void main(String[] args) {
		WeatherData weatherData = new WeatherData();
		CurrentConditionsDisplay currentConditionsDisplay = 
			new CurrentConditionsDisplay(weatherData);
		StatisticDisplay statisticDisplay = 
			new StatisticDisplay(weatherData);
		
		// first case
		weatherData.setTemperature(29.5f);
		weatherData.setHumidity(83.3f);
		weatherData.setPressure(136.6f);
		weatherData.messurementsChanged();
		currentConditionsDisplay.display();
		statisticDisplay.display();
		
		// second case
		weatherData.setTemperature(27.5f);
		weatherData.setHumidity(89.3f);
		weatherData.setPressure(146.6f);
		weatherData.messurementsChanged();
		currentConditionsDisplay.display();
		statisticDisplay.display();
	}

}