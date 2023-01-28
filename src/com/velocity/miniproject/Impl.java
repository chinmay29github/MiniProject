package com.velocity.miniproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;



public class Impl{
	
	Connection conn=DBUtility.makeConnection();
	PreparedStatement ps;
	String query;
	int i;
	static int marks;
	Scanner sc=new Scanner(System.in);
	public void checkStud() {
		
		String password;
		System.out.println("==================================================================================================================");
		System.out.println("Enter Roll No                                                  ");
		int roll_no=sc.nextInt();
		sc.nextLine();
		
		System.out.println("Enter Password                                                                   ");
		
		password=sc.nextLine();
		
		
		String grade;
		query="select emailID,password from studentregister where roll_no=? and password=?";
		ResultSet rs=null;
		Scanner sc=new Scanner(System.in);
		
		try {
			ps=conn.prepareStatement(query);
			ps.setInt(1,roll_no );
			ps.setString(2, password);
			rs=ps.executeQuery();
			
			if(rs.next()) {
				System.out.println("==================================================================================================================");
				System.out.println("Press y to start the quiz");
				System.out.println("==================================================================================================================");
				Character y=sc.nextLine().charAt(0);
				if(y.equals('y')) {
					query="select roll_no from marks where roll_no=? ";
					ps=conn.prepareStatement(query);
					ps.setInt(1, roll_no);
					rs=ps.executeQuery();
					if(rs.next()) {
						System.out.println("==================================================================================================================");
						System.out.println("You have already attended the Quiz");
						System.out.println("==================================================================================================================");
					}
					else {
						System.out.println("Start Quiz");
						int marks=displayQuestiond();
						grade=" ";
						if(marks>=8) {
							grade="A";
						}else if (marks>=6) {
							grade="B";
						}
						else if (marks>=5) {
							grade="C";
						}
						else {
							grade="fail";
						}
						query="insert into marks(roll_no,marks,grade)"
								+ "values(?,?,?)";
						try {
							ps=conn.prepareStatement(query);
							
							ps.setInt(1,roll_no );
							ps.setLong(2, marks);
							ps.setString(3, grade);
							i=ps.executeUpdate();
							if(i>0) {
								System.out.println("Thank you");
							}
							
							
						} catch (SQLException e) {
						
							e.printStackTrace();
						}
						
						
				
					}
				
				}
				else {
					System.exit(0);
				}
			}
			else {
					throw new StudNotValidException();	
				} 
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		
	
		
	}
	
	
	
	public int displayQuestiond() {
		
		try {
		ps = conn.prepareStatement("SELECT * FROM questionbank\r\n"+"ORDER BY RAND()\r\n"
					);
		ResultSet rs = ps.executeQuery();
		Scanner sc = new Scanner(System.in);
		
		int x=1;
		for(int i=1;i<=10;i++) {
			
		while(rs.next()){
			
			System.out.println("Question "+x+": "+rs.getString(2));
			System.out.println("Option A- "+rs.getString(3));
			System.out.println("Option B- "+rs.getString(4));
			System.out.println("Option C- "+rs.getString(5));
			System.out.println("Option D- "+rs.getString(6));
			System.out.println("Enter Your Answer : ");
			
			String s = sc.nextLine();
			if(s.equalsIgnoreCase(rs.getString(7))) {
				marks++;
			}x++;
		}
		
		}
		System.out.println("==================================================================================================================");
		System.out.println("You Have Attempted all Questions Successfully\n"+"Press 'Y' to Submit your Exam");
		System.out.println("==================================================================================================================");
		String y = sc.next();
		if(y.equalsIgnoreCase("Y")) {
			System.out.println("==================================================================================================================");
			System.out.println("Your Exam is Submitted Successfully.");
			System.out.println("==================================================================================================================");
		}
		System.out.println("==================================================================================================================");
		System.out.println("You scored "+marks+" marks out of 10");
		System.out.println("==================================================================================================================");
		
		
		
		
		
		
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return marks;
		
	
	}
	
	public void displaystud(){
		
		query="select studentregister.roll_no,studentregister.firstName,studentregister.middleName,"
				+ "studentregister.lastName,studentregister.city,studentregister.mobileNo,studentregister.emailID,"
				+ "marks.marks,marks.grade from studentregister left join marks on studentregister.roll_no=marks.roll_no ";
		try {

			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery(query);
			while(rs.next()) {
				int roll_no=(rs.getInt("roll_no"));
				String firstName=(rs.getString("firstName"));
				String middleName=(rs.getString("middleName"));
				String lastName=(rs.getString("lastName"));
				String city=(rs.getString("city"));
				long mobile=(rs.getLong("mobileNo"));
				String emailId=(rs.getString("emailID"));
				int marks=(rs.getInt("marks"));
				String grade=(rs.getString("grade"));
				System.out.println("==================================================================================================================");
				System.out.println(" Roll NO " + " FirstName " + " MiddleName " + " LastName " + "  City  " + " Mobile NO "+"   Email ID   " + "              Marks  " + "      Grade ");
				System.out.println("   "+roll_no+"      "+firstName+"      "+middleName+"     "+lastName+"     "+city+"     "+mobile+"     "+emailId+"     "+marks+"           "+grade);
				System.out.println("==================================================================================================================");
				
			}
			
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
	}
	
	public void searchstud(int roll_no) {
		query="select studentregister.roll_no,studentregister.firstName,studentregister.middleName,studentregister.lastName,studentregister.city,studentregister.mobileNo,studentregister.emailID,marks.marks,marks.grade from studentregister ,marks where studentregister.roll_no=? " ;
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
				long mobile=(rs.getInt("mobileNo"));
				String emailId=(rs.getString("emailID"));
				int marks=(rs.getInt("marks"));
				String grade=(rs.getString("grade"));
				System.out.println("==================================================================================================================");
				System.out.println(" Roll NO " + " FirstName " + " MiddleName " + " LastName " + "  City  " + " Mobile NO "+"   Email ID   " + "      Marks  " + "    Greade ");
				System.out.println("   "+ roll_no+ " "+"      "+firstName+"  "+"  "+middleName+"  "+"     "+lastName+" "+" "+ city+"  "+"   "+mobile+"  "+"  "+emailId+"  "+"   "+marks+"      "+"  "+grade);
				System.out.println("==================================================================================================================");
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
