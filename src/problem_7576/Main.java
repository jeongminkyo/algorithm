package problem_7576;

import java.util.LinkedList;
import java.util.Scanner;

class Node {
    int left;
    int right;
    boolean visit;
    int value;

    public Node(int left, int right, boolean visit, int value){
        this.left = left;
        this.right = right;
        this.visit = visit;
        this.value = value;

    }
}

public class Main {

    static int M,N;
    static int final_size = -1;
    static Node [][] table = new Node[1001][1001];
    static LinkedList<Node> q = new LinkedList<Node>();

    static public void InsertQueue(int i,int j, int size){
        if (i-1 >= 0) {
            if (table[i - 1][j].value >= 0) {
                if (table[i - 1][j].value > size || table[i-1][j].value ==0) {
                    table[i - 1][j].value = size;
                    table[i - 1][j].visit = true;
                    q.offer(table[i - 1][j]);
                }
            }
        }

        if (i+1 < N) {
            if(table[i+1][j].value >= 0) {
                if(table[i+1][j].value > size || table[i+1][j].value ==0){
                    table[i+1][j].value = size;
                    table[i + 1][j].visit = true;
                    q.offer(table[i+1][j]);
                }
            }
        }
        if (j-1 >= 0) {
            if(table[i][j-1].value >= 0) {
                if(table[i][j-1].value > size || table[i][j-1].value ==0){
                    table[i][j-1].value = size;
                    table[i][j-1].visit = true;
                    q.offer(table[i][j-1]);
                }
            }
        }
        if (j+1 < M) {
            if(table[i][j+1].value >= 0) {
                if(table[i][j+1].value > size || table[i][j+1].value ==0){
                    table[i][j+1].value = size;
                    table[i][j+1].visit = true;
                    q.offer(table[i][j+1]);
                }
            }
        }
    }

    static void CycleQueue(){
        while(q.size() != 0){
            Node node = q.poll();
            int x = node.left;
            int y = node.right;
            int size = node.value;
            InsertQueue(x,y,size+1);
        }
    }

    public static void main(String[]  args){
        Scanner scan = new Scanner(System.in);
        M = scan.nextInt();
        N = scan.nextInt();

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                Node node = new Node(i,j,false, scan.nextInt());
                table[i][j] = node;
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                int size = 2;

                if(table[i][j].value == 1){
                    table[i][j].visit = true;
                    InsertQueue(i,j, size);
                }
            }
        }

        CycleQueue();

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(table[i][j].value == 0){
                    final_size = -1;
                    break;
                }

                if(final_size < table[i][j].value)
                    final_size = table[i][j].value;
            }
            if(final_size == -1) break;
        }

        if(final_size == -1)
            System.out.println(final_size);
        else
            System.out.println(final_size-1);
    }
}
