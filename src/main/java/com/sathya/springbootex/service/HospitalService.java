package com.sathya.springbootex.service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.annotation.DeterminableImports;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.sathya.springbootex.entity.Hospital;
import com.sathya.springbootex.model.HospitalDetails;
import com.sathya.springbootex.repository.HospitalRepository;

import jakarta.transaction.Transactional;

@Service
public class HospitalService {
	
	@Autowired
	HospitalRepository hospitalRepository;
	
	public Hospital createHospital(HospitalDetails hospitalDetails) {
		// TODO Auto-generated method stub
	
		
		Hospital hospital = new Hospital();
		hospital.setName(hospitalDetails.getName());
		hospital.setLocation(hospitalDetails.getLocation());
		hospital.setRating(hospitalDetails.getRating());
		hospital.setMobile(hospitalDetails.getMobile());
		hospital.setCreateAt(LocalDateTime.now());
		hospital.setCreatedBy(System.getProperty("user.name"));
		
		byte[] imageData = hospitalDetails.getImage().getBytes();
		hospital.setImage(imageData);
		
		Hospital savedHospital = hospitalRepository.save(hospital);
	
		return savedHospital;
	}

	public List<Hospital> saveAllHospitalDetails(List<HospitalDetails> hospitalDetails) {
		
		List<Hospital> hospitals = new ArrayList<>();
		
		for(HospitalDetails details: hospitalDetails)
		{
			Hospital hospital = new Hospital();
			hospital.setName(details.getName());
			hospital.setLocation(details.getLocation());
			hospital.setRating(details.getRating());
			hospital.setCreateAt(LocalDateTime.now());
			hospital.setCreatedBy(System.getProperty("user.name"));
			
			hospitals.add(hospital);
			
		}
		
		List<Hospital> savedHospitals =  hospitalRepository.saveAll(hospitals);
		
		return savedHospitals;
	}

	 public Hospital updateHospital(HospitalDetails hospitalUpdates, Long id) {
	        
		 Hospital hospital = hospitalRepository.findById(id)
	             .orElseThrow(() -> new RuntimeException("Hospital not found with id " + id));
	        
	        hospital.setName(hospitalUpdates.getName());
	        hospital.setRating(hospitalUpdates.getRating());
	        hospital.setLocation(hospitalUpdates.getLocation());
	        hospital.setCreateAt(LocalDateTime.now());
			hospital.setCreatedBy(System.getProperty("user.name"));
	        
	        return hospitalRepository.save(hospital);
	 }

	 public Hospital patchHospital(Long id, HospitalDetails hospitalDetails) {
	     Hospital hospital = hospitalRepository.findById(id)
	             .orElseThrow(() -> new RuntimeException("Hospital not found with id " + id));

	     if (hospitalDetails.getName() != null) {
	         hospital.setName(hospitalDetails.getName());
	     }
	     if (hospitalDetails.getRating() != 0) {
	         hospital.setRating(hospitalDetails.getRating());
	     }
	     if (hospitalDetails.getLocation() != null) {
	         hospital.setLocation(hospitalDetails.getLocation());
	     }
	     hospital.setCreateAt(LocalDateTime.now());
	     hospital.setCreatedBy(System.getProperty("user.name"));
	     

	     return hospitalRepository.save(hospital);
	 }

	public Hospital getHospitalByName(String name) {

		return hospitalRepository.findByName(name);
	}

	public List<Hospital> findByNames(List<String> hospitalNames) {
		// TODO Auto-generated method stub
		return hospitalRepository.findByNameIn(hospitalNames);
	}

	public List<Hospital> getAllHospitalsSorted() {
		
		Sort sort = Sort.by(Direction.ASC,"name");
		return hospitalRepository.findAll(sort);
	}


	
}
