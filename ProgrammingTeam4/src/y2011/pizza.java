
package y2011;




import java.util.Scanner;

// For the judge, this must be package-private.
class Main {
    
    // #### - ####
    // Time to solve: # minutes
    // Debug time: 10 minutes
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int counter = 1;
        while(true) {
            int numPizzas = sc.nextInt();
            if (numPizzas == 0) return;
            double maxValue = Double.MAX_VALUE;
            int bestValueDiameter = -1;
            for(int i = 0; i < numPizzas; i++) {
                int d = sc.nextInt();
                int p = sc.nextInt();
                double pricePerSqft = p / (Math.PI * (d/2) * (d/2));
                if (pricePerSqft < maxValue) {
                    maxValue = pricePerSqft;
                    bestValueDiameter = d;
                }
            }
            System.out.println("Menu " + counter + ": " + bestValueDiameter);
            counter++;
        }
    }    
}

