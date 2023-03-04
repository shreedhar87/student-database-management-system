package com.shree;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionCheck {

	public static void main(String[] args) {
		
		String url="jdbc:mysql://localhost:3306/maru";
		String user="root";
		String pass="root";
		
		try {
			Connection my=DriverManager.getConnection(url,user,pass);
			System.out.println("done....");
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}
