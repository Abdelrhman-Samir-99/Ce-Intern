import java.util.Scanner;

/*
   Time Complexity: O(N) where N is the size of number
   Space Complexity: O(N)
   Description: following a greedy approach, we know that we will swap with an even digit, but which one?
   we should pick the one which is
   - farthest to the left (from the end)
   - smaller than the last digit (number[number.length - 1])
   why?
   because it will give us a greater value (logically).
*/
public class Main {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        String number = reader.next();
        char[] numberCopy = number.toCharArray();

        int pos = -1;
        int lastDigit = numberCopy[numberCopy.length - 1] - '0';
        for(int i = numberCopy.length - 2; i > -1; --i) {
            int digit = numberCopy[i] - '0';
            if(digit % 2 == 0) {
                if(pos == -1) {
                    pos = i;
                }
                else if(lastDigit >= digit){
                    pos = i;
                }
            }
        }
        if(pos == -1) {
            System.out.println(-1);
            return;
        }
        char temp = numberCopy[pos];
        numberCopy[pos] = numberCopy[numberCopy.length - 1];
        numberCopy[numberCopy.length - 1] = temp;
        System.out.println(String.valueOf(numberCopy));
    }
}