package edu.frank.headfirst.proxy.dymanicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class MatchMakingTestDrive {

	public static void main(String[] args) {
		MatchMakingTestDrive testDrive = new MatchMakingTestDrive();
		testDrive.dirve();
	}

	public void dirve() {
		PersonBean joe = new PersonBeanImpl();
		joe.setName("joe");
		joe.setInterests("swiming");
		joe.setGender("male");
		joe.setHotOrNotRating(9);
		PersonBean ownerProxy = getProxy(new OwnerInvocationHandler(joe), joe);
		try {
			ownerProxy.setHotOrNotRating(10);
		} catch (Exception e) {
			System.out.println("You can't set rating from owner proxy.");
		}
		PersonBean nonownerProxy = getProxy(new NonOwnerInvocationHandler(joe),
				joe);
		try {
			nonownerProxy.setInterests("cooking");
		} catch (Exception e) {
			System.out.println("You can't set interests from nonowner proxy.");
		}
		nonownerProxy.setHotOrNotRating(8);
		System.out.println("rating:" + joe.getHotOrNotRating());
	}

	public PersonBean getProxy(InvocationHandler handler, PersonBean person) {
		return (PersonBean) Proxy.newProxyInstance(person.getClass()
				.getClassLoader(), person.getClass().getInterfaces(), handler);
	}

}
