package com.velocity.miniproject;

public class StudNotValidException extends RuntimeException{

	public StudNotValidException() {
		System.err.println("plz enter valid rno and passward");
	}
}
