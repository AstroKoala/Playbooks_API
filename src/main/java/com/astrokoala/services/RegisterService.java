package com.astrokoala.services;

import java.util.LinkedHashMap;

import org.jooq.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.astrokoala.application.Config;
import com.astrokoala.database.Routines;

public class RegisterService {
	
	private Configuration conf = Config.database.configuration();

	@RequestMapping("/register")
  @ResponseBody
  public ResponseEntity<?> register( @RequestParam(value="email", defaultValue="") String email,
  																	 @RequestParam(value="pass", defaultValue="") String pass,
  																	 @RequestParam(value="username", defaultValue="") String username
  																  ) {
  	try {
  		//Routines.addNewUser(conf, email, PasswordService.getSaltedHash(pass), username);
  		return new ResponseEntity<>(HttpStatus.OK);
  	} catch (Exception e) {
  		if (e.getMessage().contains("Duplicate entry")) {
  			LinkedHashMap<String, String> map = new LinkedHashMap<>();
  			if (e.getMessage().contains("email_UNIQUE")) {
  				map.put("error_msg", "There's already an account associated with that email.");
  			}
  			if (e.getMessage().contains("user_name_UNIQUE")) {
  				map.put("error_msg", "Sorry, that username is taken.");
  			}
  			return new ResponseEntity<>(map, HttpStatus.OK);
  		}
  		else {
  			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
  		}
  	}
  }
}
