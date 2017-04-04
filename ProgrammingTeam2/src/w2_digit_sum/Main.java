
package w2_digit_sum;

import java.util.Arrays;
import java.util.Scanner;

// For the judge, this must be package-private.
class Main {
    
    //Digit Sum - 6497
    // Time to solve: 30 minutes
    // Debugging: 15 minutes
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            int num = sc.nextInt();
            if (num == 0) return;
            int[] data = new int[num];
            for(int i = 0; i < num; i++) {
                data[i] = sc.nextInt();
            }
            Arrays.sort(data);
            // Zeros, although small, are not allowed in the front. Let's fix that.
            int in;
            for(in = 0; in < data.length && data[in] == 0; in++) { } // Because it is sorted.
            if (in > 0) {
                // If there is a zero, we need to move two numbers in front. In specifies the
                // location of that number.
                data[0] = data[in];
                data[in] = 0;
                data[1] = data[in+1];
                data[in+1] = 0;
            }
            // Create numbers using strings then Integer.parseInt()
            String firstNum = "";
            String secondNum = "";
            for(int i = data.length-1; i>=0; i--) {
                if(i%2 == 0) {
                    firstNum = data[i]+firstNum;
                } else {
                    secondNum = data[i]+secondNum;
                }
            }
            int sum = Integer.parseInt(firstNum) + Integer.parseInt(secondNum);
            System.out.println(sum);
        }
    }    
}
