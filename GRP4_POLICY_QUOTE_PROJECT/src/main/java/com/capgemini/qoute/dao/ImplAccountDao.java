package com.capgemini.qoute.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import com.capgemini.quote.entity.Account;
import com.capgemini.quote.entity.User;
import com.capgemini.quote.util.JPAUtil;

public class ImplAccountDao implements IAccountDao {

	private EntityManager em;	
	
	public ImplAccountDao() {
		em = JPAUtil.getEntityManager();
	}
	@Override
	public void createAccount(Account acc) {
		System.out.println(em);
		em.getTransaction().begin();
		em.persist(acc);
		em.getTransaction().commit();
		System.out.println("Record Added");
	}

	@Override
	public Account getUserByAccountNumber(String accountNumber) {
		Account acount = em.find(Account.class, accountNumber);
		return acount;
	}
	
	@Override
	public List<Account> showAccountByUserName(String userName) {
		String qStr = "SELECT a FROM Account a WHERE a.User_Name=:userName";
		TypedQuery<Account> query = em.createQuery(qStr, Account.class);
		query.setParameter("userName", userName);
		List<Account> accountList = query.getResultList();
		
		return accountList;
		
	}
	@Override
	public List<Account> showAccountCreatedById(String userCreatedBy) {
		String qStr = "SELECT a FROM Account a WHERE a.createdby=:userCreatedBy";
		TypedQuery<Account> query = em.createQuery(qStr, Account.class);
		query.setParameter("userCreatedBy", userCreatedBy);
		List<Account> accountList = query.getResultList();		
		return accountList;
	}
	
}
