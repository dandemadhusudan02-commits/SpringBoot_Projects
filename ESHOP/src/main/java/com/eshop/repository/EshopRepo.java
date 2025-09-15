/**
 * 
 */
package com.eshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eshop.model.Wear;

/**
 * 
 */

public interface EshopRepo extends JpaRepository<Wear, Integer>{
	

}
