package ��ս������ƾ�����Ŀ;

public class FenceRepair {
	public static void main(String[] args) {
//		int n=3;
//		int l[]={8,5,8};
		int n=5;
		int l[]={1,2,3,4,5};
		System.out.println(solve(n, l));
	}
	static int solve(int n,int l[]){
		int ans=0;
		while(n>1){
			//�����̰�min1�ʹζ̰�min2    �±�
			int min1=0,min2=1;
			if(l[min1]>l[min2]){
				int temp=min1;
				min1=min2;
				min2=temp;
			}
			
			for(int i=2; i<n;i++){
				if(l[i]<l[min1]){
					min2=min1;
					min1=i;
				}else if(l[i]<l[min2]){
					min2=i;
				}
			}
			
			//�������ϲ�
			int t=l[min1]+l[min2];
			ans+=t;
			
			/*if(min1==n-1){
				int temp=min1;
				min1=min2;
				min2=temp;
			}*/
			l[min1]=t;
			l[min2]=l[n-1];
			n--;
		}
		return ans;
	}
}
