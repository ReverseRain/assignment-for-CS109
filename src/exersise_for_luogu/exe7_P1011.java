package exersise_for_luogu;

import java.util.Scanner;

public class exe7_P1011 {//斐波那契数列
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int a=sc.nextInt(),n=sc.nextInt(),m=sc.nextInt(),x=sc.nextInt();
        int sum1[]=new int[n];
        int sum2[]=new int[n];
        sum1[3]=2;sum1[4]=2;sum2[3]=0;sum2[4]=1;
        for (int i = 5; i <n ; i++) {
            sum1[i]=sum1[i-2]+sum1[i-1]-1;
            sum2[i]=sum2[i-1]+sum2[i-2]+1;
        }
        int b=(m-a*sum1[n-1])/sum2[n-1];
        System.out.println(sum1[x]*a+sum2[x]*b);
    }
}
