package com.jdbc.emp.presentation;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.jdbc.emp.dao.EmpDao;
import com.jdbc.emp.entity.Emp;

public class EmpUser implements IEmpUser
{
    int eno,salary;
    String ename,dept;
    Scanner scanner=new Scanner(System.in);
    EmpDao empDao=new EmpDao();
    
    public void inputAddEmp()throws SQLException
    {
    	System.out.println("Enter employee no:");
    	eno=scanner.nextInt();
    	System.out.println("Enter employee name:");
    	ename=scanner.next();
    	System.out.println("Enter employee dept:");
    	dept=scanner.next();
    	System.out.println("Enter employee salary:");
    	salary=scanner.nextInt();
    	
    	Emp emp=new Emp();
    	emp.setEno(eno);
    	emp.setEname(ename);
    	emp.setDept(dept);
    	emp.setSalary(salary); 	
    	
    	System.out.println(empDao.addEmp(emp));	
    }

	public void inputDeleteEmp() throws SQLException
	{
	 System.out.println("Enter employee no:");
	 eno=scanner.nextInt();
	 System.out.println(empDao.deleteEmp(eno)); 
		
	} 
	
    public void inputUpdateEmp() throws SQLException
    {   
    	System.out.println("Enter employee no:");
    	eno=scanner.nextInt();
    	Emp emp = empDao.getEmp(eno);
    	if(emp != null) 
    	{
    		System.out.println("Enter employee salary:");
        	salary=scanner.nextInt();
        	emp.setSalary(salary);
        	System.out.println(empDao.updateEmp(emp));
    	} 
    	else 
    	{
    		System.out.println("Record not found");
    	}
    	
    }
    
 
   public void inputFindEmpById() throws SQLException
   {
	   System.out.println("Enter emp no:");
	   eno=scanner.nextInt();
	   
	   Emp emp=empDao.FindEmpById(eno);
	   if(emp!=null)
	   {
		   System.out.println("Eno\tEname\tDept\tSalary");
		   System.out.println(emp.getEno()+"\t"+emp.getEname()+"\t"+emp.getDept()+"\t"+emp.getSalary());
	   }
	   else
	   {
		   System.out.println("No Record Found");
	   }
   }
 
   public void inputFindAllEmp() throws SQLException
   {
	   
	   List<Emp>list=empDao.FindAllEmp();
	   if(list.size()>0)
	   {
		   System.out.println("Eno\t\tEname\t\tDept\t\t\tSalary");
		   for(Emp emp:list)
		   {
			   System.out.println(emp.getEno()+"\t\t"+emp.getEname()+"\t\t"+emp.getDept()+"\t\t\t"+emp.getSalary());
		   }
	   }
	   else
	   {
		   System.out.println("No Record Found");
	   }
	   }
   }
   
	   

	