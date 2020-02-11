package com.scp.java.hbm.inheritance;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



public class OneToMany {
	
	public static void main(String[] args) {
		
		Address ad1 = new Address(101, "Pune",null);
		Address ad2 = new Address(102, "Mumbai",null);
		Address ad3 = new Address(103, "Chennai",null);
		
		Student st1= new Student(101,"AAAAA",new ArrayList<Address>());
		st1.getAddresses().add(ad1);
		st1.getAddresses().add(ad2);
		st1.getAddresses().add(ad3);
		
		ad1.setSt(st1);
		ad2.setSt(st1);
		ad3.setSt(st1);
		
		Configuration conf = new Configuration().addAnnotatedClass(Address.class).addAnnotatedClass(Student.class);
		SessionFactory sfactory = conf.configure().buildSessionFactory();
		Session session = sfactory.openSession();
		Transaction tr  = session.beginTransaction();
		session.save(st1);
		session.flush();
		tr.commit();

		
		
	}

}

@Entity
@Table(name = "student_details")
class Student{
	@Id
	private int studId;

	private String studName;
	
	@javax.persistence.OneToMany(cascade = CascadeType.ALL,mappedBy = "st")
	private List<Address> addresses;
	
	public Student(int studId, String studName, List<Address> addresses) {
		super();
		this.studId = studId;
		this.studName = studName;
		this.addresses = addresses;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Student [studId=" + studId + ", studName=" + studName + ", addresses=" + addresses + "]";
	}
	public int getStudId() {
		return studId;
	}
	public void setStudId(int studId) {
		this.studId = studId;
	}
	public String getStudName() {
		return studName;
	}
	public void setStudName(String studName) {
		this.studName = studName;
	}
	public List<Address> getAddresses() {
		return addresses;
	}
	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}
	
	
}

@Entity
@Table(name = "address_details")
class Address{
	@Id
	private int aid;
	private String city;
	
	@ManyToOne
	private Student st;
	
	
	
	public Student getSt() {
		return st;
	}
	public void setSt(Student st) {
		this.st = st;
	}
	public Address(int aid, String city,Student st) {
		super();
		this.aid = aid;
		this.city = city;
		this.st=st;
	}
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Address [aid=" + aid + ", city=" + city + "]";
	}
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	
	
	
}