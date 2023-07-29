package exersise_for_luogu;

import java.util.Scanner;

public class exe2_P1151 {
    public static void main(String[] args) {
        String chr="10000";
        Scanner sc=new Scanner(System.in);
        int k=sc.nextInt();
        while (Integer.valueOf(chr)<=30000){
            int a,b,c;
            a=Integer.valueOf(chr.substring(0,3));
            b=Integer.valueOf(chr.substring(1,4));
            c=Integer.valueOf(chr.substring(2));
            if (a%k==0&&b%k==0&&c%k==0){
                System.out.println(chr);
            }
            chr=String.valueOf(Integer.valueOf(chr)+1);
        }
    }
}
