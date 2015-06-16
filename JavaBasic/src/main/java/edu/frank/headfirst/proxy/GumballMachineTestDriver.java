package edu.frank.headfirst.proxy;

import java.rmi.Naming;

public class GumballMachineTestDriver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		GumballMachineRemote gumballMachine = null;
		int count;
		if (args.length < 2) {
			System.out.println("GumballMachine <name> <inventory>");
			System.exit(1);
		}
		try {
			count = Integer.parseInt(args[1]);
			gumballMachine = new GumballMachine(args[0], count);
			Naming.bind("//" + args[0] + "/gumballmachine", gumballMachine);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
