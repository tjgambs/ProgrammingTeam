
import java.util.Arrays;

class Main {

    public static int go(int[] num) {
        Arrays.sort(num); // O(nlogn)
        int counter = 0;
        for (int i = 0; i < num.length-2; i++) { //O(n)
            if (i > 0 && num[i - 1] == num[i]) {
                continue;
            }
            int target = -num[i];
            int j = i + 1;
            int k = num.length - 1;
            while (j < k) { //O(n)
                if (num[j] == num[j - 1]) {
                    j++;
                } else if (num[j] + num[k] > target) {
                    k--;
                } else if (num[j] + num[k] < target) {
                    j++;
                } else {
                    //System.out.print("[" + num[i] + " " + num[j] + " " + num[k] + "] ");
                    counter++;
                    j++;
                    k--;
                }
            }
        }
        //Time complexity O(n^2)
        //System.out.println();
        return counter;
    }
    
    public static int[] randomList(int n) {
        int[] ret = new int[n];
        for(int i = 0; i < n; i++) {
            double a = (Math.random() < 0.5 ? -1 : 1)*Math.random()*n;
            ret[i] = (int)a;
        }
        return ret;
    }
    
    public static void test(int n) {
        int[] num = randomList(n);
        System.out.println("N: " + n);
        long startTime = System.currentTimeMillis();
        System.out.println("Number of triplets: " + go(num));
        long endTime = System.currentTimeMillis();
        long duration = (endTime - startTime);
        System.out.println("Run time: " + duration + " milliseconds");
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {6, -4, 4, -2, -3, -1, 3, 5};
        System.out.println("Number of triplets: " + go(arr));
        //Tests
//        test(1000);
//        test(2000);
//        test(4000);
//        test(8000);
//        test(16000);
//        test(32000);
//        test(64000);
//        test(128000);
//        test(256000);
//        test(512000);
//        test(1024000);
//        test(2048000);
    }
}
