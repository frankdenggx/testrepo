package edu.frank.headfirst.composite;

import java.util.Iterator;


public abstract class Component {
	private String name;
	private String descripton;
	public Component(String name, String description) {
		this.name = name;
		this.descripton = description;
	}
	public boolean add(Component c) {
		throw new UnsupportedOperationException();
	}
	public boolean remove(Component c) {
		throw new UnsupportedOperationException();
	}
	public Component getChild(int index) {
		throw new UnsupportedOperationException();
	}
	public Iterator<Component> createIterator() {
		throw new UnsupportedOperationException();
	}
	public String getName() {
		return this.name;
	}
	public String getDescription() {
		return this.descripton;
	}
	public void operation() {
		throw new UnsupportedOperationException();
	}
	public void print() {
		throw new UnsupportedOperationException();
	}
	
}
