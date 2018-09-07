package com.myapp;

import java.sql.Connection;

import com.myapp.dao.CreditCardDaoImpl;
import com.myapp.dao.LoadDatabase;
import com.myapp.factory.DBConnect;
import com.myapp.model.CreditCard;



public class Main {
	
	 public static void main( String[] args ) throws Exception{
	     
		 
		Connection con = DBConnect.getConnection();
			
		CreditCardDaoImpl dop=new CreditCardDaoImpl(con);
			
		dop.dropTable();
		 
		dop.createTable();
		
		LoadDatabase ld=new LoadDatabase("C://Users//meenas//Documents//creditcard.txt",con);
		ld.loadDatabase();
				
		CreditCard creditCard=new CreditCard();
		creditCard.setUserId(100);
		creditCard.setName("xxx");
		creditCard.setDue(10000);
		creditCard.setLimit(12000);
		creditCard.setStatus("not updated");
		
		dop.insertData(creditCard);
		
		dop.deleteRecord(creditCard);
		
		dop.updateStatus();
	
		 
	    }
	    
	   
}
