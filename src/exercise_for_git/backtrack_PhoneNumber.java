package exercise_for_git;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class backtrack_PhoneNumber {//回溯
    private static List<String> result=new ArrayList<String>();
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        String str=sc.next();
        int big=0;
        for (int i = 0; i <str.length(); i++) {
            if (str.charAt(i)=='"'){
                big=i;
                break;
            }
        }
        char chars[]=str.substring(big+1,str.length()-1).toCharArray();
        dfs(1,chars,"");
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }
    public static void dfs(int n,char[] chars,String str){
        if (str.length()==chars.length){
            result.add(str);
        }else {
            for (int i = 0; i < chr[chars[n-1]-'0'].length; i++) {
                str=str+chr[chars[n-1]-'0'][i];
                dfs(n+1,chars,str);
                str =str.substring(0,str.length()-1);//java中没有string.Remove的用法，可以用substring来实现！！！
            }
        }
    }
    public static final char[][]chr= {{},{},{'a','b','c'},{'d','e','f'},{'g','h','i'},{'j','k','l'},
            {'m','n','o'},{'p','q','r','s'},{'t','u','v'},{'w','x','y','z'}};
}
