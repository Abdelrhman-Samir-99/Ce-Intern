import java.util.Scanner;

/*
    Time Complexity: O(N) where N is the size of the array
    Space Complexity: O(N)
    Description: The problem statement is so dumb.
    but we can change the statement to:
    - Each person has gifted only one gift to someone else
    - I will tell you who did each person gift (for example: person_1 gifted person_2)
    -- I want you to tell me who gifted each person (who gifted person_2? "the answer is person_1")

    The solution is simple, if person_1 gifted person_2, then I will store person_1 at the index of person_2.
*/
public class Main {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int arraySize = reader.nextInt();
        int[] whoDidCurrentIndexGift = new int[arraySize + 1]; // since we are 1-based, not 0-based.
        for(int i = 1; i <= arraySize; ++i) {
            int receiver = i ;
            int sender = reader.nextInt();
            whoDidCurrentIndexGift[sender] = receiver;
        }

        for(int i = 1; i <= arraySize; ++i) {
            System.out.print(whoDidCurrentIndexGift[i]);
            if(i != arraySize) {
                System.out.print(" ");
            }
        }
    }
}