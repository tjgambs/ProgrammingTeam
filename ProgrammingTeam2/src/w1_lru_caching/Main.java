
package w1_lru_caching;

import java.util.Scanner;

// For the judge, this must be package-private.
class Main {
    
    
    // LRU Caching - 6099
    // Time to solve: 90 minutes
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int counter = 1;
        while(true) {  
            int N = sc.nextInt();
            if(N == 0) return;
            System.out.printf("Simulation %d\n", counter);
            char[] in = sc.next().toCharArray();
            char[] cache = new char[N];
            int[] state = new int[N];  
            int val = 1;
            int points = 0;
            for(int i = 0; i < in.length; i++) {
                if(in[i] == '!') {
                    printCache(cache, state);
                    points++;
                }
                else if(i-points < N) {
                    cache[i-points] = in[i];
                    state[i-points] = val;
                    val++;
                } else {
                    int index = getLeastState(state);
                    cache[index] = in[i];
                    state[index] = val;
                    val++;
                }
            }
            counter += 1;
        }
    }
    
    public static int getLeastState(int[] state) {
        int index = 0;
        int value = state[0];
        for (int i = 1; i < state.length; i++) {
            if(state[i] < value) {
                value = state[i];
                index = i;
            }
        }
        return index;
    }
    
    // The bane of my existance
    public static void printCache(char[] cache, int[] state) { 
        int[] temp = state.clone();
        for(int i = 0; i < temp.length; i++) {
            int smallestIndex = 0;
            int smallest = temp[0];
            for(int j = 0; j < temp.length; j++) {
                if(temp[j] < smallest) {
                    smallest = temp[j];
                    smallestIndex = j;
                }
            }
            char toPrint = cache[smallestIndex];
            if (toPrint != '\u0000')
                System.out.print(cache[smallestIndex]);
            temp[smallestIndex] = Integer.MAX_VALUE; 
        }
        System.out.println();
    }      
}
