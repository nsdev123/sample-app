package com.openshift.aeg;

import java.io.Serializable;
import java.util.Random;
import java.util.stream.IntStream;

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
	
	
	public String[] getAccountNumbers() {
		return accountNumbers;
	}

	public void setAccountNumbers(String[] accountNumbers) {
		this.accountNumbers = accountNumbers;
	}
	
	public String[] generateAccountNumbers() {
		String[] accountPrefixes = {"AAA","BBB","CCC","DDD"};
		accountNumbers = new String[MAX_ACCOUNT_NUMBERS];
		for (int i=0; i<MAX_ACCOUNT_NUMBERS; i++) {
			String accountNumberPrefix = accountPrefixes[new Random().nextInt(accountPrefixes.length)];
			int accountNumberSuffix = 1000000 + new Random().nextInt(9000000); 
			accountNumbers[i] = new String(accountNumberPrefix + "-" + accountNumberSuffix);
		}
		return accountNumbers;
	}
	
	public static void main(String[] args) {
		AccountNumberGenerator x = new AccountNumberGenerator();
		x.getAccountNumbers();
	}
}
