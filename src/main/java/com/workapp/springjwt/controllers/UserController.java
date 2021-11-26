package com.workapp.springjwt.controllers;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import com.workapp.springjwt.security.services.UserDetailsImpl;
import com.workapp.springjwt.security.services.UserDetailsServiceImpl;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	UserRepository userRepository;
	
	private UserDetailsImpl userDetails;
    
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

	
	
	/*@PutMapping("/update/{id}")
	public ResponseEntity<Object> updateUser( @PathVariable( name = "id" ) long id ,
			@RequestBody User  user)
	 {		
	
			Optional<User> userOptional =userRepository.findById(id);
			if (!userOptional.isPresent())
				return ResponseEntity
						.badRequest()
						.body(new MessageResponse("Error: User is not found!"));
			
			user.setFirstName(userDetails.getFirstName());
        	return ResponseEntity.ok().body(userOptional);	
		
}
	*/
	/*@PutMapping("/update/{id}")
	public ResponseEntity<Object> updateUser(@PathVariable long id,
	        @RequestBody User user) {
        Optional<User> userOptional = userRepository.findById(id);
        if (!userOptional.isPresent()) {
          	return ResponseEntity
					.badRequest()
			.body(new MessageResponse("Error: User is not found!"));

        } else {

	    	UserDetailsServiceImpl.updateAddress(id, user);
        	//userRepository
        	ResponseEntity.ok().body(new MessageResponse("User Updated!"));
        	return ResponseEntity.ok().body(userOptional);	
        	        }

	    
	}*/

	
	/*@PutMapping("/update/{id}")	
    public ResponseEntity<Object> updateUser( @PathVariable( name = "id" ) long id ,User user,
			@RequestBody User UserDetailsServiceImpl ) {
        Optional<User> userOptional = userRepository.findById(id);
        if (!userOptional.isPresent()) {
          	return ResponseEntity
					.badRequest()
			.body(new MessageResponse("Error: User is not found!"));

        } 
        else {
        	user.setEmail(UserDetailsServiceImpl.getEmail());
        	user.setPassword(UserDetailsServiceImpl.getPassword());
        	user.setUsername(UserDetailsServiceImpl.getUsername());
        	
			user.setFirstName(UserDetailsServiceImpl.getFirstName());
        return	ResponseEntity.ok().body(new MessageResponse(" User Updated!"));
        	//return ResponseEntity.ok().body(userOptional);	
        	        }
    
}*/
	 @PutMapping("/changeuserdetails/{id}")
	  public ResponseEntity<Object> updateTutorial(@PathVariable("id") long id, @RequestBody User user) {
	    Optional<User> userData = userRepository.findById(id);
	    if (!userData.isPresent()) {
          	return ResponseEntity
					.badRequest()
			.body(new MessageResponse("Error: User is not found!"));

	    }
	    else {
	      User _user = userData.get();
	      _user.setFirstName(user.getFirstName());
	      _user.setLastName(user.getLastName());
	      _user.setPhone(user.getPhone());
	      _user.setGenre(user.getGenre());
	      _user.setHightDegres(user.getHightDegres());  
	      _user.setIssuedBy(user.getIssuedBy());
	      _user.setYearOfPassing(user.getYearOfPassing());  
		  _user.setSkill(user.getSkill());
		  _user.setJobType(user.getJobType());
		  _user.setJobApplyFor(user.getJobApplyFor());
		  _user.setWorkExperience(user.getWorkExperience());
		  _user.setExpectedSalary(user.getExpectedSalary());	 
			 
	      
	      
	      return new ResponseEntity<>(userRepository.save(_user), HttpStatus.OK);
	    }
	  }

}