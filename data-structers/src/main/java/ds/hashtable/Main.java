package ds.hashtable;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String args[]){
        HashTable hashTable = new HashTable();

        hashTable.set("nails", 100);
        hashTable.set("tile", 50);
        hashTable.set("lumber", 80);
        hashTable.set("bolts", 200);
        hashTable.set("screws", 140);
        hashTable.set("rudra", 12);
        hashTable.set("raj", 12);
        hashTable.set("barsha", 12);

        hashTable.printTable();

        //System.out.println("marks is: "+hashTable.get("rudra"));
        System.out.println(hashTable.getKeys());


    }

    public static List<Integer> findDuplicates(int nums[]){

        //List<Integer> duplicatesList = Arrays.stream(nums).boxed().collect(Collectors.toList());
        List<Integer> duplicatesList = new ArrayList<>();



        Map<Integer, Integer> duplicateMap = new HashMap<>();
        for(Integer i : nums){
            if(duplicateMap.containsKey(i)){
                duplicateMap.put(i, duplicateMap.getOrDefault(i, 0) + 1);
            }
        }
        System.out.println(duplicateMap);
        for(Map.Entry<Integer, Integer> entry : duplicateMap.entrySet()){
            if(entry.getValue() > 1){
                duplicatesList.add(entry.getKey());
            }
        }
        System.out.println(duplicatesList);

        return duplicatesList;

    }
}
