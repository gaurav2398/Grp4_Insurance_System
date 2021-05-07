package com.capgemini.qoute.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.capgemini.quote.entity.Business_Segment;
import com.capgemini.quote.util.JPAUtil;


public class ImplBusinessSegmentDao implements IBusinessSegmentDao {


	private EntityManager em;	
	
	public ImplBusinessSegmentDao() {
		em = JPAUtil.getEntityManager();
	}
	@Override
	public List<Business_Segment> showBusinessSegmentList() {
		List<Business_Segment> list = em.createQuery("SELECT a FROM Business_Segment a", Business_Segment.class).getResultList();
		return list ;
	}

}
