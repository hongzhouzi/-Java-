package 听课练习;

public class 五家共井_多未知数整除式 {
	public static void main(String[] args) {
		int len[]=new int[6];
		for(len[5]=4;len[5]<1000;len[5]+=4){	//设未知数len[5]从4开始，且是4的倍数
			for(len[4]=3;len[4]<1000;len[4]+=3){	//设未知数len[4]从3开始，且是3的倍数
				len[3]=len[4]+len[5]/4;	//用已知的表示未知的
				//由于不知道len[3]的数是否是3的倍数，所以现在不能用来表示len[1]的
				if(len[3]%2!=0) continue;
				len[2]=len[3]+len[4]/3;	//用已知的表示未知的
				len[1]=len[2]+len[3]/2;
				if(len[1]%5!=0) continue;
				if(len[4]==len[5]+len[1]/5){
					len[0]=len[1]*2+len[2];
					System.out.println("len1="+len[1]+" len2="+len[2]+" len3="+len[3]+" len4="+len[4]+" len5="+len[5]);
					System.out.println(len[0]);
//					return;
				}
			}
		}
	}
}
