package com.scp.java.hbm.inheritance;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="LAPTOP_INFO")
//@DiscriminatorValue(value = "L")
public class Laptop extends Product{
	String cdRom;
	String ports;
	public String getCdRom() {
		return cdRom;
	}
	public void setCdRom(String cdRom) {
		this.cdRom = cdRom;
	}
	public String getPorts() {
		return ports;
	}
	public void setPorts(String ports) {
		this.ports = ports;
	}
	public Laptop(int productId, String productName, double productPrice, String productModel, String productCategory,
			String cdRom, String ports) {
		super(productId, productName, productPrice, productModel, productCategory);
		this.cdRom = cdRom;
		this.ports = ports;
	}
	@Override
	public String toString() {
		return "Laptop [cdRom=" + cdRom + ", ports=" + ports + "]";
	}


}
