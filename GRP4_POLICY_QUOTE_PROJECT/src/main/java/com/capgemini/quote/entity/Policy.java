package com.capgemini.quote.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "policy")
public class Policy {
	@Id
	int Policy_Number;
	double Policy_Premium;
	double Account_Number;
	public Policy(int policy_Number, double policy_Premium, double account_Number) {
		super();
		Policy_Number = policy_Number;
		Policy_Premium = policy_Premium;
		Account_Number = account_Number;
	}

	public Policy() {
		super();
	}

	public int getPolicy_Number() {
		return Policy_Number;
	}

	public void setPolicy_Number(int policy_Number) {
		Policy_Number = policy_Number;
	}

	public double getPolicy_Premium() {
		return Policy_Premium;
	}

	public void setPolicy_Premium(double policy_Premium) {
		Policy_Premium = policy_Premium;
	}

	public double getAccount_Number() {
		return Account_Number;
	}

	public void setAccount_Number(double account_Number) {
		Account_Number = account_Number;
	}

	@Override
	public String toString() {
		return "\nPolicy_Number=" + Policy_Number + ", Policy_Premium=" + Policy_Premium + ", Account_Number="
				+ Account_Number;
	}
	
	
	
}
