package edu.frank.scott.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import edu.frank.apache.dbutils.CustomericDbUtil;
import edu.frank.json.JsonPluginsUtil;
import edu.frank.scott.bean.Dept;

public class DeptService implements IDeptService {

	@Override
	public Dept getDept(int deptNo) throws Exception {
		Dept dept = null;
		StringBuffer sql = new StringBuffer("SELECT * FROM dept WHERE deptno=?");
		try {
			Connection conn = CustomericDbUtil.getConnection();
			QueryRunner qr = new QueryRunner();
			dept = qr.query(conn, sql.toString(), new BeanHandler<Dept>(Dept.class), deptNo);
		} finally {
			CustomericDbUtil.closeConnection();
		}
		return dept;
	}
	
	public static void main(String[] args) throws Exception {
		IDeptService service = new DeptService();
		Dept dept = service.getDept(10);
		System.out.println(JsonPluginsUtil.beanToJson(dept));
		List<Dept> depts = service.getAllDept();
		System.out.println(JsonPluginsUtil.beanListToJson(depts));
		
		StringBuffer sql = new StringBuffer("SELECT * FROM dept WHERE deptno=?");
		try {
			
			Connection conn = CustomericDbUtil.getConnection();
			QueryRunner qr = new QueryRunner();
			dept = qr.query(conn, sql.toString(), new BeanHandler<Dept>(Dept.class), 10);
		} finally {
			CustomericDbUtil.closeConnection();
		}
		
		CustomericDbUtil.closeDataSource();
	}

	@Override
	public List<Dept> getAllDept() throws Exception {
		List<Dept> depts = new ArrayList<Dept>();
		StringBuffer sql = new StringBuffer("SELECT * FROM dept");
		try {
			Connection conn = CustomericDbUtil.getConnection();
			QueryRunner qr = new QueryRunner();
			depts = qr.query(conn, sql.toString(), new BeanListHandler<Dept>(Dept.class));
		} finally {
			CustomericDbUtil.closeConnection();
		}
		return depts;
	}

}
