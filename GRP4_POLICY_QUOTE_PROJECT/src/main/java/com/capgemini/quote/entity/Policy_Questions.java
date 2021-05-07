package com.capgemini.quote.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Policy_Question")
public class Policy_Questions {
	@Id
	int Qid;
	String Business_Segment_Name, Qid_seq;
	String Q_desc, Option1, Option2, Option3;

	public Policy_Questions(int qid, String business_Segment_Name, String qid_seq, String q_desc, String option1,
			String option2, String option3) {
		super();
		Qid = qid;
		Business_Segment_Name = business_Segment_Name;
		Qid_seq = qid_seq;
		Q_desc = q_desc;
		Option1 = option1;
		Option2 = option2;
		Option3 = option3;
	}

	public Policy_Questions() {
		super();
	}

	public int getQid() {
		return Qid;
	}

	public String getBusiness_Segment_Name() {
		return Business_Segment_Name;
	}

	public String getQid_seq() {
		return Qid_seq;
	}

	public String getQ_desc() {
		return Q_desc;
	}

	public String getOption1() {
		return Option1;
	}

	public String getOption2() {
		return Option2;
	}

	public String getOption3() {
		return Option3;
	}

	public void setQid(int qid) {
		Qid = qid;
	}

	public void setBusiness_Segment_Name(String business_Segment_Name) {
		Business_Segment_Name = business_Segment_Name;
	}

	public void setQid_seq(String qid_seq) {
		Qid_seq = qid_seq;
	}

	public void setQ_desc(String q_desc) {
		Q_desc = q_desc;
	}

	public void setOption1(String option1) {
		Option1 = option1;
	}

	public void setOption2(String option2) {
		Option2 = option2;
	}

	public void setOption3(String option3) {
		Option3 = option3;
	}

	@Override
	public String toString() {
		return "\nQ_desc=" + Q_desc + "\nOption1=" + Option1 + "\nOption2=" + Option2 
				+ "\nOption3="	+ Option3;
	}

}
