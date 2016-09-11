package com.openshift.aeg;

import java.io.Serializable;

public class AccountNumberGenerator implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	{
		accountNumbers= new String[]{"werwe", "fsdfsf"};
	}
	
	private String[] accountNumbers;
	
	public String[] getAccountNumbers() {
		return accountNumbers;
	}

	public void setAccountNumbers(String[] accountNumbers) {
		this.accountNumbers = accountNumbers;
	}
	
}
