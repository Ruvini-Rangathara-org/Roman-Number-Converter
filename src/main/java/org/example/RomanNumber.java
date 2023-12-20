package org.example;

import java.util.Scanner;

/**
 * Author: ruu
 * Created: 2023-12-20 14.50
 */

public class RomanNumber {
    public static void main(String[] args) {

        // I for 1, V for 5, X for 10, L for 50, C for 100, D for 500, M for 1000
        //I->1, II->2, III->3, IV->4, V->5, VI->6, VII->7, VIII->8, IX->9, X->10
        //XI->11, XII->12, XIII->13, XIV->14, XV->15, XVI->16, XVII->17, XVIII->18, XIX->19, XX->20

        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 3; i++) {
            System.out.print("\nEnter a Roman Number : ");
            String romanNumber = scanner.nextLine();
            romanNumber = romanNumber.toUpperCase();

            char[] ar = romanNumber.toCharArray();
            int[] intArr = translateArray(ar);
            int num =  getDecimalNumber(ar, intArr);
            System.out.println("Decimal Number is : " + num);
        }
    }
    private static int getDecimalNumber(char[] ar, int[] intArr) {

        int[] indexes = new int[0];
        for (int j = 1; j < ar.length; j++) {
            if (ar[j] == 'V' || ar[j] == 'X' || ar[j] == 'L' || ar[j] == 'C' || ar[j] == 'D' || ar[j] == 'M') {
                if (ar[j - 1] == 'I' || ar[j - 1] == 'X' || ar[j - 1] == 'C') {
                    indexes = growIndexArray(indexes, j - 1);
                }
            }
        }

        for (int i = 0; i < indexes.length; i++) {
            intArr[indexes[i]] = -intArr[indexes[i]];
        }

        int tot = 0;
        for (int j = 0; j < intArr.length; j++) {
            tot += intArr[j];
        }
        return tot;
    }

    private static int[] growIndexArray(int[] ar, int num) {
        int[] newAr = new int[ar.length + 1];
        System.arraycopy(ar, 0, newAr, 0, ar.length);
        newAr[ar.length] = num;
        return newAr;
    }

    private static int[] translateArray(char[] ar) {
        int[] intAr = new int[ar.length];
        for (int i = 0; i < ar.length; i++) {
            if (ar[i] == 'I') {
                intAr[i] = 1;
            }
            if (ar[i] == 'V') {
                intAr[i] = 5;
            }
            if (ar[i] == 'X') {
                intAr[i] = 10;
            }
            if (ar[i] == 'L') {
                intAr[i] = 50;
            }
            if (ar[i] == 'C') {
                intAr[i] = 100;
            }
            if (ar[i] == 'D') {
                intAr[i] = 500;
            }
            if (ar[i] == 'M') {
                intAr[i] = 1000;
            }
        }
        return intAr;

    }
}
