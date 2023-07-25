package ass3;

import java.util.Scanner;

public class ass3_2 {
    public static void main(String[] args) {
        int n,m,k;
        Scanner sc =new Scanner(System.in);
        n=sc.nextInt();
        m=sc.nextInt();
        k= sc.nextInt();
        int o,p;
       int[][]x=new int[m][2];
       int[][]y=new int[k][2];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < 2; j++) {
                x[i][j]= sc.nextInt();
            }
        }
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < 2; j++) {
               y[i][j]= sc.nextInt();
            }
        }
        int [][]map=new int[n][n];
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j <2 ; j++) {
                for (int l = 0; l < m; l++) {
                o=x[l][0];
                p=x[l][1];
                if (o+i>=0 && o+i<n && p+j>=0 && p+j<n){
                map[o+i][p+j]=1;
                }
                }
            }
        }
        int[][]dx=new int[3][];
        int[]dy={-2,-1,0,1,2};
        dx[0]=new int[]{-2,-1,0,1,2};
        dx[1]=new int[]{-2,2};
        dx[2]=new int[]{-2,0,2};
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < 5; j++) {
                int a;
                if (dy[j]==-2||dy[j]==2){
                    a=0;
                }
                else if (dy[j]==-1||dy[j]==1)
                    a=1;
                else
                    a=2;
                for (int l = 0; l < dx[a].length; l++) {
                    o=y[i][0]+dx[a][l];
                    p=y[i][1]+dy[j];
                    if (o>=0&&o<n&&p>=0&&p<n)
                        map[o][p]=1;
                }
            }
        }

        int num=0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <n; j++) {
                if (map[i][j]==0){
                    num++;
                }
            }
        }
        System.out.printf("%d",num);
    }
}
