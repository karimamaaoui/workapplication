package com.workapp.springjwt.controllers;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.workapp.springjwt.models.Offre;
import com.workapp.springjwt.models.User;
import com.workapp.springjwt.payload.response.MessageResponse;
import com.workapp.springjwt.repository.OffreRepository;

import springfox.documentation.swagger2.annotations.EnableSwagger2;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/offre")
public class OffreController {
	
	  @Autowired
	    private OffreRepository offreRepository;

		@GetMapping("/offres")
		public List<Offre> list(){
				System.out.println("get list user from controller");
				return this.offreRepository.findAll(Sort.by("published").descending());
			}
					
		@GetMapping("/offre/{id}")
		public ResponseEntity<Object> getOffreById(@PathVariable("id") Long id) {
			Optional<Offre> offreData = offreRepository.findById(id);

			if (offreData.isPresent()) {
				return new ResponseEntity<>(offreData.get(), HttpStatus.OK);
			} else {
		      	return ResponseEntity
						.badRequest()
				.body(new MessageResponse("Error: Offre is not found!"));
			}
		}
		
		@PreAuthorize("hasRole('ADMIN')")		
		@PostMapping("/add")
		public ResponseEntity<Offre> createTutorial(@RequestBody Offre offre) {
			try {
				Offre _offre = offreRepository.save(
						new Offre(
						offre.getPosteNumber(), 
						offre.getJobRequirements(),offre.getEmail(),
						offre.getCountry(),offre.getTitle(),
						offre.getPublished(),offre.getDescription()));
				return new ResponseEntity<>(offre, HttpStatus.CREATED);
			} catch (Exception e) {
				return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
			}
		}
		
		@PutMapping("/offre/{id}")
		@PreAuthorize("hasRole('ADMIN')")		
		public ResponseEntity<Object> updateTutorial(@PathVariable("id") long id, @RequestBody Offre offre) {
		    Optional<Offre> offreData = offreRepository.findById(id);

		    if (offreData.isPresent()) {
		    	Offre _offre = offreData.get();
		    	_offre.setTitle(offre.getTitle());
		    	_offre.setCountry(offre.getCountry());
		    	_offre.setPublished(offre.getPublished());
		    	_offre.setEmail(offre.getEmail());
		    	_offre.setJobRequirements(offre.getJobRequirements());
		    	_offre.setPosteNumber(offre.getPosteNumber());
		    	_offre.setDescription(offre.getDescription());
		      return new ResponseEntity<>(offreRepository.save(_offre), HttpStatus.OK);
		    } else {
		      	return ResponseEntity
						.badRequest()
				.body(new MessageResponse("Error: Offre is not found!"));
			  }
		  }
		
		@DeleteMapping("/offre/{id}")
		@PreAuthorize("hasRole('ADMIN')")		
		public ResponseEntity<Object> deleteTutorial(@PathVariable("id") long id) {
			Optional<Offre> offreOptional = offreRepository.findById(id);
	        if (!offreOptional.isPresent()) {
	        	return ResponseEntity
						.badRequest()
				.body(new MessageResponse("Error: Offre is not found!"));

	        } 
	        offreRepository.deleteById(id);
				return ResponseEntity.ok().body(new MessageResponse("Offre Deleted!"));	

}
		

}



