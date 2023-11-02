package com.jdbc.emp.presentation;
import java.util.Scanner;

import java.sql.SQLException;

public class EmpApplication 
{
	public static void main(String a[])
	{
		Scanner scanner=new Scanner(System.in);
		EmpUser empUser=new EmpUser();
		int choice=0;
		System.out.println("--------------Employee Operations--------------");
		System.out.println("-----------------------------------------------");
		System.out.println("1.Add Record :");
		System.out.println("2.Delete Record :");
		System.out.println("3.Update Record :");
		System.out.println("4.Find Record By Emp Id :");
		System.out.println("5.Find All Records :");
		System.out.println("6.Exit Application :");
		while(choice!=6)
		{
			System.out.println("...........................................");
			System.out.println("Enter Operation No :");
			choice=scanner.nextInt();
			try
			{
			switch(choice)
			{
			case 1: empUser.inputAddEmp();
			        break;
			case 2: empUser.inputDeleteEmp();
			        break;
			case 3: empUser.inputUpdateEmp();
	                break;
			case 4: empUser.inputFindEmpById();
			        break;
			case 5: empUser.inputFindAllEmp();
			        break;
			case 6:System.out.println("User Quit Application");
			       System.exit(0);
			default: System.out.println("Invalid Operation.....Try Again/n");
			}
			}
		catch(SQLException e) 
		{
			System.out.println(e);
			
		}
		
	  }
	
	}

}
