/**
 * 
 */
package com.banking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.banking.model.Account;

/**
 * Repository interface for managing {@link Account} entities.
 * 
 * <p>This interface extends {@link JpaRepository} to provide CRUD operations 
 * and database interaction methods for the Account table.</p>
 * 
 * <p>Spring Data JPA automatically implements the basic data access logic 
 * (like save, findById, findAll, delete, etc.) based on this interface.</p>
 * 
 * <p>Custom query methods (e.g., findByCustomerId, findByStatus) can be added here 
 * if specific database queries are required in the future.</p>
 * 
 * @author Madhusudan Dande
 */
public interface AccountRepo extends JpaRepository<Account, Long> {
    // You can define custom finder methods here, for example:
    // Optional<Account> findByCustomerId(Long customerId);
}
