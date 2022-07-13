package com.rewards.demo;

import java.time.LocalDate;

public class User {
	
	private String name;
	private LocalDate transdate;
	private int transAmount;
	private int rewards;
	
	
	
	public int getRewards() {
		if(transAmount != 0 && transAmount > 100) {
			rewards = (transAmount-100)*2;
		}
		if (transAmount != 0 && transAmount > 50) {
			rewards = rewards + 50;
		}
		setRewards(rewards);
		return rewards;
	}
	public void setRewards(int rewards) {
		this.rewards = rewards;
	}
	public User() {}
	public User(String name, LocalDate transdate, int transAmount) {
		super();
		this.name = name;
		this.transdate = transdate;
		this.transAmount = transAmount;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getTransdate() {
		return transdate;
	}
	public void setTransdate(LocalDate transdate) {
		this.transdate = transdate;
	}
	public int getTransAmount() {
		return transAmount;
	}
	public void setTransAmount(int transAmount) {
		this.transAmount = transAmount;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", transdate=" + transdate + ", transAmount=" + transAmount + ", rewards="
				+ getRewards() + "]";
	}
	

}
