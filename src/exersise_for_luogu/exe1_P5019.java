package exersise_for_luogu;

import java.util.Scanner;

public class exe1_P5019 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int n=sc.nextInt(),count=0;
        int[] d=new int[n];
        int[] hu=new int[n];
        for (int i = 0; i <d.length ; i++) {
            d[i]=sc.nextInt();
            hu[i]=0;
        }
        while (!isEqual(d,hu)){
            int a=-1,b=-1;
            for (int i = 0; i < d.length; i++) {
                if (d[i]==0){
                    b=i;
                    for (int j =a+1;j<i; j++) {
                        d[j]--;
                        if (j==i-1){
                            count++;

                        }
                    }a=i;
                }
            }
            for (int i =b+1; i <d.length ; i++) {
                d[i]--;
                if (i==d.length-1)
                    count++;
            }
        }
        System.out.printf("%d",count);
    }
    public static boolean isEqual(int a[], int b[]){
        for (int i = 0; i < a.length; i++) {
            if (a[i]!=b[i])
                return false;
        }
        return true;
    }
}
