package fr.carbonit.kata.bankaccount;

/**
 * Account
 */
public class Account {

    /**
     * balance of the account
     */
    private Amount balance;

    /**
     * Constructor without initial deposit
     */
    public Account() {
        this.balance = Amount.ZERO;
    }

    /**
     * Constructor with an initial deposit
     *
     * @param initialDeposit initial deposit on the account
     */
    public Account(Amount initialDeposit) {
        this.balance = new Amount(initialDeposit.getValue());
    }

    /**
     * Make a deposit to the account
     *
     * @param amountToDeposit amount to deposit
     */
    public void deposit(Amount amountToDeposit) {
        this.balance = balance.add(amountToDeposit);
    }

    /**
     * Make a withdrawal to the account
     *
     * @param amountToWithdraw amount to withdraw
     */
    public void withdraw(Amount amountToWithdraw) {
        this.balance = balance.subtract(amountToWithdraw);
    }

    /**
     * Get the balance
     *
     * @return the balance
     */
    public Amount getBalance() {
        return balance;
    }
}
