package exersise_for_luogu;

import java.util.Scanner;


public class exe9_P5194 {
    static long n=0,c=0,ans=0;
    static long[] sum=new long[1005],a=new long[1005];
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        n=sc.nextInt();c=sc.nextInt();
        for (int i = 1; i <=n; i++) {
            a[i]=sc.nextInt();
            sum[i]=sum[i-1]+a[i];
        }
        search((int) n+1,0);
        System.out.println(ans);
    }
    public static void search(int cur,long x){
        if (x>c){
            return;
        }
        //对一些条件进行剪枝
        if (sum[cur-1]+x<=c){//什么意思呢？
            ans=Math.max(ans, sum[cur-1]+x);
            return;
        }
        ans=Math.max(ans, x);
        for (int i = 1; i <cur; i++) {//这个循环是如何做到遍历所有的组合的？？？
           search(i,x+a[i]);
        }

    }

}
