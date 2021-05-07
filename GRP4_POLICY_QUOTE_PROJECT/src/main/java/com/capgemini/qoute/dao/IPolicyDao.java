package com.capgemini.qoute.dao;

import java.util.List;

import com.capgemini.quote.entity.Policy;

public interface IPolicyDao {
	public void createPolicy(Policy p);
	public List<Policy> showPolicy();
	public List<Policy> showPolicyByUserName(String accNum);
}
