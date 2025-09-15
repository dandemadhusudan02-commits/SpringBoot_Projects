/**
 * 
 */
package com.hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.model.Novotel;
import com.hotel.repo.HotelRepo;

/**
 * 
 */
@RestController
public class HotelController {

	@Autowired
	HotelRepo repo;
	
	@PostMapping("/saveHotel")
	public String saveHotel(@RequestBody Novotel n) {
		repo.save(n);
		return "Data Saved Successfully......!!!!";
	}
	
	@PostMapping("/saveMultipleHotel")
	public String saveMultipleHotels(@RequestBody List<Novotel> s) {
		repo.saveAll(s);
		return "All Hotels Data Saved Successfully";
	}
	@GetMapping("/getAllHotels")
	public List<Novotel> getAllHotel(){
		return (List<Novotel>) repo.findAll();
	}
}
