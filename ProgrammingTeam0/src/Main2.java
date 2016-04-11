import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

class Main2 {
    
    // Problem A: Parity
    public static void main0(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        while (true) {
            String line = sc.nextLine();
            if (line.equals("#")) {
                break;
            }
            
            char[] charArray = line.toCharArray();
            int numOne = 0;
            String lastLetter = "";
            String ret = "";
            for(char c: charArray) {
                if(c == '1') numOne++;
                else
                    lastLetter = ""+c;
            }
            if(lastLetter.equals("o")) {
                if(numOne%2==1) {
                    ret = line.replace("o","0");
                } else {
                    ret = line.replace("o","1");
                    //add a one
                }
            } else {
                if(numOne%2==0) {
                    ret = line.replace("e","0");
                    //add a zero
                } else {
                    ret = line.replace("e","1");
                    //add a one
                }
            }

            System.out.println(ret);
            
        }
    }
    
    //I cannot, for the life of me figure out why this is not working... my brain hurts.
    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String firstLine = sc.nextLine();
            if (firstLine.equals("0")) {
                break;
            }
            
            String[] array0 = firstLine.split("[ ]");
            int counter = 0;
            int n = Integer.parseInt(array0[0]);
            int w = Integer.parseInt(array0[1]);
            int h = Integer.parseInt(array0[2]);
            
            ArrayList<Integer> sortedxVals = new ArrayList<>();
            ArrayList<Integer> sortedyVals = new ArrayList<>();

            int[] xlVals = new int[n];
            int[] xhVals = new int[n];
            int[] ylVals = new int[n];
            int[] yhVals = new int[n];
            
            sortedxVals.add(0);
            sortedyVals.add(0);
            
            int xIndex = 0;
            int yIndex = 0;
            
            while(counter != n) {
                String line = sc.nextLine();
                String[] array1 = line.split("[ ]");
                
                int xl = Integer.parseInt(array1[0]);
                int yl = Integer.parseInt(array1[1]);
                int xh = Integer.parseInt(array1[2]);
                int yh = Integer.parseInt(array1[3]);
                
                if(!sortedxVals.contains(xl)) {
                    sortedxVals.add(xl);
                }      
                if(!sortedyVals.contains(yl)) {
                    sortedyVals.add(yl);
                }
                if (!sortedxVals.contains(xh)) {  
                    sortedxVals.add(xh);
                }
                if (!sortedyVals.contains(yh)) {
                    sortedyVals.add(yh);
                }
                
                xlVals[counter] = xl;
                xhVals[counter] = xh;
                ylVals[counter] = yl;
                yhVals[counter] = yh;
                
                counter++;
            }
            
            if (!sortedxVals.contains(w)) {
                sortedxVals.add(w);
            }
            if (!sortedyVals.contains(h)) {
                sortedyVals.add(h);
            }
            
            Collections.sort(sortedxVals);
            Collections.sort(sortedyVals);
            
            System.out.println(sortedxVals);
             System.out.println(sortedyVals);
             System.out.println(Arrays.toString(xlVals));
             System.out.println(Arrays.toString(ylVals));
             System.out.println(Arrays.toString(xhVals));
             System.out.println(Arrays.toString(yhVals));
            
            int maxDepth = 0;
            int clearArea = 0;
            int maxDepthArea = 0;
            
            for(int i = 1; i < sortedxVals.size(); i++) {
                for(int j = 1; j < sortedyVals.size(); j++) {
                    
                    int depth = 0;
                    for(int k = 0; k < n; k++) {
                        
                        if (xlVals[k] <= sortedxVals.get(i-1) && sortedxVals.get(i) <= xhVals[k]  &&
                               ylVals[k] <= sortedyVals.get(j-1) && sortedyVals.get(j) <= yhVals[k]) 
                             depth++;

                        int area = (sortedxVals.get(i) - sortedxVals.get(i-1))*(sortedyVals.get(j) - sortedyVals.get(j-1));
                        System.out.println(depth+"["+sortedxVals.get(i) +"-"+ sortedxVals.get(i-1)+"]*["+sortedyVals.get(j)+"-"+ sortedyVals.get(j-1)+"]");
                        
                        if (depth == 0)
                            clearArea += area;
                        else if ( depth == maxDepth)
                            maxDepthArea += area;
                        else if (depth > maxDepth) {
                            maxDepthArea = area;
                            maxDepth = depth;
                        }
                    }
                    
                }
            }
             System.out.format("%d %d %d%n", clearArea, maxDepth, maxDepthArea);
        }
    }
 }

    