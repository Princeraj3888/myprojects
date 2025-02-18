package ds.hashtable;

import java.util.HashMap;

public class CommonItem {

    public static void main(String args[]){
        int arr1[] = {1, 3, 5};
        int arr2[] = {4, 7, 6};
        //System.out.println("common item search step1: "+commonItemSearchStep1(arr1, arr2));
        System.out.println("common item search step using hashmap: "+commonItemSearchHashMap(arr1, arr2));
    }

    public static boolean commonItemSearchStep1(int arr1[], int arr2[]){
        for(int i : arr1){
            for(int j: arr2){
                if(i == j){return true;}
            }
        }
        return false;
    }

    public static boolean commonItemSearchHashMap(int arr1[], int arr2[]){
        HashMap<Integer, Boolean> hashMap = new HashMap<>();
        for (int i: arr1){
            hashMap.put(i, true);
        }

        for(int j : arr2){
            if(hashMap.get(j) != null){
                return true;
            }
        }
        return false;
    }
}
