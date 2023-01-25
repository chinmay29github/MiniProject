package com.velocity.miniproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;



public class Impl {
	
	Connection conn=DBUtility.makeConnection();
	PreparedStatement ps;
	String query;
	int i;
	
	public void checkStud(int roll_no,String passward) {
		query="select * from studreg where roll_no=? And passward=?";
		ResultSet rs=null;
		
		try {
			ps=conn.prepareStatement(query);
			ps.setInt(1, roll_no);
			ps.setString(2, passward);
			rs=ps.executeQuery();
			
			if(rs.next()) {
				System.out.println("start quiz");
				displayQuestiond();
			}
			else {

				throw new StudNotValidException();
				
			}
			ps.close();
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void displayQuestiond() {
		try {
		PreparedStatement ps = conn.prepareStatement("SELECT * FROM questionbank\r\n"+"ORDER BY RAND()\r\n"
					);
		ResultSet rs = ps.executeQuery();
		Scanner sc = new Scanner(System.in);
		int marks = 0;
		for(int i=1;i<=10;i++) {
		while(rs.next()){
			int x=1;
			System.out.println("Question "+x+": "+rs.getString(2));
			System.out.println("Option A- "+rs.getString(3));
			System.out.println("Option B- "+rs.getString(4));
			System.out.println("Option C- "+rs.getString(5));
			System.out.println("Option D- "+rs.getString(6));
			System.out.println("Enter Your Answer : ");
			
			String s = sc.next();
			if(s.equalsIgnoreCase(rs.getString(7))) {
				marks++;
			}x++;
		}
		}
		System.out.println("You Have Attempted all Questions Successfully\n"+
		"Press 'Y' to Submit your Exam");
		String y = sc.next();
		if(y.equalsIgnoreCase("Y")) {
			System.out.println("Your Exam is Submitted Successfully.");
		}
		System.out.println("You scored "+marks+" marks out of 10");
		conn.close();
		ps.close();
		rs.close();	
		sc.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	
	}
}
