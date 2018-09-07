package com.myapp.model;

public class CreditCard {
	
	public CreditCard(){ 
	
		super();
		
	}
	private int userId;
	private String name;
	private int due;
	private int limit;
	private String status;
	

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDue() {
		return due;
	}

	public void setDue(int due) {
		this.due = due;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public CreditCard(int userId, String name, int due, int limit,
			String status) {
		super();
		this.userId = userId;
		this.name = name;
		this.due = due;
		this.limit = limit;
		this.status = status;
	}
	@Override
	public String toString() {
		return "CreditCard [user_id=" + userId + ", name=" + name + ", due="
				+ due + ", limit=" + limit + ", status=" + status + "]";
	}
	

}
