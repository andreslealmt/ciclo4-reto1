package com.restfull.app.service;


import java.util.Optional;
import com.restfull.app.entity.User;


public interface UserService {
	
	public Iterable<User> findAll();
	
	public Optional<User> findById(int id);
	
	public User save(User user);
	
	public void deleteById(int id);	
	
	public Optional<User> findByEmail(String email);
	

}
