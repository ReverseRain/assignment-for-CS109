package exersise_for_luogu;

import java.util.ArrayList;
import java.util.Scanner;

public class exe3_P1152 {//与题意不符
    public static void main(String[] args) {
        ArrayList<Integer>ints=new ArrayList<>();
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        char[] chr=str.toCharArray();
        int a=-1,b=-1;
        for (int i = 0; i < chr.length; i++) {
            if (chr[i]==' '){
                b=i;
                ints.add(Integer.valueOf(str.substring(a+1,b)));
                a=i;
            }
        }
            ints.add(Integer.valueOf(str.substring(b+1)));
        int[] array=new int[ints.size()];
        for (int i = 0; i < ints.size()-1; i++) {
            array[i]=i;
        }
        for (int i = 0; i < ints.size()-1; i++) {
            if (Math.abs(ints.get(i)-ints.get(i+1))<array.length)
            array[Math.abs(ints.get(i)-ints.get(i+1))]=0;
        }
        for (int i = 0; i <array.length; i++) {
            if (array[i]!=0){
                System.out.println("Not jolly");
                return;
            }
        }
        System.out.println("Jolly");
    }
}
