/**
 * 
 */
package com.eshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.eshop.model.Wear;
import com.eshop.repository.EshopRepo;

/**
 * 
 */
@RestController
public class EshopController {

	@Autowired
	EshopRepo eshopRepo;
	
	@PostMapping("/saveData")
	public String saveDetails(@RequestBody Wear wr) {
		eshopRepo.save(wr);
		return "Saved..";
	}
}
