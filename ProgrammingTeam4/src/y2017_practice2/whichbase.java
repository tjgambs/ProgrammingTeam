
package y2017_practice2;

import java.util.Scanner;


class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0; i < n; i++) {
            int row = sc.nextInt();
            int toConvert = sc.nextInt();
            
            String b8 = Integer.toOctalString(toConvert);
            String b10 = Integer.toString(toConvert, 10);
            String b12 = Integer.toString(toConvert, 12);
            System.out.println(b8 + " " + b10 + " " + b12);
        }
    }
}
