import java.util.Scanner;

class Main6 {
    
    //pascal's travels
    static long[][] grid, movesGrid;
    public static void main0(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            int n = sc.nextInt();
            if(n == -1) {
                break;
            }
            grid = new long[n][n];
            sc.nextLine();
            for(int i = 0; i < n; i++) {
                String d = sc.nextLine();
                for(int j = 0; j < d.length(); j++) {
                    grid[i][j] = Integer.parseInt(""+d.charAt(j));
                }
            }
            
            movesGrid = new long[n][n];
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    sum(i,j);  
                }
            }
            System.out.println(movesGrid[n-1][n-1]);        
        }
    }

    public static void sum(int row, int col) {  
        if(row == 0 && col == 0) {
            movesGrid[row][col] = 1;
            return;
        } 
        long sumVertical = 0;
        long sumHorizontal = 0;
        for(int r = 0; r < row; r++) {
            if(grid[r][col] == row-r) {
                sumVertical+=movesGrid[r][col];
            }
        }
        for(int c = 0; c < col; c++) {
            if(grid[row][c] == col-c) {
                sumHorizontal+=movesGrid[row][c];
            }
        }
        movesGrid[row][col] = sumHorizontal + sumVertical;
    }
    
    //ripoff
    public static void main3(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            int n = sc.nextInt();
            if(n == 0) {
                break;
            }
            
            int s = sc.nextInt();
            int t = sc.nextInt();
            
            int[] gameBoard = new int[n];
            for(int i = 0; i < n; i++) {
                gameBoard[i] = sc.nextInt();
            }
            
            int[][] dynamicArr = new int[n][n];
            
            
            
            
            
            
        }
    }
    
}
