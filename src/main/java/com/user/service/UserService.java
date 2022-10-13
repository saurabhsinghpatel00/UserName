package com.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.entity.UserDetails;
import com.user.repo.UserRepo;

@Service
public class UserService {

	@Autowired
	UserRepo repo;

	public List<UserDetails> findAll() {
		// TODO Auto-generated method stub
		
		return repo.findAll();
	}

	public UserDetails findById(Integer id) {
		// TODO Auto-generated method stub
		return repo.findById(id).get();
	}

	public void save(UserDetails user) {
		// TODO Auto-generated method stub
		repo.save(user);
		
	}

	public void deleteUser(Integer id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
		
	}
	
}
