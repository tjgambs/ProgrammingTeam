/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package y2010;

import java.util.Scanner;

class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            String row = sc.nextLine();
            if(row.equals("#")) return;
            int y=0,n=0,p=0;
            for (char c:row.toCharArray()) {
                if(c == 'Y') y++;
                else if(c == 'N') n++;
                else if(c == 'P') p++;
            }
            if (((double)(y+n+p)/row.length()) <= 0.5) {
                System.out.println("need quorum");
            } else if (y > n) {
                System.out.println("yes");
            } else if (n > y) {
                System.out.println("no");
            } else {
                System.out.println("tie");
            }
        }
    }
}
