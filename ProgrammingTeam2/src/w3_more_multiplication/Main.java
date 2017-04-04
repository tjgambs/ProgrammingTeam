package w3_more_multiplication;

import java.util.Scanner;

// For the judge, this must be package-private.
class Main {
    
    // (More) Multiplication - 6812
    // Time to solve: 200 minutes
    // Debug time: 0 minutes
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            if(n == 0 && m == 0) return;
            
            char[][] grid = new char[4*String.valueOf(n).length()+5][4*String.valueOf(m).length()+5];
            grid = addBorder(grid, 0, 0, grid.length-1, grid[0].length-1);
            grid = placeN(grid, n);
            grid = placeM(grid, m);
            for(int i = 0; i < String.valueOf(m).length(); i++) {
                for(int j = 0; j < String.valueOf(n).length(); j++) {
                    grid = addBorder(grid,j*4+2,i*4+2,j*4+6,i*4+6);  
                    grid = addDiagonalLines(grid, j*4+2,i*4+6);
                }
            }
            char[] answer = String.valueOf(m*n).toCharArray();
            int count = String.valueOf(m).length()-1;
            int i;
            for(i = answer.length-1; count > -1; i--) {
                grid[grid.length-2][3+4*count] = answer[i];
                count--;
            }
            count = String.valueOf(n).length()-1;
            boolean flag = false;
            for(; i >= 0; i--) {
                flag = true;
                grid[5+4*count][1] = answer[i];
                count--;
            }
            if (flag) {
                grid = cleanGrid(grid, 5+4*(count+1));
            } else {
                grid[grid.length-2][1] = '\u0000';
            }
            
            char[] nChar = String.valueOf(n).toCharArray();
            char[] mChar = String.valueOf(m).toCharArray();
            for(int t = 0; t < nChar.length; t++) {
                for(int k = 0; k < mChar.length; k++) {
                    int a = Integer.parseInt(nChar[t]+"")*Integer.parseInt(mChar[k]+"");
                    char[] arr = String.valueOf(a).toCharArray();  
                    if(arr.length == 1) {
                        grid[3+4*t][3+4*k] = '0';
                        grid[5+4*t][5+4*k] = arr[0];
                    } else {
                        grid[3+4*t][3+4*k] = arr[0];
                        grid[5+4*t][5+4*k] = arr[1];
                    }
                }
            }
            printGrid(grid);
        }
    } 
    
    public static char[][] cleanGrid(char[][] arr, int last) {
        for(int i = last; i > 0; i--) {
            if(arr[i][1]=='/') arr[i][1] = '\u0000';
        }
        return arr;
    }
    
    public static char[][] placeM(char[][] arr, int m) {
        char[] todo = String.valueOf(m).toCharArray();
        for(int i = 1; i < todo.length+1; i++) {
            arr[1][4*i] = todo[i-1];
        }
        return arr;
    }
    
    public static char[][] placeN(char[][] arr, int n) {
        char[] todo = String.valueOf(n).toCharArray();
        for(int i = 1; i < todo.length+1; i++) {
            arr[4*i][arr[0].length-2] = todo[i-1];
        }
        return arr;
    }
    
    public static char[][] addDiagonalLines(char[][] arr, int x, int y) {
        int i = x;
        int j = y;
        for(; j > 0 && i < arr.length ;) {
            if (arr[i][j] == '\u0000') 
                arr[i][j] = '/';
            i++;
            j--;  
        } 
        return arr;
    }
    
    public static char[][] addBorder(char[][] arr, int x1, int y1, int x2, int y2) {
        arr[x1][y1] = '+';
        arr[x2][y1] = '+';
        arr[x1][y2] = '+';
        arr[x2][y2] = '+';
        for(int i = x1+1; i < x2; i++) {
            arr[i][y1] = '|';
            arr[i][y2] = '|';
        }
        for(int i = y1+1; i < y2; i++) {
            arr[x1][i] = '-';
            arr[x2][i] = '-';
        }
        return arr;
    }
    
    public static void printGrid(char[][] arr) {
        for(char[] ca : arr) {
            for(char c : ca) {
                if(c != '\u0000') {
                    System.out.print(c);
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}