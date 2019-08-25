package practice;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in) ;
        int L = 0;
        String S = "" ;
        if(scanner.hasNext()){  //��������l���ַ���s
            L = scanner.nextInt() ;
            S = scanner.next() ;
        }
        Map<String,Integer> map = new HashMap<String,Integer>() ;   //ʹ��map��key�����ַ��� value�����ַ������ֵĴ���
        int maxValue = 0 ;  //�����ַ����ĳ��ִ��������ֵ
        String maxStr = "" ;    //������ִ��������ַ���
        for(int i = 0 ; i < S.length() - L + 1 ; i ++){
            for(int j = i + L ; j < S.length() ; j ++){
                String str = S.substring(i,j) ; //ö�ٽ�ȡ���ȴ��ڵ���l���ַ���
                if(map.containsKey(str)){   //�����ַ���֮ǰ���ֹ���map(key,value)��valueֵ+1
                    int value = map.get(str) ;	//get�ü�����ȡ�ü���Ӧ��ֵ
                    value ++ ;
                    if(value > maxValue){
                        maxValue = value ;
                        maxStr = str ;
                    }
                    else if(value == maxValue){    //�����ַ������ֵĴ����뵱ǰ���ִ��������ַ�����ȣ���Ƚ������ַ����ĳ��ȣ�ȡ�ַ�������
                        if(maxStr.length() < str.length()){
                            maxStr = str ;
                        }
                    }
                    map.put(str, value) ;	//��map��ֵ
                }
                else{  //�����ַ���֮ǰ��δ���ֹ�����ӣ�����ʼ��valueֵΪ0
                    map.put(str, 0) ;   
                }
            }
        }
        System.out.println(maxStr); //������ִ��������ַ���
    }

}

/*import java.util.Scanner;
public class Main {
	static int L;
	static String s;
	static String[] arr=new String[100];	//��¼ȡ��������ͬ�ַ���
	static int[] num=new int[100];	//��¼����
	static String[] NUM=new String[100];	//��¼ȡ��������ͬ�ַ���
	static void f(int n){
		int[] a=new int[100];	//��¼��ͬ�ַ���������
		for(int i=0;i<s.length()-n;i++){
			arr[i]=s.substring(i, n+i);
			for(int j=0;j<i;j++){
				if(a[i]==a[j])
					a[i]++;
			}
		}
		int max=0;
		for(int i=0;i<s.length();i++){
			if(a[i]>max)
				max=i;
		}
		num[n-L]=max;
		NUM[n-L]= s.substring(max,max+n);
	}
	
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		L=in.nextInt();
		s=in.next();
		for(int i=L;i<s.length();i++){
			f(i);
		}
		int Max=0;
		for(int i=0;i<s.length();i++){
			if(num[i]>Max)
				Max=i;
		}
		System.out.println(NUM[Max]);
	}
}*/
