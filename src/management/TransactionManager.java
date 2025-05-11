package management;

import datastructures.lists.CustomArrayList;
import library.Book;
import library.Member;
import library.Transaction;

import java.util.Date;

public class TransactionManager {
    private CustomArrayList transactions;

    public TransactionManager() {
        transactions = new CustomArrayList<>();
    }

    public Transaction addTransaction(String bookTitle, String memberName, String type) {

        Transaction transaction = new Transaction(
                "TXN-" + new Date().getTime(),
                bookTitle,
                memberName,
                type
        );

        transactions.add(transaction);
        return transaction;
    }

    public Transaction getTransactionByIndex(int index) {
        if (index >= 0 && index < transactions.size()){
            return (Transaction) transactions.get(index);
        }
        return null;
    }
}
