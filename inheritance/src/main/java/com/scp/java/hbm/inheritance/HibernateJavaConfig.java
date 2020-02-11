package com.scp.java.hbm.inheritance;
import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.scp.java.hbm.inheritance.AppUtil.SUPPORTED_DATABASES;

public class HibernateJavaConfig {
	private static SessionFactory mysqlSfactory  = null;
	public static SessionFactory hsqlSfactory  = null;
	private HibernateJavaConfig() {
	}
	public static SessionFactory getSessionFactoryInstance(SUPPORTED_DATABASES whichDb) {
		Configuration configure = null;
		ServiceRegistry registry =  null;
		configure = new Configuration();//.configure();
		configure.addAnnotatedClass(Product.class).addAnnotatedClass(Mobile.class).addAnnotatedClass(Laptop.class);
		
		if (SUPPORTED_DATABASES.MYSQL.equals(whichDb)){
			if(mysqlSfactory==null) {
					configure.setProperties(AppUtil.getMySqlDBProperties());
					registry = new StandardServiceRegistryBuilder().
							applySettings(configure.getProperties()).build();
					mysqlSfactory = configure.buildSessionFactory(registry);
					System.out.println("Creating sessionfactoryMYSQL -- java config -- from scratch");
			}
			return mysqlSfactory;
		}else if(SUPPORTED_DATABASES.HSQL.equals(whichDb)) {
			if(hsqlSfactory==null) {
				configure.setProperties(AppUtil.getHSQLDBProperties());
				registry=new StandardServiceRegistryBuilder().
						applySettings(configure.getProperties()).build();
				hsqlSfactory = configure.buildSessionFactory(registry);
				System.out.println("Creating sessionfactoryHSQL -- java config -- from scratch");
			}
			return hsqlSfactory;

		}
		System.out.println("Only supported database till date is Mysql and HSQL");
		return null;
	}

}
