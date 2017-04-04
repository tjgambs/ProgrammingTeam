
package w2_sort_me;

import java.util.Arrays;
import java.util.Scanner;

// For the judge, this must be package-private.
class Main {
    
    // Sort Me - 6499
    // Time to solve: 30 minutes
    // Debug time: 10 minutes
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int currentYear = 1;
        while(true) {
            int wordCount = sc.nextInt();
            if (wordCount == 0) return;
            String newAlphabet = sc.next();
            String currentAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            
            String[] encodedWords = new String[wordCount];
            for (int i = 0; i < wordCount; i++) {
                // Encode the words using the new alphabet. This makes a word
                // that is not english but allows us to sort using java sort methods.
                encodedWords[i] = encode(sc.next(), newAlphabet, currentAlphabet);
            }
            // Sort the non-english words.
            Arrays.sort(encodedWords);
            System.out.printf("year %d\n", currentYear);
            for (int i = 0; i < wordCount; i++) {
                // Encode the words back to english.
                System.out.println(encode(encodedWords[i], currentAlphabet, newAlphabet));
            }
            currentYear++;
        }
    }    
    
    public static String encode(String word, String newAlphabet, String currentAlphabet) {
        char[] charWord = word.toCharArray();
        for(int i = 0; i < charWord.length; i++) {
            int index = newAlphabet.indexOf(charWord[i]);
            charWord[i] = currentAlphabet.charAt(index);
        }
        return String.valueOf(charWord);
    }

}
