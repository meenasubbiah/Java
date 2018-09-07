package com.myapp;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import com.myapp.dao.CreditCardDaoImpl;
import com.myapp.model.CreditCard;

public class TestMyApp {
	
	@Mock
	Connection con;
	
	@Mock
	Statement stmt;
	
	@Mock
	PreparedStatement prepStmt;
	
	@Mock
	CreditCard creditCard;
	
	@InjectMocks
	CreditCardDaoImpl impl;
	
	@Rule
	public MockitoRule rule = MockitoJUnit.rule();

	@Before
	public void setUp() throws Exception {
	}

	
	@Test
	public void testCreateTable() throws SQLException {
		
		when(con.createStatement()).thenReturn(stmt);
		when(stmt.executeUpdate(Mockito.anyString())).thenReturn(1);
		Assert.assertEquals(new CreditCardDaoImpl(con).createTable(),1);
	}
	@Test
	public void testInsertData() throws SQLException {
		
		when(con.prepareStatement(Mockito.anyString())).thenReturn(prepStmt);
		when(prepStmt.executeUpdate()).thenReturn(1);
		Assert.assertEquals(new CreditCardDaoImpl(con).insertData(creditCard),1);
	}
	@Test
	public void testUpdateDue() throws SQLException {
		
		when(con.createStatement()).thenReturn(stmt);
		when(stmt.executeUpdate(Mockito.anyString())).thenReturn(1);
		Assert.assertEquals(new CreditCardDaoImpl(con).updateDue(creditCard),1);
	}
	@Test
	public void testUpdateLimit() throws SQLException {
		
		when(con.createStatement()).thenReturn(stmt);
		when(stmt.executeUpdate(Mockito.anyString())).thenReturn(1);
		Assert.assertEquals(new CreditCardDaoImpl(con).updateLimit(creditCard),1);
	}
	@Test
	public void testDropTable() throws SQLException {
		
		when(con.createStatement()).thenReturn(stmt);
		when(stmt.executeUpdate(Mockito.anyString())).thenReturn(1);
		Assert.assertEquals(new CreditCardDaoImpl(con).dropTable(),1);
	}
	@Test
	public void testDeleteRecord() throws SQLException {
		
		when(con.createStatement()).thenReturn(stmt);
		when(stmt.executeUpdate(Mockito.anyString())).thenReturn(1);
		Assert.assertEquals(new CreditCardDaoImpl(con).deleteRecord(creditCard),1);
	}
	
}
