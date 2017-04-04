
package w5_falling_apples;

import java.util.Scanner;

// For the judge, this must be package-private.
class Main {
    
    // Falling Apples - 7691
    // Time to solve: 25 minutes
    // Debug time: 0 minutes
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int height = sc.nextInt();
        int width = sc.nextInt();
        char[][] grid = new char[height][width];
        for(int h = 0; h < height; h++)
            grid[h] = sc.next().toCharArray();
        
        for(int i = 0; i < width; i++) {
            int count = 0;
            for(int j = 0; j < height; j++) {
                if(grid[j][i] == 'a') {
                    grid[j][i] = '.';
                    count++;
                } else if(grid[j][i] == '#') {
                    for(int k = 0; k < count; k++) {
                        grid[j-k-1][i] = 'a';
                    }
                    count = 0;
                }
            }
            for(int k = 0; k < count; k++) {
                grid[height-k-1][i] = 'a';
            }
        }
        
        for(char[] i: grid) {
            for(char j: i) {
                System.out.print(j);
            }
            System.out.println();
        }  
    }    
}

