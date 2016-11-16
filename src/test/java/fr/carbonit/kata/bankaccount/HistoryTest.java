package fr.carbonit.kata.bankaccount;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;
import java.time.Month;

import static fr.carbonit.kata.bankaccount.History.DATE_FORMATTER;
import static fr.carbonit.kata.bankaccount.History.REPORT_FORMAT;
import static fr.carbonit.kata.bankaccount.operations.Operation.Type.DEPOSIT;
import static fr.carbonit.kata.bankaccount.operations.Operation.Type.WITHDRAWAL;
import static org.junit.Assert.assertEquals;

public class HistoryTest {


    @Test
    public void whenPrintHistoryOnAccountThenPrintAccountHistory() {
        // given
        Account account = new Account(new Amount(500D));
        Amount depositValue = new Amount(50D);
        LocalDate depositDate = LocalDate.of(2015, Month.APRIL, 27);
        Amount withdrawValue = new Amount(100D);
        LocalDate withdrawDate = LocalDate.of(2015, Month.MAY, 05);
        account.deposit(depositValue, depositDate);
        account.withdraw(withdrawValue, withdrawDate);
        History history = new History(account);
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(os);

        StringBuilder expectedOutput = new StringBuilder();
        expectedOutput.append(History.REPORT_HEADER);
        expectedOutput.append("\r\n");
        expectedOutput.append(String.format(REPORT_FORMAT,
                DEPOSIT, depositDate.format(DATE_FORMATTER), depositValue, new Amount(550D)));
        expectedOutput.append("\r\n");
        expectedOutput.append(String.format(REPORT_FORMAT,
                WITHDRAWAL, withdrawDate.format(DATE_FORMATTER), withdrawValue, new Amount(450D)));
        expectedOutput.append("\r\n");

        // when
        history.print(ps);

        // then
        assertEquals(os.toString(), expectedOutput.toString());
    }

}