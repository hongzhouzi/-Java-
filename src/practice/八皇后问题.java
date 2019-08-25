package practice;

public class �˻ʺ����� {
	
	static int Num=0,Eight=8;			//Num��Ź��м���⣬Eight��ʾ��8���ʺ�
	static int[] queen=new int[Eight];	//���8���ʺ����λ��

	//�ж��Ƿ��յ��������ܵ���������true�����ܹ�������false
	static boolean attack(int row,int col){
		int i=0,offset_row=0,offset_col=0;
		boolean atk=false;
		while(atk==false&&i<col){
			offset_col=Math.abs(i-col);	
			offset_row=Math.abs(queen[i]-row);	
			//�ж��Ƿ���ͬһ�л�Խ������ܵ�����
			if((queen[i]==row)||(offset_row==offset_col))
				atk=true;
			i++;
		}
		return atk;
	}
	
	//�����Ҫ�Ľ��
	static void print(){
		Num++;
		System.out.println("\n�˻ʺ�����ĵ�"+Num+"��⣺");
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
			//�ж��Ƿ��յ�����
			if(attack(i,value)==false){
				queen[value]=i;
				if(value==7)
					print();
				else
					decide_position(value+1);	//�ݹ������ǰ��λ�ðڷ�
			}
			i++;
		}
	}
	public static void main(String[] args) {
		decide_position(0);
	}
}

