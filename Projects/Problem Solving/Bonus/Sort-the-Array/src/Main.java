import java.util.Arrays;
import java.util.Scanner;

/*
    Time Complexity: O(N log(N)) Where N is the size of the array, since we sorted the array.
    Space Complexity: O(N)
    Description: we are following a constructive - greedy approach.
    we will always do the following:
    - Look for the start of the reversed sorted segment
    - Look for the end of the reversed sorted segment
    - Reverse it and match it with a sorted copy of the array
*/
public class Main {
    static void reverse(int start, int end, int[] numbers) {
        int temp;
        while(start < end) {
            temp = numbers[end];
            numbers[end] = numbers[start];
            numbers[start] = temp;
            ++start;
            --end;
        }
    }

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int arraySize = reader.nextInt();
        int[] numbers = new int[arraySize];
        for(int i = 0; i < arraySize; ++i) {
            numbers[i] = reader.nextInt();
        }

        int[] numbersCopy = Arrays.copyOf(numbers, arraySize);
        Arrays.sort(numbersCopy);
        int start = -1;
        for(int i = 0; i < arraySize; ++i) {
            if(numbers[i] == numbersCopy[i]) {
                continue;
            }
            start = i;
            break;
        }

        if(start == -1) {
            System.out.println("yes");
            System.out.print("1 1");
            return;
        }

        int end = arraySize - 1;
        for(int i = start + 1; i < arraySize; ++i) {
            if(numbers[i] <= numbers[i - 1]) {
                continue;
            }
            end = i - 1;
            break;
        }

        reverse(start, end, numbers);
        if(Arrays.equals(numbers, numbersCopy) == true) {
            System.out.println("yes");
            ++start; ++end;
            System.out.print(start + " " + end);
            return;
        }
        System.out.print("no");
    }
}