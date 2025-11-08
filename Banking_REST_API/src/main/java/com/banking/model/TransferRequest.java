/**
 * 
 */
package com.banking.model;

/**
 * Represents a request payload for transferring money between two accounts.
 * 
 * <p>This class is used as a Data Transfer Object (DTO) to capture
 * information required for fund transfer operations in the Banking/Wallet REST API.</p>
 * 
 * <p>It includes the source account ID, destination account ID, 
 * and the amount to be transferred.</p>
 * 
 * <p>This object is typically sent from the client (e.g., frontend or Postman)
 * to the backend REST controller during a transfer request.</p>
 * 
 * @author Madhusudan Dande
 */
public class TransferRequest {

    /**
     * Account ID from which the amount will be debited.
     */
    private Long fromAccountId;

    /**
     * Account ID to which the amount will be credited.
     */
    private Long toAccountId;

    /**
     * Amount of money to be transferred.
     */
    private double amount;

    // ---------------------------------------------------------
    // Getters and Setters
    // ---------------------------------------------------------

    /**
     * Returns the source account ID.
     * @return fromAccountId
     */
    public Long getFromAccountId() {
        return fromAccountId;
    }

    /**
     * Sets the source account ID.
     * @param fromAccountId the account ID from which funds will be debited
     */
    public void setFromAccountId(Long fromAccountId) {
        this.fromAccountId = fromAccountId;
    }

    /**
     * Returns the destination account ID.
     * @return toAccountId
     */
    public Long getToAccountId() {
        return toAccountId;
    }

    /**
     * Sets the destination account ID.
     * @param toAccountId the account ID to which funds will be credited
     */
    public void setToAccountId(Long toAccountId) {
        this.toAccountId = toAccountId;
    }

    /**
     * Returns the amount to be transferred.
     * @return amount
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Sets the amount to be transferred.
     * @param amount the value of money to transfer between accounts
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }
}
