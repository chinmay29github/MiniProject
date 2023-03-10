package com.velocity.miniproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class DisplayQuestions {

	public static void displayQuestions() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz","root","root");
			PreparedStatement ps = con.prepareStatement("SELECT * FROM questionbank\r\n"+"ORDER BY RAND()\r\n");
			ResultSet rs = ps.executeQuery();
			Scanner sc = new Scanner(System.in);
			int marks = 0;
			int x=1;
			for(int i=1;i<=10;i++) {
			while(rs.next()){				
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
			String grade=null;
			if(marks>=8) {
				grade="A";
			}else if(marks>=6 && marks<8) {
				grade="B";
			}else if(marks==5) {
				grade="C";
			}else {
				grade="Fail";
			}
			addMarks(marks, grade);
			System.out.println("You scored "+marks+" marks out of 10");
			
		} catch ( Exception e) {		
			e.printStackTrace();
		}
	}
	public static void addMarks(int marks, String grade) {
		try {
			Connection con = DBUtility.makeConnection();
			PreparedStatement ps = con.prepareStatement("insert into marks(marks,grade)values(?,?)");
			ps.setInt(2, marks);
			ps.setString(3, grade);
			int i = ps.executeUpdate();
			System.out.println("Marks Uploaded..."+i);
			ps.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
