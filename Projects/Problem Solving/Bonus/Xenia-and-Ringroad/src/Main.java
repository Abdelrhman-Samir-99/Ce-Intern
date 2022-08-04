import java.util.Scanner;

/*
    Time Complexity: O(N) where N is the number of tasks
    Space Complexity: O(N)
    Description: We are just moving in a cycle, and we would like to get the distance between the previous move
    and current one.
    we should be careful if the current move will end the cycle (cycle of length 4, standing at 3 and should move
    2 more moves).
*/

public class Main {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int roadLength = reader.nextInt();
        int tasksCount = reader.nextInt();
        int[] task = new int[tasksCount];

        long total = 0;
        int currentPosition = 1;
        for(int i = 0; i < tasksCount; ++i) {
            task[i] = reader.nextInt();
            if(task[i] < currentPosition) {
                total += (roadLength - currentPosition);
                total += task[i];
            }
            else {
                total += (task[i] - currentPosition);
            }
            currentPosition = task[i];
        }

        System.out.println(total);
    }
}