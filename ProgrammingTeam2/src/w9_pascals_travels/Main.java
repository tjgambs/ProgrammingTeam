
package w9_pascals_travels;

import java.util.Scanner;

// For the judge, this must be package-private.
class Main {
    
    // Pascal's Travels - ####
    // Time to solve: 40 minutes
    // Debug time: 20 minutes
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            int n = sc.nextInt();
            if(n == -1) return;
            int[][] grid = new int[n][n];
            long[][] numMoves = new long[n][n];
            numMoves[0][0] = 1;
            for(int i = 0; i < n; i++) {   
                char inputChar[] = sc.next().toCharArray();
                for(int j = 0; j < n; j++) {
                    int input = Integer.parseInt(inputChar[j]+"");
                    grid[i][j] = input;
                    if(numMoves[i][j] > 0 && grid[i][j] > 0) {
                        if((j+input) < n)
                            numMoves[i][j+input] += numMoves[i][j];
                        if((i+input) < n)
                            numMoves[i+input][j] += numMoves[i][j];
                    }
                }
            }  
            System.out.println(numMoves[n-1][n-1]);
        }
    }
}