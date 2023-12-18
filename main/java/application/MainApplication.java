package main.java.application;

import main.java.analyzer.BankTransactionAnalyzer;
import main.java.parser.BankStatementCSVParser;

import java.io.IOException;

public class MainApplication {

    private static String RECOURCE = "/Users/comedial/javaBootcamp/BankTransactionAnalyzer/src/resources/transactions.csv";

    public static void main(String[] args) {
        BankTransactionAnalyzer bankTransactionAnalyzer = new BankTransactionAnalyzer();
        try {
            bankTransactionAnalyzer.analyze(RECOURCE, new BankStatementCSVParser());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
