import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Math.abs;
import static java.lang.Math.max;

/*
    Time Complexity: O(N log(N)) where N is the size of the array (since we sorted)
    Space Complexity: O(N)
    Description: we will just follow a greedy approach. we know that we will check every two consecutive lanterns.
    the smart move is to make each lantern lighten half of the distance between them (since we want to minimize the maximum radius)
    so, if the distance is 3, it makes sense to make each lantern radius = 1.5
    - We should not forget that the first lantern will have to light all the way to 0
    - We should not forget that the last lantern will have to light all the way to roadLenght
*/

public class Main {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int arraySize = reader.nextInt();
        int roadLength = reader.nextInt();
        int[] lanternsPositions = new int[arraySize];
        for(int i = 0; i < arraySize; ++i) {
            lanternsPositions[i] = reader.nextInt();
        }

        Arrays.sort(lanternsPositions);
        double result = max(lanternsPositions[0], roadLength - lanternsPositions[arraySize - 1]);
        for(int i = 1; i < arraySize; ++i) {
            double currentState = abs((double) lanternsPositions[i] - lanternsPositions[i - 1]) / 2;
            if(result < currentState) {
                result = currentState;
            }
        }
        System.out.println(result);
    }
}