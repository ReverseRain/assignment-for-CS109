package ass2;

import java.util.Scanner;

public class ass2_3 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int n = sc.nextInt();
        int sum=0;
        String str="";
        char[][]chars=new char[n][];
        for (int j = 0; j < n; j++) {
            str=sc.next();
            chars[j]=str.toCharArray();
            sum=chars[j].length;
            for (int i = 0; i < chars[j].length; i++) {
                int a = i - 1;
                int b = i + 1;
                int c = i;
                while (c >= 0 && b < chars[j].length) {
                    if (chars[j][c] == chars[j][b]) {
                        sum++;
                        c--;
                        b++;
                    } else
                        break;
                }
                b = i + 1;
                while (a >= 0 && b < chars[j].length) {
                    if (chars[j][a] == chars[j][b]) {
                        a--;
                        b++;
                        sum++;
                    } else
                        break;
                }
            }
            System.out.printf("%d\n",sum);
        }
        }

    }

