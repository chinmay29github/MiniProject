package com.velocity.miniproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Impl {

	Connection conn = DBUtility.makeConnection();
	PreparedStatement ps;
	String query;
	int i;
	static int marks;

	public void checkStud(int roll_no, String password) {

		String grade;
		query = "select emailID,password from studentregister where roll_no=? and password=?";
		ResultSet rs = null;
		Scanner sc = new Scanner(System.in);

		try {
			ps = conn.prepareStatement(query);
			ps.setInt(1, roll_no);
			ps.setString(2, password);
			rs = ps.executeQuery();

			if (rs.next()) {
				System.out.println(
						"==================================================================================================================");
				System.out.println("Press y to start the quiz");
				System.out.println(
						"==================================================================================================================");
				Character y = sc.nextLine().charAt(0);
				if (y.equals('y')) {
					query = "select roll_no from marks where roll_no=? ";
					ps = conn.prepareStatement(query);
					ps.setInt(1, roll_no);
					rs = ps.executeQuery();
					if (rs.next()) {
						System.out.println(
								"==================================================================================================================");
						System.out.println("You have already attended the Quiz");
						System.out.println(
								"==================================================================================================================");
					} else {
						System.out.println("Start Quiz");
						DisplayQuestions.displayQuestions();

					}
				} else {
					System.exit(0);
				}
			} else {
				throw new StudNotValidException();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void displaystud() {

		query = "select studentregister.roll_no,studentregister.firstName,studentregister.middleName,"
				+ "studentregister.lastName,studentregister.city,studentregister.mobileNo,studentregister.emailID,"
				+ "marks.marks,marks.grade from studentregister left join marks on studentregister.roll_no=marks.roll_no ";
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				int roll_no = (rs.getInt("roll_no"));
				String firstName = (rs.getString("firstName"));
				String middleName = (rs.getString("middleName"));
				String lastName = (rs.getString("lastName"));
				String city = (rs.getString("city"));
				int mobile = (rs.getInt("mobileNo"));
				String emailId = (rs.getString("emailID"));
				int marks = (rs.getInt("marks"));
				String grade = (rs.getString("grade"));
				System.out.println(
						"==================================================================================================================");
				System.out.println(" Roll NO " + " FirstName " + " MiddleName " + " LastName " + "  City  "
						+ " Mobile NO " + "   Email ID   " + "              Marks  " + "      Grade ");
				System.out.println("   " + roll_no + "      " + firstName + "      " + middleName + "     " + lastName
						+ "     " + city + "     " + mobile + "     " + emailId + "     " + marks + "           "
						+ grade);
				System.out.println(
						"==================================================================================================================");

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public void searchstud(int roll_no) {
		query = "select studentregister.roll_no,studentregister.firstName,studentregister.middleName,studentregister.lastName,studentregister.city,studentregister.mobileNo,studentregister.emailID,marks.marks,marks.grade from studentregister ,marks where studentregister.roll_no=? ";
		ResultSet rs = null;

		try {
			ps = conn.prepareStatement(query);
			ps.setInt(1, roll_no);
			rs = ps.executeQuery();

		} catch (SQLException e) {
			
			e.printStackTrace();
		}

		try {
			if (rs.next()) {

				roll_no = (rs.getInt("roll_no"));
				String firstName = (rs.getString("firstName"));
				String middleName = (rs.getString("middleName"));
				String lastName = (rs.getString("lastName"));
				String city = (rs.getString("city"));
				int mobile = (rs.getInt("mobileNo"));
				String emailId = (rs.getString("emailID"));
				int marks = (rs.getInt("marks"));
				String grade = (rs.getString("grade"));
				System.out.println(
						"==================================================================================================================");
				System.out.println(" Roll NO " + " FirstName " + " MiddleName " + " LastName " + "  City  "
						+ " Mobile NO " + "   Email ID   " + "      Marks  " + "    Greade ");
				System.out.println("   " + roll_no + " " + "      " + firstName + "  " + "  " + middleName + "  "
						+ "     " + lastName + " " + " " + city + "  " + "   " + mobile + "  " + "  " + emailId + "  "
						+ "   " + marks + "      " + "  " + grade);
				System.out.println(
						"==================================================================================================================");
			} else {
				System.err.println("plz enter correct Roll number");
		}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
