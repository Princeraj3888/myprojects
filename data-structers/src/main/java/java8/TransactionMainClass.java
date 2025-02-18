package java8;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class TransactionMainClass {

    public static void main(String args[]){
        //Given a list of transactions (each having amount and category), calculate the total amount per category using groupingBy() and reducing().
        List<Transactions> transactions = new ArrayList<Transactions>();
        Transactions transactions1 = new Transactions(Double.valueOf(1001), "PENDING");
        Transactions transactions2 = new Transactions(Double.valueOf(1002), "COMPLETED");
        Transactions transactions3 = new Transactions(Double.valueOf(1003), "REVIEW");
        Transactions transactions4 = new Transactions(Double.valueOf(1004), "PENDING");
        Transactions transactions5 = new Transactions(Double.valueOf(1005), "COMPLETED");
        Transactions transactions6 = new Transactions(Double.valueOf(1006), "REVIEW");
        Transactions transactions7 = new Transactions(Double.valueOf(1007), "PENDING");

        transactions.add(transactions1); transactions.add(transactions2);transactions.add(transactions3);transactions.add(transactions4);
        transactions.add(transactions5); transactions.add(transactions6); transactions.add(transactions7);

        Map<String, Double> transactionMap = transactions.stream()
                .collect(Collectors.groupingBy(Transactions::getCategory, Collectors.summingDouble(Transactions::getAmount)));
        System.out.println(transactionMap);

        Optional<Transactions> maxAmount = transactions.stream().max(Comparator.comparing(Transactions::getAmount));
        System.out.println("maxAmount from Transactions: "+(maxAmount.isPresent()?maxAmount.get():""));

        Optional<Transactions> minAmount = transactions.stream().min(Comparator.comparing(Transactions::getAmount));
        System.out.println("minimum amount from transactions: "+(minAmount.isPresent()?minAmount.get():""));

        List<Transactions> sortedList = transactions.stream().sorted(Comparator.comparing(Transactions::getCategory)).toList();
        System.out.println("sortedList: "+sortedList);

        Map<String, Double> averageMap = transactions.stream()
                .collect(Collectors.groupingBy(Transactions::getCategory,
                        Collectors.averagingDouble(Transactions::getAmount)));

        System.out.println("average of each category: "+averageMap);
    }
}
