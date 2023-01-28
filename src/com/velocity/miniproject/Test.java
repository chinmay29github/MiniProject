package com.velocity.miniproject;


import java.util.Scanner;

public class Test
{	
	
	 void displayData()
	 {
		 Scanner sc=new Scanner(System.in);
			Impl impl=new Impl();
			
			System.out.println("==================================================================================================================");
			System.out.println("                  ********************** Welcome TO EXAM SYSTEM **********************                                          ");
			System.out.println("==================================================================================================================");
			int ch=1;
			while(ch!=0) {
			System.out.println(" Select Your Option                                               ");
			System.out.println("==================================================================================================================");
			System.out.println("For Registration Press  ' 1 ' ");
			System.out.println("To Login Press ' 2 ' ");
			System.out.println("Press ' 3 '  for Exit");
			System.out.println("Press ' 4 ' to Display all Students Data");
			System.out.println("Press ' 5 '  to Search Particular details of Students");
			System.out.println("==================================================================================================================");
			System.out.println("Enter your choice");
			ch=sc.nextInt();
			System.out.println("==================================================================================================================");
			
			switch (ch) {
			case 1:
				System.out.println("==================================================================================================================");
		        System.out.println("                          Start Your Registration                                                       ");
				System.out.println("==================================================================================================================");
			       InsertData.doRegistration();
			       System.out.println("==================================================================================================================");
				break;
				
			case 2:
				System.out.println("==================================================================================================================");
			    System.out.println("Login with your Roll NO  and  Password                                                              ");
			    System.out.println("==================================================================================================================");
			
			
			int roll_no;
			String password;
			System.out.println("==================================================================================================================");
			System.out.println("Enter Roll No                                                  ");
			roll_no=sc.nextInt();
			sc.nextLine();
			
			System.out.println("Enter Password                                                                   ");
			
			password=sc.nextLine();
			impl.checkStud(roll_no, password);
			System.out.println("==================================================================================================================");
			break;
			case 3:
				System.exit(0);
				break;
				
			case 4:
				System.out.println("==================================================================================================================");
				System.out.println("Student Details are ");
				impl.displaystud();
				System.out.println("==================================================================================================================");
			break;
			case 5:
				System.out.println("==================================================================================================================");
				System.out.println("Your Details are ");
				System.out.println("==================================================================================================================");
				System.out.println("Enter your RollNo to search your Result");
				int rno=sc.nextInt();
				impl.searchstud(rno);
				System.out.println("==================================================================================================================");
			break;
			
			default:
				System.out.println("==================================================================================================================");
				System.out.println("invalid choice");
				System.out.println("==================================================================================================================");
				break;
			}
			}
			
			
		 
	 }
public static void main(String[] args) 
{	
		Test t = new Test();
		t.displayData();
	}

}
