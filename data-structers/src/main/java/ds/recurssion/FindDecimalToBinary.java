package ds.recurssion;

public class FindDecimalToBinary {

    public static void main(String[] args){
        toBinary(100);
    }

    public static void toBinary(int N){
        if(N == 0)
            return;
        toBinary(N/2);
        System.out.print(N%2);
    }
}
