import java.util.Scanner;

/*
    Time Complexity: O(N * T) Where N is the size of the queue, and T is the time. (Constraints are way too low, no point of optimizing it)
    Space Complexity: O(N)
    Description: I'm just simulation the process. if there is a girl standing behind a boy, then they will swap and continue starting
    after the girl's position.
*/
public class Main {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int arraySize = reader.nextInt();
        int time = reader.nextInt();
        String queue = reader.next();

        char[] newQueue = queue.toCharArray();
        for(int i = 1; i <= time; ++i) {
            for(int j = 0; j < arraySize - 1; ++j) {
                if(newQueue[j] == 'B' && newQueue[j + 1] == 'G') {
                    newQueue[j] = 'G';
                    newQueue[j + 1] = 'B';
                    ++j;
                }
            }
        }

        for(char c : newQueue) {
            System.out.print(c);
        }
    }
}