package com.demo.demo_programs;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class CompletableFutureExample {

    public static void main(String[] args){
        List<Integer> integerList = List.of(1, 2, 3, 4, 5);

        Integer sum = integerList.stream().mapToInt(Integer::intValue).sum();
        System.out.println("sum: "+sum);

        List<CompletableFuture<Integer>> futures = integerList.stream().map(
                num -> CompletableFuture.supplyAsync(()-> num*2))
                .collect(Collectors.toList());

        List<Integer> results = futures.stream()
                .map(CompletableFuture::join)
                .collect(Collectors.toList());
        System.out.println(results);
    }
}
