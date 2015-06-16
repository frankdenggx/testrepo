package edu.frank.copy;

import java.util.Date;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.lang.time.DateUtils;

import edu.frank.scott.bean.Dept;
import edu.frank.scott.bean.Emp;

public class ObjectCopyUtil {
	static {
		ConvertUtils.register(new SqlDateConverter(null), java.sql.Date.class);
		ConvertUtils.register(new DateConverter(null), java.util.Date.class);
	}
	public static Object shallowCopy(Object object) {

		return object;
	}
	public static Object deepCopy(Object object) {
		return object;
	}

	public static void main(String[] args) {
		try {
			// Define Department
			Dept mgrDept = new Dept();
			mgrDept.setDeptno(1000);
			mgrDept.setDname("MGR");
			mgrDept.setLoc("Guangzhou");
			// Define Department
			Dept itDept = new Dept();
			itDept.setDeptno(1001);
			itDept.setDname("IT");
			itDept.setLoc("Shenzhen");
			// Define Employer's Manager
			Emp ceo = new Emp();
			ceo.setEmpno(9000);
			ceo.setEname("CEO");
			ceo.setHiredate(new Date());
			ceo.setJob("CEO");
			ceo.setSal(999999.00D);
			ceo.setComm(0.00D);
			ceo.setDept(mgrDept);
			// Define IT Employer
			Emp it = new Emp();
			it.setEmpno(9001);
			it.setEname("IT");
			it.setHiredate((DateUtils.addDays(new Date(), 1)));
			it.setJob("IT");
			it.setSal(8000.00D);
			it.setComm(10.00D);
			it.setDept(itDept);
			it.setMgr(ceo);
			// shallow copy
			Emp it1 = new Emp();
			BeanUtils.copyProperties(it1, it);
			System.out.println(it1 == it);
			System.out.println(it1.equals(it));
			System.out.println(it1.getEmpno());
			System.out.println(it1.getDept() == null ? "it1's Dept is empty" : it1.getDept().getDname());
			System.out.println(it1.getMgr() == null ? "it1's Mgr is empty" : it1.getMgr().getEname());
			System.out.println(it1.getHiredate());
			long nanos1 = System.nanoTime();
			long ms = System.currentTimeMillis();
			long nanos2 = System.nanoTime();
			System.out.println(ms);
			System.out.println(nanos2-nanos1);


		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
