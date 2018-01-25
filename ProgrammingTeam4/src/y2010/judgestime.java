
package y2010;

import java.util.Scanner;


class Main3 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0; i < n; i++) {
            int h = sc.nextInt();
            int m = -sc.nextInt();
            int th = sc.nextInt()+1;
            int tm = sc.nextInt();
            if(tm+(-m) >= 60) th++;
            System.out.println("------+---------");
            System.out.println(" time | elapsed");
            System.out.println("------+---------");
            for(int j = 0; j < th; j++) {
                int lengthOfHour = String.valueOf(h).length();
                if(lengthOfHour == 1) {
                    System.out.print(" "+h+":XX | XX");
                } else {
                    System.out.print(h+":XX | XX");
                }
                if(m < 0) {
                    System.out.println(" - "+(-m));
                } else if(m > 0) {
                    System.out.println(" + "+m);
                } else {
                    System.out.println();
                }
                m += 60;
                h = (h==12) ? 1 : h+1;
            }
        }
    }
}
