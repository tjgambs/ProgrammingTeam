package w4_line_them_up;


import java.util.Scanner;

// For the judge, this must be package-private.
class Main {
    
    // Line Them Up - 7355
    // Time to solve: 15 minutes
    // Debug time: 5 minutes
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String[] arr = new String[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.next();
        }
        boolean isIncreasing = true;
        boolean isDecreasing = true;
        for (int i = 1; i < arr.length; i++) {
            int cmp = arr[i - 1].compareTo(arr[i]);
            if (cmp > 0) {
                isIncreasing = false;
            } else {
                isDecreasing = false;
            }
            if(!isIncreasing && !isDecreasing) {
                System.out.println("NEITHER");
                return;
            }
        }
        System.out.println(isDecreasing ? "DECREASING" : "INCREASING");
    }    
}

