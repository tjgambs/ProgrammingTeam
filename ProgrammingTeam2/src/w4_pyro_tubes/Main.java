package w4_pyro_tubes;

import java.util.ArrayList;
import java.util.Scanner;

// For the judge, this must be package-private.
class Main {

    // Pyro Tubes - 7357
    // Time to solve: 60 minutes
    // Debug time: 0 minutes
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> input = new ArrayList();
        while (true) {
            Integer i = sc.nextInt();
            if (i == -1)
                break;
            input.add(i);
        }
        for (int x : input) {
            int count = 0;
            for (int i = (1 << 17); i > 0; i >>= 1) {
                if ((x^i) < x)
                    continue;
                if (input.contains(x^i))
                    count++;
                for (int j = (i >> 1); j > 0; j >>= 1) {
                    if ((x^i^j) < x) 
                        continue;
                    if (input.contains(x^i^j))
                        count++;
                }
            }
            System.out.printf("%d:%d",x,count);
        }
    }
}
