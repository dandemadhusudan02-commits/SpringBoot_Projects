/**
 * 
 */
package com.banking.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.banking.model.Transaction;

/**
 * Repository interface for managing {@link Transaction} entities.
 * 
 * <p>This interface extends {@link JpaRepository} to provide CRUD operations 
 * and query methods for transaction data.</p>
 * 
 * <p>It allows the application to perform operations like saving new transactions, 
 * retrieving transaction history, and filtering transactions based on account IDs 
 * and date ranges.</p>
 * 
 * <p>Spring Data JPA automatically generates the required SQL queries 
 * from method names based on naming conventions.</p>
 * 
 * <p>Use this repository in the service layer to interact with the database 
 * without writing explicit SQL or JPQL queries.</p>
 * 
 * @author Madhusudan Dande
 */
public interface TransactionRepo extends JpaRepository<Transaction, Long> {

    /**
     * Retrieves a list of all transactions where the given account ID 
     * was either the sender or the receiver.
     * 
     * <p>This method is useful for fetching complete transaction history 
     * for a particular account, regardless of whether it was a debit or credit transaction.</p>
     * 
     * @param fromAccountId the account ID from which money was sent
     * @param toAccountId the account ID to which money was received
     * @return a list of {@link Transaction} objects related to the provided account IDs
     */
    public List<Transaction> findByFromAccountIdOrToAccountId(Long fromAccountId, Long toAccountId);
    
    /**
     * Retrieves all transactions for the given account IDs within a specified date range.
     * 
     * <p>This method is typically used to generate filtered transaction statements 
     * or reports for a customer between two timestamps.</p>
     * 
     * @param fromAccountId the account ID from which money was sent
     * @param toAccountId the account ID to which money was received
     * @param startDate the start date and time of the filter range
     * @param endDate the end date and time of the filter range
     * @return a list of {@link Transaction} objects within the specified date range
     */
    public List<Transaction> findByFromAccountIdOrToAccountIdAndTimestampBetween(
            Long fromAccountId,
            Long toAccountId,
            LocalDateTime startDate,
            LocalDateTime endDate);
}
