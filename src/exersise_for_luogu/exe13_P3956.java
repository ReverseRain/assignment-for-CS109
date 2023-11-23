package exersise_for_luogu;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class exe13_P3956 {
    static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
    static int result = -1;
    static ArrayList<Node> colorNode = new ArrayList<>();

    static class Node {
        int c;
        boolean magic;
        boolean visisted;

        public void setC(int c) {
            this.c = c;
        }
        public void draw(int color){
                magic=true;
                c=color;
        }

        public Node(int c,boolean magic,boolean visisted) {
            this.c = c;
            this.magic=magic;
            this.visisted=visisted;
        }

        public void Node(int c){
            c=-1;
            magic=false;
            visisted=false;

        }
        public void fade(){
            c=-1;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(), n = sc.nextInt();
        Node[][] map=new Node[m+1][m+1];
        for (int i = 1; i <m+1 ; i++) {
            for (int j = 1; j <m+1 ; j++) {
                map[i][j]=new Node(-1,false,false);
            }
        }
        for (int i = 0; i < n; i++) {
            map[sc.nextInt()][sc.nextInt()].c=sc.nextInt();
        }
        System.out.println("jj");
        dfs(1,1,map,0);
        System.out.println("lo");
        System.out.println(result);
    }
    static void dfs(int x,int y,Node[][]map,int spent){
        if (x== map.length-1
                &&y== map.length-1){
            if (result!=-1){
                if (spent<result){
                    result=spent;
                }
            }else result=spent;
            for (int i = 1; i < map.length; i++) {
                for (int j = 1; j < map.length ; j++) {
                    System.out.print(map[i][j].visisted+"");
                }
                System.out.println("");
            }
            System.out.println(spent);
            System.out.println(result);
        }else {
            for (int i = 0; i <4; i++) {
                int nx=x+dx[i],ny=y+dy[i];
                if (nx>0&&nx< map.length&&ny>0&&ny< map.length
                        &&map[nx][ny].visisted!=true){
                    if (map[nx][ny].c!=map[x][y].c){
                        if (map[nx][ny].c!=-1){
                            spent++;
                            map[nx][ny].visisted=true;
                            dfs(nx,ny,map,spent);
                            spent--;
                            map[nx][ny].visisted=false;
                        }else {
                            //case1
                            int color=map[x][y].c;
                            spent+=2;
                            map[nx][ny].visisted=true;
                            if (map[x][y].c==0){
                                map[nx][ny].draw(1);
                            }else map[nx][ny].draw(0);
                            spent++;
                            if (map[x][y].magic){
                                map[x][y].fade();
                            }
                            dfs(nx,ny,map,spent);
                            spent--;
                            //case2
                            map[nx][ny].draw(color);
                            dfs(nx,ny,map,spent);
                            spent-=2;
                            if (map[x][y].magic){
                                map[x][y].draw(color);
                            }
                            map[nx][ny].visisted=false;map[nx][ny].fade();
                        }
                    }else {
                        map[nx][ny].visisted=true;
                        int color=map[x][y].c;
                        if (map[x][y].magic){
                            map[x][y].fade();
                        }
                        dfs(nx,ny,map,spent);
                        if (map[x][y].magic){
                            map[x][y].draw(color);
                        }
                        map[nx][ny].visisted=true;
                    }
                }
            }
        }
    }

//    static void dfs(Node start, int m, int spent) {
//        if (start.x == m && start.y == m) {
//            if (result != -1 && spent < result) {
//                result = spent;
//            }
//            if (result == -1) {
//                result = spent;
//            }
//        } else {
//            for (int i = 0; i < 4; i++) {
//                int x = start.x + dx[i], y = start.y + dy[i];
//                Node target = new Node(x, y, -1);
//                for (int j = 0; j < colorNode.size(); j++) {
//                    if (x == colorNode.get(j).x && y == colorNode.get(j).y) {
//                        target.setC(colorNode.get(j).c);
//                    }
//                }
//                if (x > 0 && y > 0 && x <= m && y <= m && target.visited != true) {
//
//                }
//            }
//
//        }
//    }
}