package com.velocity.miniproject;

import java.util.Scanner;

public class StudNotValidException extends RuntimeException{

	public StudNotValidException() {
		System.err.println("you are not register then do registration press '1' ");
		System.err.println("you are register then enter valid data press '2'");
		
		
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
