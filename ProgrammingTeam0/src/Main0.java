
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class Main0 {

    //Quicksum
    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            String line = sc.nextLine();
            if (line.equals("#")) {
                break;
            }

            char[] input = line.toCharArray();
            int result = 0;
            int index = 1;
            for (char i : input) {
                result += (index * ((int) i % 32));
                index++;
            }
            System.out.println(result);
        }
    }

    //Linear Pachinko
    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            String line = sc.nextLine();
            if (line.equals("#")) {
                break;
            }

            char[] input = line.toCharArray();
            int divisor = 0;
            int dividend = 0;
            for (int i = 0; i < input.length; i++) {
                switch (input[i]) {
                    case '\\': //Going to the right
                        int j;
                        for (j = i + 1; j < input.length; j++) {
                            if (input[j] == '|' || input[j] == '/') {
                                break;
                            } else if (input[j] == '.') {
                                dividend += 100;
                                break;
                            }
                        }
                        if (j == input.length) {
                            dividend += 100;
                        }
                        break;
                    case '/': //Going to the left
                        int k;
                        for (k = i - 1; k >= 0; k--) {
                            if (input[k] == '|' || input[k] == '\\') {
                                break;
                            } else if (input[k] == '.') {
                                dividend += 100;
                                break;
                            }
                        }
                        if (k == -1) {
                            dividend += 100;
                        }
                        break;
                    case '|': //50/50 odds
                        int odds = 0;

                        //Calculate left
                        int m;
                        for (m = i - 1; m >= 0; m--) {
                            if (input[m] == '|' || input[m] == '\\') {
                                break;
                            } else if (input[m] == '.') {
                                odds += 100;
                                break;
                            }
                        }
                        if (m == -1) {
                            odds += 100;
                        }

                        //Calculate right
                        int n;
                        for (n = i + 1; n < input.length; n++) {
                            if (input[n] == '|' || input[n] == '/') {
                                break;
                            } else if (input[n] == '.') {
                                odds += 100;
                                break;
                            }
                        }
                        if (n == input.length) {
                            odds += 100;
                        }

                        //Take average of the two
                        dividend += odds / 2;
                        break;
                    case '.': //Reached a hole, 100
                        dividend += 100;
                        break;
                }
                divisor++;
            }
            System.out.println(dividend / divisor);
        }
    }

    // Surprising Strings
    public static void main3(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String line = sc.nextLine();
            if (line.equals("*")) {
                break;
            }

            char[] input = line.toCharArray();
            int count = 1;
            int index = 0;
            boolean flag = false;
            boolean surprising = true;

            while (true) {
                String[] arr = new String[input.length * input.length];
                for (int i = 0; i < input.length - count; i++) {
                    flag = true;
                    if (Arrays.asList(arr).contains(input[i] + "" + input[i + count])) {
                        surprising = false;
                        break;
                    }
                    arr[index] = input[i] + "" + input[i + count];
                    index++;
                }
                if (flag) {
                    flag = false;
                } else {
                    break;
                }
                count++;
            }
            if (surprising) {
                System.out.println(line + " is surprising.");
            } else {
                System.out.println(line + " is NOT surprising.");
            }
        }
    }

    //Frugal Search
    public static void main4(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<String> ret = new ArrayList();
        
        OUTER:
        while (true) {

            ArrayList<String> terms = new ArrayList();
            ArrayList<String> querys = new ArrayList();

            boolean oneStar = false; 

            while (true) {
                String line = sc.nextLine();
                if (line.equals("#")) {
                    break OUTER;
                } else if (line.equals("*")) {
                    oneStar = true;
                } else if (line.equals("**")) {
                    break;
                } else {
                    if (!oneStar) {
                        terms.add(line);
                    } else {
                        querys.add(line);
                    }
                }
            }
                      
            for (int i = 0; i < querys.size(); i++) {

                String[] subQuery = querys.get(i).split("\\|");
                ArrayList<String> goodTerms = new ArrayList();
                
                for (String q : subQuery) {

                    char[] letters = q.toCharArray();

                    ArrayList<String> atLeastOne = new ArrayList();
                    ArrayList<String> need = new ArrayList();
                    ArrayList<String> dontNeed = new ArrayList();

                    boolean onToSigned = false;

                    for (int j = 0; j < letters.length; j++) {
                        if (letters[j] == '+' || letters[j] == '-') {
                            onToSigned = true;
                        }
                        if (!onToSigned) {
                            atLeastOne.add("" + letters[j]);
                        } else {
                            if (letters[j] == '+') {
                                need.add("" + letters[j + 1]);
                                j++;
                            } else if (letters[j] == '-') {
                                dontNeed.add("" + letters[j + 1]);
                                j++;
                            }
                        }
                    }
                    
                    for (String s : terms) {
                        boolean good = true;
                        boolean tempFlag = false;
                        for (int m = 0; m < atLeastOne.size(); m++) {
                            if (s.contains(atLeastOne.get(m) + "")) {
                                tempFlag = true;
                                break;
                            }
                        }
                        if (!tempFlag) {
                            good = false;
                        }
                        
                        for (int n = 0; n < need.size(); n++) {
                            if (!s.contains(need.get(n) + "")) {
                                good = false;
                                break;
                            }
                        }
                        
                        for (int p = 0; p < dontNeed.size(); p++) {
                            if (s.contains(dontNeed.get(p) + "")) {
                                good = false;
                                break;
                            }
                        }
                        
                        if(good) {
                            goodTerms.add(s);
                        }
                    }    
                }
                        
                if(goodTerms.isEmpty()) {
                    ret.add("NONE");
                } else {
                    String winner = goodTerms.get(0);
                    for (String good : goodTerms) {
                        if(good.compareTo(winner) < 0) {
                            winner = good;
                        }
                    }
                    ret.add(winner);
                } 
            }
            ret.add("$");
        }
        
        for (String r : ret) {
            System.out.println(r);
        }
    }
    
    //Root of the problem
    public static void main5(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        while(true) {
            String line = sc.nextLine();
            
            if("0 0".equals(line)) break;
            
            String[] data = line.split(" ");
            int B = Integer.parseInt(data[0]);
            int N = Integer.parseInt(data[1]);
            int A = 0;
            
            double difference = Math.abs(Math.pow(0, N) - B);

            for (int i = 1; i <= 1000000; i++) {
                double number = Math.pow(i, N);
                if (Math.abs(number - B) < difference) {
                    A = i;
                    difference = Math.abs(number - B);
                } else {
                    break;
                }
            }
            System.out.println(A);
        }
    }

}
