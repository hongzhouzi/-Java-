package 真题;

public class Main6 {
	
	/*static int a[]=new int[50]; 
	static void f(int sum,int x,int y){
		if(x==y||x+1==y||x-1==y) return;	//保证位置不相同，不相邻
		if(x>48||y>48||x<1||y<1) return;
		if(sum>2015) return;
		if(sum==2015){
			System.out.println(x+" "+y);
			return;
		}
		
		sum=0;
		for(int i=1;i<50;i++){
			if(i==x||i==x+1||i==y||i==y+1) continue;
			sum+=a[i];
		}
		sum+=a[x]*a[x+1]+a[y]*a[y+1];
		f(sum,x,y+1);
		f(sum,x+1,y);
		return;
	}*/
	public static void main(String[] args) {
		int a;
		for(int i=1;i<=46;i++){
			for(int j=i+2;j<=48;j++){
				a=1225;
				a-=i+(i+1);
				a-=j+(j+1);
				a+=i*(i+1)+j*(j+1);
				if(a==2015){
					System.out.println(i);
				}
			}
		}
	}
}
