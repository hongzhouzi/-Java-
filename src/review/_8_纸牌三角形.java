package review;

public class _8_纸牌三角形 {
	static int box[]=new int[10]; 
	static boolean mark[]=new boolean[10]; 
	static int sum=0;
	static void f(int n){
		if(n==10){
			if(box[1]+box[2]+box[4]+box[6]==box[1]+box[3]+box[5]+box[9]&&box[6]+box[7]+box[8]+box[9]==box[1]+box[3]+box[5]+box[9]){
				sum++;
				return;
			}
		}
		for(int i=1;i<10;i++){	//暴力破解时，列出[1,9]之间互不相同的数
			if(!mark[i]){	//mark数组标记i下标的数据取不取，取了就标记为true
				mark[i]=true;
				box[n]=i;	//把当前这个数装入数组中
				f(n+1);		//向下继续找
				mark[i]=false;	//回溯
			}
		}
	}
	public static void main(String[] args) {
		f(1);
		System.out.println(sum/2/3);
	}
}
