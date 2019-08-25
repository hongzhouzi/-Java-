package review;

import java.util.HashSet;

public class 剪邮票_真题 {
	static boolean check(){
		boolean mark[]=new boolean[5];
		dfs(mark,0);
		return mark[0]&&mark[1]&&mark[2]&&mark[3]&&mark[4];
	}
	static void dfs(boolean mark[],int cur){
		mark[cur]=true;	//把当前标记为已访问
		//向四周试探
		for(int i=0;i<5;i++){
//			左右相邻，注意一定要写a[i]/4==a[cur]/4，先要保证在同一行再满足相邻
			if((!mark[i])&&a[i]/4==a[cur]/4&&(a[i]==a[cur]+1||a[i]==a[cur]-1)){
				mark[cur]=true;
				dfs(mark,i);
			}
//			上下相邻，注意一定要写a[i]%4==a[cur]%4，先要保证在同一列再满足相邻
			if((!mark[i])&&a[i]%4==a[cur]%4&&(a[i]==a[cur]+4||a[i]==a[cur]-4)){
				mark[cur]=true;
				dfs(mark,i);
			}
		}
	}
	static int a[]=new int[5];
	static HashSet<String> hs=new HashSet<String>();
	public static void main(String[] args) {
		for(a[0]=0;a[0]<12;a[0]++){
			for(a[1]=a[0]+1;a[1]<12;a[1]++){
				for(a[2]=a[1]+1;a[2]<12;a[2]++){
					for(a[3]=a[2]+1;a[3]<12;a[3]++){
						for(a[4]=a[3]+1;a[4]<12;a[4]++){
							if(check()){
								hs.add(""+a[0]+a[1]+a[2]+a[3]+a[4]);
							}
						}
					}
				}
			}
		}
		System.out.println(hs.size());
	}
}
