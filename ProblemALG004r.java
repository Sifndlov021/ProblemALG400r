import java.util.Scanner;

public class ProblemALG004r {

    int n;
    int rotation;

    public ProblemALG004r(int n, int rotation) {
        this.n = n;
        this.rotation = rotation;

        
        int[][] ar = new int[n][n];
        int dia = 0, row = 0, col = 0;
        boolean magic = true;
        
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the numbers for your square (separate by space after each number):");
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
            if (dia != row) {
                magic = false;
                break;
            }
        }
        
        if (magic) {
            for (int i = 0; i < n; i++) {
                col = 0;
                for (int j = 0; j < n; j++) {
                    col += ar[j][i];
                }
                if (dia != col) {
                    magic = false;
                    break;
                }
            }
        }
        
        if (!magic) {
            System.out.println("Not a magic square.");
            return;
        }

        for (int i = 0; i < rotation; i++) {
            ListRotation(ar, n);
        }

        System.out.println("Magic square rotated " + rotation + " times:");
        RotatedListPrintOut(ar);
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
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = 0;
        boolean odd = false;

        while (!odd) {
            System.out.println("Enter the size of your Square (odd numbers only): ");
            n = s.nextInt();
            
            if (n % 2 == 1) {
                odd = true;
            } else {
                System.out.println("Invalid input. Please enter an odd number for dimensions.");
            }
        }
        
        System.out.println("Enter the number of rotations (from 1 - 3 max): ");
        int rotation = s.nextInt();

        ProblemALG004r solution = new ProblemALG004r(n, rotation);
    }
}
