package com.scp.java.hbm.inheritance;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="MOBILE_INFO")
//@DiscriminatorValue(value = "M")
public class Mobile extends Product{
	String calling;
	String sim;
	public Mobile() {
		super();
	}
	public Mobile(int productId, String productName, double productPrice, String productModel, String productCategory,String calling, String sim) {
		super(productId, productName, productPrice, productModel, productCategory);
		this.calling=calling;
		this.sim=sim;
	}
	public String getCalling() {
		return calling;
	}
	public void setCalling(String calling) {
		this.calling = calling;
	}
	public String getSim() {
		return sim;
	}
	public void setSim(String sim) {
		this.sim = sim;
	}
	@Override
	public String toString() {
		return "Mobile [calling=" + calling + ", sim=" + sim + "]";
	}
	

}
