package com.jdbc.emp.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jdbc.emp.entity.Emp;

public class EmpDao implements IEmpDao{
Connection connection;
PreparedStatement preparedStatement;
String sql;
private ResultSet resultSet;
public EmpDao()
{
	connection=MyConnection.getConnection();
	
}
public String addEmp(Emp emp)throws SQLException
{
	sql="insert into employee values(?,?,?,?)";
	preparedStatement=connection.prepareStatement(sql);
	preparedStatement.setInt(1,emp.getEno());
	preparedStatement.setString(2,emp.getEname());
	preparedStatement.setString(3,emp.getDept());
	preparedStatement.setInt(4,emp.getSalary());
	preparedStatement.executeUpdate();
	return ".....Record inserted successfully.....";
}
public String deleteEmp(Integer eno)throws SQLException
{
	sql="delete from employee where eno=?";
	preparedStatement=connection.prepareStatement(sql);
	
	preparedStatement.setInt(1, eno);
	
	
	 if(preparedStatement.executeUpdate()>0)
	{
		return "Record Deleted";
	}
	else
	{
		return "Record Not Found";
	}
	
	
}
public String updateEmp(Emp emp)
{
	String updateMessage = null;
	try {
		sql="update employee set salary=? where eno=?";
		preparedStatement=connection.prepareStatement(sql);
		preparedStatement.setInt(1, emp.getSalary());
		preparedStatement.setInt(2, emp.getEno());
		if(preparedStatement.executeUpdate()>0)
		{ 
			updateMessage = "Record updated";
		} 
		else 
		{
			updateMessage = "Failed to update record";
		}
	} 
	catch(Exception e) {
		updateMessage = "Exception occurred while updating records in employee";
		System.out.println(e.getMessage());
	}
	return updateMessage;
}
@Override
public Emp getEmp(int eno) {
	Emp emp = null;
	ResultSet resultSet = null;
	try {
		String getEmpSQL = "select * from employee where eno=?";
		preparedStatement=connection.prepareStatement(getEmpSQL);
		preparedStatement.setInt(1, eno);
		resultSet = preparedStatement.executeQuery();
		if(resultSet != null) {
			while(resultSet.next()) {
				emp = new Emp();
				emp.setEno(resultSet.getInt("eno"));
				//emp.setEname(resultSet.getString("ename"));
				//emp.setDept(resultSet.getString("dept"));
				//emp.setSalary(resultSet.getInt("salary"));
			}
		}
	}catch(Exception e) {
		System.out.println(e.getMessage());
	}
	return emp;
}

public Emp FindEmpById(Integer eno)throws SQLException
{

	sql="select*from employee where eno=?";
	preparedStatement=connection.prepareStatement(sql);
	preparedStatement.setInt(1, eno);
	resultSet = preparedStatement.executeQuery();
	Emp emp=null;
	if(resultSet.next())
	{
		emp=new Emp();
		emp.setEno(resultSet.getInt(1));
		emp.setEname(resultSet.getString(2));
		emp.setDept(resultSet.getString(3));
		emp.setSalary(resultSet.getInt(4));
	}
	return emp;
	
}

public List<Emp> FindAllEmp() throws SQLException
{
	sql="select*from employee";
	preparedStatement=connection.prepareStatement(sql);
	resultSet = preparedStatement.executeQuery();
	Emp emp=null;
	List<Emp>list=new ArrayList<Emp>();
	while(resultSet.next())
	{
		emp=new Emp();
		emp.setEno(resultSet.getInt(1));
		emp.setEname(resultSet.getString(2));
		emp.setDept(resultSet.getString(3));
		emp.setSalary(resultSet.getInt(4));
		list.add(emp);
		
	}
	return list;
	
}


}

 