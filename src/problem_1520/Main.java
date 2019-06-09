package problem_1520;

import java.util.ArrayList;
import java.util.Scanner;

class Node {
    int left;
    int right;
    int value;

    public Node(int left, int right, int value){
        this.left = left;
        this.right = right;
        this.value = value;
    }
}

public class Main {

    static int M,N;
    static int final_cnt = 0;
    static Node [][] table = new Node[501][501];
    static ArrayList<Node> q = new ArrayList<Node>();

    public static void DownHill(int i, int j){
        if (i-1 >= 0) {
            if(table[i-1][j].value < table[i][j].value){
                q.add(table[i-1][j]);
            }
        }

        if (i+1 < M) {
            if(table[i+1][j].value < table[i][j].value){
                q.add(table[i+1][j]);
            }
        }
        if (j-1 >= 0) {
            if(table[i][j-1].value < table[i][j].value){
                q.add(table[i][j-1]);
            }
        }
        if (j+1 < N) {
            if(table[i][j+1].value < table[i][j].value){
                q.add(table[i][j+1]);
            }
        }
    }

    static void CycleQueue(){
        while(q.size() != 0){
            Node node = q.get(0);
            q.remove(0);
            int x = node.left;
            int y = node.right;
            if(x == M-1 && y == N-1)
                final_cnt += 1;
            DownHill(x,y);
        }
    }

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        M = scan.nextInt();
        N = scan.nextInt();

        for(int i = 0; i < M; i++){
            for(int j = 0; j < N; j++){
                Node node = new Node(i, j, scan.nextInt());
                table[i][j] = node;
            }
        }

        DownHill(0,0);
        CycleQueue();

        System.out.println(final_cnt);
    }
}
