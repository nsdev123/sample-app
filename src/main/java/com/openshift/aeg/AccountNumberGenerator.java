package com.openshift.aeg;

import java.io.Serializable;

public class AccountNumberGenerator implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	{
		accountNumbers= new String[]{"AAA-3254234234", "BBB-2434597938"};
	}
	
	private String[] accountNumbers;
	
	public String[] getAccountNumbers() {
		return accountNumbers;
	}

	public void setAccountNumbers(String[] accountNumbers) {
		this.accountNumbers = accountNumbers;
	}
	
}
