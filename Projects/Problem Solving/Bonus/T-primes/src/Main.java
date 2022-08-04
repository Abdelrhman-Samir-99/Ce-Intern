import java.util.Scanner;

/*
    Time Complexity: O(N log(log N) + Q) where N is the maximum input value (that's cause of Sieve), and Q is the number of queries
    Space Complexity: O(sqrt(N))
    Description: Simply, we want to find a number with 3 divisors.
    each number has at least 2 divisors (except of 1)
    - first one is: 1
    - second divisor: is the number itself.
    Observation 1: To get the third one we must make sure that its prime factorization doesn't contain anything except of itself.
    so we're basically looking for a prime number.
    Observation 2: The number needs to be the square root of N. (so we have only 3 divisors)
*/
public class Main {
    static void sieve(boolean[] notPrime) {
        notPrime[1] = true;
        for(int i = 2; i <= 1_000_000; ++i) {
            if(notPrime[i] == true) {
                continue;
            }
            for(int j = i + i; j <= 1_000_000; j += i) {
                notPrime[j] = true;
            }
        }
    }

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int queries = reader.nextInt();
        boolean notPrime[] = new boolean[1_000_020];
        sieve(notPrime);
        while(queries-- > 0) {
            long number = reader.nextLong();
            long squareRoot = (long)Math.sqrt(number);
            System.out.println(squareRoot * squareRoot == number && number != 1  && !notPrime[(int) squareRoot] ? "YES" : "NO");
        }
    }
}