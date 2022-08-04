import java.util.Hashtable;
import java.util.Scanner;

/*
    Time Complexity: O(N) where N is the length of the string.
    Space Complexity: O(N)
    Description: We just want to store our vowels in a hash table, so we can access them quickly and easily.
    Then we make the whole string lower case, why?
    - so we don't have to store the vowels in upper case as well
    - we will change all upper cases to lower case anyway.
    after that, we just follow the instructions in the problem (pretty clear).
*/
public class Main {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        String word = reader.next();
        word = word.toLowerCase();

        Hashtable <Character, Boolean> Vowels = new Hashtable<>();
        Vowels.put('a', true);
        Vowels.put('o', true);
        Vowels.put('y', true);
        Vowels.put('e', true);
        Vowels.put('u', true);
        Vowels.put('i', true);

        StringBuilder result = new StringBuilder();
        for(int i = 0; i < word.length(); ++i) {
            Character c = word.charAt(i);
            if(Vowels.containsKey(c)) {
                continue;
            }
            result.append(".");
            result.append(c);
        }
        System.out.println(result);
    }
}