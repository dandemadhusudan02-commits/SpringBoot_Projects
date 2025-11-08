/**
 * TransactionController.java
 * 
 * This controller handles all REST API endpoints related to banking transactions.
 * It includes endpoints for transferring money between accounts, 
 * viewing transaction history, and filtering transactions by date range.
 */

package com.banking.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.banking.model.Transaction;
import com.banking.model.TransferRequest;
import com.banking.service.TransactionService;

/**
 * REST Controller for managing transactions between accounts.
 * 
 * Base URL: /transactions
 * 
 * Provides the following APIs:
 *  - POST /transfer → transfer money between accounts
 *  - GET /byTransactionId/{tid} → get details of a transaction by ID
 *  - GET /history/{accountId} → get all transactions related to an account
 *  - GET /history/{accountId}/daterange → get transactions within a specific date range
 */
@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    private TransactionService service;

    /**
     * Transfers an amount from one account to another.
     * 
     * @param request TransferRequest object containing sender account ID, 
     *                receiver account ID, and transfer amount.
     * @return Transaction object with transfer details and status (SUCCESS or FAILED).
     * 
     * Example JSON Body:
     * {
     *   "fromAccountId": 1,
     *   "toAccountId": 2,
     *   "amount": 5000
     * }
     */
    @PostMapping("/transfer")
    public Transaction transfer(@RequestBody TransferRequest request) {
        return service.transfer(request);
    }

    /**
     * Retrieves details of a specific transaction using its ID.
     * 
     * @param transactionId Unique ID of the transaction.
     * @return Transaction object if found, otherwise null.
     */
    @GetMapping("/byTransactionId/{tid}")
    public Transaction getTransaction(@PathVariable("tid") Long transactionId) {
        return service.getTransationById(transactionId);
    }

    /**
     * Retrieves all transactions (both sent and received) for a given account.
     * 
     * @param accountId ID of the account.
     * @return List of Transaction objects related to the given account.
     */
    @GetMapping("/history/{accountId}")
    public List<Transaction> getHistory(@PathVariable("accountId") Long accountId) {
        return service.getTransactionByAccount(accountId);
    }

    /**
     * Retrieves transactions for a given account that occurred within a specified date range.
     * 
     * @param accountId ID of the account.
     * @param startDate Start date in ISO format (e.g. "2025-11-01T00:00:00").
     * @param endDate   End date in ISO format (e.g. "2025-11-08T23:59:59").
     * @return List of transactions that fall within the given date range.
     * 
     * Example API Call:
     * GET /transactions/history/1/daterange?startDate=2025-11-01T00:00:00&endDate=2025-11-08T23:59:59
     */
    @GetMapping("/history/{accountId}/daterange")
    public List<Transaction> getHistoryByDateRange(
            @PathVariable("accountId") Long accountId,
            @RequestParam String startDate,
            @RequestParam String endDate) {

        // Convert string parameters to LocalDateTime
        LocalDateTime start = LocalDateTime.parse(startDate);
        LocalDateTime end = LocalDateTime.parse(endDate);

        // Fetch transactions for the given account and date range
        return service.getTransactionByACcountAndDateRange(accountId, start, end);
    }
}
