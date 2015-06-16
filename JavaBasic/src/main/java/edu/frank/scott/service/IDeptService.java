package edu.frank.scott.service;

import java.util.List;

import edu.frank.scott.bean.Dept;

public interface IDeptService {
	public Dept getDept(int deptNo) throws Exception;
	public List<Dept> getAllDept() throws Exception;
}
