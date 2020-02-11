package com.scp.java.hbm.inheritance;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.cfg.Configuration;


public class OneToOne {
	public static void main(String[] args) {
		
		PanCard pan  = new PanCard(111, "Pune", "Person", "APLPC3663N",null);
		Employee e1 = new Employee(1, "AAAA", 2923.3,33, "Pune", pan);
		pan.setEmp(e1);
		
		Configuration conf = new Configuration().addAnnotatedClass(PanCard.class).addAnnotatedClass(Employee.class);
		SessionFactory sfactory = conf.configure().buildSessionFactory();
		Session session = sfactory.openSession();
		Transaction tr  = session.beginTransaction();
		session.save(e1);
		session.flush();
		tr.commit();
		
	}

}

@Entity
@Table(name = "EMP_DETAILS")
class Employee{
	@Id
	private int empId;
	private String empName;
	private double empSalary;
	private int empAge;
	private String empAddress;
	
	@javax.persistence.OneToOne(mappedBy = "emp")
	@Cascade(CascadeType.ALL)
	private PanCard panCard;

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public double getEmpSalary() {
		return empSalary;
	}

	public void setEmpSalary(double empSalary) {
		this.empSalary = empSalary;
	}

	public int getEmpAge() {
		return empAge;
	}

	public void setEmpAge(int empAge) {
		this.empAge = empAge;
	}

	public String getEmpAddress() {
		return empAddress;
	}

	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}

	public PanCard getPanCard() {
		return panCard;
	}

	public void setPanCard(PanCard panCard) {
		this.panCard = panCard;
	}

	public Employee(int empId, String empName, double empSalary, int empAge, String empAddress, PanCard panCard) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empSalary = empSalary;
		this.empAge = empAge;
		this.empAddress = empAddress;
		this.panCard = panCard;
	}

	public Employee() {
		super();
		
	}

	@Override
	public String toString() {
		return "\n [empId=" + empId + ", empName=" + empName + ", empSalary=" + empSalary + ", empAge=" + empAge
				+ ", empAddress=" + empAddress + ", panCard=" + panCard + "]";
	}
	
	
}

@Entity
@Table(name = "EMP_PAN_DETAILS")
class PanCard{
	@Id
	private int pid;
	private String panCity;
	private String panType;
	private String panNumber;
	
	@javax.persistence.OneToOne(cascade = javax.persistence.CascadeType.ALL)
	private Employee emp;
	
	
	
	
	
	public Employee getEmp() {
		return emp;
	}
	public void setEmp(Employee emp) {
		this.emp = emp;
	}
	@Override
	public String toString() {
		return "PanCard [pid=" + pid + ", panCity=" + panCity + ", panType=" + panType + ", panNumber=" + panNumber
				+ ", emp=" + emp + "]";
	}
	public PanCard(int pid, String panCity, String panType, String panNumber,Employee emp) {
		super();
		this.pid = pid;
		this.panCity = panCity;
		this.panType = panType;
		this.panNumber = panNumber;
		this.emp = emp;
	}
	public PanCard() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPanCity() {
		return panCity;
	}
	public void setPanCity(String panCity) {
		this.panCity = panCity;
	}
	public String getPanType() {
		return panType;
	}
	public void setPanType(String panType) {
		this.panType = panType;
	}
	public String getPanNumber() {
		return panNumber;
	}
	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}
	
	
	
	
}