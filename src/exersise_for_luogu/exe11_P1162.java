package exersise_for_luogu;

import java.util.Queue;
import java.util.Scanner;

public class exe11_P1162 {
    //思路:
    //1.我们假设所有的'0'其实都被包围,但事实上并不是
    //
    //2.犯了错误就要纠正,具体有哪一些本来并不是被包围的'0'被我们误认成了被包围的?
    //
    //3.我们发现,那些在矩阵边缘的其实都不应该被包围!(这个就自己证明吧)
    //
    //程序实现:
    //1.先认为所有的'0'都应该被修改,并且真的把它修改成了'2';
    //
    //2.边角上的'2'其实本来不应该被修改的,那我们把他们改回去 ,改成'0'
    //
    //3.然后来寻找与这些零相邻的'2',它们其实也是被改错了的
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[][] map=new int[n+1][n+1];
        for (int i = 1; i <n+1; i++) {
            for (int j = 1; j <n+1 ; j++) {
                map[i][j]=sc.nextInt();
                if (map[i][j]==0)map[i][j]=2;
            }
        }
        for (int i = 1; i <n+1 ; i++) {
            if (map[1][i]==2)map[1][i]=0;
            if (map[i][n]==2)map[i][n]=0;
            if (map[n][i]==2)map[n][i]=0;
            if (map[n][1]==2)map[n][1]=0;
        }
        for (int i = 1; i <n+1 ; i++) {
            for (int j = 1; j <n+1 ; j++) {
                if (map[i][j]==2){
                    if (map[i-1][j]==0||map[i][j-1]==0
                            ||map[i+1][j]==0||map[i][j+1]==0){
                        map[i][j]=0;
                    }
                }
            }
        }
        for (int i = 1; i <n+1 ; i++) {
            for (int j = 1; j <n+1 ; j++) {
                System.out.print(map[i][j]+" ");
            }
            System.out.println("");
        }

    }


//    void bfs(int s){
//        Queue<Integer> queue=new LinkedList<Integer>();
//        queue.offer(s);
//        while(!queue.isEmpty()){
//            //取出队首元素top
//            //访问队首元素top
//            //将队首元素出队
//            //将top的下一层结点中未曾入队的结点全部入队，并设置为已入队
//        }


//    from collections import deque
//    def bfs(graph, start, target):
//            # 创建一个队列并将起始节点加入队列
//            queue = deque()
//    queue.append(start)
//
//            # 创建一个集合用于记录已经访问过的节点
//            visited = set()
//    visited.add(start)
//
//            while queue:
//            # 从队列中取出一个节点
//            node = queue.popleft()
//
//        # 判断是否找到目标节点
//        if node == target:
//            return True
//
//        # 获取当前节点的邻居节点
//            neighbors = graph[node]
//
//        # 遍历邻居节点
//        for neighbor in neighbors:
//            # 如果邻居节点未被访问过，则加入队列和已访问集合
//            if neighbor not in visited:
//            queue.append(neighbor)
//            visited.add(neighbor)
//
//            # 如果遍历完整个图都没有找到目标节点，则返回False
//    return False
//

}
