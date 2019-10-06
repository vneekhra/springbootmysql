package com.tech.resource;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tech.model.Users;
import com.tech.repository.UsersRepository;

@RestController
@RequestMapping(value = "/rest/users")
public class UsersResource {
	
	@Autowired
	UsersRepository userRepository;
	
	// get all users from Users table
	@GetMapping(value="/")
	public List<Users> getAll() {
		System.out.println("##### Inside getAll");
		return userRepository.findAll();
	}
	
	// create one user
	@PostMapping(value="/create")
	public List<Users> persist(@RequestBody final Users users){
		userRepository.save(users);
		return userRepository.findAll();
	}
	
	// find one user by id
	@GetMapping(value="/user/{id}")
	public ResponseEntity<Optional<Users>> getUserById(@PathVariable(value="id") Integer userId) {
		
		Optional<Users> user = userRepository.findById(userId);
		
		if (user == null)
			return ResponseEntity.notFound().build();
		
		return ResponseEntity.ok().body(user);
	}
	
	// update user by id
	@PutMapping(value="/user/{id}")
	public ResponseEntity<Users> updateUserById(@PathVariable(value="id") Integer userId, @Valid @RequestBody Users userDetails) {
		
		Optional<Users> user = userRepository.findById(userId);
		
		if (!user.isPresent())
			return ResponseEntity.notFound().build();
		
		final Users updatedUser = userRepository.save(userDetails);
		
		return ResponseEntity.ok(updatedUser);
	}
	
	// delete a user
	@DeleteMapping("/user/{id}")
	public void deleteUser(@PathVariable Integer id) {
		userRepository.deleteById(id);
	}

}
