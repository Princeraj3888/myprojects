package multithreading.completablefuture;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CompletableFuture;

public class Client {

    public static void main(String[] args){
        List<Integer> integerList = Arrays.asList(1, 5, 7, 8, 2);
        List<CompletableFuture<Integer>> completableFutureList = integerList.stream()
                .map(num ->
                    CompletableFuture.supplyAsync(()-> executeThisCompleteMethod(num)))
                .toList();

        List<Integer> resultsList = completableFutureList.stream().map(CompletableFuture::join).toList();
        System.out.println("resultsList: "+resultsList);

        List<String> stringList = Arrays.asList("hi", "this", "is", "demo", "program", "to", "explore", "completable future", "in", "java");

        List<CompletableFuture<String>> completableStringList = stringList.stream()
                .map(str ->
            CompletableFuture.supplyAsync(()-> convertToUpperCase(str))).toList();
        List<String> resultStringList = completableStringList.stream().map(CompletableFuture::join).toList();
        System.out.println("resultStringList: "+resultStringList);
    }

    public static Integer executeThisCompleteMethod(Integer number){
        return number * 2;
    }

    public static String convertToUpperCase(String element){
        return element.toUpperCase(Locale.ROOT);
    }
}
