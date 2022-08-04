import java.util.Scanner;

/*
    Time Complexity: O(N) where N is the string size.
    Space Complexity: O(N)
    Description: the problem statement can be changed to "Can we get the word "hello" as a subsequence from the text?"
    So, we are just looking for each character in-order (since we are looking for a subsequence).
*/
public class Main {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        String word = reader.next();

        String target = "hello";
        int ptr = 0;
        for(char c : word.toCharArray()) {
            if(ptr == 5) {
                break;
            }

            if(c == target.charAt(ptr)) {
                ++ptr;
            }
        }

        System.out.println(ptr == 5 ? "YES" : "NO");
    }
}