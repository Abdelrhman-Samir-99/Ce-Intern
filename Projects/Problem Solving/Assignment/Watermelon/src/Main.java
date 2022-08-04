import java.io.IOException;
import java.util.Scanner;

/*
    Time Complexity: O(1)
    Space Complexity: O(1)
    Description: Any even number can be divided to the sum of two even numbers (4 -> 2 + 2, 8 -> 4 + 4)
    So we just need to check the parity of the number.
    Corner case: the only "positive" even number that can't apply that rule is 2.
    Corner case: if the number is negative, then the parity check using "%" may cause some issues.
*/
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner reader = new Scanner(System.in);
        int number = reader.nextInt();
        System.out.println(number % 2 == 0 && number != 2 ? "YES" : "NO");
    }
}