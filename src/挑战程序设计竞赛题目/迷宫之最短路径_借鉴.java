package 挑战程序设计竞赛题目;

import java.util.Queue;  
import java.util.concurrent.ConcurrentLinkedQueue;  
  
/** 
 * TODO :给定一个大小为N*M的迷宫，迷宫由通道和墙壁组成，每一步可以向邻接的上下左右四 
 * 格的通道移动。求从起点到终点所需的最小步数。 
 */  
public class 迷宫之最短路径_借鉴 {  
  
    private static final int INF = 100000;  
    private static final int N = 10;  //行
    private static final int M = 10;  //列
    private static char[][] mazeMatrix = {  
            {'#', 'S', '#', '#', '#', '#', '#', '#', 'o', '#'},  
            {'o', 'o', 'o', 'o', 'o', 'o', '#', 'o', 'o', '#'},  
            {'o', '#', 'o', '#', '#', 'o', '#', '#', 'o', '#'},  
            {'o', '#', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o'},  
            {'#', '#', 'o', '#', '#', 'o', '#', '#', '#', '#'},  
            {'o', 'o', 'o', 'o', '#', 'o', 'o', 'o', 'o', '#'},  
            {'#', '#', '#', '#', '#', '#', '#', '#', 'o', '#'},  
            {'o', 'o', 'o', '#', 'o', 'o', 'o', 'o', 'o', 'o'},  
            {'o', '#', '#', '#', '#', 'o', '#', '#', '#', 'o'},  
            {'o', 'o', 'o', 'o', '#', 'o', 'o', 'o', 'G', '#'}  
    };  
    private static int xs = 0;  //起点行坐标
    private static int ys = 1;  //起点列坐标
    private static int xe = 9;  //终点行坐标
    private static int ye = 8;  //终点列坐标
    private static int[][] distance = new int[N][M];  //存起点到各个位置的最短距离
  
    private static int[] xd = {1, 0, -1, 0};  //移动情况，表示向左右移动
    private static int[] yd = {0, 1, 0, -1};  //移动情况，表示向上下移动
  
    public static void main(String[] args) {  
        initDistance();  
        迷宫之最短路径_借鉴 maze = new 迷宫之最短路径_借鉴();  
        int dis = maze.bfs();  
        System.out.println("shortest length is : " + dis);  
        printDistance();  
    }  
  
    private int bfs() {  
        Queue<Point> que = new ConcurrentLinkedQueue<Point>();  
        que.add(new Point(xs, ys));  //增加一个元索      如果队列已满，则抛出一个IIIegaISlabEepeplian
        distance[xs][ys] = 0;  		//把起点距离设为0
        while (que.size() > 0) {  	//队列不为空时
            Point point = que.poll();  //移除并返问队列头部的元素    如果队列为空，则返回null
            if (point.getX() == xe && point.getY() == ye) {  //到达终点时
                break;  
            }  
            for (int i = 0; i < 4; i++) {  
                int xp = point.getX() + xd[i];  
                int yp = point.getY() + yd[i];  
                if (0 <= xp && xp < N && 0 <= yp && yp < M && mazeMatrix[xp][yp] != '#' && distance[xp][yp] == INF) {  
                    que.add(new Point(xp, yp));  //向队列中增加元素
                    distance[xp][yp] = distance[point.getX()][point.getY()] + 1;  
                }  
            }  
        }  
        return distance[xe][ye];  
    }  
  
    private static void initDistance() {  
        for (int i = 0; i < N; i++) {  
            for (int j = 0; j < M; j++) {  
                distance[i][j] = INF;  
            }  
        }  
    }  
  
    private static void printDistance() {  
        for (int i = 0; i < N; i++) {  
            System.out.println();  
            for (int j = 0; j < M; j++) {  
                System.out.print("\t\t" + distance[i][j]);  
            }  
        }  
    }  
  
    class Point {  
        int x;  
        int y;  
  
        public Point(int x, int y) {  
            this.x = x;  
            this.y = y;  
        }  
  
        public int getX() {  
            return x;  
        }  
  
        public int getY() {  
            return y;  
        }  
  
        public void setX(int x) {  
            this.x = x;  
        }  
  
        public void setY(int y) {  
            this.y = y;  
        }  
    }  
}  