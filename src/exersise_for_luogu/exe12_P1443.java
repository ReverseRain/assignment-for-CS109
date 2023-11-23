package exersise_for_luogu;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class exe12_P1443 {
    static int dx[] = {-1, -2, -2, -1, 1, 2, 2, 1}, dy[] = {-2, -1, 1, 2, 2, 1, -1, -2};
    static class Po{
        int x,y;

        public Po(int x,int y) {
            this.x=x;
            this.y=y;
        }
    }
    public static void main(String[] args) {
        int n=0,m=0,x=0,y=0;

        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();m=sc.nextInt();
        x=sc.nextInt();y=sc.nextInt();
        int[][]map=new int[n+1][m+1];
        for (int i = 1; i <n+1 ; i++) {
            for (int j = 1; j <m+1 ; j++) {
                map[i][j]=-1;
            }
        }
        map[x][y]=0;
        search(new Po(x,y),map);
        for (int i = 1; i <n+1 ; i++) {
            for (int j = 1; j <m+1 ; j++) {
                System.out.print(map[i][j]+" ");
            }
            System.out.println("");
        }
    }
    public static void search(Po p,int[][]map){
        LinkedList<Po> q = new LinkedList<>();
        q.addLast(p);
        Boolean[][] visited=new Boolean[map.length-1][map[1].length-1];
        visited[p.x][p.y]=true;
        while (!q.isEmpty()){
            Po t =q.removeFirst();
            for (int i = 0; i <8 ; i++) {
                int x=t.x+dx[i],y=t.y+dy[i];
                if (x<1||x>map.length-1||y<1||y>map[1].length-1||map[x][y]!=-1){//在这里map单元中的初始值都是-1，所以map[x][y]!=-1就是已经走过的，不走回头路
                    continue;
                }
                map[x][y]=map[t.x][t.y]+1;
                q.addLast(new Po(x,y));
            }
        }

    }

}
