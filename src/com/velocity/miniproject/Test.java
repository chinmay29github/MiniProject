package com.velocity.miniproject;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		//************************************************************************
		System.out.println("Welcome");
		
		
		
		Impl impl=new Impl();
		int roll_no;
		String passward;
		System.out.println("enter rno ");
		roll_no=sc.nextInt();
		sc.nextLine();
		System.out.println("enter passward ");
		passward=sc.nextLine();
		impl.checkStud(roll_no, passward);
		
		//************************************************************************

	}

}
