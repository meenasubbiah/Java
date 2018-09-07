package com.myapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.myapp.model.CreditCard;


public class CreditCardDaoImpl implements CreditCardDao{
	
	private Connection con=null;
	private Statement stmt=null;
	private PreparedStatement prepStmt=null;
	int res=0;
	
	
	public CreditCardDaoImpl(Connection con){
		this.con=con;
	}
	public int createTable(){
		try {
			stmt = con.createStatement();
			res=stmt.executeUpdate("CREATE TABLE Credit_card(user_id INT NOT NULL,name VARCHAR(50) NOT NULL,due INT,limit INT,status varchar(20),PRIMARY KEY (user_id));");
			stmt.close();
			
		}catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return res;
        
	}
	public int insertData(CreditCard creditCard){
		try{
			prepStmt=con.prepareStatement("INSERT INTO Credit_card VALUES (?,?,?,?,?)");
			//int result = prepStmt.executeUpdate("INSERT INTO Credit_card VALUES (?,?,?,?,?)"); 
			prepStmt.setInt(1,creditCard.getUserId());
			prepStmt.setString(2,creditCard.getName()); 
			prepStmt.setInt(3,creditCard.getDue());
			prepStmt.setInt(4,creditCard.getLimit());
			prepStmt.setString(5,creditCard.getStatus());  
			res=prepStmt.executeUpdate(); 
			prepStmt.close();
		}catch(SQLException e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return res;
		
	}
	public int updateDue(CreditCard creditCard){
		try{
				stmt = con.createStatement();
				res=stmt.executeUpdate("UPDATE Credit_card SET DUE="+creditCard.getDue()+"where user_id="+creditCard.getUserId());
				stmt.close();
		}catch(SQLException e){
				e.printStackTrace();
				throw new RuntimeException(e);
		}
		return res;
	}	
	public int updateLimit(CreditCard creditCard){
		try{
			stmt = con.createStatement();
			res=stmt.executeUpdate("UPDATE Credit_card SET limit="+creditCard.getLimit()+"where user_id="+creditCard.getUserId());
			stmt.close();
		}catch(SQLException e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}	
		return res;
	}
	public int dropTable(){
		try{
			stmt = con.createStatement();
			res=stmt.executeUpdate("DROP table credit_card");
			stmt.close();
		}catch(SQLException e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return res;
	}
	public int deleteRecord(CreditCard creditCard){
		try{
			stmt = con.createStatement();
			res=stmt.executeUpdate("DELETE FROM credit_card WHERE user_id="+creditCard.getUserId());
			stmt.close();
		}catch(SQLException e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return res;
	}
	public void updateStatus(){
		try{
			int userid=0;
			int due=0;
			int limit=0;
			int res=0;
			stmt = con.createStatement();
	        ResultSet result = stmt.executeQuery("SELECT user_id,due,limit FROM Credit_card");
	         
	         while(result.next()){
	        	 userid=result.getInt(1);
	        	 due=result.getInt(2);
	        	 limit=result.getInt(3);
	        	 stmt = con.createStatement();
	        	 if(due>limit){
	        		  res=stmt.executeUpdate("UPDATE credit_card SET status = 'disabled'  WHERE user_id ="+userid);
	        	 }
	        	 else{
	        		  res=stmt.executeUpdate("UPDATE credit_card SET status = 'enabled'  WHERE user_id ="+userid);
	        	 }
	        	 stmt.close(); 
	         }
	         stmt.close();
	        	 
		}catch(SQLException e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}	

}

