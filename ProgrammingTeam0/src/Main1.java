import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

class Main1 {
    
    // The seven percent solution
    public static void main0(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        while (true) {
            String line = sc.nextLine();
            if (line.equals("#")) {
                break;
            }
            
            String ret = line.replaceAll("[%]","%25");
            ret = ret.replaceAll("[ ]","%20").replaceAll("[!]", "%21")
                    .replaceAll("[$]", "%24").replaceAll("[(]", "%28")
                    .replaceAll("[)]","%29").replaceAll("[*]","%2a");
            System.out.println(ret);
            
        }
    }
    
    // Persistent Bits - exceeds time limit (ask on tuesday)
    public static void main1(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        while (true) {
            String line = sc.nextLine();
            if (line.equals("0")) {
                break;
            }
            
            String[] splitLine = line.split("[ ]");
            
            Integer A = Integer.parseInt(splitLine[0]);
            Integer B = Integer.parseInt(splitLine[1]);
            Integer C = Integer.parseInt(splitLine[2]);
            Integer S = Integer.parseInt(splitLine[3]);
            
            ArrayList<Integer> values = new ArrayList();
            
            while (true) {
                if (values.contains(S)) {
                    break;
                } else {
                    values.add(S);
                    S = (A*S+B)%C;
                }  
            }
            
            ArrayList<String> binaryValues = new ArrayList();
            
            for (Integer value : values) {
                String bVal = addZeros(Integer.toBinaryString(value));
                binaryValues.add(bVal);
            }
            
            String ret = "0000000000000000";
            for (int i = 0; i < 16; i++) {
                int numZeros = 0;
                int numOnes = 0;
                for (int j = 0; j < binaryValues.size(); j++) {
                    String temp = ""+binaryValues.get(j).charAt(i);
                    if(temp.equals("0"))
                        numZeros++;
                    if(temp.equals("1"))
                        numOnes++;
                }
                
                if (numZeros == binaryValues.size())
                    ret = ret.substring(0, i) + "0" + ret.substring(i + 1);
                else if (numOnes == binaryValues.size())
                    ret = ret.substring(0, i) + "1" + ret.substring(i + 1);
                else
                    ret = ret.substring(0, i) + "?" + ret.substring(i + 1);
            }
            
            System.out.println(ret);
            
        }
    }
    
    public static String addZeros(String a) {
        String b = "";
        for(int i = a.length(); i < 16; i++) {
            b += "0";
        }
        return b+a;
    }
    
    // Electronic Document Security - Runtime error?????
    public static void main2(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int counter = 0;
        while (true) {
            String line = sc.nextLine();
            if (line.equals("#")) {
                break;
            }
            String[] commands = line.split("[,]");
            
            Map<String, String> dictionary = new HashMap();
            
            for(String c: commands) {
                String tempUsers = c.split("[-|+|=]")[0];
               
                String operator = c.substring(c.indexOf(tempUsers)+tempUsers.length(),
                                    c.indexOf(tempUsers)+tempUsers.length()+1);
                char[] tempRights = c.substring(c.indexOf(operator)+1).toCharArray();
                char[] splitUsers = tempUsers.toCharArray();
                Arrays.sort(tempRights);
                for(char user: splitUsers) {
                    String oldRights = dictionary.get(user+"");
                    if(oldRights == null) {
                        String rights = new String(tempRights);
                        if (operator.equals("+") || operator.equals("=")) {
                            dictionary.put(""+user, rights);
                        }
                    } else {
                        switch (operator) {
                            case "+":
                                for(char r: tempRights) {
                                    if(oldRights.indexOf(r) == -1) {
                                        char[] a = (oldRights + r).toCharArray();
                                        Arrays.sort(a);
                                        String b = new String(a);
                                        oldRights = b;
                                    }
                                }   break;
                            case "-":
                                for(char r: tempRights) {
                                    oldRights = oldRights.replaceAll(""+r,"");
                                }   char[] a = (oldRights).toCharArray();
                                Arrays.sort(a);
                                String b = new String(a);
                                oldRights = b;
                                break;
                            case "=":
                                oldRights = new String(tempRights);
                                break;
                        }
                        dictionary.put(""+user, oldRights);
                    }
                } 
            }
            
            SortedSet<String> keys = new TreeSet(dictionary.keySet());
            String ret = "";
            int subStringStart = 0;
            for (String key : keys) { 
                String value = dictionary.get(key);
                if(ret.substring(subStringStart).contains(value+",")) {
                    int index = ret.indexOf(value);
                    ret = ret.substring(0,index) + key + ret.substring(index);
                } else {
                    subStringStart += ret.length();
                    if(value.length() != 0)
                        ret += (key + value + ",");
                }
            }
            counter++;
            System.out.println(counter+":"+ret.replaceAll(",",""));
        }
    }
}