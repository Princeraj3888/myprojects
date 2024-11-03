package techm.questions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ArrayCalculation {

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        int number = sc.nextInt();

        List<Integer> integerList = new ArrayList<>();

        for(int i=0; i<number; i++){
            integerList.add(sc.nextInt());
        }


        while(integerList.size() > 1){
            integerList.remove(Collections.min(integerList));

            if(integerList.size() == 1) break;

            integerList.remove(Collections.max(integerList));
        }

        System.out.println("last integer: "+integerList.get(0));
        sc.close();

    }
}
