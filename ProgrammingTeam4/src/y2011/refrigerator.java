
package y2011;




import java.util.Scanner;

// For the judge, this must be package-private.
class Main1 {
    
    // #### - ####
    // Time to solve: # minutes
    // Debug time: 4 minutes
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            String word = sc.nextLine();
            if(word.equals("END")) return;
            int i = 0;
            boolean flag = false;
            for(char c : word.replace(" ", "").toCharArray()) {
                if(word.replace(" ", "").lastIndexOf(""+c) != i) {
                    flag = true;
                    break;
                }
                i++;
            }
            if(flag == false) System.out.println(word);   
        }
    }    
}

