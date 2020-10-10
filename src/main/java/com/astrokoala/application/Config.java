package com.astrokoala.application;

import java.sql.Connection;
import java.sql.DriverManager;

import org.jooq.DSLContext;
import org.jooq.impl.DSL;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.astrokoala")
public class Config {
	
	public static DSLContext database; 
	
	private static final String userName = "root";
	private static final String password = "";
	private static final String timeZone = "?serverTimezone=UTC";
	private static final String url = "jdbc:mysql://localhost:3333/Playbooks" + timeZone;
	
	public static int connectToDatabase() {
	  try {
	  	Class.forName("com.mysql.cj.jdbc.Driver");
	  	Connection conn = DriverManager.getConnection(url, userName, password);
	  	database = DSL.using(conn);
	  	return 0;
	  } 
	  catch (Exception e) {
	      e.printStackTrace();
	      return 1;
	  }
	}
	
}

