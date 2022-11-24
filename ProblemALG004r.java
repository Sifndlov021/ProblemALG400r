package ProblemALG004r;

import java.util.Scanner;

public class ProblemALG004r {

    int n;
    int rotation;

    public ProblemALG004r(int n, int rotation) {

        Scanner s = new Scanner(System.in);
        this.n = n;
        this.rotation = rotation;

        if (n % 2 == 0) {
            return;
        } else {

            int[][] ar = new int[n][n];
            int dia = 0, row = 0, col = 0;
            boolean magic = true;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    ar[i][j] = s.nextInt();
                }
            }
            s.close();

            for (int i = 0; i < n; i++) {
                dia += ar[i][i];
            }

            for (int i = 0; i < n; i++) {
                row = 0;
                for (int j = 0; j < n; j++) {
                    row += ar[i][j];
                }
                if (dia == row) {
                    magic = true;
                } else {
                    magic = false;
                    break;
                }
            }
            if (magic == true) {
                for (int i = 0; i < n; i++) {
                    col = 0;
                    for (int j = 0; j < n; j++) {
                        col += ar[j][i];
                    }
                    if (dia == col) {
                        magic = true;
                    } else {
                        magic = false;
                        break;
                    }
                }
            }
            if (magic == true) {
                if (rotation == 1) {
                    ListRotation(ar, n);
                    System.out.println();
                    System.out.println("rotated " + rotation + " times.\n");
                    RotatedListPrintOut(ar);
                    
                } else if (rotation == 2) {
                    ListRotation(ar, n);
                    System.out.println();
                    System.out.println("rotated " + rotation + " times. \n");
                    RotatedListPrintOut(ar);

                } else if (rotation == 3) {
                    ListRotation(ar, n);
                    System.out.println();
                    System.out.println("rotated " + rotation + " times. \n");
                    RotatedListPrintOut(ar);
                }
            } else {
                return;
            }
        }
    }

    public void ListRotation(int a[][], int n) {

        for (int i = 0; i < n / 2; i++) {
            for (int j = i; j < n - i - 1; j++) {

                int temp = a[i][j];
                a[i][j] = a[n - 1 - j][i];
                a[n - 1 - j][i] = a[n - 1 - i][n - 1 - j];
                a[n - 1 - i][n - 1 - j] = a[j][n - 1 - i];
                a[j][n - 1 - i] = temp;
            }
        }
    }
    

    public void RotatedListPrintOut(int arr[][]) {

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) 
                System.out.print(arr[i][j] + " ");
                System.out.println();
            
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the size of your Square(odd no.s only): ");
        int n = s.nextInt();
        System.out.println("Enter the number of rotation(from 1 - 3 max): ");
        int rotation = s.nextInt();
        System.out.println("Enter the numbers you wish to be in your square:");

        ProblemALG004r solution = new ProblemALG004r(n, rotation);

    }

}
