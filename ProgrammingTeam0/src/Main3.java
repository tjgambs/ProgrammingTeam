import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main3 {
    
    //Gnome Sequencing
    public static void main0(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        int num = Integer.parseInt(line);
        String[] ret = new String[num];
        for (int i = 0; i < num; i++) {
            line = sc.nextLine();
            String[] stringArr = line.split("[ ]");
            int[] numbers = new int[stringArr.length];
            for(int j = 0; j < stringArr.length; j++) {
                numbers[j] = Integer.parseInt(stringArr[j]);
            }
            
            boolean growing = true;
            if(numbers[0] > numbers[1]) {
                growing = false;
            }
            
            boolean flag = true;
            for (int k = 1; k < numbers.length-1; k++) {
                if((numbers[k] < numbers[k+1]) && !growing) {
                    flag = false;
                    break;
                } else if ((numbers[k+1] < numbers[k]) && growing) {
                    flag = false;
                    break;
                }
            }
            if(flag) {
                ret[i] = "Ordered";
            } else {
                ret[i] = "Unordered";
            }

        }
        System.out.println("Gnomes:");
        for (String ret1 : ret) {
            System.out.println(ret1);
        }
    }
    
    //Rock, Paper, Scissors
    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> ret = new ArrayList();
        while(true) {
            String line1 = sc.nextLine();
            String line2 = sc.nextLine();
            if(line1.equals("E") && line2.equals("E"))
                break;
            char[] p1 = line1.toCharArray();
            char[] p2 = line2.toCharArray();
            
            int p1Win = 0;
            int p2Win = 0;
            for(int i = 0; i < p1.length; i++) {
                if(p1[i] == 'R' && p2[i] == 'S') {
                    p1Win++;
                }
                if(p2[i] == 'R' && p1[i] == 'S') {
                    p2Win++;
                }
                if(p1[i] == 'R' && p2[i] == 'P') {
                    p2Win++;
                }
                if(p2[i] == 'R' && p1[i] == 'P') {
                    p1Win++;
                }
                if(p1[i] == 'S' && p2[i] == 'P') {
                    p1Win++;
                }
                if(p2[i] == 'S' && p1[i] == 'P') {
                    p2Win++;
                }
            }
            ret.add("P1: " + p1Win);
            ret.add("P2: " + p2Win);
        }
        
        for (String a: ret) {
            System.out.println(a);
        }
    }
    
    //Duplicate Removal
    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            String line = sc.nextLine();
            if("0".equals(line)) {
                break;
            }
            
            String[] stringArr = line.split("[ ]");
            ArrayList<Integer> numbers = new ArrayList();
            Integer dontAdd = -1;
            for(int j = 0; j < stringArr.length-1; j++) {
                
                if(dontAdd == -1) {
                    dontAdd = Integer.parseInt(stringArr[j+1]);
                    numbers.add(Integer.parseInt(stringArr[j+1]));
                } else {
                    if(dontAdd != Integer.parseInt(stringArr[j+1])) {
                        numbers.add(Integer.parseInt(stringArr[j+1]));
                    }
                    dontAdd = Integer.parseInt(stringArr[j+1]);
                }
            }
            
            for(Integer a : numbers) {
                System.out.print(a+" ");
            }
            System.out.println("$");
        }
    }
    
    //Don't have time to finish this beast
    public static void main4(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        
        int numberOfDulls = Integer.parseInt(line.split("[ ]")[0]);
        int numberOfPrograms = Integer.parseInt(line.split("[ ]")[1]);
        int numberOfStateTransitions = Integer.parseInt(line.split("[ ]")[2]);
        
        String[] stringDulls = sc.nextLine().split("[ ]");
        int[] dullSizes = new int[stringDulls.length];
        for(int j = 0; j < stringDulls.length; j++) {
            dullSizes[j] = Integer.parseInt(stringDulls[j]);
        }
        
        int[] sizeOfProgram = new int[numberOfPrograms];
        String[] requiredDulls = new String[numberOfPrograms];
        for(int i = 0; i < numberOfPrograms; i++) {
            String[] linei = sc.nextLine().split("[ ]");       
            sizeOfProgram[i] = Integer.parseInt(linei[0]);
            requiredDulls[i] = linei[1];
        }
        
        String[] stringTransitions = sc.nextLine().split("[ ]");
        int[] transitions = new int[stringTransitions.length];
        for(int j = 0; j < stringTransitions.length; j++) {
            transitions[j] = Integer.parseInt(stringTransitions[j]);
        }

        Map<String, Integer> numberUsing = new HashMap();
        Map<String, Integer> sizeOf = new HashMap();
        for (int i = 1; i < dullSizes.length+1; i++) {
            numberUsing.put(getCharForNumber(i), 0);
            sizeOf.put(getCharForNumber(i), sizeOfProgram[i-1]);
        }
        
        int memory = 0;
        int maxMemory = 0;
        for(int i = 0; i < transitions.length; i++) {
            
            boolean negative = false;
            if(transitions[i] < 0)
                negative = true;
            
            int transitionNum = Math.abs(transitions[i]);
            
            if(negative) {
                memory += sizeOfProgram[transitionNum-1];
            } else {
                memory -= sizeOfProgram[transitionNum-1];
            }

            String[] neededDulls = requiredDulls[transitionNum-1].split("");
            for(String a : neededDulls) {
                if (negative) {
                    numberUsing.put(a, numberUsing.get(a)-1);
                    if(numberUsing.get(a) == 0)
                        memory -= sizeOf.get(a);
                } else {
                    numberUsing.put(a, numberUsing.get(a)+1);
                    if(numberUsing.get(a) == 1)
                        memory += sizeOf.get(a);
                }
            }
            
            if(memory > maxMemory)
                maxMemory = memory;

        }
        System.out.println(maxMemory);
        
    }
    
    private static String getCharForNumber(int i) {
        return i > 0 && i < 27 ? String.valueOf((char)(i + 64)) : null;
    }
       
}
