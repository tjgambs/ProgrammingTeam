package w8_dance_recital;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

// For the judge, this must be package-private.
class Main {

    // Dance Recital - 7352
    // Time to solve: 150 minutes
    // Debug time: 60 minutes

    static int min = Integer.MAX_VALUE;
    static int[][] d;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int R = sc.nextInt();
        ArrayList<Integer> arr = new ArrayList();
        String[] shows = new String[R];
        d = new int[R][R];
        for(int i = 0; i < R; i++) {
            shows[i] = sc.next();
            for (int j = 0; j<i; j++) {
                for (char ch: shows[j].toCharArray()) {
                    if (shows[i].contains(""+ch)) {
                        d[i][j]=d[j][i]=d[i][j]+1; 
                    }
                }
            }
            arr.add(i); 
        }
        allPermutations(arr, 0, 0);
        System.out.println(min);
    }
    
    static void allPermutations(ArrayList<Integer> arr, int k, int cost){
        if (k == arr.size()) {
            if(min > cost) min = cost;
        } else {
            for(int i = k; i < arr.size(); i++){
                Collections.swap(arr, k, i); 
                int c = cost + ((k>0) ? d[arr.get(k-1)][arr.get(k)] : 0);
                allPermutations(arr, k+1, c);
                Collections.swap(arr, k, i);
            }
        }
    }
}
