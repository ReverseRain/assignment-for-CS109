package ass2;

import javax.security.sasl.SaslClient;
import java.util.Scanner;

public class ass2_2 {    //Nethersea Land
    public static void main(String[] args) {
        int n, m;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        String[][] array = new String[n][m];
        int[][] array1 = new int[n][m];
        int c = sc.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                array[i][j] = sc.next();
                if (array[i][j].equals("l"))
                    array1[i][j] = 0;
                if (array[i][j].equals("W"))
                    array1[i][j] = -1;
                if (array[i][j].equals("B"))
                    array1[i][j] = 1;
            }
        }
        for (int i = 1; i < c + 1; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (array1[j][k] == i) {
                        if (j + 1 < n) {
                            if (array1[j + 1][k] == 0)
                                array1[j + 1][k] = i+1;
                        }
                        if (j- 1 >= 0) {
                            if (array1[j - 1][k] == 0)
                                array1[j - 1][k] = i+1;
                        }
                        if (k + 1 < m) {
                            if (array1[j][k + 1] == 0)
                                array1[j][k + 1] = i+1;
                        }
                        if (k - 1 >= 0) {
                            if (array1[j][k - 1] == 0)
                                array1[j][k - 1] = i+1;
                        }
                    }
                }
            }
        }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (array1[i][j] != 0 && array1[i][j] != -1)
                        array[i][j] = "B";
                    else if (array1[i][j] == 0) {
                        array[i][j] = "L";
                    } else
                        array[i][j] = "W";
                }
            }


            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    System.out.printf("%s ", array[i][j]);
                }
                System.out.println("");
            }
        }
    }


