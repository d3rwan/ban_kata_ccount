package fr.carbonit.kata.bankaccount;

import fr.carbonit.kata.bankaccount.operations.Operation;

import java.time.LocalDate;

/**
 * Transaction
 */
public class Transaction {

    /**
     * timestamp
     */
    private LocalDate timestamp;

    /**
     * target account
     */
    private Account account;

    /**
     * operation to performOn
     */
    private Operation operation;

    /**
     * balance after transaction
     */
    private Amount balance;

    /**
     * Constructor
     *
     * @param timestamp timestamp
     * @param account   account
     * @param operation operation
     * @param balance   balance
     */
    public Transaction(LocalDate timestamp, Account account, Operation operation, Amount balance) {
        this.timestamp = timestamp;
        this.account = account;
        this.operation = operation;
        this.balance = balance;
    }

    /**
     * Get the balance
     *
     * @return the balance
     */
    public Amount getBalance() {
        return balance;
    }

    /**
     * Get the timestamp
     *
     * @return the timestamp
     */
    public LocalDate getTimestamp() {
        return timestamp;
    }

    /**
     * Get the account
     *
     * @return the account
     */
    public Account getAccount() {
        return account;
    }

    /**
     * Get the operation
     *
     * @return the operation
     */
    public Operation getOperation() {
        return operation;
    }
}
