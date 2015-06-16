/*
 * 
 * Hotel1802 
 *
 * 
 * 
 *
 */

/**
 *  : Hotel1802 
 * JDK  : 1.6.10
 *  : JavaBasic
 *
 *  : edu.frank
 *  : RunReflection.java
 *  : 1.0.0.0
 * Java
 *
 *  : Frank
 *  : 2011-4-29 06:49:26
 *  :
 * <>				<>				<>
 *
 */
package edu.frank.reflection;

import java.awt.Rectangle;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * <p>
 * Java
 * </p>
 *
 * @author Frank
 * @Version JavaBasic 1.0.0.0
 */
public class RunReflection {

	/**
	 * 
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	private volatile static RunReflection instance;

	/**
	 *  <code>RunReflection</code> 
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	private RunReflection() {
	}

	/**
	 *
	 * 
	 *
	 * @return 
	 * @since JavaBasic 1.0.0.0
	 */
	public static RunReflection getInstance() {
		if (instance == null) {
			synchronized (RunReflection.class) { // 
				if (instance == null) { // 
					instance = new RunReflection();
				}
			}
		}
		return instance;
	}

	/**
	 *
	 * 
	 *
	 * @throws Exception
	 *				
	 * @since JavaBasic 1.0.0.0
	 */
	public void showClassInfo() throws Exception {

		Rectangle rect = new Rectangle(300, 100);
		System.out.println("rect: " + rect.toString());

		// Class
		Class rectClass = rect.getClass();
		// Class rectClass = Rectangle.class;
		// Class.forName("java.awt.Rectangle");

		// 
		// 
		Rectangle rect1 = (Rectangle) rectClass.newInstance();
		System.out.println("rect1: " + rect1.toString());
		// 
		Class[] paramsType = new Class[] { int.class, int.class };
		Constructor con = Rectangle.class.getConstructor(paramsType);
		Rectangle rect2 = (Rectangle) con.newInstance(new Object[] {
				new Integer(400), new Integer(300) });
		System.out.println("rect2: " + rect2.toString());

		// 
		Field field = rectClass.getField("height");
		String fieldName = field.getName();		// 
		String fieldType = field.getType().getName();	// 
		int modifiers = field.getModifiers();	// 
		String mod = "name:" + fieldName + " type:" + fieldType +" ";

		if (Modifier.isStatic(modifiers)) {
			mod += "mod:static ";
		}
		if (Modifier.isPublic(modifiers)) {
			mod += "mod:public ";
		} else if (Modifier.isProtected(modifiers)) {
			mod += "mod:protected ";
		} else if (Modifier.isPrivate(modifiers)) {
			mod += "mod:private ";
		}
		System.out.println("Field: " + mod);
		// 
		field.setInt(rect, new Integer(500));
		System.out.println("rect height: " + rect.height);
		// 
		int height = field.getInt(rect);
		System.out.println("rect height: " + height);


		// 
		paramsType = new Class[] {};
		Method method = rectClass.getMethod("getHeight", paramsType);	//  getHeight
		height = ((Double)method.invoke(rect, new Object[0])).intValue();
		System.out.println("----------------------------rect height: " + height);
		paramsType = new Class[] {int.class, int.class};
		method = rectClass.getMethod("setSize", paramsType);	//  setHeight
		method.invoke(rect, new Object[] {new Integer(50), new Integer(30)});
		System.out.println("rect height: " + rect.height + " width: " + rect.width);

		// 
		String superClassName = rectClass.getSuperclass().getName();
		System.out.println("Rectangle super class name: " + superClassName);

		// 
		Class[] interfaces = rectClass.getInterfaces();
		System.out.println("Rectangle interface list: ");
		for(Class c : interfaces) {
			System.out.println(c.getName());
		}

	}

	/**
	 *
	 * 
	 *
	 * @param args
	 *			
	 * @since JavaBasic 1.0.0.0
	 */
	public static void main(String[] args) {
		RunReflection rf = RunReflection.getInstance();
		try {
			rf.showClassInfo();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}