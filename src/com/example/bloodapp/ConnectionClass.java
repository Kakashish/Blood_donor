package com.example.bloodapp;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import android.annotation.SuppressLint;
import android.os.StrictMode;
import android.util.Log;

public class ConnectionClass {
	
	Connection conn = null;
	String ConnURL = null;
	@SuppressLint("NewApi")
	public Connection CONN(){
		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
		StrictMode.setThreadPolicy(policy);
		
		try {
			Class.forName("net.sourceforge.jtds.jdbc.Driver");//oracle.jdbc.OracleDriver
			ConnURL=
					"jdbc:jtds:sqlserver://122.168.195.107:1433/Libdemo;user=Lib;password=myadmin_st1";//jdbc:oracle:thin:@localhost:1521:XE"
		conn = DriverManager.getConnection(ConnURL);
		}
		catch(SQLException se){
			Log.e("ERRO",se.getMessage());
		}
		catch (ClassNotFoundException e){
			Log.e("ERRO",e.getMessage());
		}
		catch(Exception e){
		Log.e("ERRO",e.getMessage());
		}
		return conn;
	}
	
	
	

}
//