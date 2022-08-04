import java.util.*;

/*
    Time Complexity: O(N)
    Space Complexity: O(N)
    Discussion: I can't calculate the exact complexity of my solution, but I think that asymptotic complexity is O(sqrt(N))
    Description: We can generate the luckyDigitsNumbers by just adding 4 or 7 to the end of the number.
    How can we do that?
    - Multiply 10
    - the last digit is now 0
    - add 4 or 7
    after that, we can just iterate over them.
*/

public class Main {
    static void generateLuckyDigitsNumbers(List <Integer> luckyDigitsNumbers, int currentNumber) {
        if(currentNumber > 1000) {
            return;
        }
        luckyDigitsNumbers.add(currentNumber);
        generateLuckyDigitsNumbers(luckyDigitsNumbers, currentNumber * 10 + 7);
        generateLuckyDigitsNumbers(luckyDigitsNumbers, currentNumber * 10 + 4);
    }

    public static void main(String[] args) {
        List <Integer> luckyDigitsNumbers = new ArrayList<>();
        generateLuckyDigitsNumbers(luckyDigitsNumbers, 4);
        generateLuckyDigitsNumbers(luckyDigitsNumbers, 7);

        // System.out.println(luckyDigitsNumbers.size());
        Scanner reader = new Scanner(System.in);
        Integer number = reader.nextInt();

        boolean result = false;
        for(Integer luckyDigitNumber : luckyDigitsNumbers) {
            if(number % luckyDigitNumber == 0) {
                result = true;
                break;
            }
        }

        System.out.println(result ? "YES" : "NO");
    }
}