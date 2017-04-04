
package w3_reverse_rot;

import java.util.Scanner;

// For the judge, this must be package-private.
class Main {
    
    // Reverse Rot - 6818
    // Time to solve: 10 minutes
    // Debug time: 0 minutes
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            int N = sc.nextInt();
            String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ_.";
            if (N == 0) return;
            char[] todo = sc.next().toCharArray();
            for (int i = todo.length-1; i>=0; i--) {
                int offset = N%28;
                int index = alphabet.indexOf(todo[i])+offset;
                if(index > 27) index -= 28;
                System.out.print(alphabet.charAt(index));
            }
            System.out.println();
        }
    }    
}

