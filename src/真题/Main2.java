package ецЬт;

public class Main2 {
	static int f(int n){
		int sum=0;
		while(n>0){
			sum+=n%10;
			n/=10;
		}
		return sum;
	}
	public static void main(String[] args) {
		int count=0;
		for(int i=1;i<100000;i++){
			if(f(i*i*i)==i){
				count++;
				System.out.println(i+"="+i*i*i);
			}
		}
		System.out.println(count);
	}
}
