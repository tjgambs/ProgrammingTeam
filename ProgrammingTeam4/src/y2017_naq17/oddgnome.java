
package y2017_naq17;

import java.util.Scanner;


class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt();
        for(int i = 0; i < rows; i++) {
            int n = sc.nextInt();
            int previous = sc.nextInt();
            int j;
            int index = -1;
            for (j = 1; j < n; j++) {
                int k = sc.nextInt();
                if((previous+1 != k) && index == -1) {
                    index = j;
                }
                previous = k;
            }
            System.out.println(index+1);
        }
    }
}
