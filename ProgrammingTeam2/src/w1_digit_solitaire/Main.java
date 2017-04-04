/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package w1_digit_solitaire;

import java.util.Scanner;

// For the judge, this must be package-private.
class Main {
    
    // Digit Solitaire - 6095
    // Time to solve: 15 minutes
    
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            int S = sc.nextInt();
            if (S==0) return;
            if (S >= 10) System.out.print(S+" ");
            else System.out.print(S);
            while (S >= 10) {
                int total = 1;
                while(S > 0) {
                    total *= (S % 10);
                    S /= 10;
                }
                S = total;
                if (S >= 10) System.out.print(total+" ");
                else System.out.print(total);
            }
            System.out.println(); 
        }
    }
}
