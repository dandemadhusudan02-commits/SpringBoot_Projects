/**
 * 
 */
package com.banking.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.banking.model.Account;
import com.banking.repository.AccountRepo;

/**
 * Service class that provides business logic for managing {@link Account} entities.
 * 
 * <p>This service interacts with the {@link AccountRepo} repository to handle all
 * account-related operations such as account creation, balance updates,
 * and retrieving account information.</p>
 * 
 * <p>The service layer acts as an intermediary between the controller layer
 * (which handles HTTP requests) and the repository layer (which interacts with the database).</p>
 * 
 * <p>It ensures that all account-related logic is centralized and reusable
 * across multiple controllers if needed.</p>
 * 
 * @author Madhusudan Dande
 */
@Service
public class AccountService {

    /**
     * Repository used for performing CRUD operations on account data.
     */
    private final AccountRepo repo;

    /**
     * Constructor-based dependency injection for {@link AccountRepo}.
     * 
     * @param repo the repository instance used for database operations
     */
    public AccountService(AccountRepo repo) {
        super();
        this.repo = repo;
    }
    
    /**
     * Creates a new bank account and saves it to the database.
     * 
     * <p>When an account is created, its default status is set to <b>"ACTIVE"</b>.</p>
     * 
     * @param account the {@link Account} object containing account details
     * @return the saved {@link Account} entity with generated account ID
     */
    public Account createAccount(Account account) {
        account.setStatus("ACTIVE");
        return repo.save(account);
    }
    
    /**
     * Retrieves an account by its unique account ID.
     * 
     * @param id the unique account ID
     * @return the corresponding {@link Account} object if found, otherwise {@code null}
     */
    public Account getAccount(Long id) {
        return repo.findById(id).orElse(null);
    }
    
    /**
     * Retrieves all accounts stored in the database.
     * 
     * @return a list of all {@link Account} entities
     */
    public List<Account> getAllAccount() {
        return repo.findAll();
    }
    
    /**
     * Updates the balance of an existing account.
     * 
     * <p>This method adds the specified amount to the current balance.
     * It can be used for deposit or withdrawal operations (negative values
     * can be passed to reduce the balance).</p>
     * 
     * @param id the account ID whose balance will be updated
     * @param amount the amount to adjust the balance by (can be positive or negative)
     * @return the updated {@link Account} entity if found, otherwise {@code null}
     */
    public Account updateBalance(Long id, double amount) {
        Account account = getAccount(id);
        if (account != null) {
            account.setBalance(account.getBalance() + amount);
            return repo.save(account);
        }
        return null;
    }
    
    /**
     * Updates the customer ID associated with a specific account.
     * 
     * <p>This method can be used when linking an account to a customer profile
     * or updating customer information.</p>
     * 
     * @param id the account ID whose customer ID will be updated
     * @param custId the new customer ID to be linked
     * @return the updated {@link Account} entity if found, otherwise {@code null}
     */
    public Account updateCustomerId(Long id, Long custId) {
        Account account = getAccount(id);
        if (account != null) {
            account.setCustomerId(custId);
            return repo.save(account);
        }
        return null;
    }
}
