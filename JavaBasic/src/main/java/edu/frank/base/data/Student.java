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
 *  : edu.frank.base.data
 *  : Student.java
 *  : 1.0.0.0
 * 
 *
 *  : Frank
 *  : 2011-4-29 07:14:34
 *  :
 * <>				<>				<>
 *
 */
package edu.frank.base.data;

import java.math.BigDecimal;

/**
 * <p>
 * 	Student 
 * </p>
 * @author Frank
 * @Version JavaBasic 1.0.0.0
 */
public final class Student extends AbstractPerson {

	/**
	 * 
	 * @since JavaBasic 1.0.0.0
	 */
	private static final long serialVersionUID = -7983942452468624296L;
	private int classId;
	private String className;
	private BigDecimal score;

	static int createClassId = 0;


	public Student() {
		super();
		createClassId += 1;
		System.out.println("Class ID: " + createClassId);
	}

	public Student(String id, String name, String sex) {
		super(id, name, sex);
		createClassId += 1;
		System.out.println("Class ID: " + createClassId);
	}

	/**
	 * @param classId the classId to set
	 */
	public void setClassId(int classId) {
		this.classId = classId;
	}

	public int getClassId() {
		return classId;
	}

	/**
	 * @param className the className to set
	 */
	public void setClassName(String className) {
		this.className = className;
	}

	/**
	 * @param score the score to set
	 */
	public void setScore(BigDecimal score) {
		this.score = score;
	}

	/* (non-Javadoc)
	 * @see edu.frank.base.data.AbstractPerson#showInfo()
	 */
	@Override
	public String showInfo() {
		return "Student info: " + "\n" +
				"ID: " + id + "\n" +
				"Name: " + id + "\n" +
				"Sex: " + id + "\n" +
				"ClassID: " + classId + "\n" +
				"ClassName: " + className + "\n" +
				"Score: " + score + "\n";
	}

}