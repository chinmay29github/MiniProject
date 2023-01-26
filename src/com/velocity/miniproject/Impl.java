package com.velocity.miniproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;



public class Impl {
	
	Connection conn=DBUtility.makeConnection();
	PreparedStatement ps;
	String query;
	int i;
	
	public void checkStud(int roll_no,String passward) {
		query="select * from studreg where roll_no=? And passward=?";
		ResultSet rs=null;
		Scanner sc=new Scanner(System.in);
		
		try {
			ps=conn.prepareStatement(query);
			ps.setInt(1, roll_no);
			ps.setString(2, passward);
			rs=ps.executeQuery();
			
			if(rs.next()) {
				System.out.println("Press y to start the quiz");
				Character y=sc.nextLine().charAt(0);
				if(y.equals('y')) {
					query="select roll_no from course where roll_no=? ";
					ps=conn.prepareStatement(query);
					ps.setInt(1, roll_no);
					rs=ps.executeQuery();
					if(rs.next()) {
						System.out.println("y are already attending the quiz");
					}
					else {
						System.out.println("start quize");
				
					}
				
				}
				else {
					System.exit(0);
				}
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
		ps = conn.prepareStatement("SELECT * FROM questionbank\r\n"+"ORDER BY RAND()\r\n"
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
	
	public void displaystud(){
		
		query="select studreg.roll_no,studreg.firstName,studreg.middleName,studreg.lastName,studreg.city,studreg.mobile,course.marks from studreg left join course on\r\n"
				+ "studreg.roll_no=course.roll_no";
		try {

			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery(query);
			while(rs.next()) {
				
				int roll_no=(rs.getInt("roll_no"));
				String firstName=(rs.getString("firstName"));
				String middleName=(rs.getString("middleName"));
				String lastName=(rs.getString("lastName"));
				String city=(rs.getString("city"));
				int mobile=(rs.getInt("mobile"));
				int marks=(rs.getInt("marks"));
				System.out.println(roll_no+" "+firstName+" "+middleName+" "+lastName+" "+city+" "+mobile+" "+marks);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void searchstud(int roll_no) {
		query="select studreg.roll_no,studreg.firstName,studreg.middleName,studreg.lastName,studreg.city,studreg.mobile,course.marks from studreg ,course where studreg.roll_no=? " ;
		ResultSet rs=null;
		
		try {
			ps=conn.prepareStatement(query);
			ps.setInt(1, roll_no);
			rs=ps.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			if(rs.next()) {
				
				roll_no=(rs.getInt("roll_no"));
				String firstName=(rs.getString("firstName"));
				String middleName=(rs.getString("middleName"));
				String lastName=(rs.getString("lastName"));
				String city=(rs.getString("city"));
				int mobile=(rs.getInt("mobile"));
				int marks=(rs.getInt("marks"));
				System.out.println(roll_no+" "+firstName+" "+middleName+" "+lastName+" "+city+" "+mobile+" "+marks);
				
			}
			else {
				System.err.println("plz enter correct Roll number");
				
			}
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
