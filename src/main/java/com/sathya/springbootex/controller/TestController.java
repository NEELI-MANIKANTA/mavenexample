package com.sathya.springbootex.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sathya.springbootex.entity.Hospital;
import com.sathya.springbootex.model.HospitalDetails;
import com.sathya.springbootex.service.HospitalService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/sathya")
public class TestController {

	@Autowired
	HospitalService hospitalService;

	@PostMapping("/save")
	public Hospital createHospital(@Valid @RequestBody HospitalDetails hospitalDetails) 
	{
		return hospitalService.createHospital(hospitalDetails);
	}

	@PostMapping("/saveAll")
	public List<Hospital> saveAllHospitalDetails(@RequestBody List<HospitalDetails> hospitalDetails) {
		return hospitalService.saveAllHospitalDetails(hospitalDetails);

	}

	@PutMapping("/update/{id}")
	public Hospital putHospital(@PathVariable Long id, @RequestBody HospitalDetails hospitalUpdates) {

		Hospital hospital = hospitalService.updateHospital(hospitalUpdates, id);

		return hospital;
	}

	@PatchMapping("/patchupdate/{id}")
	public Hospital patchHospital(@PathVariable Long id, @RequestBody HospitalDetails hospitalUpdates) {

		return hospitalService.patchHospital(id, hospitalUpdates);
	}
	
	@GetMapping("/gethospital/{name}")
	public Hospital getHospitalByName(@PathVariable String name)
	{
		return hospitalService.getHospitalByName(name);
	}
	
	@GetMapping("/getallhospitals")
	public List<Hospital> findByNames(@RequestBody List<String> hospitalNames) {
	        // Use the hospital repository to find hospitals by their names
		return hospitalService.findByNames(hospitalNames);
	}   
	
	@GetMapping("/getallsortedhospitals")
	public List<Hospital> getAllHospitalsSorted()
	{
		return hospitalService.getAllHospitalsSorted();
	}
}
