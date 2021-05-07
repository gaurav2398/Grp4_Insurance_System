package com.capgemini.qoute.dao;

import javax.persistence.EntityManager;

import com.capgemini.quote.entity.Policy_Questions;
import com.capgemini.quote.util.JPAUtil;

public class ImplPolicyQuestionDao implements IPolicyQuestionsDao {

	private EntityManager em;	
	
	public ImplPolicyQuestionDao() {
		em = JPAUtil.getEntityManager();
	}

	@Override
	public Policy_Questions showPolicyQuestions(int qid) {
		Policy_Questions policy_Questions=  em.find(Policy_Questions.class, qid);
		return policy_Questions;
	}


}
