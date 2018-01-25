
package y2014;

import java.util.Scanner;


class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cloud = 1;
        while(true) {
            int maxWidth = sc.nextInt();
            int n = sc.nextInt();
            if(maxWidth == 0 && n == 0) break;
            String[] words = new String[n];
            int[] counts = new int[n];
            int maxCount = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                words[i] = sc.next();
                counts[i] = sc.nextInt();
                if(counts[i] > maxCount) 
                    maxCount = counts[i];
            }
            int totalHeight = 0;
            int previousHeight = 0;
            int currentHeight = 0;
            int currentWidth = 0;
            int padding = 0;
            for(int i = 0; i < n; i++) {
                int pointSize = 8 + (int)Math.ceil((40.0*(counts[i]-4))/(maxCount-4));
                int width = (int)Math.ceil((9.0/16.0)*words[i].length()*pointSize);     
                if((padding+currentWidth+width) > maxWidth) {
                    currentWidth = 0;
                    previousHeight = currentHeight;
                    totalHeight += currentHeight;
                    currentHeight = 0;
                    padding = 0;
                }
                if((padding+currentWidth+width) <= maxWidth) {
                    currentWidth = padding+currentWidth+width;
                    if(pointSize > currentHeight)
                        currentHeight = pointSize;
                    padding = 10;
                }
            }
            totalHeight += currentHeight;
            System.out.println("CLOUD "+cloud+": "+totalHeight);
            cloud++;
        }
    }
}
