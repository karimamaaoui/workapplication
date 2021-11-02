package com.workapp.springjwt.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.workapp.springjwt.models.Offre;


@Repository
public interface OffreRepository extends JpaRepository <Offre, Integer> {
	
}
