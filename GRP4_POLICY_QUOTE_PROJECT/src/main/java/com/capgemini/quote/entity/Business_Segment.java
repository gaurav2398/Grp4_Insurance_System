package com.capgemini.quote.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="business_segment")
public class Business_Segment {

	@Id
	String Business_Segment_Name;
	int Bus_Id;
	String Bus_Seg_Id;
	public Business_Segment(String business_Segment_Name, int bus_Id, String bus_Seg_Id) {
		super();
		Business_Segment_Name = business_Segment_Name;
		Bus_Id = bus_Id;
		Bus_Seg_Id = bus_Seg_Id;
	}

	public Business_Segment() {
		super();
	}

	public String getBusiness_Segment_Name() {
		return Business_Segment_Name;
	}

	public void setBusiness_Segment_Name(String business_Segment_Name) {
		Business_Segment_Name = business_Segment_Name;
	}

	public int getBus_Id() {
		return Bus_Id;
	}

	public void setBus_Id(int bus_Id) {
		Bus_Id = bus_Id;
	}

	public String getBus_Seg_Id() {
		return Bus_Seg_Id;
	}

	public void setBus_Seg_Id(String bus_Seg_Id) {
		Bus_Seg_Id = bus_Seg_Id;
	}

	@Override
	public String toString() {
		return "\nBusiness_Segment_Name=" + Business_Segment_Name;
	}
	

}
