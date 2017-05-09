import java.util.Arrays;
import java.util.Scanner;

public class _2004 {
    //C
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int counter = 1;
//        while (true) {
//            int N = Integer.parseInt(sc.nextLine());
//            if(N==0) break;
//            String[] ret = new String[N];
//            boolean flag = true;
//            int end = N-1;
//            int start = 0;
//            for (int i = 0; i < N; i++) {
//                
//                String str = sc.nextLine();
//                if (flag) {
//                    ret[start] = str;
//                    start++;
//                } else {
//                    ret[end] = str;
//                    end--;
//                }
//                flag = !flag;
//            }
//            
//            System.out.println("SET "+counter);
//            
//            for (int i = 0; i < ret.length;i++) {
//                System.out.println(ret[i]);
//            }
//            counter++;
//        }
//    }
    
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        while(true) {
//            int N = sc.nextInt();
//            if(N==-1) break;
//            int lasthour = 0;
//            int distance = 0;
//            for(int i = 0; i < N; i++) {       
//                int speed = sc.nextInt();
//                int time = sc.nextInt();       
//                lasthour = time-lasthour;               
//                distance += speed*lasthour;               
//                lasthour = time; 
//            }
//            System.out.println(distance+" miles");
//        }
//    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            int WIDTH = sc.nextInt();
            if(WIDTH==0) break;   
            int MAX_WIDTH = 0;
            int MAX_HEIGHT = 0;
            int tempWidth = 0;
            int tempHeight = 0;
            for(int i = 0; i < 15; i++) {
                int width = sc.nextInt();
                int height = sc.nextInt();
                
                if(width==-1&height==-1) 
                    break;
                
                tempWidth += width;
                
                if (tempWidth>WIDTH) {
                    tempWidth = width;
                    MAX_HEIGHT += tempHeight;
                    tempHeight = height;       
                } else {
                    if(MAX_WIDTH<tempWidth) {
                        MAX_WIDTH = tempWidth;
                    }
                    if(height>tempHeight) {
                        tempHeight=height;
                    }
                }
            }        
            MAX_HEIGHT += tempHeight; 
            System.out.println(MAX_WIDTH +" x "+ MAX_HEIGHT);
        }
    }
}

