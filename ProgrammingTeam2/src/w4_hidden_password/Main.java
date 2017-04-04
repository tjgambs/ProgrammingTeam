package w4_hidden_password;


import java.util.Scanner;

// For the judge, this must be package-private.
class Main {
    
    // Hidden Password - 7353
    // Time to solve: 20 minutes
    // Debug time: 0 minutes
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] password = sc.next().toCharArray();
        int passwordLoc = 0;
        char[] text = sc.next().toCharArray();
        int textLoc = 0;
        boolean failed = false;
        do { 
            if(text[textLoc] == password[passwordLoc]) {
                textLoc++;
                passwordLoc++;
            } else {           
                String visiblePass = String.valueOf(password).substring(passwordLoc);
                boolean contains = visiblePass.contains(text[textLoc]+"");
                if(contains) failed = true;
                textLoc++;
            }
            if (textLoc == text.length) {
                System.out.println("FAIL");
                return;
            }
        } while(passwordLoc < password.length);
        System.out.println(failed ? "FAIL" : "PASS");
    }    
}

