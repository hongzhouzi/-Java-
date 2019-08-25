package review;

public class 方格填数 {
	static int count=0;
	static boolean judge(int x,int y){	//判断x和y是否是相邻的数，如果相邻返回true，不相同返回false
		if(x==y-1||x==y+1)
			return true;
		else
			return false;
	}
	
	static void find(int a[],int cur){
		if(cur==10){
			count++;
		}
		boolean flag;
		for(int i=0;i<10;i++){
			//排除相等情况
			flag=true;	//注意：在每次试探前都要把flag重置一下
			for(int j=0;j<cur;j++){
				if(a[j]==i)
					flag=false;
			}
			if( false==flag) continue;
			//排除相邻情况
			switch(cur){
				case 0: 
					break;
				case 1: 
					if (judge(a[0],i)) 
						flag=false;
					break;
				case 2:
					if(judge(a[1],i))
						flag=false;
					break;
				case 3:
					if(judge(a[0],i))
						flag=false;
					break;
				case 4:
					if(judge(a[3],i)||judge(a[0],i)||judge(a[1],i))
						flag=false;
					break;
				case 5:
					if(judge(a[4],i)||judge(a[0],i)||judge(a[1],i)||judge(a[2],i))
						flag=false;
					break;
				case 6:
					if(judge(a[5],i)||judge(a[1],i)||judge(a[2],i))
						flag=false;
					break;
				case 7:
					if(judge(a[3],i)||judge(a[4],i))
						flag=false;
					break;
				case 8:
					if(judge(a[7],i)||judge(a[3],i)||judge(a[4],i)||judge(a[5],i))
						flag=false;
					break;
				case 9:
					if(judge(a[8],i)||judge(a[4],i)||judge(a[5],i)||judge(a[6],i))
						flag=false;
					break;
			}
			if(flag==false) continue;
			a[cur]=i;
			find(a,cur+1);
		}
	}
	public static void main(String[] args) {
		int a[]=new int[10];
		find(a,0);
		System.out.println(count);
	}
}
