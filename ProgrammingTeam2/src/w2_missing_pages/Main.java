
package w2_missing_pages;

import java.util.Arrays;
import java.util.Scanner;

// For the judge, this must be package-private.
class Main {
    
    // Missing Pages - 6494
    // Time to solve: 15 minutes
    // Debug time: 0 minutes
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            int N = sc.nextInt();
            if(N == 0) return;
            int P = sc.nextInt();
            int p1 = N - P + 1;
            int p2 = (P%2==0) ? P - 1 : P + 1;
            int p3 = N - p2 + 1;
            int[] arr = {p1, p2, p3};    
            Arrays.sort(arr);
            System.out.printf("%d %d %d\n", arr[0], arr[1], arr[2]);
        }
    }
}