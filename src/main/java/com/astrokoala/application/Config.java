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
	
	private static final String USERNAME = "root";
	private static final String PASSWORD = "";
	private static final String TIMEZONE = "?serverTimezone=UTC";
	private static final String URL = "jdbc:mysql://localhost:3333/Playbooks" + TIMEZONE;
	public static DSLContext database;
	
	public static int connectToDatabase() {
	  try {
	  	Class.forName("com.mysql.cj.jdbc.Driver");
	  	Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
	  	database = DSL.using(conn);
	  	return 0;
	  } 
	  catch (Exception e) {
	      e.printStackTrace();
	      return 1;
	  }
	}
	
}

