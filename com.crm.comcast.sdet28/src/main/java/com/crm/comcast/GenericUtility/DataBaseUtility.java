package com.crm.comcast.GenericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class DataBaseUtility {
	Connection connection=null;
	/**
	 * This method will do connection to database
	 * @throws Throwable
	 */
	public void connectToBe() throws Throwable {
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentinfo","root","root");
		}
	/**
	 * This method will close the database connection
	 * @throws Throwable
	 */
	public void closeDB() throws Throwable {
		connection.close();
	}
	/**
	 * This method will fetch all the data from database
	 * @param querry
	 * @return 
	 * @throws Throwable 
	 */
	public ResultSet getAllData(String querry) throws Throwable {
		ResultSet result = connection.createStatement().executeQuery(querry);
		return result;
	}
	/**
	 * Method will update the data in database and it will verify
	 * @param querry
	 * @return
	 * @throws Throwable
	 */
	public boolean updateData(String querry) throws Throwable {
		boolean flag=false;
		 int result = connection.createStatement().executeUpdate(querry);
		 if(result==1) {
			 System.out.println("data is update in database");
			 flag=true;
		 }else {
			 System.out.println("data is not update in database");
		 }
		 return flag;
	}
	/**
	 * This method will verify the given data is present in the database or not
	 * @param querry
	 * @param columnNumber
	 * @param ExpectedData
	 * @return
	 * @throws Throwable
	 */
	public String getTheData(String querry,int columnNumber,String ExpectedData) throws Throwable {
		boolean flag=false;
		String actualdata=null;
		ResultSet result = connection.createStatement().executeQuery(querry);
		while(result.next()) {
			String data = result.getString(columnNumber);
			if(data.equals(ExpectedData)) {
				actualdata=data;
				flag=true;
				break;
			}
		}
		if(flag==true) {
			System.out.println("data is present in the database");
			return actualdata;
		}else {
			System.out.println("data is not present in the database");
			return actualdata;
		}
			
	}
	

}
