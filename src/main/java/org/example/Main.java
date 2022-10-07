package org.example;

import java.util.Scanner;

public class Main {
    static void show(String arr[][]) {
        for (int i=0; i< arr.length; i++) {
            for (int j=0; j<arr[1].length; j++) {
                System.out.printf(arr[i][j]);
            }
            System.out.println();
        }
    }

    static void type(String arr[][], int column, String a) {
        for(int i1=arr.length-1; i1>=0; i1--) {
            if (arr[i1][column] == " * ") {
                arr[i1][column] = a;

                row_tracking= i1;
                col_tracking= column;

                i1 = -1;
            }
        }
    }
    public static Scanner scanner = new Scanner(System.in);
    static int row_tracking, col_tracking;

    static int dem1, dem2;

    static int ii, jj;

    static int row_cpt, col_cpt;
    public static void main(String[] args) {
        String[][] test = {  {" * ", " * ", " * ", " * ", " * ", " * ", " * "}
                ,{" * ", " * ", " * ", " * ", " * ", " * ", " * "}
                ,{" * ", " * ", " * ", " * ", " * ", " * ", " * "}
                ,{" * ", " * ", " * ", " * ", " * ", " * ", " * "}
                ,{" * ", " * ", " * ", " * ", " * ", " * ", " * "}
                ,{" * ", " * ", " * ", " * ", " * ", " * ", " * "}};
        System.out.println("============== Game start ================");
        show(test);

        int column;

        while (true) {
            System.out.printf("Enter the column (Player 1): ");
            column = scanner.nextInt();
            column--;
            type(test,column," O ");
            show(test);

            dem1 = 0;
            dem2 = 0;
            // check ben phai
            for(int i=col_tracking ; i<7 ; i++) {
                if(test[row_tracking][i] == " O ") {
                    dem1++;
                }
                if(test[row_tracking][i] == " * " || test[row_tracking][i] == " X ") {
                    i=7;
                }
                if (dem1 == 4) {
                    System.out.println("Player 1 win");
                    return;
                }
            }
            //check ben trai
            for(int i=col_tracking ; i>=0 ; i--) {
                if(test[row_tracking][i] == " O ") {
                    dem2++;
                }
                if(test[row_tracking][i] == " * " || test[row_tracking][i] == " X ") {
                    i=-1;
                }
                if (dem2 == 4) {
                    System.out.println("Player 1 win");
                    return;
                }
                if (dem1+dem2 >= 5) {
                    System.out.println("Player 1 win");
                    return;
                }
            }
            //check ben tren
            dem1 = 0;
            dem2 = 0;
            for(int i=row_tracking ; i>=0 ; i--) {
                if(test[i][col_tracking] == " O ") {
                    dem1++;
                }
                if(test[i][col_tracking] == " * " || test[i][col_tracking] == " X ") {
                    i=-1;
                }
                if (dem1 == 4) {
                    System.out.println("Player 1 win");
                    return;
                }
            }
            //check ben duoi
            for(int i=row_tracking ; i<6 ; i++) {
                if(test[i][col_tracking] == " O ") {
                    dem2++;
                }
                if(test[i][col_tracking] == " * " || test[i][col_tracking] == " X ") {
                    i=7;
                }
                if (dem2 == 4) {
                    System.out.println("Player 1 win");
                    return;
                }
                if (dem1+dem2 >= 5) {
                    System.out.println("Player 1 win");
                    return;
                }
            }

            //check cheo tren trai
            dem1 = 0;
            dem2 = 0;
            ii = row_tracking;
            jj = col_tracking;
            while (ii>=0 && jj>=0) {
                if (test[ii][jj] == " O ") {
                    dem1++;
                }
                if (test[ii][jj] == " * " || test[ii][jj] == " X ") {
                    ii = -1;
                }
                if (dem1 == 4) {
                    System.out.println("Player 1 win");
                    return;
                }
                ii--;
                jj--;
            }

            //check cheo phai duoi
            ii = row_tracking;
            jj = col_tracking;

            while (ii<6 && jj<7) {
                if (test[ii][jj] == " O ") {
                    dem2++;
                }
                if (test[ii][jj] == " * " || test[ii][jj] == " X ") {
                    ii = 7;
                }
                if (dem2 == 4) {
                    System.out.println("Player 1 win");
                    return;
                }
                if (dem1+dem2 >= 5) {
                    System.out.println("Player 1 win");
                    return;
                }
                ii++;
                jj++;
            }

            //check cheo tren phai
            dem1 = 0;
            dem2 = 0;
            ii = row_tracking;
            jj = col_tracking;
            while (ii>=0 && jj<7) {
                if (test[ii][jj] == " O ") {
                    dem1++;
                }
                if (test[ii][jj] == " * " || test[ii][jj] == " X ") {
                    ii = -1;
                }
                if (dem1 == 4) {
                    System.out.println("Player 1 win");
                    return;
                }
                ii--;
                jj++;
            }

            //check cheo duoi trai
            ii = row_tracking;
            jj = col_tracking;

            while (ii<6 && jj>=0) {
                if (test[ii][jj] == " O ") {
                    dem2++;
                }
                if (test[ii][jj] == " * " || test[ii][jj] == " X ") {
                    ii = 7;
                }
                if (dem2 == 4) {
                    System.out.println("Player 1 win");
                    return;
                }
                if (dem1+dem2 >= 5) {
                    System.out.println("Player 1 win");
                    return;
                }
                ii++;
                jj--;
            }

            //==============================Player2======================================//
            //check ben phai
            System.out.printf("Enter the column (Player 2): ");
            column = scanner.nextInt();
            column--;
            type(test,column," X ");
            show(test);

            dem1 = 0;
            dem2 = 0;
            for(int i=col_tracking ; i<7 ; i++) {
                if(test[row_tracking][i] == " X ") {
                    dem1++;
                }
                if(test[row_tracking][i] == " * " || test[row_tracking][i] == " O ") {
                    i=7;
                }
                if (dem1 == 4) {
                    System.out.println("Player 2 win");
                    return;
                }
            }
            //check ben trai
            for(int i=col_tracking ; i>=0 ; i--) {
                if(test[row_tracking][i] == " X ") {
                    dem2++;
                }
                if(test[row_tracking][i] == " * " || test[row_tracking][i] == " O ") {
                    i=-1;
                }
                if (dem2 == 4) {
                    System.out.println("Player 2 win");
                    return;
                }
                if (dem1+dem2 >= 5) {
                    System.out.println("Player 2 win");
                    return;
                }
            }
            //check ben tren
            dem1 = 0;
            dem2 = 0;
            for(int i=row_tracking ; i>=0 ; i--) {
                if(test[i][col_tracking] == " X ") {
                    dem1++;
                }
                if(test[i][col_tracking] == " * " || test[i][col_tracking] == " O ") {
                    i=-1;
                }
                if (dem1 == 4) {
                    System.out.println("Player 2 win");
                    return;
                }
            }
            //check ben duoi
            for(int i=row_tracking ; i<6 ; i++) {
                if(test[i][col_tracking] == " X ") {
                    dem2++;
                }
                if(test[i][col_tracking] == " * " || test[i][col_tracking] == " O ") {
                    i=7;
                }
                if (dem2 == 4) {
                    System.out.println("Player 2 win");
                    return;
                }
                if (dem1+dem2 >= 5) {
                    System.out.println("Player 2 win");
                    return;
                }
            }

            //check cheo tren trai
            dem1 = 0;
            dem2 = 0;
            ii = row_tracking;
            jj = col_tracking;
            while (ii>=0 && jj>=0) {
                if (test[ii][jj] == " X ") {
                    dem1++;
                }
                if (test[ii][jj] == " * " || test[ii][jj] == " O ") {
                    ii = -1;
                }
                if (dem1 == 4) {
                    System.out.println("Player 2 win");
                    return;
                }
                ii--;
                jj--;
            }
            //check cheo phai duoi
            ii = row_tracking;
            jj = col_tracking;

            while (ii<6 && jj<7) {
                if (test[ii][jj] == " X ") {
                    dem2++;
                }
                if (test[ii][jj] == " * " || test[ii][jj] == " O ") {
                    ii = 7;
                }
                if (dem2 == 4) {
                    System.out.println("Player 2 win");
                    return;
                }
                if (dem1+dem2 >= 5) {
                    System.out.println("Player 2 win");
                    return;
                }
                ii++;
                jj++;
            }

            //check cheo tren phai
            dem1 = 0;
            dem2 = 0;
            ii = row_tracking;
            jj = col_tracking;
            while (ii>=0 && jj<7) {
                if (test[ii][jj] == " X ") {
                    dem1++;
                }
                if (test[ii][jj] == " * " || test[ii][jj] == " O ") {
                    ii = -1;
                }
                if (dem1 == 4) {
                    System.out.println("Player 2 win");
                    return;
                }
                ii--;
                jj++;
            }
            //check cheo duoi trai
            ii = row_tracking;
            jj = col_tracking;

            while (ii<6 && jj>=0) {
                if (test[ii][jj] == " X ") {
                    dem2++;
                }
                if (test[ii][jj] == " * " || test[ii][jj] == " O ") {
                    ii = 7;
                }
                if (dem2 == 4) {
                    System.out.println("Player 2 win");
                    return;
                }
                if (dem1+dem2 >= 5) {
                    System.out.println("Player 2 win");
                    return;
                }
                ii++;
                jj--;
            }
            /////////////////////////////////////////////////////////////////////
        }
    }
}