package exersise_for_luogu;

import java.util.Scanner;

public class exe8_P1219 {//搜索与回溯算法
    static int n=0,total=0;
    static int[] a=new int[100];
    static boolean[] b= new boolean[100];
    static boolean[] c= new boolean[100];
    static boolean[] d= new boolean[100];
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        n=sc.nextInt();
        Search(1);
        System.out.println(total);
    }
    public static void Search(int i){
        if (i>n){//到达目的地的条件是什么
            total++;
            if (!(total>3)){
                for (int j = 1; j <=n ; j++) {
                    System.out.printf("%d ",a[j]);
                }
                System.out.println("");
            }
        }else {
            for (int j = 1; j <=n; j++) {
                if ((!b[j])&&(!c[i+j])&&(!d[-j+i+n])){//i+j代表“/“方向上的对角线数，i-j+n代表”\“方向的对角线数
                    a[i]=j;//保留答案
                    b[j]=true;
                    c[i+j]=true;
                    d[-j+i+n]=true;
                    Search(i+1);//在搜索i+1行的情况，直到n行；（一路走到底）
                    //回溯：清空之前的标记,用于继续搜索其他的答案
                    b[j]=false;
                    c[i+j]=false;
                    d[-j+i+n]=false;
                }
            }
        }
    }
//    搜索与回溯的算法框架（c语言）
//    算法框架[一]
//    int Search(int k)
//    {
//　for (i=1;i<=算符种数;i++)
//　　if (满足条件)
//　　   {
//　　　　保存结果
//　　　　if (到目的地) 输出解;
//　　　           else Search(k+1);
//　　　　恢复：保存结果之前的状态{回溯一步}
//　 　  }
//    }
//    算法框架[二]
//    int Search(int k)
//    {
//　 if  (到目的地) 输出解;
//　 else
//　　　for (i=1;i<=算符种数;i++)
//　　　　if (满足条件)
//　　　　　　{
//　　　　　　　保存结果;
//　　　                 Search(k+1);
//　　　　　　　恢复：保存结果之前的状态{回溯一步}
//　　　　　　}
//    }
}
