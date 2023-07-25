package ass2;

import java.util.Scanner;

public class ass2_1 {  //Polynomial Multiplication  第一个输入的代表有几个组多项式，
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n,m;
        int b = sc.nextInt();
        for (int i = 0; i <b; i++) {
            n=sc.nextInt();
            int[]array1=new int[n];
            for (int j = n-1; j >=0; j--) {
                array1[j]=sc.nextInt();
            }
            m=sc.nextInt();
            int[]array2=new int[m];
            for (int j = m-1; j >=0; j--) {
                array2[j]= sc.nextInt();
            }
            int[]array3=new int[n+m-1];
            for (int j =n-1; j >=0; j--) {
                for (int k = m-1; k >=0; k--) {
                    array3[j+k]+=(array1[j]*array2[k]);
                }
            }
            for (int j = n+m-2; j >=0; j--) {
                System.out.printf("%d ",array3[j]);
            }
            System.out.println("");
        }
    }
}
