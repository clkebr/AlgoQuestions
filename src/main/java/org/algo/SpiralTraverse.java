package org.algo;

import java.util.ArrayList;
import java.util.List;

public class SpiralTraverse {
    /*
    Write a function that takes in an n x m two-dimensional array (that can be square-shaped
    when n == m) and returns a one-dimensional array of all the array's elements in spiral order.
    Spiral order starts in the top left corner of the two-dimensional array, goes to the right, and
    proceeds in a spiral pattern all the way until every element has been visited. Both iterative and
    recursive solutions are welcome.

    Sample Input
    array = [ [1, 2, 3, 4], [12, 13, 14, 5], [11, 16, 15, 6], [10, 9, 8, 7],]
    Sample Output
    [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12,13,14,15,16] */

    public static void main(String[] args) {
        int[][] matrix= { {1, 2 ,3,4}, {12, 13, 14,5 },{11, 16, 15, 6}, { 10, 9, 8,7}};
        spiralTraverse(matrix).forEach(System.out::println);
    }


    // Solution1- Iterative approach
    // O(n) time | O(n) space - where n is the total number of elements in the array
    public static List<Integer> spiralTraverse(int[][] array) {
        if (array.length == 0) return new ArrayList<Integer>();
        var result = new ArrayList<Integer>();
        int startRow = 0;
        int endRow = array.length - 1;
        int startCol = 0;
        int endCol = array[0].length - 1;
        while (startRow <= endRow && startCol <= endCol) {

            // uprow
            for (int col = startCol; col <= endCol; col++) {
                result.add(array[startRow][col]);
            }
            // Right Col
            for (int row = startRow + 1; row <= endRow; row++) {
                result.add(array[row][endCol]);
            }
            // Bottom Row
            for (int col = endCol - 1; col >= startCol; col--) {
                // Handle the edge case when there's a single row
                // in the middle of the matrix. In this case, we don't
                // want to double-count the values in this row, which
                // we've already counted in the first for loop above.

                if (startRow == endRow) break;
                result.add(array[endRow][col]);
            }
            // Left col to up

            for (int row = endRow - 1; row > startRow; row--) {
                // Handle the edge case when there's a single column
                // in the middle of the matrix. In this case, we don't
                // want to double-count the values in this column, which
                // we've already counted in the second for loop above.

                if (startCol == endCol) break;
                result.add(array[row][startCol]);
            }
            startRow++;
            endRow--;
            startCol++;
            endCol--;
        }
        return result;
    }
}
