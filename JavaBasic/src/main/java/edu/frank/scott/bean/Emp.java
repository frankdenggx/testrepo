package edu.frank.scott.bean;

import java.io.Serializable;
import java.util.Date;

public class Emp implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2480757928044899035L;

	private int empno;
	private String ename;
	private String job;
	private Emp mgr;
	private Date hiredate;
	private double sal;
	private double comm;
	private Dept dept;
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public Emp getMgr() {
		return mgr;
	}
	public void setMgr(Emp mgr) {
		this.mgr = mgr;
	}
	public Date getHiredate() {
		return hiredate;
	}
	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}
	public double getSal() {
		return sal;
	}
	public void setSal(double sal) {
		this.sal = sal;
	}
	public double getComm() {
		return comm;
	}
	public void setComm(double comm) {
		this.comm = comm;
	}
	public Dept getDept() {
		return dept;
	}
	public void setDept(Dept dept) {
		this.dept = dept;
	}
}
