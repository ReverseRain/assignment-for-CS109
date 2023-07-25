package ass3;

import java.util.Scanner;

public class ass3_1 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int a= sc.nextInt();
        char[][]array1=new char[a][];
        for (int i = 0; i < a; i++) {
                String str;
                str=sc.next();
                array1[i]=str.toCharArray();
        }
        int x=sc.nextInt();
        int y=sc.nextInt();
        int num=0;
        if ( array1[x][y]=='x'){
            System.out.printf("%d",-1);
        }
        else {
                for (int i =-1; i <2 ; i++) {
                    for (int j = -1; j < 2; j++) {
                      if (x+i>=0&&x+i<a) {
                          if (y+j>=0&&y+j<a) {
                          if (array1[x  + i][y  + j]=='x'){
                              num++;
                          }
                      }
                      }
                    }
                }
            System.out.printf("%d",num);
        }
    }
}
