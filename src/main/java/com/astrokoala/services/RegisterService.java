package com.astrokoala.services;

import java.util.LinkedHashMap;

import org.jooq.Configuration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.astrokoala.application.Config;
import com.astrokoala.database.Routines;

@RestController
@ComponentScan
public class RegisterService {
	
	private Configuration conf = Config.database.configuration();

	@GetMapping(path = "/register")
  @ResponseBody
  public ResponseEntity<?> register( @RequestParam(value="email", defaultValue="") String email, @RequestParam(value="pass", defaultValue="") String pass, @RequestParam(value="username", defaultValue="") String username) {
  	LinkedHashMap<String, Object> map = new LinkedHashMap<>();
  	try {
  		Routines.createNewUser(conf, email, PasswordService.getSaltedHash(pass), username);
  	} catch (Exception e) {
  		map.put("success", false);
  		if (e.getMessage().contains("Duplicate entry")) {
  			if (e.getMessage().contains("email_UNIQUE")) {
  				map.put("error", "An account is already associated with that email.");
    			return new ResponseEntity<>(map, HttpStatus.CONFLICT);	
  			}
  		}
  		else {
  			map.put("error", e.getCause().toString());
  			return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
  		}
  	}
  	map.put("success", true);
		return new ResponseEntity<>(map, HttpStatus.OK);
  }
	
}
