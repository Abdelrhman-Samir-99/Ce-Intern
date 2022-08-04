import java.util.Scanner;

/*
    Time Complexity: O(queries * N) where N is the maximum word length.
    Space Complexity: O(N)
    Description: if the string size is greater than 10, then we just print (first character + (size - 2) + last character)
*/
public class Main {
    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);
        int queries = reader.nextInt();
        while(queries-- > 0) {
            String word = reader.next();
            int lastIndex = word.length() - 1;
            System.out.println(word.length() > 10 ? ("" + word.charAt(0) + (word.length() - 2) + word.charAt(lastIndex)): word);
        }
    }
}