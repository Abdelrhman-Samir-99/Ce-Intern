import java.util.Arrays;
import java.util.Scanner;

/*
   Time Complexity: O(N log(N)) Where N is the size of the array.
   Space Complexity: O(N)
   Description: This is a "greedy" solution, we just want to take the minimum number of coins,
   so we must take the greatest values if we can!
   that's why we sort and take from the end of the array.

   Note: this can be done in time complexity of O(max(N, M)) and space complexity of O(M) using count sort.
   Where M is the maximum value in the array, and N is the array size.
*/

public class Main {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int arraySize = reader.nextInt();
        int[] coins = new int[arraySize];
        int totalSum = 0;
        for(int i = 0; i < arraySize; ++i) {
            coins[i] = reader.nextInt();
            totalSum += coins[i];
        }

        Arrays.sort(coins);
        int total = 0;
        int currentSum = 0;
        for(int i = arraySize - 1; i > -1; --i) {
            currentSum += coins[i];
            totalSum -= coins[i];
            ++total;
            if(currentSum > totalSum) {
                break;
            }
        }
        System.out.println(total);
    }
}