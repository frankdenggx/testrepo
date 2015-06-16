package edu.frank.headfirst.proxy.remoteproxy;

public class GumballMonitor {
	
	GumballMachineRemote machine = null;
	
	public GumballMonitor(GumballMachineRemote machine) {
		this.machine = machine;
	}
	
	public void report() {
		try {
			System.out.println("Gumball Machine: " + machine.getLocation());
			System.out.println("Current Inventory: " + machine.getCount());
			System.out.println("Current State: " + machine.getState());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
