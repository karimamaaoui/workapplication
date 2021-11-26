package com.workapp.springjwt.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.workapp.springjwt.models.User;
import com.workapp.springjwt.payload.response.MessageResponse;
import com.workapp.springjwt.repository.UserRepository;
import com.workapp.springjwt.security.services.UserDetailsServiceImpl;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	UserRepository userRepository;
    
	@Autowired
	private UserDetailsServiceImpl userService;
	
	@GetMapping("/users")
	public List<User> list(){
		System.out.println("get list user from controller");
		return userService.getAll();
	}
	
	
	
	@GetMapping("/users/{id}")
	public ResponseEntity<Object> getUserById( @PathVariable (value="id") long id )
	{
		Optional<User> userOptional= userRepository.findById(id);

		if (!userOptional.isPresent())
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: User is not found!"));
	//	user.setFirstName("dd");
		
		//userRepository.save(user);
		System.out.println("user by id "+id);
		return ResponseEntity.ok().body(userOptional);	
		
	}
	@DeleteMapping("/delete/{id}")	
	 public ResponseEntity<Object> deleteUser(@PathVariable (value="id") long id) {
		
	        Optional<User> userOptional = userRepository.findById(id);
	        if (!userOptional.isPresent()) {
	        	return ResponseEntity
						.badRequest()
				.body(new MessageResponse("Error: User is not found!"));

	        } 
	        	userRepository.deleteById(id);
				return ResponseEntity.ok().body(new MessageResponse("Error: User Deleted!"));	

	        
	    }

	
	
/*	@PutMapping("/update/{id}")
	public ResponseEntity<MessageResponse> updateUser( @PathVariable( name = "id" ) long id ,
			@RequestBody User  UserDetailsServiceImpl)
	 {		
	
			Optional<User> userOptional =userRepository.findById(id);
			if (!userOptional.isPresent())
				return ResponseEntity
						.badRequest()
						.body(new MessageResponse("Error: User is not found!"));
			
			userOptional.setFirstName(UserDetailsServiceImpl.getFirstName());
		
}*/
	
	@PutMapping("/update/{id}")
    public ResponseEntity<Object> updateUser( @PathVariable( name = "id" ) long id ,User user,
			@RequestBody User UserDetailsServiceImpl ) {
        Optional<User> userOptional = userRepository.findById(id);
        if (!userOptional.isPresent()) {
          	return ResponseEntity
					.badRequest()
			.body(new MessageResponse("Error: User is not found!"));

        } 
        else {
        	userRepository.findById(id);
        	UserDetailsServiceImpl.setEmail(UserDetailsServiceImpl.getEmail());
        	UserDetailsServiceImpl.setPassword(UserDetailsServiceImpl.getPassword());
        	UserDetailsServiceImpl.setUsername(UserDetailsServiceImpl.getUsername());
        	
			UserDetailsServiceImpl.setFirstName(UserDetailsServiceImpl.getFirstName());
        	ResponseEntity.ok().body(new MessageResponse("Error: User Updated!"));
        	return ResponseEntity.ok().body(userOptional);	
        	        }
    
}

}