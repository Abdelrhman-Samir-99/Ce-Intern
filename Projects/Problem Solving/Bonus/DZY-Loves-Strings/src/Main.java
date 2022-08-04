import java.util.Scanner;

import static java.lang.Math.max;

/*
    Time Complexity: O(N) Where N is the length of the word
    Space Complexity: O(N)
    Description: greedy approach, we can pick any character (choices) times; so obviously we will pick the one with
    the highest value!
*/
public class Main {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        String word = reader.next();
        int choices = reader.nextInt();
        int total = 0, maximum_value = 0;
        int[] alphabet_value = new int[26];

        for(int i = 0; i < 26; ++i) {
            alphabet_value[i] = reader.nextInt();
            maximum_value = max(maximum_value, alphabet_value[i]);
        }

        for(int i = 0; i < word.length(); ++i) {
            char c = word.charAt(i);
            total += alphabet_value[c - 'a'] * (i + 1);
        }
        for(int j = word.length(); j < choices + word.length(); ++j) {
            total += j * maximum_value;
        }

        System.out.println(total + choices * maximum_value);
    }
}