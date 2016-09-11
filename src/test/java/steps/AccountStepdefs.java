package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import fr.carbonit.kata.bankaccount.Account;
import fr.carbonit.kata.bankaccount.Amount;

import static org.junit.Assert.*;

public class AccountStepdefs {

    private Account account;
    private boolean fail = false;

    @Given("^I have an account with balance (\\d+)$")
    public void i_have_an_account_with_balance(double initialBalance) throws Throwable {
        try {
            account = new Account(new Amount(initialBalance));
        } catch (IllegalArgumentException ex) {
            fail = true;
        }
    }

    @When("^I am depositing (\\d+)$")
    public void i_am_depositing(double amount) throws Throwable {
        try {
            account.deposit(new Amount(amount));
        } catch (IllegalArgumentException ex) {
            fail = true;
        }

    }

    @When("^I am withdrawing (\\d+)$")
    public void i_am_retrieving(double amount) throws Throwable {
        try {
            account.withdraw(new Amount(amount));
        } catch (IllegalArgumentException ex) {
            fail = true;
        }
    }

    @And("^My account balance should be (\\d+)$")
    public void my_account_balance_must_be(double expectedBalance) throws Throwable {
        assertEquals(account.getBalance().getValue().doubleValue(), expectedBalance, 0D);
    }

    @Then("^It works$")
    public void itWorks() throws Throwable {
        assertFalse(fail);
    }

    @Then("^It fails$")
    public void itFails() throws Throwable {
        assertTrue(fail);
    }
}