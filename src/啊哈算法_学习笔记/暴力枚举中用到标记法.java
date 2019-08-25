package 啊哈算法_学习笔记;

public class 暴力枚举中用到标记法 {
	public static void main(String[] args) {
		int a[]=new int[3];
		int book[]=new int[10];
		int sum;
		for(a[0]=0;a[0]<10;a[0]++){
			for(a[1]=0;a[1]<10;a[1]++){
				for(a[2]=0;a[2]<10;a[2]++){
					for(int i=0;i<10;i++)	//需要初始化标记数组，要保证在每次用标记数组时都是被初始化为全0状态的
						book[i]=0;
					for(int i=0;i<3;i++)	//这儿i<3，指需要满足三个数不同，在下面满足3个数不同时，sum也要为3.（3为个数）
						book[a[i]]=1;	//把已有的数字做个标记
					sum=0;				//重置sum变量
					for(int i=0;i<10;i++)
						sum+=book[i];
					//如果满足有三个不相同的数，且满足算式条件就输出
					if(sum==3&&a[0]*100+a[1]*10+a[2]==a[0]*a[0]*a[0]+a[1]*a[1]*a[1]+a[2]*a[2]*a[2])
						System.out.println(a[0]*100+a[1]*10+a[2]);
				}
			}
		}
	}
}
