package fr.carbonit.kata.bankaccount;

/**
 * Main method
 */
public class BankAccountKata {

    public static void main(String[] args) {
        Account myAccount = new Account(new Amount(1000D));
        myAccount.deposit(new Amount(50D));
        myAccount.withdraw(new Amount(240D));
        myAccount.deposit(new Amount(100D));
        myAccount.withdraw(new Amount(30D));

        History myHistory = new History(myAccount);
        myHistory.print(System.out);
    }

}
