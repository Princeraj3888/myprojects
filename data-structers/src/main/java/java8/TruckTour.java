package java8;

import java.util.List;

public class TruckTour {

    public static void main(String args[]){
        List<List<Integer>> integerList = List.of(List.of(1, 5), List.of(10, 3), List.of(3, 4));
        int size = integerList.size();

        int startingPoint = findTruckTourStartingPoint(integerList, size);
        System.out.println("starting point: "+startingPoint);
    }

    private static int findTruckTourStartingPoint(List<List<Integer>> integerList, int size) {
        int start = 0;
        int totalSurplus = 0;
        int currentSurplus = 0;
        for(int i=0; i<size; i++){
            int petrol = integerList.get(i).get(0);
            int distance = integerList.get(i).get(1);
            int surplus = petrol - distance;

            totalSurplus += surplus;
            currentSurplus += surplus;

            if(currentSurplus < 0){
                start = i + 1;
                currentSurplus = 0;
            }
        }

        return totalSurplus >=0 ? start : -1;
    }
}
