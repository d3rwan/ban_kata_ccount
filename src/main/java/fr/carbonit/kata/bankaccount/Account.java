package fr.carbonit.kata.bankaccount;

import fr.carbonit.kata.bankaccount.operations.Deposit;
import fr.carbonit.kata.bankaccount.operations.Withdrawal;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Account
 */
public class Account {

    /**
     * balance of the account
     */
    private Amount balance;

    /**
     * transactions applied on this account
     */
    private List<Transaction> transactions;

    /**
     * Constructor without initial deposit
     */
    public Account() {
        this(Amount.ZERO);
    }

    /**
     * Constructor with an initial deposit
     *
     * @param initialDeposit initial deposit on the account
     */
    public Account(Amount initialDeposit) {
        this.balance = new Amount(initialDeposit.getValue());
        this.transactions = new ArrayList<>();
    }

    /**
     * Make a deposit to the account
     *
     * @param amountToDeposit amount to deposit
     * @param timestamp       timestamp of the deposit
     */
    public void deposit(Amount amountToDeposit, LocalDate timestamp) {
        Deposit deposit = new Deposit(amountToDeposit);
        this.balance = deposit.performOn(this);
        this.transactions.add(new Transaction(timestamp, this, deposit, this.balance));
    }

    /**
     * Make a deposit to the account
     *
     * @param amountToDeposit amount to deposit
     */
    public void deposit(Amount amountToDeposit) {
        this.deposit(amountToDeposit, LocalDate.now());
    }

    /**
     * Make a withdrawal to the account
     *
     * @param amountToWithdraw amount to withdraw
     * @param timestamp        timestamp of the withdraw
     */
    public void withdraw(Amount amountToWithdraw, LocalDate timestamp) {
        Withdrawal withdrawal = new Withdrawal(amountToWithdraw);
        this.balance = withdrawal.performOn(this);
        this.transactions.add(new Transaction(timestamp, this, withdrawal, this.balance));
    }

    /**
     * Make a withdrawal to the account
     *
     * @param amountToWithdraw amount to withdraw
     */
    public void withdraw(Amount amountToWithdraw) {
        this.withdraw(amountToWithdraw, LocalDate.now());
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
     * Get the list of transaction
     *
     * @return the list of transaction
     */
    public List<Transaction> getTransactions() {
        return transactions;
    }
}
