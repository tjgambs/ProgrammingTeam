
import java.util.Scanner;

class Main8 {

    //Firefly
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = 1;
        while (true) {

            double speed = in.nextInt();
            double x = in.nextInt();
            double y = in.nextInt();
            boolean caught = false;

            if (speed == 0)
                break;

            while (true) {
                int fireflyX = in.nextInt();
                int fireflyY = in.nextInt();

                if (fireflyX == -1)
                    break;
                
                //a2 + b2 = c2 -> c = sqrt(a2+b2)
                double d = Math.sqrt((Math.pow(fireflyX - x, 2)) + Math.pow(fireflyY - y, 2));
                if (d - speed <= 1 && !caught) {
                    System.out.println("Firefly " + count + " caught at (" + fireflyX + "," + fireflyY + ")");
                    caught = true;
                } else if (!caught) {
                    x += (speed / d) * (fireflyX - x);
                    y += (speed / d) * (fireflyY - y);
                }
            }
            if (!caught) {
                System.out.println("Firefly " + count + " not caught");
            }
            count++;
        }
    }
}
