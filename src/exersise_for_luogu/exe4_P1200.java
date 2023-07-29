package exersise_for_luogu;

import java.util.Scanner;

public class exe4_P1200 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        char[] team=sc.next().toCharArray();
        char[] ufo=sc.next().toCharArray();
        int a = 1,b=1;
        for (int i = 0; i <team.length ; i++) {
            a=a*(Integer.valueOf(team[i]-'A')+1);
        }
        for (int i = 0; i < ufo.length; i++) {
            b=b*(Integer.valueOf(ufo[i]-'A')+1);
        }
        if (a%47==b%47){
            System.out.println("GO");
        }else System.out.println("STAY");
    }
}
