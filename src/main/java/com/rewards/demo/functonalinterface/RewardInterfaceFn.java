package com.rewards.demo.functonalinterface;

public interface RewardInterfaceFn {
	
	public static int calculateRewards(int txnAmount) {
	    if(txnAmount <= 50) 
	            return 0;
	    
	    if(txnAmount <= 100) 
	            return txnAmount - 50;
	    
	    return (txnAmount - 100) * 2 + 50;
	}
	
	
}
