package ds.recurssion;

public class CountTwoWays {

    static int Ro = 3, Co = 3;

    public static void main(String[] args){
        int r = 3; int c= 3;
        int waysFromDestToSource = waysFromDestToSource(r-1, c-1);
        System.out.println("no of ways: "+waysFromDestToSource);

        int waysFromSourceToDestination = waysFromSourceToDestination(0, 0);
        System.out.println("waysFromSourceToDestination: "+waysFromSourceToDestination);
    }

    private static int waysFromSourceToDestination(int r, int c) {
        if(r == Ro-1 || c == Co-1){
            return 1;
        }
        return waysFromSourceToDestination(r+1, c) + waysFromSourceToDestination(r, c+1);
    }

    private static int waysFromDestToSource(int r, int c) {
        if(r == 0 || c == 0){
            return 1;
        }
        return waysFromDestToSource(r-1, c) + waysFromDestToSource(r, c-1);
    }
}
