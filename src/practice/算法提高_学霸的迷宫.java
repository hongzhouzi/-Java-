package practice;

import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.ConcurrentLinkedQueue;

public class 算法提高_学霸的迷宫 {
	
	static void dfs(int n,int m,int a[][]){
		final int INF = 100000;	//把为走过的做个标记，避免重复走
		Queue<Point> que = new ConcurrentLinkedQueue<Point>();  
		Point point=new Point(1,1);	//起始点坐标，point当成当前坐标
		int [][]move={{-1,0},{1,0},{0,-1},{0,1}};	//移动的四个方向，上下左右顺序
		char []move_char={'U','D','L','R'};
		int [][]distance=new int[n][m];	//	存距离
		String path="";
		que.add(point);	//把起始点添加到队列中，注意用到的自己定义的point类，需要new关键字
		distance[0][0]=0;
		while(que.size()>0){
			point = que.poll();		//把最先进入的 弹出
			for(int i=0;i<4;i++){	//向四个方向试探
					int x1=point.x+move[i][0];
					int y1=point.y+move[i][1];
					if(x1>=0&&x1<n&&y1>=0&&y1<m&&a[x1][y1]==0&&distance[x1][y1]==INF){	//该点可以通过，就把该点存入队列中，继续试探同一层次的数据
						que.add(new Point(x1,y1));
						distance[x1][y1]=distance[x1-move[i][0]][y1-move[i][1]]+1;	//该点的距离等于上一个点的距离加一
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
		for(int i=0;i<n;i++){	//输入
			d[i]=in.nextLine();
		}
		for(int i=0;i<n;i++){	//把输入的数据转化为字符矩阵
			char[] dt=d[i].toCharArray();	//把字符串转化为字符数
			for(int j=0;j<m;j++){			//把字符数组转化为数字
				da[i+1][j+1]=dt[j]-'0';
			}
		}
		dfs(n,m,da);
	}
}
class Point {  
    int x,y;
    public Point(int x,int y){	//构造函数
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
