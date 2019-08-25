package practice;
import java.util.ArrayList;
import java.util.Scanner;

public class 学霸迷宫 {
	final static int move[][]={{-1,0},{0,1},{1,0},{0,-1}};	//移动顺序，上左下右
	final static char onePath[]={'U','L','D','R'};		//顺序，上左下右
	
	static class point{	//内部类，用来记录点的信息
		public int x,y,step;
		public String path;
		point(int x,int y,int step,String path){
			this.x=x;
			this.y=y;
			this.step=step;
			this.path=path;
		}
	}
//	将输入的数据转化为矩阵
	static int[][] getMatrix(String A[],int n){
		int Matrix[][]=new int [A.length+1][n+1];
		for(int i=1;i<=n;i++){
			char []temp=A[i].toCharArray();		//注意写法,把改行的字符串转化成字符数组
			for(int j=1;j<=A.length;j++){		//把字符数组转化成数值
				Matrix[i][j]=temp[j]-'0';
			}
		}
		return Matrix;
	}
//	判断该点是否可以走
	static boolean check(int [][]a,int x,int y){
		if(x<0||x>a[0].length||y<0||y>a.length||a[x][y]==1)
			return false;
		else
			return true;
	}
//	检测字符串的字典序大小,A大于B就返回true，否则返回false
	static boolean judge(String A,String B){
		char Ac[]=A.toCharArray();
		char Bc[]=B.toCharArray();
		for(int i=0;i<A.length();i++){
			if(Ac[i]<Bc[i])
				return false;
		}
		return true;
	}
	static void bfs(String[]a,int m){
		int matrix[][]=getMatrix(a,m);
		ArrayList <point> list=new ArrayList<point>();
		list.add(new point(1,1,0,""));	//注意new一个point，把起点添加进去
		int minStep=0;		//用来记录所走的最小步数
		String minPath="";	//用来记录最小步数下的路径
		while(list.size()!=0){
			//先获取链表中的第一个元素，再对该元素进行操作
			point begin=list.get(0);				//++++++++++++++++++++++++++++++++++++++++++++注意
			list.remove(0);		//删除链表中的第一个元素++++++++++++++++++++++++++++++++++++++++++++++++注意
			
			if(begin.x==matrix.length - 1 && begin.y == matrix[0].length - 1){		//到达出口时，+++注意
				//检测最小步数和字典序
				if(minStep>begin.step){
					minStep=begin.step;
					minPath=begin.path;
				}
				else if(minStep==begin.step){
					if(judge(minPath,begin.path)){
						minStep=begin.step;
						minPath=begin.path;
					}
				}
				continue;	//此时可以结束该次试探了
			}
			
			for(int i=0;i<4;i++){		//向四周试探的过程
				int x1=begin.x+move[i][0];
				int y1=begin.y+move[i][1];
				if(check(matrix,x1,y1)){	//试探后，如果可以走，那么就把他添加到链表中
					list.add(new point(x1,y1,begin.step+1,begin.path+onePath[i]));
					matrix[x1][y1]=1;		//将该点标记为不可达，+++++++++++++++++++++++++++++++++++++++注意
				}
			}
		}
	}
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int m=in.nextInt();
		String a[]=new String[n];
		for(int i=0;i<n;i++){
			a[i]=in.next();
		}
		bfs(a,m);
	}
}
