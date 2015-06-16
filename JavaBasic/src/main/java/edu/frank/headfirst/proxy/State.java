package edu.frank.headfirst.proxy;

import java.io.Serializable;

public interface State extends Serializable {
	public void insertQuarter();
	public void ejectQuarter();
	public void turnQuarter();
	public void dispense();
}
