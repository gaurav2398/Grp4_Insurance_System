package com.capgemini.quote.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="business_segment")
public class Business_Segment {

	@Id
	int Bus_Id;
	String Bussiness_Seg_Name;
	String Bus_Seg_Id;
	public Business_Segment(int bus_Id, String bussiness_Seg_Name, String bus_Seg_Id) {
		super();
		Bus_Id = bus_Id;
		Bussiness_Seg_Name = bussiness_Seg_Name;
		Bus_Seg_Id = bus_Seg_Id;
	}
	public Business_Segment() {
		super();
	}
	public int getBus_Id() {
		return Bus_Id;
	}
	public void setBus_Id(int bus_Id) {
		Bus_Id = bus_Id;
	}
	public String getBussiness_Seg_Name() {
		return Bussiness_Seg_Name;
	}
	public void setBussiness_Seg_Name(String bussiness_Seg_Name) {
		Bussiness_Seg_Name = bussiness_Seg_Name;
	}
	public String getBus_Seg_Id() {
		return Bus_Seg_Id;
	}
	public void setBus_Seg_Id(String bus_Seg_Id) {
		Bus_Seg_Id = bus_Seg_Id;
	}
	@Override
	public String toString() {
		return "\nBus_Id=" + Bus_Id + ", Bussiness_Seg_Name=" + Bussiness_Seg_Name + ", Bus_Seg_Id="
				+ Bus_Seg_Id;
	}	

}
