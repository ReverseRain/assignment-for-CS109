package exersise_for_luogu;

import java.util.Scanner;

public class exe6_P1002 {//经典dq题目，多看别人的题解思路！ 动态规划
    public static void main(String[] args) {
        long[][] f=new long[40][40];//要开long类型的数组，否则长度会溢出；
        Boolean[][] s=new Boolean[40][40];
        int fx[]={0, -2, -1, 1, 2, 2, 1, -1, -2};
        int fy[]={0, 1, 2, 2, 1, -1, -2, -2, -1};
        Scanner sc =new Scanner(System.in);
        int bx=sc.nextInt();int by=sc.nextInt();int mx=sc.nextInt();int my=sc.nextInt();
        bx+=2;by+=2;mx+=2;my+=2;//所有坐标加2保证大于0
        f[1][2]=1;//对之后用的函数进行初始化，实际初始化了f（-1.0）这个点
        for (int i = 0; i < 9; i++) {
            s[mx+fx[i]][my+fy[i]]=true;
        }
        //第一种最简单，无优化
//        for (int i = 2; i <=bx; i++) {//特别注意此时要从（2,2）开始计算
//            for (int j = 2; j <=by; j++) {//注意网格是到（bx,by）停止  !!!为什么是先bx后by呢？？
//                if (s[i][j]!=null){
//                    f[i][j]=0;
//                }else f[i][j]=f[i-1][j]+f[i][j-1];
//            }
//        }
        //第二种，考虑滚动数组的优化：I.x%2与x&1所得到的结果是相同的；
        // II.数组的第一维可以简化维两个元素0,1，因为i % 2=(i−1) % 2
        //这种方法中，电脑将只存储两个数据：分别是上方与下方；
        // 注意在这种方法中所动用的维度只有1和0，所以初始化时应当初始（-1.0）
//        for (int i = 2; i <=bx ; i++) {
//            for (int j = 2; j <=by ; j++) {
//                if (s[i][j]!=null){
//                    f[i&1][j]=0;
//                }else f[i&1][j]=f[(i-1)&1][j]+f[i&1][j-1];
//            }
//        }
        //第三种，考虑将f(x,y)化简成f(x)，既f(y)=f(y)+f(y-1)
        long g[]=new long[40];
        g[2]=1;
        for (int i = 2; i <=bx; i++) {
            for (int j = 2; j <=by; j++) {
                if (s[i][j]!=null){
                    g[j]=0;
                }else g[j]=g[j]+g[j-1];
            }
        }
        System.out.println(g[by]);
//        System.out.println(f[bx][by]);
//        System.out.println(f[bx&1][by]);
    }
}
