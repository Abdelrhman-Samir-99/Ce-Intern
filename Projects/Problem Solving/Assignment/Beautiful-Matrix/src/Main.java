import java.util.Scanner;

import static java.lang.Math.abs;

/*
    Time Complexity: O(1) it is constant since the number of operation is always the same.
    Space Complexity: O(1)
    Description: we just need to get the distance between the cell which contains the 1, and the middle cell.
    Note: the operation he described in the problem is equivalent to move one cell at any direction (horizontal or vertical)
    so, we can change the statement to:
    what is the minimum number of moves to reach the middle cell.
*/

public class Main {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int [][] grid = new int[5][5];
        int row = -1, col = -1; // the index of the value 1.
        for(int r = 0; r < 5; ++r) {
            for(int c = 0; c < 5; ++c) {
                grid[r][c] = reader.nextInt();
                if(grid[r][c] == 1) {
                    row = r;
                    col = c;
                }
            }
        }
        System.out.println(abs(row - 2) + abs(col - 2));
    }
}