package ass3;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
public class ass3_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m,n;
        m=sc.nextInt();
        n= sc.nextInt();
        String str= sc.next();
        char[] chars = decompress(str).toCharArray();
        String[][]map=matrix(chars,m,n);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%s",map[i][j]);
            }
            System.out.println("");
        }
    }
    public static String decompress(String a){
        char[]chars=new char[1];
        chars=a.toCharArray();
        String b="";
        int s=0,o=0,p=0;
        ArrayList<Integer>intList=new ArrayList<Integer>();
        ArrayList<String>stringList=new ArrayList<String>();
        for (int i = 0; i < chars.length; i++) {
            if (Character.isDigit(chars[i])){
                for (int j = i+1; j <chars.length; j++) {
                    if (Character.isDigit(chars[j])) {
                    s++;
                    }
                    else
                        break;
                }
                if (i+1==chars.length){
                    s=0;
                }
                if (i+s!=chars.length-1){
                        o=Integer.parseInt(String.valueOf(a.substring(i,i+s+1)));
                    }
                else
                    o=Integer.parseInt(String.valueOf(a.substring(i)));
                    i=i+s;                //已经算过的数字跳过
                    s=0;
                    intList.add(o);
            }
            else{
                stringList.add(String.valueOf(chars[i]));  //String.valueOf(chars[i])这一操作是将chars数组转化成String值
                p++;
            }
        }
        for (int i = 0; i <p ; i++) {
            for (int j = 0; j < intList.get(i); j++) {
                b+=stringList.get(i);
            }
        }
            return b;

    }
    public static String[][] matrix(char[]a,int m,int n){                 //!!螺旋数组的排列，先来分析坐标的走向
        String[][]map=new String[m][n];
        int x=m-1,y=0;
        int o=1;
        for (int i = 0; i < a.length; i++) {
            map[x][y]= String.valueOf(a[i]);
            if (y+o<n&&y+o>=0&& Objects.equals(map[x][y + o], null)){
                y+=o;
            }
            else if (x-o<m&&x-o>=0&& Objects.equals(map[x - o][y], null)){
                x-=o;
            }
            else{               //在某个节点坐标判断的方向开始改变：原本是判断左方与上方，此节点后改为右方和下方
                o=-o;
                y+=o;
            }
        }
        return map;
    }
}