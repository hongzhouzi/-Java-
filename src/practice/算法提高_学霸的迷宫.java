package practice;

import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.ConcurrentLinkedQueue;

public class �㷨���_ѧ�Ե��Թ� {
	
	static void dfs(int n,int m,int a[][]){
		final int INF = 100000;	//��Ϊ�߹���������ǣ������ظ���
		Queue<Point> que = new ConcurrentLinkedQueue<Point>();  
		Point point=new Point(1,1);	//��ʼ�����꣬point���ɵ�ǰ����
		int [][]move={{-1,0},{1,0},{0,-1},{0,1}};	//�ƶ����ĸ�������������˳��
		char []move_char={'U','D','L','R'};
		int [][]distance=new int[n][m];	//	�����
		String path="";
		que.add(point);	//����ʼ����ӵ������У�ע���õ����Լ������point�࣬��Ҫnew�ؼ���
		distance[0][0]=0;
		while(que.size()>0){
			point = que.poll();		//�����Ƚ���� ����
			for(int i=0;i<4;i++){	//���ĸ�������̽
					int x1=point.x+move[i][0];
					int y1=point.y+move[i][1];
					if(x1>=0&&x1<n&&y1>=0&&y1<m&&a[x1][y1]==0&&distance[x1][y1]==INF){	//�õ����ͨ�����ͰѸõ��������У�������̽ͬһ��ε�����
						que.add(new Point(x1,y1));
						distance[x1][y1]=distance[x1-move[i][0]][y1-move[i][1]]+1;	//�õ�ľ��������һ����ľ����һ
//						str[x1][y1]=str[x1-xx[i]][y1-yy[i]]+xc.toString();
				}
			}
		}
		System.out.println(distance[n-1][m-1]);
//		System.out.println(str[n-1][m-1]);
	}
	
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int m=in.nextInt();
		String []d=new String [n];
		int [][]da=new int[n+1][m+1];
		for(int i=0;i<n;i++){	//����
			d[i]=in.nextLine();
		}
		for(int i=0;i<n;i++){	//�����������ת��Ϊ�ַ�����
			char[] dt=d[i].toCharArray();	//���ַ���ת��Ϊ�ַ���
			for(int j=0;j<m;j++){			//���ַ�����ת��Ϊ����
				da[i+1][j+1]=dt[j]-'0';
			}
		}
		dfs(n,m,da);
	}
}
class Point {  
    int x,y;
    public Point(int x,int y){	//���캯��
    	this.x=x;
    	this.y=y;
    }
    /*public int getX(){
    	return x;
    }
    public int getY(){
    	return y;
    }
    public void setX(int x){
    	this.x=x;
    }
    public void setY(int y){
    	this.y=y;
    }*/
}  
