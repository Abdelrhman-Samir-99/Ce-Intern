import java.util.Scanner;

/*
    Time Complexity: O(N) where N is the length of the string.
    Space Complexity: O(N)
    Description: we can just use "count sort" to solve this problem, by counting how many 1's, 2's, and 3's.
    then adding all 1's at the beginning then followed by 2's then lastly 3's.
*/
public class Main {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        String text = reader.next();

        int[] numbers = new int[4];
        for(char c : text.toCharArray()) {
            if(c == '+') {
                continue;
            }
            numbers[c - '0']++;
        }

        StringBuilder result = new StringBuilder();
        for(int i = 1; i <= 3; ++i) {
            for(int j = 0; j < numbers[i]; ++j) {
                result.append((char)('0' + i));
                result.append('+');
            }
        }
        result.deleteCharAt(result.length() - 1);
        System.out.println(result);
    }
}