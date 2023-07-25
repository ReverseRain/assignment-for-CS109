package ass3;

import java.util.Arrays;
import java.util.Scanner;

public class ass3_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int w = sc.nextInt();
        int h = sc.nextInt();
        int[][] map = new int[h + 3][w];
        int num = sc.nextInt();
        String[] str = new String[num];
        int[] cord = new int[num];
        for (int i = 0; i < num; i++) {
            str[i] = sc.next();
            cord[i] = sc.nextInt();
        }
        map = trivial(map, str, cord);
        for (int i = 3; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                System.out.printf("%d",map[i][j]);
            }
            System.out.println("");
        }
    }

    public static int[][] trivial(int[][] map, String[] str, int[] cord) {
        int[] x = new int[4];
        int[] y = new int[4];
        int[]sam=new int[map[0].length];
        for (int i = 0; i < str.length; i++) {
            x = coordinateX(str[i]);
            y = coordinateY(str[i], cord[i]);
            for (int j = 0; j < map.length; j++) {
                if (x[0]+j<map.length&&x[1]+j<map.length&&x[2]+j<map.length&&x[3]+j<map.length){
                    if (map[x[0] + j][y[0]] != 0 || map[x[1] + j][y[1]] != 0 || map[x[2] + j][y[2]] != 0 || map[x[3] + j][y[3]] != 0) {
                        map[x[0] + j - 1][y[0]] = 1;
                        map[x[1] + j - 1][y[1]] = 1;
                        map[x[2] + j - 1][y[2]] = 1;
                        map[x[3] + j - 1][y[3]] = 1;
                        map = cutLine(map);
                        break;
                    }
                    if (x[0]+j== map.length-1||x[1]+j== map.length-1||x[2]+j== map.length-1||x[3]+j== map.length-1){
                        map[x[0] + j ][y[0]] = 1;
                        map[x[1] + j ][y[1]] = 1;
                        map[x[2] + j ][y[2]] = 1;
                        map[x[3] + j ][y[3]] = 1;
                        map = cutLine(map);
                        break;
                    }
                }
            }
            if (Arrays.equals(map[0],sam)&&Arrays.equals(map[1],sam)&&Arrays.equals(map[2],sam)){
                map=map;
            }
            else
                break;
        }
        return map;
    }

    public static int[][] cutLine(int[][] map) {
        int[] sam = new int[map[0].length];
        int[] sam2 = new int[map[0].length];
        for (int i = 0; i < map[0].length; i++) {
            sam[i] = 1;
            sam2[i] = 0;
        }
        for (int i = 3; i < map.length; i++) {
            if (Arrays.equals(map[i],sam)) {
                for (int j = i; j>=1; j--) {
                    for (int k = 0; k < map[0].length; k++) {
                        map[j][k] = map[j-1][k];
                    }
                }
                map[0] = sam2;
            }
        }
        return map;
    }

    public static int[] coordinateX(String str) {
        int[] x = new int[4];
        if (str.equals("I")) {
            for (int j = 0; j < 4; j++) {
                x[j] = I[j][0];
            }
        }
        if (str.equals("O")) {
            for (int j = 0; j < 4; j++) {
                x[j] = O[j][0];
            }
        }
        if (str.equals("L")) {
            for (int j = 0; j < 4; j++) {
                x[j] = L[j][0];
            }
        }
        if (str.equals("J")) {
            for (int j = 0; j < 4; j++) {
                x[j] = J[j][0];
            }
        }
        if (str.equals("T")) {
            for (int j = 0; j < 4; j++) {
                x[j] = T[j][0];
            }
        }
        if (str.equals("S")) {
            for (int j = 0; j < 4; j++) {
                x[j] = S[j][0];
            }
        }
        if (str.equals("Z")) {
            for (int j = 0; j < 4; j++) {
                x[j] = Z[j][0];
            }
        }
        return x;
    }

    public static int[] coordinateY(String str, int cord) {
        int[] y = new int[4];
        if (str.equals("I")) {
            for (int j = 0; j < 4; j++) {
                y[j] = cord + I[j][1];
            }
        }
        if (str.equals("O")) {
            for (int j = 0; j < 4; j++) {
                y[j] = cord + O[j][1];
            }
        }
        if (str.equals("L")) {
            for (int j = 0; j < 4; j++) {
                y[j] = cord + L[j][1];
            }
        }
        if (str.equals("J")) {
            for (int j = 0; j < 4; j++) {
                y[j] = cord + J[j][1];
            }
        }
        if (str.equals("T")) {
            for (int j = 0; j < 4; j++) {
                y[j] = cord + T[j][1];
            }
        }
        if (str.equals("S")) {
            for (int j = 0; j < 4; j++) {
                y[j] = cord + S[j][1];
            }
        }
        if (str.equals("Z")) {
            for (int j = 0; j < 4; j++) {
                y[j] = cord + Z[j][1];
            }
        }
        return y;
    }

    public static final int[][] I = {
            {0, 0},
            {0, 1},
            {0, 2},
            {0, 3}
    };
    public static final int[][] O = {
            {0, 0},
            {0, 1},
            {1, 0},
            {1, 1}
    };
    public static final int[][] L = {
            {0, 0},
            {1, 0},
            {2, 0},
            {2, 1}
    };
    public static final int[][] J = {
            {0, 1},
            {1, 1},
            {2, 0},
            {2, 1}
    };
    public static final int[][] T = {
            {0, 0},
            {0, 1},
            {0, 2},
            {1, 1}
    };
    public static final int[][] S = {
            {0, 1},
            {0, 2},
            {1, 0},
            {1, 1}
    };
    public static final int[][] Z = {
            {0, 0},
            {0, 1},
            {1, 1},
            {1, 2}
    };
}
