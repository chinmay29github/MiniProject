package com.velocity.miniproject;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Impl impl=new Impl();
		
		//************************************************************************
		System.out.println("Welcome");
		System.out.println("============================================================");
		int ch=1;
		while(ch!=0) {
		System.out.println("registration press 1");
		System.out.println("login press 2");
		System.out.println("press 3 for Exit");
		System.out.println("press 4 to display all stud");
		System.out.println("press 5 to search details");
		System.out.println("*******************************************************");
		System.out.println("enter ur choice");
		ch=sc.nextInt();
		System.out.println("*******************************************************");
		switch (ch) {
		
		case 1:System.out.println("register the stud");
		       InsertData id=new InsertData();
		       id.insertStudentData(null, null, null, ch, null, null, null);
			break;
		case 2:System.out.println("login stud");
		
		
		int roll_no;
		String passward;
		System.out.println("enter rno ");
		roll_no=sc.nextInt();
		sc.nextLine();
		System.out.println("enter passward ");
		passward=sc.nextLine();
		impl.checkStud(roll_no, passward);
		System.out.println("************************************************************");
		break;
		case 3:
			System.exit(0);
			break;
			
		case 4:
			
			System.out.println("stud details are");
			impl.displaystud();
			System.out.println("*************************************************");
		break;
		case 5:
			
			System.out.println("your details are");
			System.out.println("enter rno for search");
			int rno=sc.nextInt();
			impl.searchstud(rno);
			System.out.println("*************************************************");
		break;
		
		default:
			System.out.println("invalid choice");
			break;
		}
		}
		
		
		
		//************************************************************************

	}

}
