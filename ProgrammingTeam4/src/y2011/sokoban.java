/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package y2011;

import java.util.Arrays;
import java.util.Scanner;

public class sokoban {
    
    static class Grid {
        char[][] grid;
        public Grid(char[][] grid) {
            this.grid = grid;
        }
        
        public void run(char[] steps) {
            for(char c: steps) {
                switch(c) {
                    case 'U':
                        moveUp();
                        break;
                    case 'D':
                        moveDown();
                        break;
                    case 'R':
                        moveRight();
                        break;
                    case 'L':
                        moveLeft();
                        break;
                }
            }
        }
        
        public void moveUp() {
            
        }
        
        public void moveDown() {
            
        }
        
        public void moveLeft() {
            
        }
        
        public void moveRight() {
            
        }
        
        public boolean iscomplete() {
            return true;
        }
        
        @Override
        public String toString() {
            String a = "";
            for(char[] c: this.grid) {
                for(char i : c) {
                    a += i;
                }
                a += "\n";
            }
            return a;
        }
    }
    
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int index = 1;
        while(true) {
            int columns = sc.nextInt();
            int rows = sc.nextInt();
            if(columns == 0 && rows == 0) break;
            
            char[][] grid = new char[rows][columns];
            for(int i = 0; i < rows; i++) {
                grid[i] = sc.nextLine().toCharArray();
                System.out.println(Arrays.toString(grid[i]));
            }
            char[] steps = sc.nextLine().toCharArray();
            Grid map = new Grid(grid);
            map.run(steps);     
            System.out.print("Game " + index + ": " + (map.iscomplete() ? "complete" : "incomplete"));
            System.out.print(map);
            index++;
        }
    }
}
