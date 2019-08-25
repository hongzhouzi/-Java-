package 啊哈算法_学习笔记;
/*
 1到9之间的数满足每个数只用一次且拼成一个等式。如：124+659=783    659+124=783
 * */
public class 数字填充 {
	static int []a=new int[10];
	static int []book=new int[10];
	static int total=0;		//记录可行解，注意124+659=783    659+124=783是一个可行解，在累加后需要除2
	static void dfs(int step){
		
		if(step==10){
			if(a[1]*100+a[2]*10+a[3]+a[4]*100+a[5]*10+a[6]==a[7]*100+a[8]*10+a[9]){
				total++;		//满足要求，那么可行解+1
				System.out.printf("%d%d%d+%d%d%d=%d%d%d\n",a[1],a[2],a[3],a[4],a[5],a[6],a[7],a[8],a[9]);
			}
			return;		//返回到之前的一步（最近一次调用dfs的地方）
		}
		
		for(int i=1;i<=9;i++){
			if(book[i]==0){		//i这个数还没有用就尝试该数，如果用了就向下尝试
				a[step]=i;	//尝试过程
				book[i]=1;	//标记，将book[i]是值赋为1表示i号已经用了
				dfs(step+1);	//当前这步走了后就走下一步
				book[i]=0;	//用了之后要还原到最初状态
			}
		}
		
		return;		//返回一下
	}
	public static void main(String[] args) {
		dfs(1);
		System.out.println(total/2);
	}
}