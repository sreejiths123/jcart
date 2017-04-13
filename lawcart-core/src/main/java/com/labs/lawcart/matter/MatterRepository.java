package com.labs.lawcart.matter;

import org.springframework.data.jpa.repository.JpaRepository;

import com.labs.lawcart.entities.Matter;

public interface MatterRepository extends JpaRepository<Matter, Integer> {

	
	
}
