package com.capgemini.qoute.dao;

import java.util.List;

import com.capgemini.quote.entity.Account;

public interface IAccountDao {

	public void createAccount(Account acc);
	public List<Account> showAccountByUserName(String userName);
	public Account getUserByAccountNumber(String accountNumber);
	public List<Account> showAccountCreatedById(String userCreatedBy);
}
