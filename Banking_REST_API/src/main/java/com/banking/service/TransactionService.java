/**
 * 
 */
package com.banking.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.banking.model.Account;
import com.banking.model.Transaction;
import com.banking.model.TransferRequest;
import com.banking.repository.AccountRepo;
import com.banking.repository.TransactionRepo;

/**
 * Service class that handles all transaction-related business logic 
 * such as fund transfers, transaction retrieval, and transaction history filtering.
 * 
 * <p>This class interacts with both {@link AccountRepo} and {@link TransactionRepo}
 * to ensure that fund transfers between accounts are properly processed, validated,
 * and recorded.</p>
 * 
 * <p>It ensures data consistency between account balances and transaction records,
 * handling failure conditions like insufficient funds or invalid account IDs.</p>
 * 
 * @author Madhusudan Dande
 */
@Service
public class TransactionService {

    /**
     * Repository used for performing CRUD operations on transaction data.
     */
    private final TransactionRepo transactionRepo;

    /**
     * Repository used for managing account data.
     */
    private final AccountRepo accountRepo;

    /**
     * Constructor-based dependency injection for {@link TransactionRepo} and {@link AccountRepo}.
     * 
     * @param transactionRepo repository for transaction records
     * @param accountRepo repository for account data
     */
    public TransactionService(TransactionRepo transactionRepo, AccountRepo accountRepo) {
        super();
        this.transactionRepo = transactionRepo;
        this.accountRepo = accountRepo;
    }

    /**
     * Transfers funds from one account to another.
     * 
     * <p>This method performs the following steps:</p>
     * <ul>
     *   <li>Validates that both sender and receiver accounts exist.</li>
     *   <li>Checks that the sender has sufficient balance.</li>
     *   <li>Debits the sender’s account and credits the receiver’s account.</li>
     *   <li>Creates and stores a {@link Transaction} record for auditing purposes.</li>
     * </ul>
     * 
     * <p>If validation fails (invalid account or insufficient funds), 
     * the transaction is marked as <b>"FAILED"</b>.</p>
     * 
     * @param request the {@link TransferRequest} object containing transfer details
     * @return the persisted {@link Transaction} record (either SUCCESS or FAILED)
     */
    public Transaction transfer(TransferRequest request) {
        Transaction transaction = new Transaction();

        // Set transaction details from request
        transaction.setFromAccountId(request.getFromAccountId());
        transaction.setToAccountId(request.getToAccountId());
        transaction.setAmount(request.getAmount());
        transaction.setTimestamp(LocalDateTime.now());

        // Fetch sender and receiver accounts
        Account fromAccount = accountRepo.findById(request.getFromAccountId()).orElse(null);
        Account toAccount = accountRepo.findById(request.getToAccountId()).orElse(null);

        // Validate both accounts exist
        if (fromAccount == null || toAccount == null) {
            transaction.setStatus("FAILED");
            return transactionRepo.save(transaction);
        }

        // Validate sufficient funds in sender’s account
        if (fromAccount.getBalance() < request.getAmount()) {
            transaction.setStatus("FAILED");
            return transactionRepo.save(transaction);
        }

        // Perform debit and credit operations
        fromAccount.setBalance(fromAccount.getBalance() - request.getAmount());
        accountRepo.save(fromAccount);

        toAccount.setBalance(toAccount.getBalance() + request.getAmount());
        accountRepo.save(toAccount);

        // Mark transaction successful
        transaction.setStatus("SUCCESS");
        return transactionRepo.save(transaction);
    }

    /**
     * Retrieves a transaction record by its unique transaction ID.
     * 
     * @param transactionId the unique ID of the transaction
     * @return the corresponding {@link Transaction} object if found, otherwise {@code null}
     */
    public Transaction getTransationById(Long transactionId) {
        return transactionRepo.findById(transactionId).orElse(null);
    }

    /**
     * Retrieves all transactions performed by or received in a specific account.
     * 
     * <p>This method fetches both debit and credit transactions for a given account ID.</p>
     * 
     * @param accountId the account ID for which to retrieve transactions
     * @return a list of {@link Transaction} objects related to the given account
     */
    public List<Transaction> getTransactionByAccount(Long accountId) {
        return transactionRepo.findByFromAccountIdOrToAccountId(accountId, accountId);
    }

    /**
     * Retrieves all transactions performed by a specific account within a given date range.
     * 
     * <p>Useful for generating transaction history statements or reports
     * for a particular account over a specified period.</p>
     * 
     * @param accountId the account ID for which to retrieve transactions
     * @param startDate the start of the date range
     * @param endDate the end of the date range
     * @return a list of {@link Transaction} objects matching the criteria
     */
    public List<Transaction> getTransactionByACcountAndDateRange(Long accountId,
                                                                 LocalDateTime startDate,
                                                                 LocalDateTime endDate) {
        return transactionRepo.findByFromAccountIdOrToAccountIdAndTimestampBetween(
                accountId, accountId, startDate, endDate);
    }
}
