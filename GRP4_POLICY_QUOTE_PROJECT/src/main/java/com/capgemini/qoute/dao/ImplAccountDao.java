package com.capgemini.qoute.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

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
	public Account showAccount(double userName) {
		Account account= em.find(Account.class, userName); 
		return account;
	}

}
