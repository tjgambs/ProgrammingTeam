
package y2011;

import java.util.Scanner;

class Main3 {
    
    // #### - ####
    // Time to solve: # minutes
    // Debug time: 30 minutes
    
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int fdsa = 1;
        while(true) {
            long i = sc.nextLong();
            long j = sc.nextLong();
            if(i == 0 && j == 0) break;
            long value = i * j;
            int iLength = String.valueOf(i).length();
            int jLength = String.valueOf(j).length();
            int valueLength = String.valueOf(value).length();
            System.out.println("Problem "+ fdsa);
            printCharacter(" ", valueLength - iLength);
            System.out.println(i);
            printCharacter(" ", valueLength - jLength);
            System.out.println(j);
            printCharacter("-",valueLength);
            System.out.println();
            
            int counter = 0;
            int numZeros = 0;
            boolean earlyBreak = false;
            for(int x = jLength - 1; x >= 0; x--) {
                int y = Integer.valueOf(String.valueOf(j).charAt(x)+"");
                long rowValue = y * i;
                if(rowValue == 0) {
                    counter++;
                    numZeros++;
                    continue;
                }
                int numSpaces = valueLength - String.valueOf(rowValue).length();
                String toPrint = rowValue+"";
                if(numZeros != 0) {
                    for (int k = 0; k < numZeros; k++) {
                        toPrint += "0";
                    }
                }  
                if(Long.valueOf(toPrint) == value) {
                    earlyBreak = true;
                    break;
                } 
                printCharacter(" ",numSpaces - counter);
                System.out.println(toPrint);
                counter++;
                numZeros = 0;
            }
            if(!earlyBreak) {
                printCharacter("-",valueLength);
                System.out.println();
            }
            System.out.println(value);  
            fdsa++;
        }
    }
    
    public static void printCharacter(String toPrint, int numTimes) {
        for (int i = 0; i < numTimes; i++) {
            System.out.print(toPrint);
        }
    }
}
