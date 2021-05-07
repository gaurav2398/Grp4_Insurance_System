package com.capgemini.qoute.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.capgemini.quote.entity.Account;
import com.capgemini.quote.entity.Business_Segment;
import com.capgemini.quote.entity.Policy;
import com.capgemini.quote.util.JPAUtil;

public class ImplPolicyDao implements IPolicyDao{


	private EntityManager em;	
	
	public ImplPolicyDao() {
		em = JPAUtil.getEntityManager();
	}
	
	@Override
	public void createPolicy(Policy p) {
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();		
	}

	@Override
	public List<Policy> showPolicy() {
		List<Policy> list = em.createQuery("SELECT a FROM Policy a", Policy.class).getResultList();
		return list ;
	}

	@Override
	public List<Policy> showPolicyByUserName(String accNum) {
		String qStr = "SELECT p FROM Policy p WHERE p.Account_Number=:accNum";
		TypedQuery<Policy> query = em.createQuery(qStr, Policy.class);
		query.setParameter("accNum", accNum);
		List<Policy> policyList = query.getResultList();
		
		return policyList;
	}
}
