package com.scp.java.hbm.inheritance;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="PRODUCT_INFORMATION")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name="WHOSE_RECORD")
//@DiscriminatorValue(value="P")
public class Product {
@Id
@Column(name="Product_ID")
@GeneratedValue(strategy = GenerationType.TABLE)
 private int productId;
@Column(name="PRODUCT_NAME")
 private String productName;
@Column(name="PRODUCT_PRICE")
 private double productPrice;
@Column(name="PRODUCT_MODEL")
 private String productModel;
@Column(name="PRODUCT_CATEGORY",unique = true)
 private String productCategory;
public int getProductId() {
	return productId;
}
public void setProductId(int productId) {
	this.productId = productId;
}
public String getProductName() {
	return productName;
}
public void setProductName(String productName) {
	this.productName = productName;
}
public double getProductPrice() {
	return productPrice;
}
public void setProductPrice(double productPrice) {
	this.productPrice = productPrice;
}
public String getProductModel() {
	return productModel;
}
public void setProductModel(String productModel) {
	this.productModel = productModel;
}
public String getProductCategory() {
	return productCategory;
}
public void setProductCategory(String productCategory) {
	this.productCategory = productCategory;
}
public Product(int productId, String productName, double productPrice, String productModel, String productCategory) {
	super();
	this.productId = productId;
	this.productName = productName;
	this.productPrice = productPrice;
	this.productModel = productModel;
	this.productCategory = productCategory;
}
public Product() {
	super();
}
@Override
public String toString() {
	return "Product [productId=" + productId + ", productName=" + productName + ", productPrice=" + productPrice
			+ ", productModel=" + productModel + ", productCategory=" + productCategory + "]";
}


}
