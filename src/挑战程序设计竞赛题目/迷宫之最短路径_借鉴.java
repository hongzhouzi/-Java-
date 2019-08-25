package ��ս������ƾ�����Ŀ;

import java.util.Queue;  
import java.util.concurrent.ConcurrentLinkedQueue;  
  
/** 
 * TODO :����һ����СΪN*M���Թ����Թ���ͨ����ǽ����ɣ�ÿһ���������ڽӵ����������� 
 * ���ͨ���ƶ��������㵽�յ��������С������ 
 */  
public class �Թ�֮���·��_��� {  
  
    private static final int INF = 100000;  
    private static final int N = 10;  //��
    private static final int M = 10;  //��
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
    private static int xs = 0;  //���������
    private static int ys = 1;  //���������
    private static int xe = 9;  //�յ�������
    private static int ye = 8;  //�յ�������
    private static int[][] distance = new int[N][M];  //����㵽����λ�õ���̾���
  
    private static int[] xd = {1, 0, -1, 0};  //�ƶ��������ʾ�������ƶ�
    private static int[] yd = {0, 1, 0, -1};  //�ƶ��������ʾ�������ƶ�
  
    public static void main(String[] args) {  
        initDistance();  
        �Թ�֮���·��_��� maze = new �Թ�֮���·��_���();  
        int dis = maze.bfs();  
        System.out.println("shortest length is : " + dis);  
        printDistance();  
    }  
  
    private int bfs() {  
        Queue<Point> que = new ConcurrentLinkedQueue<Point>();  
        que.add(new Point(xs, ys));  //����һ��Ԫ��      ����������������׳�һ��IIIegaISlabEepeplian
        distance[xs][ys] = 0;  		//����������Ϊ0
        while (que.size() > 0) {  	//���в�Ϊ��ʱ
            Point point = que.poll();  //�Ƴ������ʶ���ͷ����Ԫ��    �������Ϊ�գ��򷵻�null
            if (point.getX() == xe && point.getY() == ye) {  //�����յ�ʱ
                break;  
            }  
            for (int i = 0; i < 4; i++) {  
                int xp = point.getX() + xd[i];  
                int yp = point.getY() + yd[i];  
                if (0 <= xp && xp < N && 0 <= yp && yp < M && mazeMatrix[xp][yp] != '#' && distance[xp][yp] == INF) {  
                    que.add(new Point(xp, yp));  //�����������Ԫ��
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