package main.java.processor;

import main.java.models.BankTransaction;

import java.time.Month;
import java.util.List;

public class BankStatementProcessor {
    private final List<BankTransaction> bankTransactions;

    public BankStatementProcessor(List<BankTransaction> bankTransactions) {
        this.bankTransactions = bankTransactions;
    }
    public double calculateTotalAmount(){
        double sum = 0;
        for (BankTransaction transaction : bankTransactions) {
            sum += transaction.getAmount();
        }
        return sum;
    }

    public double calculateTotalInMonth(final Month month){
        double sum = 0;
        for (BankTransaction transaction : bankTransactions) {
            if(transaction.getDate().getMonth() == month) {
                sum += transaction.getAmount();
            }
        }
        return sum;
    }

    public double calculateTotalForCategory(final String category){
        double sum = 0;
        for (BankTransaction transaction : bankTransactions) {
            if(transaction.getDescription().equals(category)) {
                sum += transaction.getAmount();
            }
        }
        return sum;
    }
}
