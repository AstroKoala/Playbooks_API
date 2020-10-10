package com.astrokoala.services;
import org.jooq.Configuration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.astrokoala.application.Config;
import com.astrokoala.database.Routines;
import com.astrokoala.database.routines.GetUserInfoByEmail;
import com.astrokoala.models.User;

@RestController
@ComponentScan
//@RequestMapping("/api/")
public class LoginService {
	
	 	private Configuration conf = Config.database.configuration();
	     
    @RequestMapping("/login")
    @ResponseBody
    public ResponseEntity<?> login( @RequestParam(value ="email") String email, @RequestParam(value ="pass") String passwd) {
    	GetUserInfoByEmail proc = Routines.getUserInfoByEmail(conf, email);
    	// we won't have pass to check against if email isn't valid, so both cases will return false
//    	if (!PasswordService.check(passwd, proc.getPass())) {
    	if (passwd.equals(proc.getPass())) {
    		//return new ResponseEntity<>(new User().toLinkedHashMap(), HttpStatus.OK);
    		User user = new User(
    				proc.getId().intValue(),
    				email,
    				proc.getUsername(),
    				proc.getCreateDate()
    		);
      	return new ResponseEntity<>(user.toLinkedHashMap(), HttpStatus.OK);
    	}
    	return new ResponseEntity<>(new User().toLinkedHashMap(), HttpStatus.UNAUTHORIZED);
    }
    
}
    