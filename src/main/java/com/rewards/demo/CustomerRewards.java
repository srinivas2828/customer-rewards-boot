package com.rewards.demo;

import java.time.Month;

import org.springframework.util.StringUtils;

public class CustomerRewards {
	
	

	
	 private String name;
	 int rewards[];
	 
	    

		
	    
	    public CustomerRewards(String name) {
	            this.name = name;
	            this.rewards = new int[13]; //rewars[0] is empty,rewards[1]=10 means first month(january)
	    }
	    
	   public  void addReward(int month, int reward) {
	            rewards[month] = rewards[month] + reward;
	    }
	    
	    public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

	    @Override
	    public String toString() {
	    	String s ="Customer- "+name+ "\n";
	            int totalRewards = 0;
	            for(int i=1; i<=12; i++) {
	            	totalRewards =  totalRewards + rewards[i];
	            	if(rewards[i] > 0)
	                    s += StringUtils.capitalize(Month.of(i).name().toLowerCase())  + "- Rewards= " + rewards[i] + "\n";
	            }
	            //finally add total rewards
	            s += "Total Rewards="+totalRewards +"\n";
	            return s;
	    }
}
