package org.studyeasy.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.studyeasy.entity.user;

public class UsersModel {
	public List<user> listUsers(DataSource datasource){
		List<user> listUsers=new ArrayList<>();
		Connection connect = null;
        java.sql.Statement stmt = null;
        ResultSet rs = null;
        try {
			connect = datasource.getConnection();
			
			// Step 2: Create a SQL statements string
			String query = "Select * from users";
			stmt = connect.createStatement();

			// Step 3: Execute SQL query
         rs = stmt.executeQuery(query);
         
			// Step 4: Process the result set
			while(rs.next()){
				listUsers.add(new user(rs.getInt("userid"),rs.getString("username"),rs.getString("email")));
				
			}
			
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return listUsers;
		
		
	}
	public void addUser(DataSource datasource, user newUser) {
		Connection connect=null;
		PreparedStatement statement=null;
		try {
			connect=datasource.getConnection();
			String username=newUser.getUsername();
			String email=newUser.getEmail();
			String query="insert into users(username,email) values(?,?)";
			statement=connect.prepareStatement(query);
			statement.setString(1,username);
			statement.setString(2, email);
			statement.execute();
		}
catch (SQLException e) {
			
			e.printStackTrace();
			
		}
		
		}
	public void updateUser(DataSource datasource, user updatedUser) {
		Connection connect=null;
		PreparedStatement statement=null;
		try {
			connect=datasource.getConnection();
			int userid=updatedUser.getUserid();
			String username=updatedUser.getUsername();
			String email=updatedUser.getEmail();
			String query="update users set username=?,email=? where userid=?";
			statement=connect.prepareStatement(query);
			statement.setString(1,username);
			statement.setString(2, email);
			statement.setInt(3,userid);
			statement.execute();
		}
catch (SQLException e) {
			
			e.printStackTrace();
			
		}
		
	}
	public void deleteuser(DataSource datasource, int userid) {
		Connection connect=null;
		PreparedStatement statement=null;
		try {
			connect=datasource.getConnection();
			
			String query="delete from users where userid=?";
			statement=connect.prepareStatement(query);
			
			statement.setInt(1,userid);
			statement.execute();
		}
catch (SQLException e) {
			
			e.printStackTrace();
			
		}
		
	}
		
		
	}

