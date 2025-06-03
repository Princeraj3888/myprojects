package ds.recurssion;

public class TowerOfHanoi {

    public long toh(int N, int from, int to, int aux){
        long moves[] = new long[1];
        tower(N, from, to, aux, moves);
        return moves[0];
    }

    public void tower(int N, int from, int to, int aux, long[] moves){

        if(N == 0){
            return;
        }
        moves[0]++;

        tower(N-1, from, aux, to, moves);
        System.out.println("move disk "+N+" from rod "+from+" to rod "+to);

        tower(N-1, aux, to, from, moves);

    }
}
