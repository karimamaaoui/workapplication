package com.workapp.springjwt.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.workapp.springjwt.models.Offre;


@Repository
public interface OffreRepository extends JpaRepository <Offre, Long> {
	List<Offre> findByPublished(boolean published);
	  List<Offre> findByTitleContaining(String title);

	
}
