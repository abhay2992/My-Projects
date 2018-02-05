/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Others;

import java.util.ArrayList;

/**
 *
 * @author Abhay
 */
public class test1 {

    public ArrayList<ArrayList<Integer>> generateMatrix(int n) {
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i < n; i++) {
            matrix.add(new ArrayList<Integer>());
            for(int j=0; j<n;j++)
            {
                matrix.get(i).add(0);;
            }
        }
        

        int row = 0, col = 0, lenRow = n - 1, lenCol = n - 1;
        int count = 1;
        int startRow = 0, startCol = 0;
        while (row <= lenRow && col <= lenCol) {

            startCol = col;
            while (startCol <= lenCol) {
                matrix.get(row).set(startCol, count);
                System.out.println("Row: " + row + "\tColumn: " + startCol);
                count++;
                startCol++;
            }

            row++;
            startRow = row;
            while (startRow <= lenRow) {
                matrix.get(startRow).set(lenCol, count);
                System.out.println("Row: " + startRow + "\tColumn: " + lenCol);
                startRow++;
                count++;
            }

            lenCol--;
            startCol = lenCol;
            while (startCol >= col) {
                matrix.get(lenRow).set(startCol, count);
                System.out.println("Row: " + lenRow + "\tColumn: " + startCol);
                startCol--;
                count++;
            }

            lenRow--;
            startRow = lenRow;
            while (startRow >= row) {
                matrix.get(startRow).set(col, count);
                System.out.println("Row: " + startRow + "\tColumn: " + col);
                count++;
                startRow--;
            }
            col++;
        }

        return matrix;
    }

    public static void main(String[] args) {
        test1 obj = new test1();
        int n = 3;
        ArrayList<ArrayList<Integer>> matrix = obj.generateMatrix(n);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.println(matrix.get(i).get(j));
            }
        }
    }
}
