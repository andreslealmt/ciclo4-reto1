package com.restfull.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.restfull.app.entity.User;
import com.restfull.app.pojos.UserPojo;
import com.restfull.app.service.UserServiceIml;


@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class UserController {
	
	@Autowired private UserServiceIml userServiceIml;
	
	@GetMapping("/all")
	public List<User> getAll(){
		return (List<User>) userServiceIml.findAll();
	}	
	
	@PostMapping("/new")
	@ResponseStatus(HttpStatus.CREATED)
	public User save(@RequestBody User user) {
		return userServiceIml.save(user);
	}
	
	@GetMapping("/{email}")
	public boolean emailVerify(@PathVariable(value = "email") String email ) {
		Optional<User> oUser = userServiceIml.findByEmail(email);
		if(oUser.isPresent()) {
			return true;
		}
		return false;
	}
	
	@GetMapping("/{email}/{password}")
	public Object autenticar(@PathVariable String email, @PathVariable String password) {
		Optional<User> oUser = userServiceIml.findByEmail(email);
		
		if(oUser.isPresent()) {
			if(oUser.get().getEmail().equals(email) && oUser.get().getPassword().equals(password)) {
				return oUser.get();
			}			
		}
		
		UserPojo user = new UserPojo();		
		user.setEmail(email);
		user.setPassword(password);		
		return user;
	}
	
	
	

}
