
package y2010;

import java.util.Scanner;

class Main1 {
    public static void main (String args[]) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            int n = sc.nextInt();
            if(n == 0) return;
            int previous = 0;
            String s = "";
            for (int i = 1; i < n+1; i++) {
                int current = sc.nextInt();
                int total = current - previous;
                for (int j = 0; j < total; j++) {
                    System.out.print(s + i);
                    s = " ";
                }
                previous = current;
            }
            System.out.println();
        }
    }
}
