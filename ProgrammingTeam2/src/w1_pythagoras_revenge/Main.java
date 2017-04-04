
package w1_pythagoras_revenge;

import static java.lang.Math.sqrt;
import java.util.Scanner;

// For the judge, this must be package-private.
class Main {
    
    // Pythagoras's Revenge - 6094
    // Time to solve: 75 minutes
    
    /*
        A^2 + B2 = C^2
        We are solving for A in this problem so let's 
        set the equation in terms of A
        A^2 = C^2 - B^2
        OR
        A^2 = (C-B)(C+B)
        
        Let's say,
            x = (C-B)
            y = (C+B) C+B-C+B = 2B
        Therefore, since x is the smallest, x is at most A.
        Solving for B and C we get,
            B = (y-x)/2
            C = (y+x)/2
    */
    
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            int count = 0;
            int A = sc.nextInt();
            if (A == 0) return;
            long AA = (long)A*A;
            // Start at the maximum value for x and work backwards
            for (long x = (long)((sqrt(2) - 1)*A); x > 0; x--) {
                /* Check and makes sure that x fits into A^2 without remainder 
                and that y-x OR C+B-C+B OR 2B is an even number. */
                long y = AA/x;
                if (AA % x == 0 && (y - x) % 2 == 0)
                    count++;
            }    
            System.out.println(count);
        }
    }
}
