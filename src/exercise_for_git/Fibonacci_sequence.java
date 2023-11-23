package exercise_for_git;

import java.util.Scanner;

public class Fibonacci_sequence {//很多题目可以用斐波那契数列数列解决
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int n =sc.nextInt();
        System.out.println(f2(n));
    }
    public static int f(int n){//但是在这当中重复运算了f(2)，有什么方法可以避免呢？
        if(n<=0){
            return n;
        } else  {
            return f(n-1)+f(n-2);
        }
    }//递归
    public static int f2(int n){
        if (n<=1){
            return n;
        }
        int fir=0,fib=0,sec=1;
        for (int i = 2; i <=n; i++) {
            fib=fir+sec;
            fir=sec;
            sec=fib;
        }return fib;
    }

}
