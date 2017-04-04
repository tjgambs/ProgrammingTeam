package w4_acm_contest_scoring;

import java.util.HashMap;
import java.util.Scanner;

// For the judge, this must be package-private.
class Main {
    
    // ACM Contest Scoring - 7350
    // Time to solve: 20 minutes
    // Debug time: 0 minutes
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String,Integer> key = new HashMap();
        int sum = 0;
        int count = 0;
        while(true) {
            int m = sc.nextInt();
            if(m == -1) break;
            String question = sc.next();
            boolean correct = sc.next().equals("right");
            Integer lookup = key.get(question); 
            Integer minutes = (lookup != null ? lookup : 0) + (correct ? 0 : 20);
            key.put(question, minutes);
            if(correct) {
                count++;
                sum += key.get(question) + m;
            }
        }
        System.out.printf("%d %d\n",count,sum);
    }    
}

