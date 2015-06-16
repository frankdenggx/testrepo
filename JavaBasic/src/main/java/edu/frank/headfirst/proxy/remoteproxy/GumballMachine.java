package edu.frank.headfirst.proxy.remoteproxy;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

@SuppressWarnings("serial")
public class GumballMachine extends UnicastRemoteObject 
implements GumballMachineRemote {

	private int count;
	private String location;
	private State state;

	public GumballMachine(String location, int numberGumball) 
			throws RemoteException {
		this.location = location;
		this.count = numberGumball;
	}

	@Override
	public int getCount() throws RemoteException {
		return count;
	}

	@Override
	public String getLocation() throws RemoteException {
		return location;
	}

	@Override
	public State getState() throws RemoteException {
		return state;
	}

}
