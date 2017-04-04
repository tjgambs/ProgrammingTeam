
package w2_round_robin;

import java.util.Scanner;

// For the judge, this must be package-private.
class Main {
    
    // Round Robin - 6493
    // Time to solve: 60 minutes
    // Debug time: 30 minutes
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            int N = sc.nextInt(); // Players
            if (N == 0) return;
            int T = sc.nextInt(); // Turns
            
            // Initalize the players with 0 turns.
            int[] data = new int[N];
            
            // Keep track of the current index.
            int index = -1;
            while(true) {
                                
                // Nothing complicated here, just iterate over the indicies, incrementing each one.
                for(int j = 0; j < T; j++) {
                    index = (index+1)%N;
                    data[index]++;
                }
                
                // Now we have to get rid of the last index. I am just going to move everything forward
                // then decrement the length of the list. Basically, just ignore everything beyond N.
                for (int j = index; j < N-1; j++)
                    data[j] = data[j+1];
                N--;
                // After deleting, we go backwards one.
                index--;
                
                // Check if everything is the same
                boolean sameNumbers = checkIfSame(data, N);
                if (sameNumbers) {
                    System.out.printf("%d %d\n", N, data[0]);
                    break;
                }      
            }   
        }
    }
    public static boolean checkIfSame(int[] data, int N) {
        int first = data[0];
        for(int i = 0; i < N; i++) {
            if(data[i] != first) return false;
        }
        return true;
    }
}
