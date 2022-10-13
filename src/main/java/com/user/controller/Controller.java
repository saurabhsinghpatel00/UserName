package com.user.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.user.entity.UserDetails;
import com.user.service.UserService;

@RestController
public class Controller {
	
	@Autowired
	UserService studentService;
	
	

	@GetMapping("")
	public List<UserDetails> list()
	{
		return studentService.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UserDetails> get(@PathVariable Integer id) {
        try {
        	UserDetails user = studentService.findById(id);
            return new ResponseEntity<UserDetails>(user, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<UserDetails>(HttpStatus.NOT_FOUND);
        }
    }
	
	
	@PostMapping("/add")
	public void add(@RequestBody UserDetails user) {
		studentService.save(user);
    }
	
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody UserDetails user, @PathVariable Integer id) {
        try {
        	UserDetails existUser = studentService.findById(id);
            user.setId(id);            
            studentService.save(user);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
	
	
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {

		studentService.deleteUser(id);
    }
	
}
