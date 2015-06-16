package edu.frank.scott.service;

import java.util.List;

import edu.frank.scott.bean.Emp;

public interface IEmpService {
	public Emp getEmp(int empNo) throws Exception;
	public List<Emp> getAllEmp() throws Exception;
}
