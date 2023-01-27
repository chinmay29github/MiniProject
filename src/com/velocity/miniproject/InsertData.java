package com.velocity.miniproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class InsertData {
	PreparedStatement ps = null;
	Connection con = null;

	public void insertStudentData(String firstName, String middleName, String lastName, long mobileNo, String city,
			String emailID, String password) {
		try {
			con = ConnectionProvider.getConnectionDetails();
			ps = con.prepareStatement(
					"insert into studentregister(firstName,middleName,lastName,mobileNo,city,emailID,password)values(?,?,?,?,?,?,?)");
			ps.setString(1, firstName);
			ps.setString(2, middleName);
			ps.setString(3, lastName);
			ps.setLong(4, mobileNo);
			ps.setString(5, city);
			ps.setString(6, emailID);
			ps.setString(7, password);
			int i = ps.executeUpdate();
			System.out.println("Student Registration Successful..." + i);
			ps.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void doRegistration() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your First Name");
		String firstname = sc.next();
		System.out.println("Enter your Middle Name");
		String middlename = sc.next();
		System.out.println("Enter your Last Name");
		String lastname = sc.next();
		System.out.println("Enter your mobile number");
		long mobileno = sc.nextLong();
		System.out.println("Enter your city");
		String city = sc.next();
		System.out.println("Enter your email ID");
		String email = sc.next();
		System.out.println("Set New Password");
		String password = sc.next();

		InsertData data = new InsertData();
		data.insertStudentData(firstname, middlename, lastname, mobileno, city,email, password);
		System.out.println("Please Check your Login Details below");
		System.out.println("Username : "+email);
		System.out.println("Password : "+password);
		sc.close();
	}

	public static void main(String[] args) {
		doRegistration();
	}

}
