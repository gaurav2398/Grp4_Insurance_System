package com.capgemini.qoute.dao;

import com.capgemini.quote.entity.Account;

public interface IAccountDao {

	public void createAccount(Account acc);
	public Account showAccount(double userName);
	
}
