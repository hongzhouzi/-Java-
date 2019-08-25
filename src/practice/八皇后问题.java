package practice;

public class 八皇后问题 {
	
	static int Num=0,Eight=8;			//Num存放共有几组解，Eight表示有8个皇后
	static int[] queen=new int[Eight];	//存放8个皇后的列位置

	//判断是否收到攻击，受到攻击返回true，不受攻击返回false
	static boolean attack(int row,int col){
		int i=0,offset_row=0,offset_col=0;
		boolean atk=false;
		while(atk==false&&i<col){
			offset_col=Math.abs(i-col);	
			offset_row=Math.abs(queen[i]-row);	
			//判断是否在同一行或对角线上受到攻击
			if((queen[i]==row)||(offset_row==offset_col))
				atk=true;
			i++;
		}
		return atk;
	}
	
	//输出需要的结果
	static void print(){
		Num++;
		System.out.println("\n八皇后问题的第"+Num+"组解：");
		for(int i=0;i<Eight;i++){
			for(int j=0;j<Eight;j++){
				if(i==queen[j])
					System.out.print(" X ");
				else
					System.out.print(" O ");
			}
			System.out.println();
		}
	}
	
	static void decide_position(int value){
		int i=0;
		while(i<Eight){
			//判断是否收到攻击
			if(attack(i,value)==false){
				queen[value]=i;
				if(value==7)
					print();
				else
					decide_position(value+1);	//递归求出当前行位置摆放
			}
			i++;
		}
	}
	public static void main(String[] args) {
		decide_position(0);
	}
}

