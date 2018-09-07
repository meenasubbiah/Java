package com.myapp.dao;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import com.myapp.model.CreditCard;

public class LoadDatabase {
	
	private String path;
	private Connection con=null;
	private ArrayList<CreditCard> creditCard=new ArrayList<>();
	
	public LoadDatabase(String path,Connection con){
		this.path = path;
		this.con=con;
	}
	
	private void readFile(){
		
		FileInputStream fis=null;
		InputStreamReader is=null;
		BufferedReader br=null;
		
		
		try{
			
			fis=new FileInputStream(path);
			is=new InputStreamReader(fis);
			br=new BufferedReader(is);
			
			String line=null;
			
			String[] cardDetail=null;
			
			try {
				line=br.readLine();
				
				while(line!=null){
					cardDetail=line.split(",");
					creditCard.add(new CreditCard(Integer.parseInt(cardDetail[0]), cardDetail[1], Integer.parseInt(cardDetail[2]), Integer.parseInt(cardDetail[3]), cardDetail[4]));
					line=br.readLine();
				}
				
				
			} catch (IOException e){
				e.printStackTrace();
			}finally{
				if(br!=null){
					try{
				br.close();
				is.close();
				fis.close();
					}catch(IOException e){
						e.printStackTrace();
						throw new RuntimeException();
					}
				}
			}
				
			
		}catch(FileNotFoundException e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}
	
	public int[] loadDatabase(){
		readFile();
		int[] count=null;
		try {
			PreparedStatement prepStmt=con.prepareStatement("INSERT INTO Credit_card VALUES (?,?,?,?,?)");
			for(CreditCard card:creditCard){
				prepStmt.setInt(1,card.getUserId());
				prepStmt.setString(2,card.getName()); 
				prepStmt.setInt(3,card.getDue());
				prepStmt.setInt(4,card.getLimit());
				prepStmt.setString(5,card.getStatus());
				
				//prepStmt.executeUpdate();
				prepStmt.addBatch();
			}
			count=prepStmt.executeBatch();
			prepStmt.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
		return count;
		
	}

}
