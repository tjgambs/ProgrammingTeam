
package w1_is_the_name_of_this_problem;

import java.util.Scanner;

// For the judge, this must be package-private.
class Main {
    
    // Is the Name of This Problem - 6097
    // Time to solve: 30 minutes
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            String in = sc.nextLine();
            if(in.equals("END")) return;
            int firstQuote = in.indexOf("\"");
            int lastQuote = in.substring(firstQuote+1).indexOf("\"")+1;
            if(lastQuote <= 1) {
                System.out.println("not a quine");
                continue;
            }
            String inQuotes = in.substring(1,lastQuote);
            String outQuotes = in.substring(lastQuote+1);
            Boolean equals = (" "+inQuotes).equals(outQuotes);
            if(equals) {
                System.out.printf("Quine(%s)\n",inQuotes);
            } else {
                System.out.println("not a quine");
            }
        }
    }
}
