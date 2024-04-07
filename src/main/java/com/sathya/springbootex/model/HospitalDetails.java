package com.sathya.springbootex.model;

import java.sql.Blob;

import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HospitalDetails {
	
	@NotBlank(message="Hospital name is required")
	private String name;
	
	private double rating;
	
	
	@NotBlank(message="location is required")
	private String location;
	
	@Email(message="Invalid Email Address")
	private String email;
	
	@Pattern(regexp = "[0-9]{10}", message = "Invalid mobile number")
	@NotBlank(message="mobile is required")
	private String mobile;
	
	
	private String image;
	
}
