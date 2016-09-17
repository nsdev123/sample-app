package com.openshift.aeg;

import java.io.Serializable;
import java.util.Random;

public class AccountNumberGenerator implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final int MAX_ACCOUNT_NUMBERS = 5;

	{
		//accountNumbers= new String[]{"AAA-3254234234", "BBB-2434597938"};
		accountNumbers= generateAccountNumbers();
	}
	
	private String[] accountNumbers;
	private String[] accountPrefixes = {"AAA","BBB","CCC","DDD"};
	
	public String[] getAccountNumbers() {
		return accountNumbers;
	}

	public void setAccountNumbers(String[] accountNumbers) {
		this.accountNumbers = accountNumbers;
	}
	
	public String[] generateAccountNumbers() {
		String[] newAccountNumbers = new String[MAX_ACCOUNT_NUMBERS];
		for (int i=0; i<MAX_ACCOUNT_NUMBERS; i++) {
			newAccountNumbers[i] = accountPrefixes[new Random().nextInt(accountPrefixes.length)];
		}
		return newAccountNumbers;
	}
}
