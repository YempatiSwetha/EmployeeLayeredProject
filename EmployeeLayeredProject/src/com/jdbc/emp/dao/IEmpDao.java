package com.jdbc.emp.dao;

import java.sql.SQLException;
import java.util.List;

import com.jdbc.emp.entity.Emp;

public interface IEmpDao {
	String addEmp(Emp emp) throws SQLException;
	
	String deleteEmp(Integer eno)throws SQLException;
	
	String updateEmp(Emp emp);
	Emp getEmp(int empId);
	
	Emp FindEmpById(Integer eno)throws SQLException;
	
	
	List<Emp> FindAllEmp()throws SQLException;
	

}
