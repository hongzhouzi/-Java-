package 真题;
//思路：循环遍历每个点数所选择的张数，每个点数最多可以选4张，最少可以选0张即不选，每当牌总数达到13张则计数
public class Main7 {
	static int count=0;		//用来计数
	static void f(int type,int sum){	//type表示牌型总数，sum表示取的牌的数目
		if(sum>13) return;
		if(type==13){
			if(sum==13) count++;
			return;
		}
		for(int i=0;i<=4;i++){	//i表示取type这种牌取多少张，0表示不取，4表示取4张（全取）
			f(type+1,sum+i);	//从第一个牌型开始取，依次来看
		}
	}
	public static void main(String[] args) {
		f(0,0);
//		    for(int a=0; a<=4; a++)  //暴力破解
//		        for(int b=0; b<=4; b++)  
//		            for(int c=0; c<=4; c++)  
//		                for(int d=0; d<=4; d++)  
//		                    for(int e=0; e<=4; e++)  
//		                        for(int f=0; f<=4; f++)  
//		                            for(int g=0; g<=4; g++)  
//		                                for(int h=0; h<=4; h++)  
//		                                    for(int i=0; i<=4; i++)  
//		                                        for(int j=0; j<=4; j++)  
//		                                            for(int k=0; k<=4; k++)  
//		                                                for(int l=0; l<=4; l++)  
//		                                                    for(int m=0; m<=4; m++){  
//		                                                        if(a+b+c+d+e+f+g+h+i+j+k+l+m==13)  
//		                                                            count++;  
//		                                                    }  
		    System.out.println(count);
	}
}
