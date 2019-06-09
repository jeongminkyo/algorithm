package problem_1520;

import java.util.Scanner;

public class Main {

    static int M,N;
    static int [][] table = new int[501][501];
    static int [][] dp = new int[501][501];

    public static int DownHill(int i, int j){

        if(i == 0 && j == 0) return 1;
        if(dp[i][j] != -1) return dp[i][j];

        dp[i][j] = 0;

        if (i-1 >= 0) {
            if(table[i-1][j] > table[i][j]){
                dp[i][j] += DownHill(i-1,j);
            }
        }

        if (i+1 < M) {
            if(table[i+1][j] > table[i][j]){
                dp[i][j] += DownHill(i+1,j);
            }
        }
        if (j-1 >= 0) {
            if(table[i][j-1] > table[i][j]){
                dp[i][j] += DownHill(i,j-1);
            }
        }
        if (j+1 < N) {
            if(table[i][j+1] > table[i][j]){
                dp[i][j] += DownHill(i,j+1);
            }
        }

        return dp[i][j];
    }


    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        M = scan.nextInt();
        N = scan.nextInt();

        for(int i = 0; i < M; i++){
            for(int j = 0; j < N; j++){
                table[i][j] = scan.nextInt();
                dp[i][j] = -1;
            }
        }

        DownHill(M-1,N-1);

        System.out.println(dp[M-1][N-1]);
    }
}
