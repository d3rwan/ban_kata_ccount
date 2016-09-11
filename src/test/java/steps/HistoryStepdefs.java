package steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import fr.carbonit.kata.bankaccount.Account;
import fr.carbonit.kata.bankaccount.Amount;
import fr.carbonit.kata.bankaccount.History;
import fr.carbonit.kata.bankaccount.operations.Operation;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;

public class HistoryStepdefs {

    private Account account;
    private History history;

    @Given("^I have an account with this history$")
    public void iHaveAnAccountWithThisHistory(DataTable data) throws Throwable {
        List<List<String>> lines = data.raw();
        // on supprime l'entete
        // on parse la table & on rejoue les transactions
        IntStream.range(0, lines.size())
                .filter(i -> i > 0)
                .mapToObj(i -> lines.get(i))
                .forEach(line -> {
                    LocalDate date = LocalDate.parse(line.get(1), History.DATE_FORMATTER);
                    Double amount = Double.valueOf(line.get(2));
                    // premiere ligne, on cree le compte
                    if (account == null) {
                        // forcement un depot, le depot initial = balance - depot
                        Double balance = Double.valueOf(line.get(3));
                        account = new Account(new Amount(balance - amount));
                    }
                    if (Operation.Type.DEPOSIT.toString().equals(line.get(0))) {
                        account.deposit(new Amount(amount), date);
                    } else {
                        account.withdraw(new Amount(amount), date);
                    }
                });
    }

    @Given("^I make a deposit from (\\d+) the (\\d+)/(\\d+)/(\\d+)$")
    public void iMakeADepositFrom(double amount, int year, int month, int day) throws Throwable {
        try {
            LocalDate date = LocalDate.of(year, month, day);
            account.deposit(new Amount(amount), date);
        } catch (IllegalArgumentException ex) {
            // nothing to do
        }
    }

    @And("^I make a withdraw from (\\d+) the (\\d+)/(\\d+)/(\\d+)$")
    public void iMakeAWithdrawFrom(double amount, int year, int month, int day) throws Throwable {
        try {
            LocalDate date = LocalDate.of(year, month, day);
            account.withdraw(new Amount(amount), date);
        } catch (IllegalArgumentException ex) {
            // nothing to do
        }
    }

    @When("^I check my account history$")
    public void iCheckMyAccountHistory() throws Throwable {
        history = new History(account);
    }

    @Then("^My account history looks like$")
    public void myAccountHistoryLooksLike(String report) throws Throwable {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(os);
        history.print(ps);
        assertEquals(os.toString(), report);
    }

}
