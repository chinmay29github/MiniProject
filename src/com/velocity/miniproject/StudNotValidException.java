package com.velocity.miniproject;

import java.util.Scanner;

public class StudNotValidException extends RuntimeException{

	public StudNotValidException() {
		System.err.println("You have entered wrong details");
		System.err.println("If you have not done registration then To do registration press '1' ");
		System.err.println("If you are already registered then enter valid input press '2' to login again");
		
		
		  int ch=1; 
		  Scanner sc=new Scanner(System.in); while(ch!=0) {
		  System.out.println(
		  "=============================================================");
		  System.out.println("enter ur choice");
		  System.out.println("=========================================================");
		  ch=sc.nextInt();
		  switch (ch) {
		  case 1:
			  System.out.println("Please register"); 
			  InsertData.doRegistration();
			  break;
		  case 2:
			  System.out.println("enter valid data"); 
			  Impl i=new Impl();
			  i.checkStud();
			  break;
			  default: System.out.println("invalid choice"); } }
		
	}
}
