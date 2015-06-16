package edu.frank.scott.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import edu.frank.apache.dbutils.CustomericDbUtil;
import edu.frank.json.JsonPluginsUtil;
import edu.frank.scott.bean.Emp;

public class EmpService implements IEmpService {

	@Override
	public Emp getEmp(int empNo) throws Exception {
		Emp emp = null;
		StringBuffer sql = new StringBuffer("SELECT * FROM emp WHERE empno=?");
		try {
			Connection conn = CustomericDbUtil.getConnection();
			QueryRunner qr = new QueryRunner();
			emp = qr.query(conn, sql.toString(), new BeanHandler<Emp>(Emp.class), empNo);
		} finally {
			CustomericDbUtil.closeConnection();
		}
		return emp;
	}

	@Override
	public List<Emp> getAllEmp() throws Exception {
		List<Emp> emps = new ArrayList<Emp>();
		StringBuffer sql = new StringBuffer("SELECT * FROM emp");
		try {
			Connection conn = CustomericDbUtil.getConnection();
			QueryRunner qr = new QueryRunner();
			emps = qr.query(conn, sql.toString(), new BeanListHandler<Emp>(Emp.class));
		} finally {
			CustomericDbUtil.closeConnection();
		}
		return emps;
	}
	
	public static void main(String[] args) throws Exception {
		/*IEmpService service = new EmpService();
		Emp emp = service.getEmp(7369);
		System.out.println(JsonPluginsUtil.beanToJson(emp));
		List<Emp> emps = service.getAllEmp();
		System.out.println(JsonPluginsUtil.beanListToJson(emps));*/
		StringBuffer sql = new StringBuffer("SELECT ObjectID FROM std_ObjectInfo WHERE VehicleNum=?");
		try {
			Connection conn = CustomericDbUtil.getConnection();
			QueryRunner qr = new QueryRunner();
			String ret = qr.query(conn, sql.toString(), new BeanHandler<String>(String.class), "鄂S31857");
			System.out.println(ret);
		} finally {
			CustomericDbUtil.closeConnection();
		}
		
		CustomericDbUtil.closeDataSource();
	}

}
