
package y2010;

import java.util.Scanner;

class Main2 {
    public static void main (String args[]) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            String line = sc.nextLine();
            if(line.equals("#")) return;
            String a = "iovwxbdpq";
            String b = "iovwxdbqp";
            boolean failure = false;
            StringBuilder sb = new StringBuilder();
            for(int i = line.length(); i > 0; i--) {
                int j = a.indexOf(line.substring(i-1,i));
                if(j < 0) {
                    failure = true;
                    break;
                }
                sb.append(b.charAt(j));
            }
            System.out.println(failure ? "INVALID" : sb.toString());
        }    
    }
}
