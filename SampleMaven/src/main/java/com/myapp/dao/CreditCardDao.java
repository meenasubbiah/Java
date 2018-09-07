package com.myapp.dao;

import com.myapp.model.CreditCard;

public interface CreditCardDao {
	
	public int createTable();
	
	public int insertData(CreditCard creditCard);
	
	public int updateDue(CreditCard creditCard);
	
	public int updateLimit(CreditCard creditCard);
	
	public int dropTable();
	
	public int deleteRecord(CreditCard creditCard);
	
	public void updateStatus();

}
