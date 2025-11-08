/**
 * 
 */
package com.banking.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banking.model.Account;
import com.banking.service.AccountService;

/**
 * REST controller that exposes endpoints for managing bank accounts.
 * 
 * <p>This controller provides APIs to create new accounts, retrieve account details,
 * view all accounts, deposit funds, and update customer IDs.</p>
 * 
 * <p>It delegates business logic to the {@link AccountService}, 
 * keeping controller methods focused on handling HTTP requests and responses.</p>
 * 
 * <p>All endpoints in this controller are prefixed with <b>"/accounts"</b>.</p>
 * 
 * @author Madhusudan Dande
 */
@RestController
@RequestMapping("/accounts")
public class AccountController {

    /**
     * Service layer dependency that handles business logic related to accounts.
     */
    private final AccountService service;

    /**
     * Constructor-based dependency injection for {@link AccountService}.
     * 
     * @param service the service layer instance for account operations
     */
    public AccountController(AccountService service) {
        super();
        this.service = service;
    }

    /**
     * Creates a new bank account.
     * 
     * <p>Accepts account details in the request body and stores them in the database
     * with a default status of <b>"ACTIVE"</b>.</p>
     * 
     * <p>Example Request:</p>
     * <pre>
     * POST /accounts/createAccount
     * {
     *   "customerId": 101,
     *   "accountType": "SAVINGS",
     *   "balance": 5000.00
     * }
     * </pre>
     * 
     * @param account the {@link Account} object to be created
     * @return the created {@link Account} entity with generated account ID
     */
    @PostMapping("/createAccount")
    public Account create(@RequestBody Account account) {
        return service.createAccount(account);
    }

    /**
     * Retrieves account details by account ID.
     * 
     * <p>Example Request:</p>
     * <pre>
     * GET /accounts/getAccount/1
     * </pre>
     * 
     * @param id the unique ID of the account
     * @return the corresponding {@link Account} object if found, otherwise {@code null}
     */
    @GetMapping("/getAccount/{Id}")
    public Account getAccount(@PathVariable("Id") Long id) {
        return service.getAccount(id);
    }

    /**
     * Retrieves all existing bank accounts.
     * 
     * <p>Example Request:</p>
     * <pre>
     * GET /accounts/getAllAccounts
     * </pre>
     * 
     * @return a list of all {@link Account} objects stored in the database
     */
    @GetMapping("/getAllAccounts")
    public List<Account> getAll() {
        return service.getAllAccount();
    }

    /**
     * Deposits a specified amount into an existing account.
     * 
     * <p>This endpoint updates the balance by adding the given amount.
     * To perform a withdrawal, a negative amount can be passed.</p>
     * 
     * <p>Example Request:</p>
     * <pre>
     * PUT /accounts/1/deposit/1000
     * </pre>
     * 
     * @param id the account ID where funds will be deposited
     * @param amount the amount to deposit (positive value)
     * @return the updated {@link Account} entity after the balance change
     */
    @PutMapping("/{Id}/deposit/{amount}")
    public Account deposit(@PathVariable("Id") Long id, @PathVariable("amount") double amount) {
        return service.updateBalance(id, amount);
    }

    /**
     * Updates the customer ID linked to a specific account.
     * 
     * <p>This is useful when associating an account with a different or new customer record.</p>
     * 
     * <p>Example Request:</p>
     * <pre>
     * PUT /accounts/1/updateCustId/2001
     * </pre>
     * 
     * @param id the account ID whose customer ID needs to be updated
     * @param custId the new customer ID to link
     * @return the updated {@link Account} entity after the change
     */
    @PutMapping("/{id}/updateCustId/{custId}")
    public Account updateCustId(@PathVariable("id") Long id, @PathVariable("custId") Long custId) {
        return service.updateCustomerId(id, custId);
    }
}
