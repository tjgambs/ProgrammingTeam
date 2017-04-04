
package w5_the_calculus_of_ada;

import java.util.Scanner;

// For the judge, this must be package-private.
class Main {
    
    // The Calculus of Ada - 7696
    // Time to solve: 20 minutes
    // Debug time: 0 minutes
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] numbers = new int[n];
        for(int i = 0; i < n; i++)
            numbers[i] = sc.nextInt();
        int depth = 0;
        while(!isSame(numbers, depth)) {
            for(int i = 1; i<numbers.length-depth; i++)    
                numbers[i-1] = numbers[i] - numbers[i-1];  
            depth++;
        }
        int sum = 0;
        for(int i = numbers.length-1; i >= numbers.length-depth-1; i--)
            sum += numbers[i];
        System.out.printf("%d %d", depth, sum);
    }  
    
    public static boolean isSame(int[] arr, int depth) {
        if(arr.length < 2) return true;
        for (int i = 1; i < arr.length-depth; i++)
            if(arr[i] != arr[i-1]) return false;
        return true;
    }
}