package practice;
import java.util.ArrayList;
import java.util.Scanner;

public class ѧ���Թ� {
	final static int move[][]={{-1,0},{0,1},{1,0},{0,-1}};	//�ƶ�˳����������
	final static char onePath[]={'U','L','D','R'};		//˳����������
	
	static class point{	//�ڲ��࣬������¼�����Ϣ
		public int x,y,step;
		public String path;
		point(int x,int y,int step,String path){
			this.x=x;
			this.y=y;
			this.step=step;
			this.path=path;
		}
	}
//	�����������ת��Ϊ����
	static int[][] getMatrix(String A[],int n){
		int Matrix[][]=new int [A.length+1][n+1];
		for(int i=1;i<=n;i++){
			char []temp=A[i].toCharArray();		//ע��д��,�Ѹ��е��ַ���ת�����ַ�����
			for(int j=1;j<=A.length;j++){		//���ַ�����ת������ֵ
				Matrix[i][j]=temp[j]-'0';
			}
		}
		return Matrix;
	}
//	�жϸõ��Ƿ������
	static boolean check(int [][]a,int x,int y){
		if(x<0||x>a[0].length||y<0||y>a.length||a[x][y]==1)
			return false;
		else
			return true;
	}
//	����ַ������ֵ����С,A����B�ͷ���true�����򷵻�false
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
		list.add(new point(1,1,0,""));	//ע��newһ��point���������ӽ�ȥ
		int minStep=0;		//������¼���ߵ���С����
		String minPath="";	//������¼��С�����µ�·��
		while(list.size()!=0){
			//�Ȼ�ȡ�����еĵ�һ��Ԫ�أ��ٶԸ�Ԫ�ؽ��в���
			point begin=list.get(0);				//++++++++++++++++++++++++++++++++++++++++++++ע��
			list.remove(0);		//ɾ�������еĵ�һ��Ԫ��++++++++++++++++++++++++++++++++++++++++++++++++ע��
			
			if(begin.x==matrix.length - 1 && begin.y == matrix[0].length - 1){		//�������ʱ��+++ע��
				//�����С�������ֵ���
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
				continue;	//��ʱ���Խ����ô���̽��
			}
			
			for(int i=0;i<4;i++){		//��������̽�Ĺ���
				int x1=begin.x+move[i][0];
				int y1=begin.y+move[i][1];
				if(check(matrix,x1,y1)){	//��̽����������ߣ���ô�Ͱ�����ӵ�������
					list.add(new point(x1,y1,begin.step+1,begin.path+onePath[i]));
					matrix[x1][y1]=1;		//���õ���Ϊ���ɴ+++++++++++++++++++++++++++++++++++++++ע��
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
