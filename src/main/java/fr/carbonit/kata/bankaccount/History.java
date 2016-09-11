package fr.carbonit.kata.bankaccount;

import java.io.PrintStream;
import java.time.format.DateTimeFormatter;

import static java.lang.String.format;
import static java.time.format.DateTimeFormatter.ofPattern;

/**
 * Account history
 */
public class History {

    /**
     * report format
     */
    public static final String REPORT_FORMAT = "| %-10s | %-10s | %-10s | %-10s |";

    /**
     * report header
     */
    public static final String REPORT_HEADER
            = format(REPORT_FORMAT, "Operation", "Date", "Amount", "Balance");

    /**
     * Date formatter
     */
    public static final DateTimeFormatter DATE_FORMATTER = ofPattern("yyyy/MM/dd");

    /**
     * Account
     */
    private Account account;

    /**
     * Constructor
     *
     * @param account account
     */
    public History(Account account) {
        this.account = account;
    }

    /**
     * Print the history
     * @param printer
     */
    public void print(PrintStream printer) {
        printer.println(REPORT_HEADER);
        if (account.getTransactions() != null) {
            this.account.getTransactions().stream()
                    .map(transaction ->
                            format(REPORT_FORMAT,
                                    transaction.getOperation().getType(),
                                    transaction.getTimestamp().format(DATE_FORMATTER),
                                    transaction.getOperation().getAmount(),
                                    transaction.getBalance()))
                    .forEach(printer::println);
        }
    }
}
