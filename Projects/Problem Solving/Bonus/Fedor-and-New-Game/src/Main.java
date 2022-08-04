import java.util.Scanner;

import static java.lang.Math.abs;
import static java.lang.Math.min;

/*
    Time Complexity: O(M log(K)) where M is the number of player and K is the maximum value in the player array.
    Why did we add log(K)? for the conversion from integer to binary.
    Space Complexity: O(M)
    Description: It is just an implementation problem, there are no logic at all. just how you will implement it.
*/
public class Main {
    // O(log(Number) base 10)
    static String fromIntegerToBinary(int number, int size) {
        StringBuilder binary = new StringBuilder();
        while(number != 0) {
            binary.append((char)('0' + number % 2));
            number /= 2;
        }

        while(binary.length() != size) binary.append('0');
        return binary.toString();
    }

    static int compare(String Fedro, String player) {
        int ret = 0;
        for(int i = 0; i < min(Fedro.length(), player.length()); ++i) {
            if(Fedro.charAt(i) != player.charAt(i)) {
                ++ret;
            }
        }
        return ret + abs(player.length() - Fedro.length());
    }

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int numberOfSoldiersType = reader.nextInt();
        int numberOfPlayers = reader.nextInt();
        int numberOfDifferentBits = reader.nextInt();

        int[] player = new int[numberOfPlayers];
        for(int i = 0; i < numberOfPlayers; ++i) {
            player[i] = reader.nextInt();
        }

        int Fedro = reader.nextInt();
        String FedroBinary = fromIntegerToBinary(Fedro, numberOfSoldiersType);
        int total = 0;
        for(int i = 0; i < numberOfPlayers; ++i) {
            String playerBinary = fromIntegerToBinary(player[i], numberOfSoldiersType);
            if(compare(FedroBinary, playerBinary) <= numberOfDifferentBits) {
                ++total;
            }
        }
        System.out.println(total);
    }
}