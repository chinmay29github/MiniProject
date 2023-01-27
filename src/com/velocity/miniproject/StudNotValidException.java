package com.velocity.miniproject;

public class StudNotValidException extends RuntimeException{

	public StudNotValidException() {
		System.err.println("Please enter valid Roll No  and Password");
		
	}
}
