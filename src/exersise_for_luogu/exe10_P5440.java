package exersise_for_luogu;

import java.util.Scanner;

public class exe10_P5440 {
    static int t=0,toatl=0;
    static char[]ch;
    static String[]strings=new String[11];
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        t=sc.nextInt();
        for (int i = 1; i <=t; i++) {
            strings[i]=sc.next();
        }
    }
    public static void dfs(String str){
        ch=str.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            if (ch[i]=='-'){

            }
        }
    }
//    public static void check(String str){
//        if (Integer.valueOf(str.substring(0,4)))
//    }
}
