import java.util.Scanner;

public class Main {
    static long calculateMaximumFriendship(int participants, int teams) {
        long result = teams - 1;
        participants -= (teams - 1);
        result += ((long)participants * (participants - 1) / 2);
        return result;
    }

    static long calculateMinimumFriendship(int participants, int teams) {
        long lowestNumberOfParticipants = participants / teams;
        long total = lowestNumberOfParticipants * (teams - 1);

        return total;
    }

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int participants = reader.nextInt();
        int teams = reader.nextInt();

        long maximum = 0, minimum = 0;


        maximum = calculateMaximumFriendship(participants, teams);
        minimum = calculateMinimumFriendship(participants, teams);
        System.out.println(minimum + " " + maximum);
    }
}