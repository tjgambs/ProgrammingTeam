
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main4 {
    //Mad Scientist
    public static void main0(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            String line = sc.nextLine();
            if("0".equals(line)) {
                break;
            }
            String[] intString = line.split("[ ]");
            int[] intArr = new int[intString.length];
            int count = 0;
            for(String a : intString) {
                intArr[count] = Integer.parseInt(a);
                count++;
            }
            
            printMe(1,intArr[1]);
            
            if(intArr.length > 2) {
                for(int i = 2; i < intArr.length; i++) {
                    printMe(i,intArr[i]-intArr[i-1]);
                }
            }
            
            System.out.println();
            
        }
    }
    private static void printMe(int printThis, int howManyTimes) {
       for(int i = 0; i < howManyTimes; i++) {
           System.out.print(printThis + " ");
       }
    }
    
    
    //Voting
    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            String line = sc.nextLine();
            if("#".equals(line)) {
                break;
            } 
            
            char[] charArr = line.toCharArray();
            int Y = 0;
            int N = 0;
            int P = 0;
            int A = 0;
            int numberOfPeople = charArr.length;
            for(char c : charArr) {
                switch(c) {
                    case 'Y':
                        Y++;
                        break;
                    case 'N':
                        N++;
                        break;
                    case 'P':
                        P++;
                        break;
                    case 'A':
                        A++;
                        break;
                }
            }
            
            if(numberOfPeople % 2 == 1) {
                if(A >= (numberOfPeople+1)/2) {
                    System.out.println("need quorum");
                } else if(Y == N) {
                    System.out.println("tie");
                } else if (Y > N) {
                    System.out.println("yes");
                } else if(Y < N) {
                    System.out.println("no");
                }
            } else {
                if(A >= numberOfPeople/2) {
                    System.out.println("need quorum");
                } else if(Y == N) {
                    System.out.println("tie");
                } else if (Y > N) {
                    System.out.println("yes");
                } else if(Y < N) {
                    System.out.println("no");
                }
            }   
        }
    }
    
    //Mirror, mirror on the wall
    public static void main2(String[] args) {
        Map<String,String> a = new HashMap();
        a.put("b","d");
        a.put("d","b");
        a.put("p","q");
        a.put("q","p");
        a.put("i","i");
        a.put("o","o");
        a.put("v","v");
        a.put("w","w");
        a.put("x","x");
        
        Scanner sc = new Scanner(System.in);
        while(true) {
            String line = sc.nextLine();
            if("#".equals(line)) {
                break;
            }
            
            char[] charArr = line.toCharArray();
            String ret = "";
            for(int i = charArr.length-1; i >= 0; i--) {
                if(a.get(charArr[i]+"") != null) {
                    ret += a.get(charArr[i]+"");
                } else {
                    System.out.println("INVALID");
                    break;
                }
            }
            if(ret.length() == charArr.length) {
                System.out.println(ret);
            }
            
        }
    }
    
    //judges time calculation
    public static void main3(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        for(int j = 0; j < number; j++) {
            int SH = sc.nextInt();
            int SM = sc.nextInt();
            int DH = sc.nextInt();
            int DM = sc.nextInt();
            
            int numOfMinutes = (60*DH) + DM;
            int end = (SM + numOfMinutes) / 60 + SH;
            
            System.out.println("------+---------");
            System.out.println(" time | elapsed");
            System.out.println("------+---------");
            
            int i = -SM;
            for (int hour = SH; hour <= end; hour++) {
                int printHour = hour;
                if(hour > 12) {
                    printHour = hour-12;
                }
                
                if (printHour < 10) {
                    System.out.print(" ");
                }
                
                System.out.print(printHour + ":XX | XX");
                
                if (i < 0) {
                    System.out.print(" - " + -i);
                } else if (i > 0) {
                    System.out.print(" + " + i);
                }
                System.out.println();
                i+=60;
            } 
        }
    }

    // Egyptian Fractions
    static long gcd(long a, long b) {
        if (b == 0)
            return a;
        return gcd(b,a%b);
    }
    
    public static void main4(String[] args) {
        Scanner in = new Scanner(System.in);
        long MAX = 1000000;
        while(true) {
            long m  = in.nextInt();
            long n = in.nextInt();
            
            if (m == 0 && n == 0) {
                break;
            }
            
            while (m > 0) {
                long c;
                long bottom = (n + m - 1) / m;
                while (true) {
                    c = gcd((m*bottom)-n, n*bottom);                    
                    if ((n*bottom)/c < MAX)
                        break;
                    bottom++;
                }
                System.out.print(bottom+" ");
               
                m = (m*bottom - n)/c;
                n = (n*bottom)/c;
            }
            System.out.println();
        }
    }
    
    
    //image compression - NOT WORKING
//    public static void main5(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        while(true) {
//            String line = sc.nextLine();
//            if("0".equals(line)) {
//                break;
//            }
//            
//            int W = Integer.parseInt(line.split("[ ]")[0]);
//            int T = Integer.parseInt(line.split("[ ]")[1]);
//            
//            int[][] intMatrix = new int[W][W];
//            
//            for(int i = 0; i < W; i++) {
//                String zeroOne = sc.nextLine();
//                String[] zeroOneInts = zeroOne.split("");
//                for(int j = 0; j < W; j++) {
//                    intMatrix[i][j] = Integer.parseInt(zeroOneInts[j]);
//                }
//            }
//            
//            int[][] ret = recursiveHelper(0,0,W,T);
//            
//            for(int k = 0; k < ret.length; k++) {
//                System.out.println(Arrays.toString(ret[k]));
//            }
//                  
//        }
//   
//    }
//    private static int[][] recursiveHelper(int x, int y, int w, int t) {
//        
//        recursiveHelper(x,y,w/2,t);
//        recursiveHelper(x,y+w/2,w/2,t);
//        recursiveHelper(x+w/2,y,w/2,t);
//        recursiveHelper(x+w/2,y+w/2,w/2,t);
//
//    }
    
}
