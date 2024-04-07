package com.sathya.springbootex.repository;


import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sathya.springbootex.entity.Hospital;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital, Long>{
	
	public Hospital findByName(String name);
	
	List<Hospital> findByNameIn(List<String> hospitalNames);
}
