import java.util.Scanner;

class Main0 {
    //6095
    public static void main0(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int number = sc.nextInt();
            if(number == 0) break;
            if (number >= 10) {
                System.out.print(number+" ");
            } else {
                System.out.print(number);
            }
            while (number >= 10){
                int ret = 1;
                while(number >= 1) {
                    ret *= number%10;
                    number = number/10;
                }
                if (ret >= 10) {
                    System.out.print(ret + " ");
                } else {
                    System.out.print(ret);
                }
                number = ret;
            }
            System.out.println();
        }       
    }
    
    //6097
    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String line = sc.nextLine();
            if("END".equals(line)) break;
                if (line.replaceAll("\"","").length() != line.length()-2) {
                    System.out.println("not a quine");
                    continue;
                }
                int indexOfLastQuote = line.lastIndexOf("\"");
                if (indexOfLastQuote == line.length()-1) {
                    System.out.println("not a quine");
                    continue;
                }
                if (" ".equals(line.substring(indexOfLastQuote-1,indexOfLastQuote))) {
                    System.out.println("not a quine");
                    continue;
                }
                if (" ".equals(line.substring(1,2))) {
                    System.out.println("not a quine");
                    continue;
                }
                if (!" ".equals(line.substring(indexOfLastQuote+1,indexOfLastQuote+2))) {
                    System.out.println("not a quine");
                    continue;
                }
    
                String sentenceInQuotes = line.substring(1,indexOfLastQuote);
                String sentenceOutsideQuotes = line.substring(indexOfLastQuote+2); 
                if(!sentenceInQuotes.equals(sentenceOutsideQuotes)) {
                    System.out.println("not a quine");
                } else if (" ".equals(line.substring(1,2))) {
                    System.out.println("not a quine");
                } else if (" ".equals(line.substring(indexOfLastQuote-1,indexOfLastQuote))) {
                    System.out.println("not a quine");
            } else {
                System.out.println("Quine("+sentenceInQuotes+")");
            }
        }
    }
    
    //6099  
    public static void main3(String[] args) {
        Scanner sc = new Scanner(System.in);
        int simulationCount = 1;
        while (true) {
            String line = sc.nextLine();
            int N = Integer.parseInt(line.split("[ ]")[0]);
            if (N == 0) return;
            System.out.println("Simulation " + simulationCount);
            char[] input = line.split("[ ]")[1].toCharArray();
            char[] cache = new char[N];
            int[] recentUse = new int[N];
            for(int r = 0; r < recentUse.length; r++) {
                recentUse[r] = -1;
            }
            int count = -1;
            int index = -1;
            for (int i = 0; i < input.length; i++) {
                count++;

                boolean flag = false;
                for (int j = 0; j < cache.length; j++) {
                    if (cache[j] == input[i]) {
                        recentUse[j] = count; 
                        flag = true;
                        break;
                    }
                }
                
                if (input[i] == '!') {
                    int[] dup = recentUse.clone();
                    
                    for (int q = 0; q < dup.length; q++) {
                        int min = Integer.MAX_VALUE;
                        char toPrint = '0';
                        int t = 0;
                        for (int w = 0; w < dup.length; w++) {
                            if (dup[w] < min && dup[w] != -1) {
                                min = recentUse[w];
                                toPrint = cache[w];
                                t = w;
                            }
                        }
                        dup[t] = -1;
                        if(toPrint!='0') {
                            System.out.print(toPrint);
                        }
                    }
                    System.out.println();
                    count--; 
                } else if(!flag) {
                    boolean f = false;
                    for(char c : cache) {
                        if (c == '\u0000') {
                            f = true;
                            break;
                        }
                    }
                    if(f) {
                        index++;
                    } else {
                        int min = recentUse[0];
                        int loc = 0;
                        for (int q = 0; q < recentUse.length; q++) {
                            if(recentUse[q] < min) {
                                min = recentUse[q];
                                loc = q;
                            }
                        }
                        index = loc;
                    }           
                    recentUse[index] = count;
                    cache[index] = input[i];
                }
            }
            simulationCount++;
        }
    }
    
    //6096
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int numLines = Integer.parseInt(sc.nextLine());
            if(numLines == 0) return;
            double[] xCoordinates = new double[numLines+1];
            double[] yCoordinates = new double[numLines+1];
            double currentDegree = 90;
            xCoordinates[0] = 0;
            yCoordinates[0] = 0;
            for (int i = 1; i < numLines+1; i++) {
                String line = sc.nextLine();
                int turn = Integer.parseInt(line.split("[ ]")[0]);
                int move = Integer.parseInt(line.split("[ ]")[1]);
                currentDegree += turn;
                double x = Math.cos(Math.toRadians(currentDegree))*move+xCoordinates[i-1];
                double y = Math.sin(Math.toRadians(currentDegree))*move+yCoordinates[i-1];
                xCoordinates[i] = x;
                yCoordinates[i] = y;
            }

            if (xCoordinates.length >= 4) {
                boolean flag = false;
                for (int k = 0; k < xCoordinates.length-1; k++) {
                    double aX = xCoordinates[k];
                    double aY = yCoordinates[k];
                    double bX = xCoordinates[k+1];
                    double bY = yCoordinates[k+1];
                    for (int m = 0; m < xCoordinates.length-1; m++) {
                        double cX = xCoordinates[m];
                        double cY = yCoordinates[m];
                        double dX = xCoordinates[m+1];
                        double dY = yCoordinates[m+1];
                        double r1 = ((aX-cX)*(dY-cY)-(aY-cY)*(dX-cX))*((bX-cX)*(dY-cY)-(bY-cY)*(dX-cX));
                        double r2 = ((cX-aX)*(bY-aY)-(cY-aY)*(bX-aX))*((dX-aX)*(bY-aY)-(dY-aY)*(bX-aX));

                        if (r1 < 0 && r2 < 0) {
                            System.out.println(m+1);
                            flag = true;
                            break;
                        }
                    }
                    if(flag) break;
                }
                if(!flag) System.out.println("SAFE");
            } else {
                System.out.println("SAFE");
            }
        }
    }
}