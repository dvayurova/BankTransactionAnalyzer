package main.java.analyzer;

import main.java.models.BankTransaction;
import main.java.parser.BankStatementParser;
import main.java.processor.BankStatementProcessor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Month;
import java.util.List;

public class BankTransactionAnalyzer {

    public void analyze(final String filename, final BankStatementParser bankStatementParser) throws IOException {
        List<String> lines = Files.readAllLines(Path.of(filename));
        List<BankTransaction> bankTransactions = bankStatementParser.parseLinesFrom(lines);
        BankStatementProcessor bankStatementProcessor = new BankStatementProcessor(bankTransactions);
        collectSummary(bankStatementProcessor);
    }

    private void collectSummary(final BankStatementProcessor bankStatementProcessor) {
        System.out.println("Total amount = " + bankStatementProcessor.calculateTotalAmount());
        System.out.println("Total amount in December = " + bankStatementProcessor.calculateTotalInMonth(Month.DECEMBER));
        System.out.println("Total amount in January = " + bankStatementProcessor.calculateTotalInMonth(Month.JANUARY));
        System.out.printf("Total amount in Magnit =  %.2f", bankStatementProcessor.calculateTotalForCategory("Magnit"));
    }


}