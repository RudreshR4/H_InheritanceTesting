package com.scp.java.hbm.inheritance;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.scp.java.hbm.inheritance.AppUtil.SUPPORTED_DATABASES;
import com.scp.java.hbm.inheritance.HibernateJavaConfig;


public class StartMain {

	public static void main(String[] args) {
		Product product = new Product(101,"Product",13943.23,"T450","E");
		Mobile mobile = new Mobile(1111,"Mobile",2233.3, "ABCD","A","Var1","Var2");
		Laptop lappy =new Laptop(123,"Laptop", 23323.44,"PQRS", "C","Var3","Var4");
     
		//SessionFactory getSessionFactoryInstance(SUPPORTED_DATABASES whichDb)
		SessionFactory sfactory = HibernateJavaConfig.getSessionFactoryInstance
				(SUPPORTED_DATABASES.MYSQL);
		Session session = sfactory.openSession();
		Transaction tr  = session.beginTransaction();
		session.save(product);
		session.save(mobile);
		session.save(lappy);
		session.flush();
		tr.commit();

	}

}
