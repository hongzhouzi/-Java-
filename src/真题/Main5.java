package ����;

public class Main5 {
	public static void test(int[] x)  {   
		int a = x[0]*1000 + x[1]*100 + x[2]*10 + x[3];  
		int b = x[4]*10000 + x[5]*1000 + x[6]*100 + x[7]*10 + x[8]; 
		if(a*3==b) 
			System.out.println(a + " " + b);  
	}   
	static void f(int a[],int k){
		if(k==a.length){
			test(a);
			return;
		}
		for(int i=k;i<a.length;i++){
			{int t=a[k];a[k]=a[i];a[i]=t;}	//����
			f(a,k+1);						//��̽
			{int t=a[k];a[k]=a[i];a[i]=t;}	//����
		}
	}
	public static void main(String[] args)  {  
		int[] x = {1,2,3,4,5,6,7,8,9};    
		f(x,0);  
	}
}
