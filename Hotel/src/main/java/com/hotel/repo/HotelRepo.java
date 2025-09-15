/**
 * 
 */
package com.hotel.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.model.Novotel;

/**
 * 
 */
public interface HotelRepo extends JpaRepository<Novotel, Long> {

}
