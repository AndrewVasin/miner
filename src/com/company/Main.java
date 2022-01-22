package com.company;

import java.util.*;

public class Main {

    public static final int MINE = 9;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        sc.nextLine();
        int[][] pole = new int[m + 2][n + 2];

        for (int[] ints : pole) {
            Arrays.fill(ints, 0);
        }

        int k = sc.nextInt();
        while (k > 0) {
            sc.nextLine();
            int i = sc.nextInt();
            int j = sc.nextInt();
            pole[i][j] = MINE;
            k--;
        }

        for (int i = 1; i < pole.length - 1; i++) {
            for (int j = 1; j < pole[i].length - 1; j++) {
                int count = 0;
                if (pole[i][j] != MINE) {
                    if (pole[i-1][j-1] == MINE) {
                        count++;
                    }
                    if (pole[i][j-1] == MINE) {
                        count++;
                    }
                    if (pole[i+1][j-1] == MINE) {
                        count++;
                    }
                    if (pole[i+1][j] == MINE) {
                        count++;
                    }
                    if (pole[i+1][j+1] == MINE) {
                        count++;
                    }
                    if (pole[i][j+1] == MINE) {
                        count++;
                    }
                    if (pole[i-1][j+1] == MINE) {
                        count++;
                    }
                    if (pole[i-1][j] == MINE) {
                        count++;
                    }
                    pole[i][j] = count;
                }
            }
        }

        StringBuilder line = new StringBuilder();
        for (int i = 1; i < pole.length - 1; i++) {
            for (int j = 1; j < pole[i].length - 1; j++) {
                if (pole[i][j] == MINE) {
                    line.append("m" + " ");
                } else {
                    line.append(pole[i][j]).append(" ");
                }
            }
            System.out.println(line.toString().trim());
            line = new StringBuilder();
        }
    }
}
