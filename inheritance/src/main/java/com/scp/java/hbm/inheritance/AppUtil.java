package com.scp.java.hbm.inheritance;
import java.util.Properties;
import org.hibernate.cfg.Environment;

public class AppUtil {

	static public enum SUPPORTED_DATABASES {
		MYSQL,
		HSQL
	}
	
	private AppUtil() {
	}

	static public Properties getMySqlDBProperties() {
		Properties props = new Properties();
		props.put(Environment.DIALECT,"org.hibernate.dialect.MySQL55Dialect");
		props.put(Environment.URL,"jdbc:mysql://localhost/jdbc");
		props.put(Environment.DRIVER,"com.mysql.cj.jdbc.Driver");
		props.put(Environment.USER,"root");
		props.put(Environment.PASS,"Mysql");
		props.put(Environment.HBM2DDL_AUTO, "create");
		props.put(Environment.SHOW_SQL, true);
		return props;
	}
	
	static public Properties getHSQLDBProperties() {
		Properties props = new Properties();
		props.put(Environment.SHOW_SQL, true);
		props.put(Environment.HBM2DDL_AUTO, "create");
		props.put(Environment.DRIVER,"org.hsqldb.jdbcDriver");
		props.put(Environment.URL,"jdbc:hsqldb:hsql://localhost/");
		props.put(Environment.DIALECT,"org.hibernate.dialect.HSQLDialect");
		props.put(Environment.USER,"SA");
		props.put(Environment.PASS,"");
		return props;
	}

}
