package com.workapp.springjwt.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.workapp.springjwt.models.Offre;
import com.workapp.springjwt.repository.OffreRepository;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/offres")

public class OffreController {
	
		@GetMapping("/all")
		public String allAccess() {
			return "Public Content.";
		}
		
		@GetMapping("/user")
		@PreAuthorize("hasRole('USER')  or hasRole('ADMIN')")
		public String userAccess() {
			return "User Content.";
		}

		@GetMapping("/admin")
		@PreAuthorize("hasRole('ADMIN')")
		public String adminAccess() {
			return "Admin Board.";
		}
		
		@PostMapping("/addoffre")
		public String AddOffre (@RequestBody() Offre offre)
		{
			String name=offre.getName();
			return "offre name"+name;
			
		}
		  @Autowired
		    private OffreRepository offreRep;

		    //Récupérer la liste des produits
		/*    @RequestMapping(value = "/offres", method = RequestMethod.GET)
		    public Iterable<Offre> listeOffres() {
		        Iterable<Offre> offres = offreRep.findAll();

/*		        SimpleBeanPropertyFilter monFiltre = SimpleBeanPropertyFilter.serializeAllExcept("name");

		        FilterProvider listDeNosFiltres = new SimpleFilterProvider().addFilter("monFiltreDynamique", monFiltre);

		        MappingJacksonValue offresFiltres = new MappingJacksonValue(offres);

		        offresFiltres.setFilters(listDeNosFiltres);

		        return offresFiltres;*/
		       // return offres;}
		    

		     
}



