package com.velocity.miniproject;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class InsertData {
	PreparedStatement ps = null;
	Connection con = null;
	public void insertStudentData(int rollNo, String firstName,String middleName,String lastName,long mobileNo,String city,String password ) {
	try {
		ConnectionProvider cp = new ConnectionProvider();
		con = cp.getConnectionDetails();
		ps = con.prepareStatement("insert into quiz(rollNo,firstName,middleName,lastName,mobileNo,city,password)values(?,?,?,?,?,?,?)");
		ps.setInt(1,rollNo);
		ps.setString(2,firstName);
		ps.setString(3,middleName);
		ps.setString(4,lastName);
		ps.setLong(5,mobileNo);
		ps.setString(6,city);
		ps.setString(7,password);
		int i = ps.executeUpdate();
		System.out.println("Record inserted Successfully..."+i);
	} catch (Exception e) {
		e.printStackTrace();
	}	
	}

	public static void main(String[] args) {
	
	}

}
