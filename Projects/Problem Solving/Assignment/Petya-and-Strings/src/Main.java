import java.util.Scanner;

/*
    Time Complexity: O(max(N, M)) where N is the size of the first string, and M is the size of the second one.
    Space Complexity: O(max(N, M))
    Description: How strings comparison works?
    - Two pointers, each pointer points at the first char of each word.
    - Compare the ASCII code of each char.
    - The lower ASCII value is the smaller string.
    And that's what we had implemented, there are a scenario when
    firstWord =  abcd
    secondWord = abcde
    it should be obvious that the secondWord is larger than the firstWord (since it has additional chars)
*/
public class Main {
    static int compareStrings(String firstWord, String secondWord) {
        for(int i = 0; i < firstWord.length(); ++i) {
            int firstWordChar = firstWord.charAt(i);
            int secondWordChar = secondWord.charAt(i);

            if((firstWordChar - secondWordChar) > 0) {
                return 1;
            }
            else if((secondWordChar - firstWordChar) > 0) {
                return -1;
            }
        }
        return firstWord.length() == secondWord.length() ? 0 : -1;
    }

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        String firstWord = reader.next();
        String secondWord = reader.next();

        firstWord = firstWord.toLowerCase();
        secondWord = secondWord.toLowerCase();
        System.out.println(compareStrings(firstWord, secondWord));
    }
}